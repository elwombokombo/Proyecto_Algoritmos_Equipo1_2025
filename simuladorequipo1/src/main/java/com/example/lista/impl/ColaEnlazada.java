package com.example.lista.impl;

import com.example.lista.TDACola;

public class ColaEnlazada<T extends Comparable <T>> extends TDAListaEnlazada<T> implements TDACola <T> {

    @Override
    public T frente(){
        if (esVacia()){
            return null;
        }
        return cabeza.getDato();
    }

    @Override
    public T quitarDeCola(){
        if (esVacia()) return null;
        T primero = cabeza.getDato();
        cabeza = cabeza.getSiguiente(); // mover cabeza
        return primero;
    }

    @Override
    public boolean ponerEnCola(T elemento) {
        if (elemento == null) return false;
        insertar(elemento);
        return true;
    }
}