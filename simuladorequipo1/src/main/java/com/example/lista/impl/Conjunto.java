package com.example.lista.impl;

import com.example.lista.TDAConjunto;
import com.example.lista.TDANodo;

public class Conjunto <T extends Comparable<T>> extends TDAListaEnlazada <T> implements TDAConjunto <T> {

    @Override
    public TDAConjunto<T> union(TDAConjunto<T> otroConjunto) {
        Conjunto<T> nuevoConjunto = new Conjunto<>();
        //agrego los elementos del primer conjunto
        //uso el metodo auxiliar insertarSinRepetidos para no agregar elementos repetidos, junto con el obtenerPorIndice de lista enlazada
        for (int i = 0; i < this.cantElementos(); i++){
            nuevoConjunto.insertarSinRepetidos(this.obtenerPorIndice(i));
        }
        //agrego los elementos del segundo conjunto
        for (int i = 0; i < otroConjunto.cantElementos(); i ++){
            nuevoConjunto.insertarSinRepetidos(otroConjunto.obtenerPorIndice(i));
        }
        return nuevoConjunto;
    }

    @Override
    public TDAConjunto<T> interseccion(TDAConjunto<T> otroConjunto) {
        Conjunto<T> conjuntoC = new Conjunto();
        TDANodo<T> actual = cabeza; 
        
        while (actual!=null){
            if (otroConjunto.buscar(actual.getDato())==actual.getDato()){
                conjuntoC.insertar(actual.getDato());
            }
            actual = actual.getSiguiente();
        }
        return conjuntoC;
    }

    @Override
    public TDAConjunto<T> diferencia(TDAConjunto<T> otroConjunto) {
        Conjunto<T> nuevoConjunto = new Conjunto<>();
        TDANodo<T> actual = cabeza;
        
        while (actual != null){
            if (otroConjunto.buscar(actual.getDato()) != actual.getDato()){
                nuevoConjunto.insertar(actual.getDato());
            }
            actual = actual.getSiguiente();
        }
        return nuevoConjunto; 
    }
    
    
    public boolean insertarSinRepetidos(T data){
        if (this.buscar(data) == null){
            this.insertar(data);
            return true;
        }
        return false;
    }
    
}
