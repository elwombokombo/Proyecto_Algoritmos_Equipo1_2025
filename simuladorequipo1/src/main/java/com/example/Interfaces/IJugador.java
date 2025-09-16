package com.example.Interfaces;

import com.example.ClasesProyecto.Equipo;

public interface IJugador {
    String getNombre();
    int getEdad();
    String getPosicion();
    int getId();
    

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

    String playerStats();
}

