package com.example.Actividad3.Dominio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VideoJuegoTest {

    VideoJuego Starfield = new VideoJuego("Starfield","Espacio",59);

    @Test
    void getNombre() {
        assertEquals("Starfield",Starfield.getNombre());
    }

    @Test
    void setNombre() {
        Starfield.setNombre("Starfield Modificado");
        assertEquals("Starfield Modificado",Starfield.getNombre());
    }

    @Test
    void getCategoria() {
        assertEquals("Espacio",Starfield.getCategoria());
    }

    @Test
    void setCategoria() {
        Starfield.setCategoria("Espacio Modificado");
        assertEquals("Espacio Modificado",Starfield.getCategoria());
    }

    @Test
    void getPrecio() {
        assertEquals(59,Starfield.getPrecio());
    }

    @Test
    void setPrecio() {
        Starfield.setPrecio(60);
        assertEquals(60,Starfield.getPrecio());
    }
}