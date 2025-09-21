package com.example.ClasesProyecto;

import com.example.Interfaces.ILigaUcu;
import com.example.lista.impl.TDAListaEnlazada;


///Clase para centralizar todo, poder agregar equipos desde liga, jugadores, y agregar divisiones en liga, etc
public class LigaUcu extends TDAListaEnlazada<Division> implements ILigaUcu { 
    private String nombre;
    private TDAListaEnlazada<Division> divisiones;
    
    public LigaUcu(String nombre) {
        this.nombre = nombre;
        this.divisiones = new TDAListaEnlazada <>()
    }

    public String getNombre(){
        return nombre;
    }

//Requerimientos para divisiones
    @Override
    public boolean agregarDivision(Division division){ //Agrega una division a la liga
        return divisiones.insertar(division);
    }

    @Override
    public Division buscarDivision(String nombre){ //busca una division en la liga
        for (int i = 0; i < divisiones.cantElementos(); i++){
            Division division = divisiones.obtenerPorIndice(i);
            if (division.getNombre() == nombre){
                return division;
            }
        }
        return null;
    }

    @Override
    public boolean eliminarDivision(Division division) { //Elimina una division de la liga
        return divisiones.eliminar(division) != null;
    }

    @Override
    public String mostrarDivisiones(){ //Devuelvo un string con todas las divisiones de la liga
        StringBuilder str = new StringBuilder();
        str.append("Divisiones de la liga ").append(nombre).append(":\n");
        for (int i = 0, i < divisiones.cantElementos(); i++){
            Division division = divisiones.obtenerPorIndice(i);
            str.append("-"). append(division.getNombre()).append("\n");
        }
        return str.toString();
    }

//Requerimientos para equipos
    @Override
    public boolean agregarEquipoDivision(String nombre, Equipo equipo){ //Agrega un equipo a una division, usando el nombre de la division
        Division division = buscarDivision(nombre);
        if (division == null){ //no existe la division
            return false;
        }
        return division.agregarEquipo(equipo);//si existe agrega
    }

    @Override
    public Equipo buscarEquipoId(String idEquipo){ //sirve para buscar un equipo por id recorriendo las divisiones de la liga
        for(int d = 0; d < divisiones.cantElementos(); d++){
            Division division = divisiones.obtenerPorIndice(d);
            for(int e = 0; e < division.cantElementos(); e++){
                Equipo equipo = division.obtenerPorIndice(e);
                if (equipo.getId() == idEquipo){
                    return equipo; //cuando lo encuentra
                }
            }
        }
        return null; //cuando no lo encuentra (no existe)
    }

    @Override
    public boolean eliminarEquipo(String idEquipo){ //Sirve para eliminar un equipo de la liga por id
        for(int d = 0; d < divisiones.cantElementos(); d++){
            Division division = divisiones.obtenerPorIndice(d);
            for(int e = 0; e < division.cantElementos(); e++){
                Equipo equipo = division.obtenerPorIndice(e);
                if (equipo.getId() == idEquipo){
                    return division.eliminarEquipo(equipo);
                }
            }
        }
        return false;
    }

//Requerimientos jugadores
    @Override
    public boolean agregarJugadorEquipo(String idEquipo, Jugador jugador){ //Agrega un jugador a un equipo especifico, funciona igual que el agregar equipo
        Equipo equipo = buscarEquipoId(idEquipo);
        if (equipo == null){
            return false;
        }
        return equipo.agregarJugador(jugador);
    }

    @Override
    public Jugador buscarJugadorPorId (int idJugador){ //Busca un jugador por id recorriendo toda la liga
        for(int d = 0; d < divisiones.cantElementos(); d++){
            Division division = divisiones.obtenerPorIndice(d);
            for(int e = 0; e < division.cantElementos(); e++){
                Equipo equipo = division.obtenerPorIndice(e);
                for (int j = 0; j < equipo.cantidadDeJugadores(); j++){
                    Jugador jugador = equipo.obtenerPorIndice(j); //preguntar al profe si conviene poner listaEnlazada en equipo.
                    if (jugador.getId() == idJugador){
                        return jugador;
                    }
                   
                }
            }
        }
        return null;
    }

}