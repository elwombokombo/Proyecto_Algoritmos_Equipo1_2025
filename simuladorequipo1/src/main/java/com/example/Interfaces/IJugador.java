package com.example.Interfaces;


import com.example.ClasesProyecto.Equipo;

public interface IJugador {
    void asignarEquipo(Equipo equipo);
    void sumarGol();
    void sumarTarjeta();
    void registrarPartido();
    void agregaSancion();
    void cumpleSancion();

    String playerStats();
}