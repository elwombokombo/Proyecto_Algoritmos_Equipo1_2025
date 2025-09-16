package com.example.ClasesProyecto;

import com.example.Interfaces.IPartido;
import com.example.lista.impl.TDAListaEnlazada;

import java.util.Random;

import com.example.lista.TDAPila;
import com.example.lista.impl.ColaEnlazada;
import com.example.lista.impl.PilaListaEnlazada;

public class Partido implements IPartido, Comparable<Partido>{
    
    private Equipo local;
    private Equipo visitante;
    private Division division;

    private int golesLocal;
    private int golesVisitante;
    private boolean terminado;

    private PilaListaEnlazada<Partido> pila = new PilaListaEnlazada<>();

    private Random rnd = new Random();

    public Partido(Equipo local, Equipo visitante, Division division) {
        this.local = local;
        this.visitante = visitante;
        this.division = division;
        this.rnd = rnd; 
        this.golesLocal = 0;
        this.golesVisitante = 0;
        this.terminado = false;
    }

    // Simula el partido
    public void jugar() {
        if (terminado) return; // no repetir partido

        golesLocal = rnd.nextInt(6);     // 0 a 5 goles
        golesVisitante = rnd.nextInt(6);

        actualizarEstadisticas();

        terminado = true;
        historial.push(this);
    }

    // Actualiza estadísticas de ambos equipos
    private void actualizarEstadisticas() {
        localSumarEstadisticas();
        visitanteSumarEstadisticas();
    }

    private void localSumarEstadisticas() {
        local.golesAFavor += golesLocal;
        local.golesEnContra += golesVisitante;
        local.partidosTerminados++;

        if (golesLocal > golesVisitante) {
            local.ganados++;
            local.puntos += 3;
        } else if (golesLocal == golesVisitante) {
            local.empatados++;
            local.puntos += 1;
        } else {
            local.perdidos++;
        }
    }

    private void visitanteSumarEstadisticas() {
        visitante.golesAFavor += golesVisitante;
        visitante.golesEnContra += golesLocal;
        visitante.partidosTerminados++;

        if (golesVisitante > golesLocal) {
            visitante.ganados++;
            visitante.puntos += 3;
        } else if (golesVisitante == golesLocal) {
            visitante.empatados++;
            visitante.puntos += 1;
        } else {
            visitante.perdidos++;
        }
    }

    // Métodos de consulta
    public String getMarcador() {
        return local.getNombre() + " " + golesLocal + " - " + golesVisitante + " " + visitante.getNombre();
    }

    public boolean fueterminado() { return terminado; }
    public int getGolesLocal() { return golesLocal; }
    public int getGolesVisitante() { return golesVisitante; }
    public Equipo getLocal() { return local; }
    public Equipo getVisitante() { return visitante; }
    public Division getDivision() { return division; }

    // Historial global de partidos terminados
    public static Partido ultimoEnHistorial() {
        return historial.tope();
    }

    public static Partido desapilarHistorial() {
        return historial.sacar();
    }

    public static int cantidadHistorial() {
        return historial.cantElementos();
    }

    @Override
    public int compareTo(Partido otro) {
        // criterio: diferencia de goles
        int diff1 = this.golesLocal - this.golesVisitante;
        int diff2 = otro.golesLocal - otro.golesVisitante;
        return Integer.compare(diff1, diff2);
    }

    @Override
    public String toString() {
        return getMarcador() + " (División: " + division.getNombre() + ")";
    }
}


