package com.example.Interfaces;

import com.example.ClasesProyecto.Jugador;

public interface IEquipo <Jugador extends Comparable <Jugador>> {
    Boolean estaVacio ();
    Jugador borrarJugador (String id);
    Boolean agregarJugador (Jugador jugador);
    Jugador buscarJugador (Jugador j);
    int cantidadDeJugadores();
    void mostrarJugadores();
}

