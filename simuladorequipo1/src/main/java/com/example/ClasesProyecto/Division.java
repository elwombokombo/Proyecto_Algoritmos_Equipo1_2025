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
    public Equipo buscarEquipoPorNombre(String nombreEquipo) {
        for (int i = 0; i < cantElementos(); i++) {
            Equipo e = obtenerPorIndice(i);
            if (e.getNombre().equalsIgnoreCase(nombreEquipo)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public Boolean agregarEquipo(Equipo nuevo){
        return insertar(nuevo);    
    }

    @Override
    public Boolean eliminarEquipo(Equipo nombreEquipo) {
        return eliminar(nombreEquipo) != null;
    }
    public Boolean eliminarEquipoPorNombre(String nombreEquipo) {
    for (int i = 0; i < cantElementos(); i++) {
        Equipo e = obtenerPorIndice(i);
        if (e.getNombre().equalsIgnoreCase(nombreEquipo)) {
            eliminarEquipo(e); // elimina el nodo internamente
            return true;
        }
    }
    return false;
    }
    
    @Override
    public String mostrarEquipos() {
        StringBuilder sb = new StringBuilder("Equipos en la división " + nombre + ":\n");
        for (int i = 0; i < cantElementos(); i++) {
            Equipo e = obtenerPorIndice(i);
            sb.append(" - ").append(e.getNombre()).append("\n");
        }
        return sb.toString();
    }
    
    @Override
    public String imprimirJugadores() {
        StringBuilder str = new StringBuilder();
        str.append("Equipos de la división ").append(nombre).append(":\n");

        for (int i = 0; i < cantElementos(); i++) {
            Equipo equipo = obtenerPorIndice(i);
            str.append(equipo.mostrarJugadores()).append("\n");
            }

        return str.toString();
    }

    @Override
    public PilaListaEnlazada<Partido> mostrarHistorial(){
        return historialPartidos;
    }

    @Override
    public String mostrarHistorialString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Historial de partidos de la división ").append(nombre).append(":\n");

        PilaListaEnlazada<Partido> aux = new PilaListaEnlazada<>();

        while (!historialPartidos.esVacia()) {
            Partido p = historialPartidos.sacar();
            sb.append(p).append("\n"); 
            aux.push(p);
        }

        while (!aux.esVacia()) {
            historialPartidos.push(aux.sacar());
        }

        return sb.toString();
    }

    @Override
    public void registrarPartido(Partido partido){
        historialPartidos.push(partido);
    }

    @Override
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
    public int compareTo(Division o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    //Nueva tabla de posiciones

    @Override
    public String tablaDePosiciones() {
        if (cantElementos() == 0) {
            return "No hay equipos en la división " + nombre;
        }

        TDAListaEnlazada<Equipo> copia = new TDAListaEnlazada<>();
        for (int i = 0; i < cantElementos(); i++) {
            copia.insertar(obtenerPorIndice(i));
        }

        int n = copia.cantElementos();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                Equipo e1 = copia.obtenerPorIndice(j);
                Equipo e2 = copia.obtenerPorIndice(j + 1);

                if (e1.compareTo(e2) < 0) {
                    
                    Equipo temp = e1;
                    copia.modificarPorIndice(j, e2);
                    copia.modificarPorIndice(j + 1, temp);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Tabla de posiciones - División ").append(nombre).append(":\n");

        for (int i = 0; i < copia.cantElementos(); i++) {
            Equipo e = copia.obtenerPorIndice(i);
            sb.append((i + 1)).append(". ")
            .append(e.getNombre())
            .append(" - ").append(e.getPuntos()).append(" pts, ")
            .append(e.getGanados()).append("G-")
            .append(e.getEmpatados()).append("E-")
            .append(e.getPerdidos()).append("P, DG: ")
            .append(e.getDiferenciaDeGol()).append("\n");
        }

        return sb.toString();
    }
    
    @Override
    public void jugarTodosLosPartidos() {
        PilaListaEnlazada<Partido> aux = new PilaListaEnlazada<>();

        while (!historialPartidos.esVacia()) {
            Partido p = historialPartidos.sacar();
            if (!p.terminado()) {
                p.jugar(); 
            }
            aux.push(p);
        }

        while (!aux.esVacia()) {
            historialPartidos.push(aux.sacar());
        }
    }



}