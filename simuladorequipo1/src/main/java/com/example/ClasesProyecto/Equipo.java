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

    public String getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }
    
    public int compareTo(Equipo equipo){
        return this.id.compareTo(equipo.getId());
    }

    @Override
    public Boolean estaVacio() {
        return jugadores.esVacia();
    }

    @Override
    public Jugador borrarJugador(String id) {//hacer cuando este jugador
        return null;
    }

    @Override
    public Boolean agregarJugador(Jugador nuevo) { //Hacer cuando este jugador
        return null;
    
    }

    public Jugador buscarJugador(Jugador j){//Hacer cuando este jugador
        return null;

    }

    public int cantidadDeJugadores(){
        return jugadores.cantElementos();
    }

    public String mostrarJugadores(){
        return "Jugadores del equipo " + this.nombre + ": \n" + jugadores.imprimir( " | " );
    }

    public String mostrarJugadores3() {
    StringBuilder str = new StringBuilder();
    str.append("Jugadores del equipo ").append(this.nombre).append(":\n");
    str.append(jugadores.imprimir("|"));
    return str.toString();
}


}
