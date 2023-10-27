package com.example.Actividad3.Dominio;

import java.util.List;

public interface VideoJuegoRepository {

    public List<VideoJuego> getAll();
    public VideoJuego getVideojuego(String Nombre);
    public boolean eliminaVideojuego(String Nombre);
    public boolean modificaprecio(String Nombre,Integer precio);
}
