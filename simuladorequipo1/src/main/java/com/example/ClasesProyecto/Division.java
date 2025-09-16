package com.example.ClasesProyecto;

import com.example.Interfaces.IDivision;
import com.example.lista.TDAPila;
import com.example.lista.impl.TDAListaEnlazada;


public class Division extends TDAListaEnlazada<Equipo> implements IDivision {
   // private TDAListaEnlazada<Equipo> listaEquipos = new TDAListaEnlazada<>();
    private String nombre;
    private int cantidadEquipos;
    public TDAPila historialPartidos;

    public Division(String nombre, int cantidadEquipos){
        this.nombre = nombre;
        this. cantidadEquipos = cantidadEquipos;
    }
    public String getNombre(){
        return this.nombre;
    }

    public int getCantidadEquipos(){
        return this.cantidadEquipos;
    }


    @Override
    public Equipo buscarEquipo(Equipo nombreEquipo) {
        return buscar(nombreEquipo);
    }

    @Override
    public Boolean agregarEquipo(Equipo nuevo){
        return insertar(nuevo);    
    }

    @Override
    public Boolean eliminarEquipo(Equipo nombreEquipo) {
        return eliminar(nombreEquipo) != null;
    }

    @Override
    public String mostrarEquipos() {
        return imprimir();
    }
    
    @Override
    public String imprimirJugadores() {
    StringBuilder str = new StringBuilder();
    str.append("Equipos de la división ").append(nombre).append(":\n");

    for (int i = 0; i < cantElementos(); i++) {
        Equipo equipo = obtenerPorIndice(i);
        str.append(equipo.mostrarJugadores3()).append("\n");
        }

    return str.toString();
    }
    
    @Override
    public TDAPila mostrarHistorial(){
        return historialPartidos;
    }

}