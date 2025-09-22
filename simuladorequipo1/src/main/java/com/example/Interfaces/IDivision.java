package com.example.Interfaces;

import com.example.ClasesProyecto.Equipo;
import com.example.ClasesProyecto.Partido;
import com.example.lista.impl.PilaListaEnlazada;
public interface IDivision {
    Equipo buscarEquipo(Equipo nombreEquipo);

    Boolean agregarEquipo(Equipo nuevo);

    Boolean eliminarEquipo(Equipo nombreEquipo); 

    String mostrarEquipos();

    String imprimirJugadores();

    PilaListaEnlazada<Partido> mostrarHistorial();

    void registrarPartido(Partido partido);

    void mostrarTablaDePosiciones();

    Equipo buscarEquipoPorNombre(String nombreEquipo);

    String mostrarHistorialString();

    boolean yaJugaron(Equipo e1, Equipo e2);

    String tablaDePosiciones();

    void jugarTodosLosPartidos();
}