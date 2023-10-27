package com.example.Actividad3.Data;

import com.example.Actividad3.Connexion.ConectionManager;
import com.example.Actividad3.Dominio.VideoJuego;
import com.example.Actividad3.Dominio.VideoJuegoRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RepositorySQL implements VideoJuegoRepository {
    @Override
    public List<VideoJuego> getAll() {
        List<VideoJuego> Lista = new ArrayList<>();

        try{
            String Query = "SELECT * FROM Videojuego";
            PreparedStatement preparedStatement = ConectionManager.getConexion("Videojuegos").prepareStatement(Query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                Lista.add(new VideoJuego(rs.getString("nombre"), rs.getString("categoria"), rs.getInt("precio")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Lista;
    }

    @Override
    public VideoJuego getVideojuego(String Nombre) {
        VideoJuego videoJuego = null;
        try{
            String Query = "SELECT * FROM Videojuego WHERE nombre = '"+Nombre+"'";
            PreparedStatement preparedStatement = ConectionManager.getConexion("Videojuegos").prepareStatement(Query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                videoJuego= (new VideoJuego(rs.getString("nombre"), rs.getString("categoria"), rs.getInt("precio")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return videoJuego;
    }

    @Override
    public boolean eliminaVideojuego(String Nombre) {
        try {
            Statement statement = ConectionManager.getConexion("Videojuegos").createStatement();

            String sql = "DELETE FROM Videojuego WHERE nombre = '" +Nombre+ "'";

            int comprobador = statement.executeUpdate(sql);

            if(comprobador > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean modificaprecio(String Nombre, Integer precio) {
        VideoJuego videoJuego = null;
        try{
            Statement statement = ConectionManager.getConexion("Videojuegos").createStatement();

            String sql = "UPDATE Videojuego SET precio = " +precio+ " WHERE nombre = '" +Nombre+ "'";

            int comprobador = statement.executeUpdate(sql);

            if(comprobador > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
