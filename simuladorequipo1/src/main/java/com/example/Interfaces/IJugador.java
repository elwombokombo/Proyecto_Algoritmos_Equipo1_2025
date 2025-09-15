package com.example.Interfaces;

import com.example.lista.TDALista;

public interface IJugador {
    String getNombre();
    int getEdad();
    String getPosicion();

    int getGolesConvertidos();
    int getTarjetasRecibidas();
    int getPartidosDisputados();

    void sumarGol();
    void sumarTarjeta();
    void registrarPartido();

    TDALista<String> playerStats();
}

