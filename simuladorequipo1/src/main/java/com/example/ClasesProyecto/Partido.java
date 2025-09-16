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

    private static PilaListaEnlazada<Partido> historial = new PilaListaEnlazada<>();

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

    @Override
    // Simula el partido
    public void jugar() {
        if (terminado) return; // no repetir partido

        golesLocal = rnd.nextInt(6);     // 0 a 5 goles
        golesVisitante = rnd.nextInt(6);

        actualizarEstadisticas();

        terminado = true;
        division.registrarPartido(this);
    }

    @Override
    // Actualiza estadísticas de ambos equipos
    public void actualizarEstadisticas() {
        localSumarEstadisticas();
        visitanteSumarEstadisticas();
    }

    @Override
    public void localSumarEstadisticas() {
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
    @Override
    public void visitanteSumarEstadisticas() {
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

    @Override
    // Métodos de consulta
    public String getMarcador() {
        return local.getNombre() + " " + golesLocal + " - " + golesVisitante + " " + visitante.getNombre();
    }

    @Override
    public boolean fueTerminado() { return terminado; }

    @Override
    public int getGolesLocal() { return golesLocal; }

    @Override
    public int getGolesVisitante() { return golesVisitante; }

    @Override
    public Equipo getLocal() { return local; }

    @Override
    public Equipo getVisitante() { return visitante; }

    @Override
    public Division getDivision() { return division; }

    @Override
    // Historial global de partidos terminados
    public Partido ultimoEnHistorial() {
        return historial.tope();
    }
    @Override
    public Partido desapilarHistorial() {
        return historial.sacar();
    }
    @Override
    public int cantidadHistorial() {
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


