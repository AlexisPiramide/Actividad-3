package com.example.Actividad3.Data;

import com.example.Actividad3.Aplication.Usecases;
import com.example.Actividad3.Connexion.ConectionManager;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class RepositorySQLTest {

    Usecases usecases;

    public RepositorySQLTest(){
        this.usecases = new Usecases(
                new RepositorySQL()
        );
    }
    String Clear = "DELETE FROM Videojuego";
    String SetDefaultGetAll = "INSERT INTO Videojuego (nombre, categoria, precio)VALUES ('The Legend of Zelda: Breath of the Wild', 'Aventura', 59.99),('Red Dead Redemption 2', 'Acción/Aventura', 49.99), ('FIFA 22', 'Deportes', 39.99), ('Cyberpunk 2077', 'RPG', 54.99), ('Super Mario Odyssey', 'Plataformas', 49.99), ('Call of Duty: Warzone', 'Disparos', 0), ('Animal Crossing: New Horizons','Simulación', 49.99), ('The Witcher 3: Wild Hunt', 'RPG', 29.99), ('Minecraft', 'Sandbox', 26.99), ('Among Us', 'Estrategia', 4.99)";
    String SetDefaultUnico = "INSERT INTO Videojuego (nombre, categoria, precio)VALUES ('The Legend of Zelda: Breath of the Wild', 'Aventura', 59.99)";

    @Test
    void getAll() {
        try {
            Statement statement = ConectionManager.getConexion("Videojuegos").createStatement();
            statement.executeUpdate(Clear);
            statement.executeUpdate(SetDefaultGetAll);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        assertEquals(10, usecases.getAll().size());
    }

    @Test
    void getVideojuego() {
        try {
            Statement statement = ConectionManager.getConexion("Videojuegos").createStatement();
            statement.executeUpdate(Clear);
            statement.executeUpdate(SetDefaultUnico);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        assertEquals("The Legend of Zelda: Breath of the Wild", usecases.getVideojuego("The Legend of Zelda: Breath of the Wild").getNombre());

    }

    @Test
    void eliminaVideojuego() {
        try {
            Statement statement = ConectionManager.getConexion("Videojuegos").createStatement();
            statement.executeUpdate(Clear);
            statement.executeUpdate(SetDefaultUnico);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        assertEquals(true, usecases.eliminaVideojuego("The Legend of Zelda: Breath of the Wild"));

    }

    @Test
    void modificaprecio() {
        try {
            Statement statement = ConectionManager.getConexion("Videojuegos").createStatement();
            statement.executeUpdate(Clear);
            statement.executeUpdate(SetDefaultUnico);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        assertEquals(true, usecases.modificaprecio("The Legend of Zelda: Breath of the Wild",99));

    }
}