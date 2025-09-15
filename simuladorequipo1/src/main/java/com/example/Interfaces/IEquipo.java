package com.example.Interfaces;

import com.example.ClasesProyecto.Equipo;

public interface IEquipo <Jugador> {
    int compareTo(Equipo otro);
    Boolean estaVacio ();
    Jugador borrarJugador (String idj);
    Boolean agregarJugador (Jugador jugador);
    Jugador buscarJugador (String idj);
    int cantidadDeJugadores();
    String mostrarJugadores();
    String getId();
    
}

