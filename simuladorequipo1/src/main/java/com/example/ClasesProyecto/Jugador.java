package com.example.ClasesProyecto;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

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

    public void sumarGol()        { golesConvertidos++; }
    public void sumarTarjeta()    { tarjetasRecibidas++; }
    public void registrarPartido(){ partidosDisputados++; } 


    public List<String> playerStats() {
        List<String> s = new ArrayList<>();
        s.add("Jugador: " + nombre);
        s.add("Posición: " + posicion + " | Edad: " + edad);
        s.add("PJ: " + partidosDisputados);
        s.add("Goles: " + golesConvertidos);
        s.add("Tarjetas: " + tarjetasRecibidas);
        return s;
    }

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getPosicion() { return posicion; }
    public int getGolesConvertidos() { return golesConvertidos; }
    public int getTarjetasRecibidas() { return tarjetasRecibidas; }
    public int getPartidosDisputados() { return partidosDisputados; }

    @Override
    public String toString() {
        return nombre + " (" + posicion + ") PJ:" + partidosDisputados +
               " G:" + golesConvertidos + " T:" + tarjetasRecibidas;
    }
}

