package com.example.ClasesProyecto;

import com.example.Interfaces.IPartido;
import com.example.lista.impl.TDAListaEnlazada;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

public class Partido implements IPartido {

    private final String equipoLocal;
    private final String equipoVisitante;
    private final String division;

    private final Random rnd;
    private final int maxGolesPorEquipo;

    private final Deque<Marcador> pila = new ArrayDeque<>();

    public Partido(String equipoLocal, String equipoVisitante, String division, Random rnd, int maxGolesPorEquipo) {
        this.equipoLocal = equipoLocal;this.equipoVisitante = equipoVisitante;this.division = division; this.rnd = rnd; this.maxGolesPorEquipo = maxGolesPorEquipo;
    }

    public Marcador jugar() {
        int gl = rnd.nextInt(maxGolesPorEquipo + 1); // 0..max
        int gv = rnd.nextInt(maxGolesPorEquipo + 1);
        Marcador m = new Marcador(equipoLocal, equipoVisitante, division, gl, gv);
        pila.push(m);
        return m;
    }

    public Marcador ultimo() { return pila.peek(); }

    public Marcador desapilar() { return pila.pop(); }

    public int cantidadEnPila() { return pila.size(); }

    @Override
    public Boolean pilaVacia() {
        return pila.isEmpty();
    }

    @Override
    public String mostrarMarcador(Partido.Marcador marcador) {
        return (marcador == null) ? "" : marcador.getMarcador();
    }

    @Override
    public String equipoLocal() { return equipoLocal; }

    @Override
    public String equipoVisitante() { return equipoVisitante; }

    @Override
    public int golesLocal() {
        Marcador m = pila.peek();
        return (m == null) ? 0 : m.getGolesLocal();
    }

    @Override
    public int golesVisitante() {
        Marcador m = pila.peek();
        return (m == null) ? 0 : m.getGolesVisitante();
    }

    @Override
    public int maxGoles() {
        return maxGolesPorEquipo;
    }

    public static final class Marcador {
        private final String equipoLocal;
        private final String equipoVisitante;
        private final String division;
        private final int golesLocal;
        private final int golesVisitante;

        public Marcador(String equipoLocal, String equipoVisitante, String division, int golesLocal, int golesVisitante) {
            this.equipoLocal = equipoLocal;
            this.equipoVisitante = equipoVisitante;
            this.division = division;
            this.golesLocal = golesLocal;
            this.golesVisitante = golesVisitante;
        }

        public int getGolesLocal() { return golesLocal; }
        public int getGolesVisitante() { return golesVisitante; }
        public String getEquipoLocal() { return equipoLocal; }
        public String getEquipoVisitante() { return equipoVisitante; }
        public String getDivision() { return division; }

        public String getMarcador() {
            return equipoLocal + " " + golesLocal + " - " + golesVisitante + " " + equipoVisitante;
        }

        @Override public String toString() { return getMarcador(); }
    }
}