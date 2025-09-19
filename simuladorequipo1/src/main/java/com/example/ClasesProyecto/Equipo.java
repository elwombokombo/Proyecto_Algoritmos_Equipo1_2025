package com.example.ClasesProyecto;

import com.example.Interfaces.IEquipo;
import com.example.lista.impl.TDAListaEnlazada;

public class Equipo implements IEquipo, Comparable<Equipo> {
    private String id;
    private String nombre;
    private Division divisionAsignada;

    private TDAListaEnlazada<Jugador> jugadores;
    private CalendarioPartido calendario;

    protected int puntos;
    protected int partidosTerminados;
    protected int ganados;
    protected int empatados;
    protected int perdidos;
    protected int golesAFavor;
    protected int golesEnContra;

    public Equipo(String id, String nombre, Division division){
        this.id = id;
        this.nombre = nombre;
        this.divisionAsignada = division;
        this.jugadores = new TDAListaEnlazada<>();
        //this.calendario = new CalendarioPartido<>();
        this.partidosTerminados = 0;
        this.ganados = 0;
        this.empatados = 0;
        this.perdidos = 0;
        this.golesAFavor = 0;
        this.golesEnContra = 0;
        this.puntos = 0;
    }


    public String getId(){
        return id;
    }
    public String getNombre(){
        return nombre;
    }
    public Division getDivision() { return divisionAsignada; }
    public int getPuntos() {return puntos; }
    public int getPartidosTerminados() { return partidosTerminados; }
    public int getGanados() {return ganados; }
    public int getEmpatados() {return empatados; }
    public int getPerdidos() {return perdidos; }
    public int getGolesAFavor() {return golesAFavor; }
    public int getGolesEnContra() {return golesEnContra; }
    public int getDiferenciaDeGol() {return golesAFavor - golesEnContra;}

    @Override
    public Boolean estaVacio() {
        return jugadores.esVacia();
    }

    @Override
    public Jugador borrarJugador(Jugador jugador) {
        return jugadores.eliminar(jugador);
    }

    //jugador lewandoski= new Jugador (...)
    //...
    //Barcelona.borrarJugador(lewandoski)

    @Override
    public Boolean agregarJugador(Jugador nuevo) { 
        if (nuevo.getEquipo() != null){
            return false;
        }
        boolean agregado = jugadores.insertar(nuevo);
        if (agregado){
            nuevo.asignarEquipo(this);
        }
        return agregado;
    }


    @Override
    public Jugador buscarJugador(Jugador jugador){
        return jugadores.buscar(jugador);   
    }

    public Jugador buscarJugadorPorNombre(String nombre) {
    for (int i = 0; i < jugadores.cantElementos(); i++) {
        Jugador j = jugadores.obtenerPorIndice(i);
        if (j.getNombre().equalsIgnoreCase(nombre)) {
            return j;
        }
    }
    return null;
}

    public Jugador buscarJugadorPorIndice(int i) {
    return jugadores.obtenerPorIndice(i);
}
   

    @Override
    public int cantidadDeJugadores(){
        return jugadores.cantElementos();
    }

    @Override
    public String mostrarJugadores(){
        return "Jugadores del equipo " + this.nombre + ": \n" + jugadores.imprimir( " | " );
    }


    public String mostrarJugadores3() {
        StringBuilder str = new StringBuilder();
        str.append("Jugadores del equipo ").append(this.nombre).append(":\n");
        str.append(jugadores.imprimir("|"));
        return str.toString();
    }
    

    // metodo para la tabla de posiciones
    @Override
    public int compareTo (Equipo otro){
        if (this.puntos != otro.getPuntos()){
            return Integer.compare(this.puntos, otro.getPuntos());
        }
        if (this.getDiferenciaDeGol() != otro.getDiferenciaDeGol()){
            return Integer.compare(this.getDiferenciaDeGol(), otro.getDiferenciaDeGol());
        }
        return Integer.compare(this.golesAFavor, otro.getGolesAFavor());
    }

}
