package com.example.Interfaces;

import com.example.ClasesProyecto.Division;
import com.example.ClasesProyecto.Equipo;

public interface IPartido {
    void jugar();
    void actualizarEstadisticas();
    void localSumarEstadisticas();
    void visitanteSumarEstadisticas();
    String getMarcador();
    boolean fueTerminado();
    int getGolesLocal();
    int getGolesVisitante();
    Equipo getLocal();
    Equipo getVisitante();
    Division getDivision();
}