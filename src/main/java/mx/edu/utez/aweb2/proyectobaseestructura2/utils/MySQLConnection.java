package mx.edu.utez.aweb2.proyectobaseestructura2.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    public Connection getConnection(){
        final String DBNAME = "base",
                USERNAME = "root",
                TIMEZONE = "America/Mexico_City",
                USESSL = "false",
                PUBLICKEY = "true";
        String connectionString = String.format("jdbc:mysql://localhost:3306/%s?user=%s&" +
                "serverTimezone=%s&useSSL=%s&allowPublicKeyRetrieval=%s", DBNAME, USERNAME, TIMEZONE, USESSL, PUBLICKEY);
        try{
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            return DriverManager.getConnection(connectionString);
        }catch(SQLException ex){
            System.out.println(this.getClass().getCanonicalName() + " -> " +
                    ex.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        Connection conexion = new MySQLConnection().getConnection();
        if(conexion != null)
            System.out.println("Conectado");
        else
            System.out.println("No conectado");
    }
}