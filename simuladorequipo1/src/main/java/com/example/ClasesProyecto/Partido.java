package com.example.ClasesProyecto;

import com.example.Interfaces.IPartido;                 // tu interfaz
import com.example.lista.TDALista;                      // interfaz TDA
import com.example.lista.impl.TDAListaEnlazada;         // implementación enlazada

import java.time.LocalDateTime;
import java.util.Random;

public class Partido implements IPartido {

    private static final int MAX_GOLES = 6;

    private final Equipo<Jugador> equipoLocal;
    private final Equipo<Jugador> equipoVisitante;
    private final Division<Equipo<Jugador>> division;
    private final LocalDateTime fecha;

    // Estructuras exigidas por la interfaz (hasta getEstadisticas)
    private final TDAListaEnlazada<IPartido.Resultado> historial = new TDAListaEnlazada<>();
    private final TDAListaEnlazada<IPartido.EstadisticaEquipo> estadisticas = new TDAListaEnlazada<>();
    private final TDAListaEnlazada<IPartido.Gol> golesDelPartido = new TDAListaEnlazada<>();

    private final Random rnd = new Random();

    public Partido(Equipo<Jugador> local,
                   Equipo<Jugador> visitante,
                   Division<Equipo<Jugador>> division,
                   LocalDateTime fecha) {
        this.equipoLocal = local;
        this.equipoVisitante = visitante;
        this.division = division;
        this.fecha = fecha;
    }

    // ======================
    // IPartido: datos básicos
    // ======================

    @Override public String getEquipoLocal()     { return equipoLocal.getNombre(); }
    @Override public String getEquipoVisitante() { return equipoVisitante.getNombre(); }
    @Override public String getDivision()        { return division.getNombre(); }
    @Override public LocalDateTime getFecha()    { return fecha; }

    // Como los planteles los recibimos por las clases Equipo/Jugador,
    // estos 4 métodos se implementan de forma "no operativa" (la interfaz los pide).
    @Override public Boolean setJugadoresLocal(TDALista<String> lista) { return Boolean.TRUE; }
    @Override public Boolean setJugadoresVisitante(TDALista<String> lista) { return Boolean.TRUE; }
    @Override public TDALista<String> getJugadoresLocal() { return new TDAListaEnlazada<>(); }
    @Override public TDALista<String> getJugadoresVisitante() { return new TDAListaEnlazada<>(); }

    // ======================
    // IPartido: simulación
    // ======================

    @Override
    public IPartido.Resultado jugar() {

        // limpiar goles del partido anterior
        vaciar(golesDelPartido);

        // goles aleatorios
        int gl = rnd.nextInt(MAX_GOLES + 1);
        int gv = rnd.nextInt(MAX_GOLES + 1);

        // --- Goles del LOCAL ---
        int cantLoc = equipoLocal.cantidadDeJugadores();
        for (int i = 0; i < gl && cantLoc > 0; i++) {
            int idx = rnd.nextInt(cantLoc);
            Jugador j = equipoLocal.obtenerJugadorPorIndice(idx);   // <-- getter agregado en Equipo
            int minuto = 1 + rnd.nextInt(90);
            golesDelPartido.insertar(new GolImpl(equipoLocal.getNombre(), j.getNombre(), minuto));
            j.sumarGol();
        }

        // --- Goles del VISITANTE ---
        int cantVis = equipoVisitante.cantidadDeJugadores();
        for (int i = 0; i < gv && cantVis > 0; i++) {
            int idx = rnd.nextInt(cantVis);
            Jugador j = equipoVisitante.obtenerJugadorPorIndice(idx);
            int minuto = 1 + rnd.nextInt(90);
            golesDelPartido.insertar(new GolImpl(equipoVisitante.getNombre(), j.getNombre(), minuto));
            j.sumarGol();
        }

        // registrar partido jugado a todos los jugadores
        for (int i = 0; i < cantLoc; i++) {
            Jugador j = equipoLocal.obtenerJugadorPorIndice(i);
            j.registrarPartido();
        }
        for (int i = 0; i < cantVis; i++) {
            Jugador j = equipoVisitante.obtenerJugadorPorIndice(i);
            j.registrarPartido();
        }

        // resultado + historial
        ResultadoImpl r = new ResultadoImpl(
                equipoLocal.getNombre(), equipoVisitante.getNombre(), gl, gv, fecha);
        historial.insertar(r);

        // estadísticas de equipos (GF/GC)
        estadisticas.insertar(new EstadisticaEquipoImpl(equipoLocal.getNombre(), gl, gv));
        estadisticas.insertar(new EstadisticaEquipoImpl(equipoVisitante.getNombre(), gv, gl));

        return r;
    }

