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


    public Equipo buscarEquipo(String nombre) {
        for (int i = 0; i < divisiones.cantElementos(); i++) {
            Division d = divisiones.obtenerPorIndice(i);
            Equipo e = d.buscarEquipoPorNombre(nombre);
            if (e != null) return e;
        }
        return null;
    }


    public Jugador buscarJugador(String nombreJ, String nombreEquipo){
        Equipo e = buscarEquipo(nombreEquipo);
        for (int i = 0; i < e.cantidadDeJugadores(); i++) {
            Jugador j = e.buscarJugadorPorIndice(i); 
            if (j.getNombre().equalsIgnoreCase(nombreJ)) { 
                return j; 
                }
        }
        return null;
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

    public String mostrarEquipos() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < divisiones.cantElementos(); i++) {
            Division d = divisiones.obtenerPorIndice(i);
            sb.append("División: ").append(d.getNombre()).append("\n");
            sb.append(d.mostrarEquipos()).append("\n");
        }
        return sb.toString();
    }

    public String mostrarJugadores(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < divisiones.cantElementos(); i++) {
            Division d = divisiones.obtenerPorIndice(i);
            sb.append(d.imprimirJugadores());
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

    public boolean eliminarEquipo(String nombreEquipo) {
        for (int i = 0; i < divisiones.cantElementos(); i++) {
            Division d = divisiones.obtenerPorIndice(i);
            if (d.eliminarEquipoPorNombre(nombreEquipo)) return true;
        }
        return false;
    }

    public boolean eliminarJugador(String nombreJugador, String nombreEquipo) {
        Equipo equipo = buscarEquipo(nombreEquipo);
        if (equipo == null) {
            return false;
        }
        Jugador jugador = equipo.buscarJugadorPorNombre(nombreJugador);
        if (jugador == null) {
            return false; 
        }
        return equipo.borrarJugador(jugador) != null;
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
