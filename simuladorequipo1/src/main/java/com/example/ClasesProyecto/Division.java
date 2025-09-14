package com.example.ClasesProyecto;

import java.util.FormatFlagsConversionMismatchException;

import com.example.Interfaces.IDivision;
import com.example.ClasesProyecto.Equipo;
import com.example.lista.impl.TDAListaEnlazada;


public class Division <Equipo extends Comparable<Equipo>> implements IDivision<Equipo> {
    TDAListaEnlazada<Equipo> listaEquipos = new TDAListaEnlazada<>();
    String nombre;
    int cantidadEquipos;

    public Division(String nombre, int cantidadEquipos){
        this.nombre = nombre;
        this. cantidadEquipos = cantidadEquipos;
    }

    @Override
    public Equipo buscarEquipo(Comparable<Equipo> nombreEquipo) {
        return listaEquipos.buscar(nombreEquipo);
    }

    @Override
    public Boolean agregarEquipo(Comparable<Equipo> nombreEquipo) {
        return Equipo equipo = new Equipo(int id, String nombreEquipo);     //Ver como hacer esto
    }

    @Override
    public Boolean eliminarEquipo(Comparable<Equipo> nombreEquipo) {
        return listaEquipos.eliminar(nombreEquipo) == nombreEquipo;
       
    }

    @Override
    public String mostrarEquipos() {
        return listaEquipos.imprimir();
    }

    @Override
    public String imprimirJugadores() {
        for(Equipo equipo : listaEquipos){      // Ver como hacer esto
            equipo.mostrarJugadores();
        }
        return null;
    }

    
    

   
    
    
}