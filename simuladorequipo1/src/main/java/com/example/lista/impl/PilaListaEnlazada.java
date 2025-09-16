package com.example.lista.impl;

import com.example.lista.TDAPila;

public class PilaListaEnlazada < T extends Comparable<T>> extends TDAListaEnlazada<T> implements TDAPila<T> {
    /*No hacemos otra cabeza, usamos la q ya tiene TDAListaEnlazada, 
    porque sino estamos haciendo 2 cabezas distintas y no funcionan los metodos*/

    //sirve para insertar un elemento en la pila
    public void push(T data) {
        cabeza = new Nodo<T>(data, cabeza);
    }

    //seria como el peek
    @Override
    public T tope() {
        if (esVacia()){
            return null;
        }
        return cabeza.getDato();
    }

    //Sirve para sacar un elemento de la pila
    @Override
    public T sacar() {
        if (esVacia()){
            return null;
        }
        T dato = cabeza.getDato();
        cabeza = cabeza.getSiguiente();
        return dato;
    }
}