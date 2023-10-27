package com.example.Actividad3.Aplication;

import com.example.Actividad3.Dominio.VideoJuego;
import com.example.Actividad3.Dominio.VideoJuegoRepository;

import java.util.List;

public class Usecases {
    private VideoJuegoRepository videoJuegoRepository;

    public Usecases(VideoJuegoRepository videoJuegoRepository){
        this.videoJuegoRepository = videoJuegoRepository;
    }

    public List<VideoJuego> getAll(){
        return this.videoJuegoRepository.getAll();
    }
    public VideoJuego getVideojuego(String Nombre){
        return this.videoJuegoRepository.getVideojuego(Nombre);
    }
    public boolean eliminaVideojuego(String Nombre){
        return this.videoJuegoRepository.eliminaVideojuego(Nombre);
    }
    public boolean modificaprecio(String Nombre,Integer Precio){
        return this.videoJuegoRepository.modificaprecio(Nombre,Precio);
    }
}
