package com.example.ClasesProyecto;

import com.example.lista.impl.ColaEnlazada;
import com.example.lista.impl.PilaListaEnlazada;

public class CalendarioPartido implements Comparable<Partido> {
    private ColaEnlazada<Partido> proximosPartidos;
    private PilaListaEnlazada<Partido> historialPartidos;

    public CalendarioPartido() {
        proximosPartidos = new ColaEnlazada<Partido>();
        historialPartidos = new PilaListaEnlazada<Partido>();
    }

    public void programarPartido(Partido partido){
        proximosPartidos.ponerEnCola(partido);
    }

    public Partido verProximoPartido(){
        return proximosPartidos.frente();
    }

    public Partido ultimoPartido(){
        return historialPartidos.tope();
    }

    public Partido sacarUltimoPartido(){
        return historialPartidos.sacar();
    }

    @Override
    public int compareTo(Partido o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
}
