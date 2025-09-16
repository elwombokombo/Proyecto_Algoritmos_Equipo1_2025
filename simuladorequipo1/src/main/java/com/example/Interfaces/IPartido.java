package com.example.Interfaces;

import com.example.ClasesProyecto.Division;
import com.example.ClasesProyecto.Equipo;
import com.example.ClasesProyecto.Partido;
import com.example.lista.TDALista;
import java.time.LocalDateTime;

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
    Partido ultimoEnHistorial();
    Partido desapilarHistorial();
    int cantidadHistorial();
}