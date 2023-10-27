package com.example.Actividad3.Data;


import com.example.Actividad3.Aplication.Usecases;
import com.example.Actividad3.Dominio.VideoJuego;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RESController {
    private Usecases usecases;

    public RESController(){
        this.usecases = new Usecases(
                new RepositorySQL()
        );
    }
    @GetMapping("/videojuegos")
    List<VideoJuego> getAll(){
        return this.usecases.getAll();
    }

    @GetMapping("/videojuegos/{nombre}")
    VideoJuego buscar(@PathVariable String nombre){
        return this.usecases.getVideojuego(nombre);
    }

    @PutMapping(path = "/videojuegos/{nombre}", consumes = MediaType.APPLICATION_JSON_VALUE)
    boolean update(@PathVariable String nombre, @RequestBody Integer precio){
        return this.usecases.modificaprecio(nombre, precio);
    }

    @DeleteMapping("/videojuegos/{nombre}")
    boolean delete(@PathVariable String nombre){
        return this.usecases.eliminaVideojuego(nombre);
    }

}
