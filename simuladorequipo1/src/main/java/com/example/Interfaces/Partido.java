package com.example.Interfaces;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Random;


 //Clase Partido:
 // Crea un partido con equipos, jugadores y fecha.
 // Método jugar(): genera un resultado random y lo guarda en una lista enlazada (historial).

public class Partido {

    private static class Nodo<T> { T dato; Nodo<T> sig; Nodo(T d){ this.dato = d; } }
    public static class ListaEnlazada<T> implements Iterable<T> {
        private Nodo<T> cabeza, cola; private int tam;
        public void agregar(T d){ Nodo<T> n=new Nodo<>(d); if(cabeza==null){cabeza=cola=n;} else { cola.sig=n; cola=n; } tam++; }
        public int tamano(){ return tam; }
        public boolean estaVacia(){ return tam==0; }
        @Override public Iterator<T> iterator(){ return new Iterator<>() {
            Nodo<T> a=cabeza; @Override public boolean hasNext(){ return a!=null; }
            @Override public T next(){ T d=a.dato; a=a.sig; return d; }
        }; }
    }

    public static class Resultado {
        public final String local, visitante;
        public final int golesLocal, golesVisitante;
        public final LocalDateTime fecha;

        public Resultado(String local, String visitante, int gl, int gv, LocalDateTime f){
            this.local = local; this.visitante = visitante; this.golesLocal = gl; this.golesVisitante = gv; this.fecha = f;
        }
        @Override public String toString(){
            String f = fecha.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            return "%s %d - %d %s (%s)".formatted(local, golesLocal, golesVisitante, visitante, f);
        }
    }

    private final String equipoLocal;
    private final String equipoVisitante;
    private final ListaEnlazada<String> jugadoresLocal = new ListaEnlazada<>();
    private final ListaEnlazada<String> jugadoresVisitante = new ListaEnlazada<>();
    private final LocalDateTime fecha;
    private final ListaEnlazada<Resultado> historial = new ListaEnlazada<>();
    private final Random rnd = new Random();

    public Partido(String equipoLocal, String equipoVisitante, LocalDateTime fecha,
                   Iterable<String> jugadoresLoc, Iterable<String> jugadoresVis) {
        if (equipoLocal == null || equipoLocal.isBlank()) throw new IllegalArgumentException("Equipo local inválido");
        if (equipoVisitante == null || equipoVisitante.isBlank()) throw new IllegalArgumentException("Equipo visitante inválido");
        if (fecha == null) throw new IllegalArgumentException("Fecha inválida");
        this.equipoLocal = equipoLocal.trim();
        this.equipoVisitante = equipoVisitante.trim();
        this.fecha = fecha;

        int cL = 0, cV = 0;
        for (String n : jugadoresLoc){ validarNombre(n, "jugador local"); jugadoresLocal.agregar(n.trim()); cL++; }
        for (String n : jugadoresVis){ validarNombre(n, "jugador visitante"); jugadoresVisitante.agregar(n.trim()); cV++; }
        if (cL < 11 || cV < 11) throw new IllegalArgumentException("Cada equipo debe tener al menos 11 jugadores (L="+cL+", V="+cV+")");
    }
    private void validarNombre(String n, String rol){ if (n==null || n.isBlank()) throw new IllegalArgumentException("Nombre de " + rol + " inválido"); }

    """public Resultado jugar() {


        Resultado r = new Resultado(equipoLocal, equipoVisitante, gl, gv, fecha);
        historial.agregar(r);
        return r;
    }
    """


    private static int clamp(int v, int min, int max){ return Math.max(min, Math.min(max, v)); }


    public ListaEnlazada<Resultado> getHistorial(){ return historial; }


    public static void main(String[] args){
        String[] loc = {"L1","L2","L3","L4","L5","L6","L7","L8","L9","L10","L11"};
        String[] vis = {"V1","V2","V3","V4","V5","V6","V7","V8","V9","V10","V11"};

        Partido p = new Partido("Roja FC", "Azul FC", LocalDateTime.now(),
                java.util.Arrays.asList(loc), java.util.Arrays.asList(vis));


        //p.jugar();
        //p.jugar();
        //p.jugar();

        System.out.println("Historial:");
        for (Resultado r : p.getHistorial()) System.out.println("  " + r);
    }
}