    @Override public TDALista<IPartido.Gol> getGolesDelPartido()            { return golesDelPartido; }
    @Override public TDALista<IPartido.Resultado> getHistorial()            { return historial; }
    @Override public TDALista<IPartido.EstadisticaEquipo> getEstadisticas() { return estadisticas; }

    // ======================
    // Helpers
    // ======================
    private static <T> void vaciar(TDAListaEnlazada<T> lista) {
        // Si tu TDA no tiene "vaciar()", lo vaciamos sacando siempre el primero
        while (!lista.esVacia()) {
            T primero = lista.obtenerPorIndice(0);
            lista.eliminar(primero);
        }
    }

    // ===========================================================
    // Implementaciones internas de los tipos de la interfaz
    // (Comparables para cumplir con el bound de tu TDA)
    // ===========================================================

    private static class GolImpl implements IPartido.Gol, Comparable<IPartido.Gol> {
        private final String equipo;
        private final String jugador;
        private final int minuto;

        GolImpl(String equipo, String jugador, int minuto) {
            this.equipo = equipo;
            this.jugador = jugador;
            this.minuto = minuto;
        }

        @Override public String getEquipo()  { return equipo; }
        @Override public String getJugador() { return jugador; }
        @Override public int getMinuto()     { return minuto; }
        @Override public int compareTo(IPartido.Gol o) { return Integer.compare(this.minuto, o.getMinuto()); }
    }

    private static class ResultadoImpl implements IPartido.Resultado, Comparable<IPartido.Resultado> {
        private final String local, visitante;
        private final int golesLocal, golesVisitante;
        private final LocalDateTime fecha;

        ResultadoImpl(String local, String visitante, int gl, int gv, LocalDateTime f) {
            this.local = local; this.visitante = visitante;
            this.golesLocal = gl; this.golesVisitante = gv; this.fecha = f;
        }

        @Override public String getLocal()         { return local; }
        @Override public String getVisitante()     { return visitante; }
        @Override public int getGolesLocal()       { return golesLocal; }
        @Override public int getGolesVisitante()   { return golesVisitante; }
        @Override public LocalDateTime getFecha()  { return fecha; }

        @Override public int compareTo(IPartido.Resultado o) {
            if (this.getFecha() == null && o.getFecha() == null) return 0;
            if (this.getFecha() == null) return -1;
            if (o.getFecha() == null) return 1;
            return this.getFecha().compareTo(o.getFecha());
        }
    }

    private static class EstadisticaEquipoImpl implements IPartido.EstadisticaEquipo, Comparable<IPartido.EstadisticaEquipo> {
        private final String equipo;
        private final int golesAnotados;
        private final int golesRecibidos;

        EstadisticaEquipoImpl(String equipo, int gf, int gc) {
            this.equipo = equipo; this.golesAnotados = gf; this.golesRecibidos = gc;
        }

        @Override public String getEquipo()      { return equipo; }
        @Override public int getGolesAnotados()  { return golesAnotados; }
        @Override public int getGolesRecibidos() { return golesRecibidos; }

        @Override public int compareTo(IPartido.EstadisticaEquipo o) {
            if (this.getEquipo() == null && o.getEquipo() == null) return 0;
            if (this.getEquipo() == null) return -1;
            if (o.getEquipo() == null) return 1;
            return this.getEquipo().compareToIgnoreCase(o.getEquipo());
        }
    }
}





