package com.example.Interfaces;

import com.example.lista.TDALista;

import java.time.LocalDateTime;

public interface IPartido {

    Gol extends Comparable<Gol> {
            String getEquipo();
            String getJugador();
            int getMinuto();
        }
    Resultado extends Comparable<Resultado> {
        String getLocal();
        String getVisitante();
        int getGolesLocal();
        int getGolesVisitante();
        java.time.LocalDateTime getFecha();
    }
}
