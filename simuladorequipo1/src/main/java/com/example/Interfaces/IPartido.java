package com.example.Interfaces;

import com.example.ClasesProyecto.Division;
import com.example.ClasesProyecto.Equipo;
import com.example.lista.impl.Conjunto;

public interface IPartido {
    void jugar();
    void actualizarEstadisticas();
    void localSumarEstadisticas();
    void visitanteSumarEstadisticas();
    String getMarcador();
    boolean terminado();
    int getGolesLocal();
    int getGolesVisitante();
    Equipo getLocal();
    Equipo getVisitante();
    Division getDivision();
    Conjunto<Equipo> getEquiposComoConjunto();
}