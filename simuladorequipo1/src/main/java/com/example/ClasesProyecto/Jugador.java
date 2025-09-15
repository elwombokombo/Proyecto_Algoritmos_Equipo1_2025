package com.example.ClasesProyecto;

import com.example.Interfaces.IJugador;
import com.example.lista.TDALista;
import com.example.lista.impl.TDAListaEnlazada;

public class Jugador implements IJugador, Comparable<Jugador> {

    TDAListaEnlazada<String> s = new TDAListaEnlazada<>(); 
    private String id;
    private String nombre;
    private int edad;
    private String posicion;

    private int golesConvertidos;
    private int tarjetasRecibidas;
    private int partidosDisputados;
    private int sancionesPendientes;
    private Equipo equipo;

    public Jugador(String id, String nombre, int edad, String posicion) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.posicion = posicion;
        this.golesConvertidos = 0;
        this.tarjetasRecibidas = 0;
        this.partidosDisputados = 0;
        this.sancionesPendientes = 0;
        this.equipo = null;
    }


    @Override public String getNombre() { return nombre; }
    @Override public int getEdad() { return edad; }
    @Override public String getPosicion() { return posicion; }
    @Override public int getGolesConvertidos() { return golesConvertidos; }
    @Override public int getTarjetasRecibidas() { return tarjetasRecibidas; }
    @Override public int getPartidosDisputados() { return partidosDisputados; }

    @Override 
    public String getId(){
        return id;
    }

    @Override
    public int getSancionesPendientes(){
        return sancionesPendientes;
    }

    @Override
    public void asignarEquipo(Equipo equipo) {
        this.equipo = equipo;   
    }
    @Override
    public Equipo getEquipo(){
        return equipo;
    }


    @Override public void sumarGol()         { golesConvertidos++; }
    @Override public void sumarTarjeta()     { tarjetasRecibidas++; }
    @Override public void registrarPartido() { partidosDisputados++; }
    @Override
    public void agregaSancion(){
        sancionesPendientes++;
    }
    @Override
    public void cumpleSancion(){
        if (sancionesPendientes > 0){
            sancionesPendientes --;
        }
    }


    @Override
    public TDAListaEnlazada<String> playerStats() {

        s.insertar("Jugador: " + nombre);
        s.insertar("Posición: " + posicion + " | Edad: " + edad);
        s.insertar("PJ: " + partidosDisputados);
        s.insertar("Goles: " + golesConvertidos);
        s.insertar("Tarjetas: " + tarjetasRecibidas);
        return s;
    }
   
    @Override
    public String toString() {
        return nombre + " (" + posicion + ") PJ: " + partidosDisputados +
               " G: " + golesConvertidos + " T: " + tarjetasRecibidas + "S: " + sancionesPendientes;
    }


    @Override
    public int compareTo(Jugador otro) {
        return this.id.compareTo(otro.id);
    }
}
