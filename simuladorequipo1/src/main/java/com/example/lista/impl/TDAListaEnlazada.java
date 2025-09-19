package com.example.lista.impl;
import com.example.lista.TDALista;
import com.example.lista.TDANodo;

public class TDAListaEnlazada<T extends Comparable <T>> implements TDALista <T> {
    protected TDANodo<T> cabeza;
    @Override
    public T buscar(Comparable<T> clave) {
        TDANodo<T> actual = cabeza;
        while (actual != null) {
            if (clave.compareTo(actual.getDato()) == 0) {
                return actual.getDato();
            }
            actual = actual.getSiguiente();    
        }
        return null;
    }
    
    @Override
    public boolean insertar(T data){

        TDANodo<T> actual = cabeza;
        TDANodo<T> nuevoNodo = new Nodo<>(data, null);

        //Consideracion de que la lista este vacia.
        if (actual == null){
            cabeza = nuevoNodo;
            return true;
        }

        while (actual.getSiguiente() != null){
            actual = actual.getSiguiente();
        }

        actual.setSiguiente(nuevoNodo);
        return true;

    }
    /*public boolean insertar(T data) {
            cabeza=new Nodo<T>(data, cabeza);
            //crea un nuevo nodo que se inserta en el primer lugar y referencia al anterior (null o no)
            //Orden constante (1) 
            return true;   
    }*/

    @Override
    public T eliminar(Comparable<T> identificador) {
        TDANodo<T> actual = cabeza;
        if (identificador.compareTo(actual.getDato()) == 0){//Chequea si es la cabeza la que queremos eliminar
            cabeza=actual.getSiguiente();
            return actual.getDato();
        }
        while (actual.getSiguiente() != null) {
            if (identificador.compareTo(actual.getSiguiente().getDato()) == 0) {//busca y elimina las otras posiciones posibles
                T eliminado=actual.getSiguiente().getDato();
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                return eliminado;
            }
            actual = actual.getSiguiente();    
        }
        return null;
    }

    @Override
    public int cantElementos() {
        int contador=0;
        TDANodo<T> actual = cabeza;
        while(actual!=null){
            contador+=1;
            actual=actual.getSiguiente();
        }
        return contador;
    }

    @Override
    public boolean esVacia() {
        if (cabeza!=null){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public String imprimir(){
        if (cabeza == null){
            return "";
        }

        TDANodo<T> actual = cabeza;
        String resultado = "";

        while (actual != null) {
            resultado += actual.getDato(); 
            if (actual.getSiguiente() != null){
                resultado += " ";
            }
            actual = actual.getSiguiente();
        }
        return resultado;
        
    }

    @Override
    public String imprimir (String delimitador){
         if (cabeza == null){
            return "";
        }

        TDANodo<T> actual = cabeza;
        String resultado = "";

        while (actual != null) {
            resultado += actual.getDato(); 
            if (actual.getSiguiente() != null){
                resultado += delimitador + " ";
            }
            actual = actual.getSiguiente();
            
        }
        return resultado;
        
    }

    public T obtenerPorIndice(Integer indice){
        if (cabeza == null){
            return null;
        }

        TDANodo<T> actual = cabeza;
        Integer contador = 0;

        while (actual != null){
            if (indice == contador){
                return actual.getDato();
            }
            contador += 1;
            actual = actual.getSiguiente();
        }
        return null;
    }
    //Se tuvo que agregar para ahcer el reordenamiento de la tabla de posiciones
    public void modificarPorIndice(int indice, T nuevoDato) {
        if (indice < 0) return;

        TDANodo<T> actual = cabeza;
        int contador = 0;

        while (actual != null) {
            if (contador == indice) {
                actual.setDato(nuevoDato);
                return;
            }
            actual = actual.getSiguiente();
            contador++;
        }
    }

    
    
}
