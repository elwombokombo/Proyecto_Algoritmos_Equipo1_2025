package com.example.ClasesProyecto;

import com.example.lista.impl.TDAListaEnlazada;

public class Liga {
    private String nombre;
    protected TDAListaEnlazada<Division> divisiones;

    public Liga(String nombre) {
        this.nombre = nombre;
        this.divisiones = new TDAListaEnlazada<>();
    }

    public String getNombre() { return nombre; }

    // Para las divisiones
    public void agregarDivision(Division division) {
        divisiones.insertar(division);
    }

    public Division buscarDivision(String nombre) {
        for (int i = 0; i < divisiones.cantElementos(); i++) {
            Division d = divisiones.obtenerPorIndice(i);
            if (d.getNombre().compareTo(nombre) == 0) {
                return d;
            }
        }
        return null;
    }

    public Equipo buscarEquipo(String nombre){
        for (int i = 0; i < divisiones.cantElementos(); i++) {
            Division d = divisiones.obtenerPorIndice(i);
            for (int j = 0; j < d.cantElementos(); j++) {
                Equipo e = 
            }
        }
    }

    public String listarDivisiones() {
        StringBuilder sb = new StringBuilder("Divisiones en la liga:\n");
        for (int i = 0; i < divisiones.cantElementos(); i++) {
            Division d = divisiones.obtenerPorIndice(i);
            sb.append("- ").append(d.getNombre())
              .append(" (equipos: ").append(d.cantElementos()).append(")\n");
        }
        return sb.toString();
    }

    // Para los equipos
    public void agregarEquipoADivision(Division division, Equipo equipo) {
        division.agregarEquipo(equipo);
    }

    // Para los jugadores
    public void agregarJugadorAEquipo(Equipo equipo, Jugador jugador) {
        equipo.agregarJugador(jugador);
    }

    // para los partidos
    public void programarPartidos(Division division) {
        int cantidadEquipos = division.cantElementos();
        for (int i = 0; i < cantidadEquipos; i++) {
            Equipo local = division.obtenerPorIndice(i);
            for (int j = i + 1; j < cantidadEquipos; j++) {
                Equipo visitante = division.obtenerPorIndice(j);
                if (!division.yaJugaron(local, visitante)) {
                    Partido partido = new Partido(local, visitante, division);
                    division.registrarPartido(partido);
                }
            }
        }
    }
}
