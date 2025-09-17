package com.example.ClasesProyecto;

import com.example.lista.impl.TDAListaEnlazada;

public class LigaUcu implements Comparable<Division> {
    private String nombre;
    private TDAListaEnlazada<Division> divisiones;
    
    public LigaUcu (String nombre) {
        this.nombre = nombre;
        this.divisiones = new TDAListaEnlazada<>();
    }
    
    @Override
    public int compareTo(Division o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
}