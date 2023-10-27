package com.example.Actividad3.Connexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionManager {

    private static Connection con;
    private static ConectionManager conexionBD;
    private static String direccion = "basejugadores.cdtiqtgskb74.us-east-1.rds.amazonaws.com";
    private static String usuario = "admin";
    private static String Password = "18175118N";

    private ConectionManager(String bd){

        try {
            con = DriverManager.getConnection("jdbc:mysql://"+direccion+":3306/" + bd ,usuario,Password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConexion(String bd){

        if(conexionBD == null)
            conexionBD = new ConectionManager(bd);
        return con;
    }

    public static void closeConexion(){

        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}