package com.example.Interfaces;

public interface IDivision <Equipo extends Comparable <Equipo>>{
    Equipo buscarEquipo(Equipo nombreEquipo);

    Boolean agregarEquipo(Equipo nuevo);

    Boolean eliminarEquipo(Equipo nombreEquipo); 

    String mostrarEquipos();

    void imprimirJugadores();
}
