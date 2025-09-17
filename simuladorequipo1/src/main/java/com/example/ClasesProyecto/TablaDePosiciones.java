package com.example.ClasesProyecto;

import com.example.lista.impl.TDAListaEnlazada;
import com.example.ClasesProyecto.Equipo;
import com.example.ClasesProyecto.Division;
import com.example.ClasesProyecto.Partido;

public class TablaDePosiciones {

    private final Division division;

    public TablaDePosiciones(Division division) {
        this.division = division;
    }

    public void registrarPartido(Equipo local,
                                 Equipo visitante,
                                 int golesLocal,
                                 int golesVisitante,
                                 TDAListaEnlazada<Jugador> goleadoresLocal,
                                 TDAListaEnlazada<Jugador> goleadoresVisitante) {


        if (local == null || visitante == null) return;
        if (local.compareTo(visitante) == 0) return;

        local.golesAFavor     += golesLocal;
        local.golesEnContra   += golesVisitante;
        local.partidosTerminados++;

        visitante.golesAFavor   += golesVisitante;
        visitante.golesEnContra += golesLocal;
        visitante.partidosTerminados++;

        if (golesLocal > golesVisitante) {
            local.ganados++;     local.puntos += 3;
            visitante.perdidos++;
        } else if (golesLocal < golesVisitante) {
            visitante.ganados++; visitante.puntos += 3;
            local.perdidos++;
        } else {

            local.empatados++;     local.puntos += 1;
            visitante.empatados++; visitante.puntos += 1;
        }

        if (goleadoresLocal != null) {
            for (int i = 0; i < goleadoresLocal.cantElementos(); i++) {
                Jugador j = goleadoresLocal.obtenerPorIndice(i);
                if (j != null) j.sumarGol();
            }
        }
        if (goleadoresVisitante != null) {
            for (int i = 0; i < goleadoresVisitante.cantElementos(); i++) {
                Jugador j = goleadoresVisitante.obtenerPorIndice(i);
                if (j != null) j.sumarGol();
            }
        }
    }

    public String imprimirTabla() {
        TDAListaEnlazada<Equipo> ranking = ordenarEquiposSegunReglas();
        StringBuilder sb = new StringBuilder();
        sb.append("Tabla de posiciones — División ").append(division.getNombre()).append("\n");
        sb.append(String.format("%-3s %-20s %5s %4s %4s %4s %4s %4s %4s %5s\n",
                "#","Equipo","Pts","PJ","G","E","P","GF","GC","DG"));

        int pos = 1;
        for (int i = 0; i < ranking.cantElementos(); i++) {
            Equipo e = ranking.obtenerPorIndice(i);
            sb.append(String.format("%-3d %-20s %5d %4d %4d %4d %4d %4d %4d %5d\n",
                    pos++,
                    e.getNombre(),
                    e.getPuntos(),
                    e.getPartidosTerminados(),
                    e.getGanados(),
                    e.getEmpatados(),
                    e.getPerdidos(),
                    e.getGolesAFavor(),
                    e.getGolesEnContra(),
                    e.getDiferenciaDeGol()
            ));
        }
        return sb.toString();
    }

    private TDAListaEnlazada<Equipo> ordenarEquiposSegunReglas() {

        TDAListaEnlazada<Equipo> trabajo = copiarEquipos();
        TDAListaEnlazada<Equipo> ranking = new TDAListaEnlazada<>();

        while (!trabajo.esVacia()) {
            Equipo mejor = null;
            for (int i = 0; i < trabajo.cantElementos(); i++) {
                Equipo cand = trabajo.obtenerPorIndice(i);
                if (esMejor(cand, mejor)) mejor = cand;
            }
            ranking.insertar(mejor);
            trabajo.eliminar(mejor); // usa compareTo(id) de Equipo
        }
        return ranking;
    }

    private boolean esMejor(Equipo a, Equipo b) {
        if (b == null) return true; // a va primero si no hay comparando

        if (a.getPuntos() != b.getPuntos())
            return a.getPuntos() > b.getPuntos();

        int dga = a.getDiferenciaDeGol();
        int dgb = b.getDiferenciaDeGol();
        if (dga != dgb)
            return dga > dgb;

        if (a.getGolesAFavor() != b.getGolesAFavor())
            return a.getGolesAFavor() > b.getGolesAFavor();

        if (a.getGolesEnContra() != b.getGolesEnContra())
            return a.getGolesEnContra() < b.getGolesEnContra();

        return a.getNombre().compareToIgnoreCase(b.getNombre()) < 0;
    }

    private TDAListaEnlazada<Equipo> copiarEquipos() {
        TDAListaEnlazada<Equipo> copia = new TDAListaEnlazada<>();
        for (int i = 0; i < division.cantElementos(); i++) {
            copia.insertar(division.obtenerPorIndice(i));
        }
        return copia;
    }
}
