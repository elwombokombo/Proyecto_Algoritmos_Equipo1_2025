package com.example.Interfaces;

import com.example.ClasesProyecto.Equipo;

public interface IEquipo <Jugador extends Comparable <Jugador>> {
    int compareTo(Equipo otro);
    Boolean estaVacio ();
    Jugador borrarJugador (String id);
    Boolean agregarJugador (Jugador jugador);
    Jugador buscarJugador (Jugador j);
    int cantidadDeJugadores();
    String mostrarJugadores();
    
}

