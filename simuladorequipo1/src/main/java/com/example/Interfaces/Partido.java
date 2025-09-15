package com.example.Interfaces;
//package com.example.lista.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Random;

public class Partido {

    private static class Nodo<T> {
        T dato;
        Nodo<T> sig;

        Nodo(T d) {
            this.dato = d;
        }
    }

    public static class TDAListaEnlazada<T> implements Iterable<T> {
        private Nodo<T> cabeza, cola;
        private int tam;

        public void agregar(T d) {
            Nodo<T> n = new Nodo<>(d);
            if (cabeza == null) {
                cabeza = cola = n;
            } else {
                cola.sig = n;
                cola = n;
            }
            tam++;
        }

        public int tamaño() {
            return tam;
        }

        public boolean estaVacia() {
            return tam == 0;
        }

        public T obtener(int indice) {
            if (indice < 0 || indice >= tam) throw new IndexOutOfBoundsException("indice=" + indice + " tam=" + tam);
            Nodo<T> a = cabeza;
            for (int i = 0; i < indice; i++) a = a.sig;
            return a.dato;
        }

        @Override
        public Iterator<T> iterator() {
            return new Iterator<>() {
                Nodo<T> a = cabeza;

                @Override
                public boolean hasNext() {
                    return a != null;
                }

                @Override
                public T next() {
                    T d = a.dato;
                    a = a.sig;
                    return d;
                }
            };
        }
    }

    public static class Resultado {
        public final String local, visitante;
        public final int golesLocal, golesVisitante;
        public final LocalDateTime fecha;

        public Resultado(String local, String visitante, int gl, int gv, LocalDateTime f) {
            this.local = local;
            this.visitante = visitante;
            this.golesLocal = gl;
            this.golesVisitante = gv;
            this.fecha = f;
        }

        @Override
        public String toString() {
            String f = fecha.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            return "%s %d - %d %s (%s)".formatted(local, golesLocal, golesVisitante, visitante, f);
        }
    }

    public static class EstadisticaEquipo {
        public final String equipo;
        public final int golesAnotados;
        public final int golesRecibidos;

        public EstadisticaEquipo(String equipo, int golesAfavor, int golesEnContra) {
            this.equipo = equipo;
            this.golesAnotados = golesAfavor;
            this.golesRecibidos = golesEnContra;
        }

        @Override
        public String toString() {
            return "%s | anotados=%d, recibidos=%d".formatted(equipo, golesAnotados, golesRecibidos);
        }
    }

    public static class Gol {
        public final String equipo, jugador;
        public final int minuto;

        public Gol(String equipo, String jugador, int minuto) {
            this.equipo = equipo;
            this.jugador = jugador;
            this.minuto = minuto;
        }

        @Override
        public String toString() {
            return "%s (%s) %d'".formatted(jugador, equipo, minuto);
        }
    }

    private static final int max_goles = 6;

    private final String equipoLocal;
    private final String equipoVisitante;
    private final TDAListaEnlazada<String> jugadoresLocal = new TDAListaEnlazada<>();
    private final TDAListaEnlazada<String> jugadoresVisitante = new TDAListaEnlazada<>();
    private final LocalDateTime fecha;

    private final TDAListaEnlazada<Resultado> historial = new TDAListaEnlazada<>();
    private final TDAListaEnlazada<EstadisticaEquipo> estadisticas = new TDAListaEnlazada<>();
    private final TDAListaEnlazada<Gol> golesDelPartido = new TDAListaEnlazada<>();

    private final Random rnd = new Random();

    public Partido(String equipoLocal, String equipoVisitante, LocalDateTime fecha,
                   Iterable<String> jugadoresLoc, Iterable<String> jugadoresVis) {
        this.equipoLocal = equipoLocal.trim();
        this.equipoVisitante = equipoVisitante.trim();
        this.fecha = fecha;

        int cantidadLocal = 0, cantidadVisitante = 0;
        for (String n : jugadoresLoc) {
            validarNombre(n, "jugador local");
            jugadoresLocal.agregar(n.trim());
            cantidadLocal++;
        }
        for (String n : jugadoresVis) {
            validarNombre(n, "jugador visitante");
            jugadoresVisitante.agregar(n.trim());
            cantidadVisitante++;
        }
    }

    private void validarNombre(String n, String rol) {
        if (n == null || n.isBlank()) throw new IllegalArgumentException("Nombre de " + rol + " inválido");
    }

    public Resultado jugar() {

        int gl = rnd.nextInt(max_goles + 1);
        int gv = rnd.nextInt(max_goles + 1);

        for (int i = 0; i < gl; i++) {
            String j = jugadoresLocal.obtener(rnd.nextInt(jugadoresLocal.tamaño()));
            int minuto = 1 + rnd.nextInt(90);
            golesDelPartido.agregar(new Gol(equipoLocal, j, minuto));
        }
        for (int i = 0; i < gv; i++) {
            String j = jugadoresVisitante.obtener(rnd.nextInt(jugadoresVisitante.tamaño()));
            int minuto = 1 + rnd.nextInt(90);
            golesDelPartido.agregar(new Gol(equipoVisitante, j, minuto));
        }

        Resultado r = new Resultado(equipoLocal, equipoVisitante, gl, gv, fecha);
        historial.agregar(r);

        estadisticas.agregar(new EstadisticaEquipo(equipoLocal, gl, gv));
        estadisticas.agregar(new EstadisticaEquipo(equipoVisitante, gv, gl));

        return r;
    }

    public TDAListaEnlazada<Resultado> getHistorial(){ return historial; }
    public TDAListaEnlazada<EstadisticaEquipo> getEstadisticas(){ return estadisticas; }
    public TDAListaEnlazada<Gol> getGolesDelPartido(){ return golesDelPartido; }

    public static void main(String[] args){
        String[] local = {"L1","L2","L3","L4","L5","L6","L7","L8","L9","L10","L11"};
        String[] visitante = {"V1","V2","V3","V4","V5","V6","V7","V8","V9","V10","V11"};

        Partido p = new Partido("Equipo1", "Equipo2", LocalDateTime.now(),
                java.util.Arrays.asList(local), java.util.Arrays.asList(visitante));

        p.jugar();

        System.out.println("Resultado:");
        for (Resultado r : p.getHistorial()) System.out.println("  " + r);

        System.out.println("\nEstadísticas:");
        for (EstadisticaEquipo e : p.getEstadisticas()) System.out.println("  " + e);

        System.out.println("\nGoles (jugador/equipo/minuto):");
        for (Gol g : p.getGolesDelPartido()) System.out.println("  " + g);
    }
}

