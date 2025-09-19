package com.example.Interfaces;

import com.example.ClasesProyecto.Division;
import com.example.ClasesProyecto.Equipo;
import com.example.ClasesProyecto.Jugador;

public interface ILigaUcu {
    boolean agregarDivision(Division division);
    Division buscarDivision(String nombre);
    boolean eliminarDivision(Division division);
    String mostrarDivisiones();
    boolean agregarEquipoDivision(String nombre, Equipo equipo);
    Equipo buscarEquipoId(String idEquipo);
    boolean eliminarEquipo(String idEquipo);
    boolean agregarJugadorEquipo(String idEquipo, Jugador jugador);
    Jugador buscarJugadorPorId(int idJugador);
    //void generarFixture(String nombreDivision);
    //String mostrarFixture(String nombreDivision);
}
