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

    String tablaDePosiciones ();
}
