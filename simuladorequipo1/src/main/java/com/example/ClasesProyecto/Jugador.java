package com.example.ClasesProyecto;

import com.example.Interfaces.IJugador;

public class Jugador implements IJugador, Comparable<Jugador> {

    //TDAListaEnlazada<String> s = new TDAListaEnlazada<>(); 
    public static int contadorId = 0;
    private Integer id;
    private String nombre;
    private int edad;
    private String posicion;

    private int golesConvertidos;
    private int tarjetasRecibidas;
    private int partidosDisputados;
    private int sancionesPendientes;
    private Equipo equipo;

    public Jugador(String nombre, int edad, String posicion) {
        this.id = ++contadorId; //Cada jugador tiene una id unica
        this.nombre = nombre;
        this.edad = edad;
        this.posicion = posicion;
        this.golesConvertidos = 0;
        this.tarjetasRecibidas = 0;
        this.partidosDisputados = 0;
        this.sancionesPendientes = 0;
        this.equipo = null; //arranca sin equipo
    }


    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getPosicion() { return posicion; }
    public int getGolesConvertidos() { return golesConvertidos; }
    public int getTarjetasRecibidas() { return tarjetasRecibidas; }
    public int getPartidosDisputados() { return partidosDisputados; }
    public int getId(){
        return id;
    }
    public int getSancionesPendientes(){
        return sancionesPendientes;
    }

    public Equipo getEquipo(){
            return equipo;
    }

    @Override
    public void asignarEquipo(Equipo equipo) {
        this.equipo = equipo;   
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


    /*@Override
    public TDAListaEnlazada<String> playerStats() {

        s.insertar("Jugador: " + nombre);
        s.insertar("Posición: " + posicion + " | Edad: " + edad);
        s.insertar("PJ: " + partidosDisputados);
        s.insertar("Goles: " + golesConvertidos);
        s.insertar("Tarjetas: " + tarjetasRecibidas);
        return s;
    }*/

    @Override
    public String playerStats(){
        StringBuilder str = new StringBuilder();
        str.append("Jugador: " + nombre + "\n");
        str.append("Posicion: " + posicion + "\n");
        str.append("Edad: " + edad + "\n");
        str.append("PJ: " + partidosDisputados + "\n");
        str.append("Goles: " + golesConvertidos + "\n");
        str.append("Tarjetas: " + tarjetasRecibidas + "\n");
        return str.toString();
    }
   
    @Override
    public int compareTo(Jugador otro) {
        return this.id.compareTo(otro.getId());
    }

    @Override
    public String toString (){
        return nombre + " ("+ posicion + ", " + edad + " años)"; 
    }
    
}