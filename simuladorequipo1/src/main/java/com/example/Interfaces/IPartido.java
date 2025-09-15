package com.example.Interfaces;

import com.example.lista.TDALista;

import java.time.LocalDateTime;

public interface IPartido {
    public interface Partido {



        interface Gol extends Comparable<Gol> {
            String getEquipo();
            String getJugador();
            int getMinuto();
        }

        interface Resultado extends Comparable<Resultado> {
            String getLocal();
            String getVisitante();
            int getGolesLocal();
            int getGolesVisitante();
            java.time.LocalDateTime getFecha();
        }

        interface EstadisticaEquipo extends Comparable<EstadisticaEquipo> {
            String getEquipo();
            int getGolesAnotados();
            int getGolesRecibidos();
        }
    }

}
