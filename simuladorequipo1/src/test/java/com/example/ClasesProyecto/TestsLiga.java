package com.example.ClasesProyecto;

import java.beans.Transient;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import com.example.ClasesProyecto.*;

public class TestsLiga extends Assertions {
    private Liga liga;
    private Division division1;
    private Division division2;
    private Equipo equipo1;
    private Equipo equipo2;
    private Equipo equipo3;
    private Jugador jugador1;
    private Jugador jugador2;

    @BeforeEach
    public void SetUp(){
        liga = new Liga("Liga Uruguaya");

        //divisiones
        division1 = new Division ("Primera", 16);
        division2 = new Division ("Segunda", 12);

        liga.agregarDivision(division1);
        liga.agregarDivision(division2);

        //equipos
        equipo1 = new Equipo("PEÑ","Peñarol", division1);
        equipo2 = new Equipo("FEN", "Fenix", division1);
        equipo3 = new Equipo("NAC", "Nacional", division2);

        liga.agregarEquipoADivision(division1, equipo1);
        liga.agregarEquipoADivision(division1, equipo2);
        liga.agregarEquipoADivision(division2, equipo3);

        jugador1 = new Jugador("Leo Fernandez", 26, "Mediocampista");
        jugador2 = new Jugador("Lolo Estoyanoff", 42, "Mediocampista");

        liga.agregarJugadorAEquipo(equipo1, jugador1);
        liga.agregarJugadorAEquipo(equipo2, jugador2);
    }
//Tests divisiones
    @Test
    public void testBuscarDivision(){
        assertEquals(division1, liga.buscarDivision("Primera"));
        assertEquals(division2, liga.buscarDivision("Segunda"));//la division esta en la liga
        assertEquals(null, liga.buscarDivision("Tercera"));//la division no existe
    }

    @Test
    public void testListarDivisiones() {
        String salida = liga.listarDivisiones();//se fija si sale en el sb si las divisiones estan y si los equipos tambien
        assertTrue(salida.contains("Primera"));
        assertTrue(salida.contains("Segunda"));
        assertTrue(salida.contains("equipos: 2"));
        assertTrue(salida.contains("equipos: 1"));
        assertFalse(salida.contains("Tercera"));//no existe la division
        assertFalse(salida.contains("equipos: 3"));
    }

//Tests Equipos
    @Test
    public void testBuscarEquipo() {
        assertEquals(equipo1, liga.buscarEquipo("Peñarol"));//equipos que estan
        assertEquals(equipo2, liga.buscarEquipo("Nacional"));
        assertEquals(equipo3, liga.buscarEquipo("Defensor"));
        assertNull(liga.buscarEquipo("Danubio"));//equipo que no esta
    }

    @Test
    public void testMostrarEquipos() {
        String salida = liga.mostrarEquipos();//busca chequear lo mismo que el testListarDivisiones
        assertTrue(salida.contains("División: Primera"));
        assertTrue(salida.contains("Peñarol"));
        assertTrue(salida.contains("Nacional"));
        assertTrue(salida.contains("División: Segunda"));
        assertTrue(salida.contains("Defensor"));
        assertFalse(salida.contains("Racing"));//casos que no existen
        assertFalse(salida.contains("División: Tercera"));
    }

    @Test
    public void testEliminarEquipo() {
        assertTrue(liga.eliminarEquipo("Peñarol")); //elimina el equipo
        assertNull(liga.buscarEquipo("Peñarol")); //busca el equipo luego de borrarlo, no existe
        assertFalse(liga.eliminarEquipo("Liverpool"));
    }

//tests jugadores

    @Test
    public void testBuscarJugador(){
        assertEquals(jugador1, liga.buscarJugador("Leo Fernandez", "Peñarol"));
        assertEquals(jugador1, liga.buscarJugador("Lolo Estoyanoff", "Fenix"));
        assertNull(liga.buscarJugador("Amadeo Mombrú", "Peñarol")); //jugador que no existe
        assertNull(liga.buscarJugador("Leo Fernandez", "Chacarita")); //equipo que no existe
    }

    @Test
    public void testMostrarJugadores(){
        String devuelve = liga.mostrarJugadores();
        assertTrue(salida.contains("Leo Fernandez"));
        assertTrue(salida.contains("Lolo Estoyanoff"));
    }

    @Test
    public void testEliminarJugador(){
        assertTrue(liga.eliminarJugador("Leo Fernandez", "Peñarol"));
        assertFalse(liga.eliminarJugador("Leo Fernandez", "Peñarol"));//no se puede eliminar 2 veces, porque no existe y no tiene sentido
        assertFalse(liga.eliminarJugador("Leo Fernandez", "Montevideo City Torque"));//no existe el equipo
        assertFalse(liga.eliminarJugador("Amadeo", "Peñarol"));//no existe el jugador
    }

//tests partidos

    @Test
    public void testProgramarPartidos(){
        liga.programarPartidos(division1);

        //deberia haber un partido entre peñarol y nacional
        String historial = division.mostrarHistorialString();
        assertTrue(historial.contains("Peñarol"));
        assertTrue(historial.contains("Nacional"));
        
        //pruebo si se repiten los partidos, no deberian
        int AntesDeProgramar = division1.mostrarHistorial().cantElementos();
        liga.programarPartidos(division1);

        int DespuesDeProgramar = division1.mostrarHistorial().cantElementos();
        assertEquals(AntesDeProgramar, DespuesDeProgramar);

    }

}


