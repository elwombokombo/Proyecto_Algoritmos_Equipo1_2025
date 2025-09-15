package com.example.Interfaces;

import com.example.ClasesProyecto.Equipo;
import com.example.lista.impl.TDAListaEnlazada;

public interface IJugador {
    String getNombre();
    int getEdad();
    String getPosicion();
    String getId();

    int getGolesConvertidos();
    int getTarjetasRecibidas();
    int getPartidosDisputados();
    int getSancionesPendientes();
    Equipo getEquipo();

    void asignarEquipo(Equipo equipo);
    void sumarGol();
    void sumarTarjeta();
    void registrarPartido();
    void agregaSancion();
    void cumpleSancion();

    TDAListaEnlazada<String> playerStats();
}

