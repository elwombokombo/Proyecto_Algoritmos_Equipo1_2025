package com.example.ClasesProyecto;

import java.util.FormatFlagsConversionMismatchException;

import com.example.Interfaces.IDivision;
import com.example.ClasesProyecto.Equipo;
import com.example.lista.impl.TDAListaEnlazada;


public class Division <Equipo extends Comparable<Equipo>> implements IDivision<Equipo> {
    private TDAListaEnlazada<Equipo> listaEquipos = new TDAListaEnlazada<>();
    private String nombre;
    private int cantidadEquipos;

    public Division(String nombre, int cantidadEquipos){
        this.nombre = nombre;
        this. cantidadEquipos = cantidadEquipos;
    }

    @Override
    public Equipo buscarEquipo(Equipo nombreEquipo) {
        return listaEquipos.buscar(nombreEquipo);
    }

    @Override
    public Boolean agregarEquipo(Equipo nuevo){
        return listaEquipos.insertar(nuevo);    
    }

    @Override
    public Boolean eliminarEquipo(Equipo nombreEquipo) {
        return listaEquipos.eliminar(nombreEquipo) != null;
    }

    @Override
    public String mostrarEquipos() {
        return listaEquipos.imprimir();
    }

    @Override
    public void imprimirJugadores() {
        StringBuilder impresion = new StringBuilder();
        Equipo actual = listaEquipos.obtenerPorIndice(0);
        while (actual != null){
            Equipo equipo = actual.getDato();
            impresion.append(equipo.mostrarJugadores());
            actual = actual.getSiguiente();
        }    
    }

    public String imprimirJugadoresSeba() {
    StringBuilder sb = new StringBuilder();
    sb.append("Equipos de la división ").append(nombre).append(":\n");

    for (int i = 0; i < listaEquipos.cantElementos(); i++) {
        Equipo equipo = listaEquipos.obtenerPorIndice(i);
        sb.append(equipo.mostrarJugadores3()).append("\n");
        }

    return sb.toString();
}
    
    //Version Amadeo
    public void imprimirJugadoresAmadeo() {
        System.out.rintln("Division: " this.nombre);
        for (int i=0; i < listaEquipos.cantElementos() ; i++){
            Equipo actual = listaEquipos.obtenerPorIndice(i);
            actual.mostrarJugadores();
        }        
    }


    //Version Juan
    public String imprimirJugadores2(){
        String resultado = "";
        for (c = 0; c <= listaEquipos.cantElementos(); c++){
            Equipo actual = listaEquipos.obtenerPorIndice(c);
            resultado.append(actual.mostrarJugadores() + "\n");
        }
        return "Equipos de la division "+ this.nombre + " \n" + resultado;
    }   

}