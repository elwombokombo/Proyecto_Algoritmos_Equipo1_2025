package com.example.lista;

public interface TDACola<T extends Comparable<T>> extends TDALista<T> {
    /**
     *
     * @return Retorna el primer elemento de la cola, sin removerlo.
     * Si la pila es vacía, retornar nulo
     */
    T frente();

    /**
     *
     * @return Retorna el primer elemento de la cola y  lo remueve.
     * Si la cola es vacía, retornar nulo
     */
    T quitarDeCola();

    /**
     * Agrega un elemento a la cola.
     *
     * @param elemento elemento comparable
     * @return retorna true o false si el elemento fue o no agregado a la cola
     */
    boolean ponerEnCola(T elemento);

}
