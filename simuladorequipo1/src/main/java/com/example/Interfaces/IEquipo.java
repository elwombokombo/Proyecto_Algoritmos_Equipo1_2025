package com.example.Interfaces;

import com.example.ClasesProyecto.Equipo;
import com.example.ClasesProyecto.Jugador;

public interface IEquipo {
    int compareTo(Equipo otro);
    Boolean estaVacio ();
    Jugador borrarJugador (Jugador idj);
    Boolean agregarJugador (Jugador jugador);
    Jugador buscarJugador (Jugador idj);
    int cantidadDeJugadores();
    String mostrarJugadores();
    String getId();
    Jugador buscarJugadorPorNombre(String nombre);
    Jugador buscarJugadorPorIndice(int i);
    
}

