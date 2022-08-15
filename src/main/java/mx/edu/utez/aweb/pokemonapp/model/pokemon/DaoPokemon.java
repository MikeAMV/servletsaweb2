package mx.edu.utez.aweb.pokemonapp.model.pokemon;

import mx.edu.utez.aweb.pokemonapp.utils.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoPokemon {
    Connection conn;
    PreparedStatement pstm;
    CallableStatement cstm;
    ResultSet rs;

    public List<BeanPokemon> findAll() {
        List<BeanPokemon> pokemons = new LinkedList<>();
        BeanPokemon pokemon;
        try {
            conn = new MySQLConnection().getConnection();
            String query = "SELECT * FROM pokemons;";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()) {
                pokemon = new BeanPokemon();
                pokemon.setId(rs.getLong("id"));
                pokemon.setName(rs.getString("name"));
                pokemon.setPokemonType(rs.getString("type"));
                pokemon.setHealth(rs.getDouble("health"));
                pokemon.setHeight(rs.getDouble("height"));
                pokemon.setPower(rs.getDouble("power"));
                pokemon.setWeight(rs.getDouble("weight"));
                pokemon.setFileName(rs.getString("file_name"));
                pokemons.add(pokemon);
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoPokemon.class.getName())
                    .log(Level.SEVERE, "Error findAll", e);
        } finally {
            closeConnections();
        }
        return pokemons;
    }

    public boolean save(BeanPokemon pokemon) {
        try {
            conn = new MySQLConnection().getConnection();
            String query = "INSERT INTO pokemons" +
                    "(name, health, power, weigth, heigth, type, file_name)" +
                    " VALUES (?,?,?,?,?,?,?)";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, pokemon.getName());
            pstm.setDouble(2, pokemon.getHealth());
            pstm.setDouble(3, pokemon.getPower());
            pstm.setDouble(4, pokemon.getWeight());
            pstm.setDouble(5, pokemon.getHeight());
            pstm.setString(6, pokemon.getPokemonType());
            pstm.setString(7,pokemon.getFileName());
            return pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            Logger.getLogger(DaoPokemon.class.getName())
                    .log(Level.SEVERE, "Error save", e);
            return false;
        } finally {
            closeConnections();
        }
    }

    public BeanPokemon findOne(Long id) {
        try {
            conn = new MySQLConnection().getConnection();
            String query = "SELECT * FROM pokemons WHERE id = ?";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                BeanPokemon pokemon = new BeanPokemon();
                pokemon.setId(rs.getLong("id"));
                pokemon.setName(rs.getString("name"));
                pokemon.setPokemonType(rs.getString("type"));
                pokemon.setHealth(rs.getDouble("health"));
                pokemon.setHeight(rs.getDouble("heigth"));
                pokemon.setPower(rs.getDouble("power"));
                pokemon.setWeight(rs.getDouble("weigth"));
                return pokemon;
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoPokemon.class.getName())
                    .log(Level.SEVERE, "Error findOne", e);
        } finally {
            closeConnections();
        }
        return null;
    }

    public boolean update(BeanPokemon pokemon) {
        try {
            conn = new MySQLConnection().getConnection();
            String query = "UPDATE pokemons SET name = ?, type = ?, health = ?," +
                    "power = ?, weigth = ?, heigth = ? WHERE id = ?";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, pokemon.getName());
            pstm.setDouble(3, pokemon.getHealth());
            pstm.setDouble(4, pokemon.getPower());
            pstm.setDouble(5, pokemon.getWeight());
            pstm.setDouble(6, pokemon.getHeight());
            pstm.setString(2, pokemon.getPokemonType());
            pstm.setLong(7, pokemon.getId());
            return pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            Logger.getLogger(DaoPokemon.class.getName())
                    .log(Level.SEVERE, "Error update", e);
            return false;
        } finally {
            closeConnections();
        }
    }

    public boolean delete(Long id) {
        try {
            conn = new MySQLConnection().getConnection();
            String query = "DELETE FROM pokemons WHERE id = ?";
            pstm = conn.prepareStatement(query);
            pstm.setLong(1, id);
            return pstm.executeUpdate() == 1;
        } catch (SQLException e) {
            Logger.getLogger(DaoPokemon.class.getName())
                    .log(Level.SEVERE, "Error delete method");
            return false;
        } finally {
            closeConnections();
        }
    }

    public void closeConnections() {
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
