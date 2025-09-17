package com.example.ClasesProyecto;

import com.example.Interfaces.IDivision;
import com.example.lista.impl.Conjunto;
import com.example.lista.impl.PilaListaEnlazada;
import com.example.lista.impl.TDAListaEnlazada;

public class Division extends TDAListaEnlazada<Equipo> implements IDivision, Comparable<Division> {
   // private TDAListaEnlazada<Equipo> listaEquipos = new TDAListaEnlazada<>();
    private String nombre;
    private int cantidadEquipos;
    public PilaListaEnlazada<Partido> historialPartidos;

    public Division(String nombre, int cantidadEquipos){
        this.nombre = nombre;
        this. cantidadEquipos = cantidadEquipos;
        this.historialPartidos = new PilaListaEnlazada<>();
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
    public PilaListaEnlazada<Partido> mostrarHistorial(){
        return historialPartidos;
    }

    @Override
    public void registrarPartido(Partido partido){
        historialPartidos.push(partido);
    }

    public boolean yaJugaron(Equipo e1, Equipo e2) {
        Conjunto<Equipo> buscados = new Conjunto<>();
        buscados.insertarSinRepetidos(e1);
        buscados.insertarSinRepetidos(e2);

        PilaListaEnlazada<Partido> aux = new PilaListaEnlazada<>();
        boolean encontrados = false;

        while (!historialPartidos.esVacia()) {
            Partido p = historialPartidos.sacar();
            aux.push(p);

            // comparamos conjuntos
            if (p.getEquiposComoConjunto().equals(buscados)) {
                encontrados = true;
            }
        }

        // restauramos la pila
        while (!aux.esVacia()) {
            historialPartidos.push(aux.sacar());
        }

        return encontrados;
    }

    @Override
    public int compareTo(Division division) {
        return this.nombre.compareTo(division.getNombre());
    }




}