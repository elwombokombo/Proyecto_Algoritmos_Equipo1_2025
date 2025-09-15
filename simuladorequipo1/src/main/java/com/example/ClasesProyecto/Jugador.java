package com.example.ClasesProyecto;

import com.example.Interfaces.IJugador;
import com.example.lista.TDALista;
import com.example.lista.impl.TDAListaEnlazada;

public class Jugador implements IJugador, Comparable<Jugador> {

    TDALista<String> s = new TDAListaEnlazada<>(); 
    private String nombre;
    private int edad;
    private String posicion;

    private int golesConvertidos;
    private int tarjetasRecibidas;
    private int partidosDisputados;

    public Jugador(String nombre, int edad, String posicion) {
        this.nombre = nombre;
        this.edad = edad;
        this.posicion = posicion;
        this.golesConvertidos = 0;
        this.tarjetasRecibidas = 0;
        this.partidosDisputados = 0;
    }

    @Override public void sumarGol()         { golesConvertidos++; }
    @Override public void sumarTarjeta()     { tarjetasRecibidas++; }
    @Override public void registrarPartido() { partidosDisputados++; }

    @Override
    public TDALista<String> playerStats() {

        s.insertar("Jugador: " + nombre);
        s.insertar("Posición: " + posicion + " | Edad: " + edad);
        s.insertar("PJ: " + partidosDisputados);
        s.insertar("Goles: " + golesConvertidos);
        s.insertar("Tarjetas: " + tarjetasRecibidas);
        return s;
    }

    @Override public String getNombre() { return nombre; }
    @Override public int getEdad() { return edad; }
    @Override public String getPosicion() { return posicion; }
    @Override public int getGolesConvertidos() { return golesConvertidos; }
    @Override public int getTarjetasRecibidas() { return tarjetasRecibidas; }
    @Override public int getPartidosDisputados() { return partidosDisputados; }

    @Override
    public String toString() {
        return nombre + " (" + posicion + ") PJ:" + partidosDisputados +
               " G:" + golesConvertidos + " T:" + tarjetasRecibidas;
    }
}
