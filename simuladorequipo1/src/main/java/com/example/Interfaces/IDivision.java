package com.example.Interfaces;

public interface IDivision <Equipo extends Comparable<Equipo>> {
    Equipo buscarEquipo(Comparable<Equipo> nombreEquipo);

    Boolean agregarEquipo(Comparable<Equipo> nombreEquipo);

    Boolean eliminarEquipo(Comparable<Equipo> nombreEquipo); 

    String mostrarEquipos();

    String imprimirJugadores();
}
