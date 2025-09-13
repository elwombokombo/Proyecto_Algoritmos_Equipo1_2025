package com.example.ClasesProyecto;

import com.example.Interfaces.IEquipo;
import com.example.lista.impl.TDAListaEnlazada;


public class Equipo <Jugador extends Comparable <Jugador>> implements IEquipo<Jugador> {
    private String id;
    private String nombre;
    private int puntos;
    private Division divisionAsignada;
    private TDAListaEnlazada<Jugador> jugadores;

    public Equipo(String id, String nombre){
        this.id = id;
        this.nombre = nombre;
        this.jugadores = new TDAListaEnlazada<>();
    }

    @Override
    public Boolean estaVacio() {
        return jugadores.esVacia();
    }

    @Override
    public Jugador borrarJugador(String id) {
        return null;
    }

    @Override
    public Boolean agregarJugador(Jugador nuevo) {
        return null;
    
    }

    public Jugador buscarJugador(Jugador j){
        return null;

    }

    public int cantidadDeJugadores(){
        return jugadores.cantElementos();
    }

    public void mostrarJugadores(){
        System.out.println("Jugadores del equipo "+ this.nombre +":");
        System.out.println(jugadores.imprimir( "|" ));
    }

    
}
