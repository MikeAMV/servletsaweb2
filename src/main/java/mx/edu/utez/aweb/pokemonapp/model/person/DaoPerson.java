package mx.edu.utez.aweb.pokemonapp.model.person;

import mx.edu.utez.aweb.pokemonapp.model.pokemon.BeanPokemon;
import mx.edu.utez.aweb.pokemonapp.model.pokemon.DaoPokemon;
import mx.edu.utez.aweb.pokemonapp.utils.MySQLConnection;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoPerson {
    Connection conn;
    PreparedStatement pstm;
    CallableStatement cstm;
    ResultSet rs;

    public List<BeanPerson> findAll(){
        List<BeanPerson> persons = new LinkedList<>();
        BeanPerson person;

        try {
            conn = new MySQLConnection().getConnection();
            String query = "SELECT * FROM persons;";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()) {
                person = new BeanPerson();
                person.setId(rs.getInt("id"));
                person.setName(rs.getString("name"));
                person.setSurname(rs.getString("surname"));
                person.setCurp(rs.getString("curp"));
                person.setBirthday(rs.getString("birthday"));
                persons.add(person);
            }

        }catch (SQLException e) {
            Logger.getLogger(DaoPerson.class.getName())
                    .log(Level.SEVERE, "Error findAll", e);
        } finally {
            closeConnections();
        }
        return persons;
    }

    public boolean save(BeanPerson person){
        try {
            conn = new MySQLConnection().getConnection();
            String query = "INSERT INTO persons" +
                    "(name, surname, curp, birthday)" +
                    " VALUES (?,?,?,?)";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, person.getName());
            pstm.setString(2, person.getSurname());
            pstm.setString(3, person.getCurp());
            pstm.setString(4, person.getBirthday());
            return pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            Logger.getLogger(DaoPerson.class.getName())
                    .log(Level.SEVERE, "Error save", e);
            return false;
        } finally {
            closeConnections();
        }
    }

    public BeanPerson findOne(int id) {
        try {
            conn = new MySQLConnection().getConnection();
            String query = "SELECT * FROM persons WHERE id = ?";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                BeanPerson person = new BeanPerson();
                person.setId(rs.getInt("id"));
                person.setName(rs.getString("name"));
                person.setSurname(rs.getString("surname"));
                person.setCurp(rs.getString("curp"));
                person.setBirthday(rs.getString("birthday"));
                return person;
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoPerson.class.getName())
                    .log(Level.SEVERE, "Error findOne", e);
        } finally {
            closeConnections();
        }
        return null;
    }

    public boolean update(BeanPerson person) {
        try {
            conn = new MySQLConnection().getConnection();
            String query = "UPDATE persons SET name = ?, surname = ?, curp = ?," +
                    "birthday = ? WHERE id = ?";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, person.getName());
            pstm.setString(2, person.getSurname());
            pstm.setString(3, person.getCurp());
            pstm.setString(4, person.getBirthday());
            pstm.setInt(5, person.getId());
            return pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            Logger.getLogger(DaoPerson.class.getName())
                    .log(Level.SEVERE, "Error update", e);
            return false;
        } finally {
            closeConnections();
        }
    }

    public boolean delete(int id) {
        try {
            conn = new MySQLConnection().getConnection();
            String query = "DELETE FROM persons WHERE id = ?";
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, id);
            return pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            Logger.getLogger(DaoPerson.class.getName())
                    .log(Level.SEVERE, "Error delete method");
            return false;
        } finally {
            closeConnections();
        }
    }

    private void closeConnections() {
        try {
            if (conn != null) {
                conn.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (cstm != null) {
                cstm.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
        }
    }
}
