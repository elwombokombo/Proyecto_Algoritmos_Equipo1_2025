package com.example.ClasesProyecto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class TestsLiga {
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
        String devuelve = liga.listarDivisiones();//se fija si sale en el sb si las divisiones estan y si los equipos tambien
        assertTrue(devuelve.contains("Primera"));
        assertTrue(devuelve.contains("Segunda"));
        assertTrue(devuelve.contains("equipos: 2"));
        assertTrue(devuelve.contains("equipos: 1"));
        assertFalse(devuelve.contains("Tercera"));//no existe la division
        assertFalse(devuelve.contains("equipos: 3"));
    }

//Tests Equipos
    @Test
    public void testBuscarEquipo() {
        Equipo existe = liga.buscarEquipo("Peñarol");
        Equipo noExiste = liga.buscarEquipo("Danubio");
        assertEquals(existe, liga.buscarEquipo("Peñarol"));//equipos que estan
        assertNull(noExiste);
    }

    @Test
    public void testMostrarEquipos() {
        String devuelve = liga.mostrarEquipos();//busca chequear lo mismo que el testListarDivisiones
        assertTrue(devuelve.contains("División: Primera"));
        assertTrue(devuelve.contains("Peñarol"));
    }

    @Test
    public void testEliminarEquipo() {
        assertTrue(liga.eliminarEquipo("Peñarol")); //elimina el equipo
        assertNull(liga.buscarEquipo("Peñarol")); //busca el equipo luego de borrarlo, no existe
        assertFalse(liga.eliminarEquipo("Liverpool"));//equipo que no existe, devuelve false
    }

//tests jugadores

    @Test
    public void testBuscarJugador(){
        Jugador encontrado = liga.buscarJugador("Leo Fernandez", "Peñarol");
        Jugador noEncontrado = liga.buscarJugador("Amadeo Mombrú", "Peñarol");
        assertEquals(encontrado, liga.buscarJugador("Leo Fernandez", "Peñarol"));
        assertEquals(noEncontrado, liga.buscarJugador("Amadeo Mombrú", "Peñarol")); //jugador que no existe
    }

    @Test
    public void testMostrarJugadores(){
        String devuelve = liga.mostrarJugadores();
        assertTrue(devuelve.contains("Leo Fernandez"));
        assertTrue(devuelve.contains("Lolo Estoyanoff"));
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
        String historial = division1.mostrarHistorialString();
        assertTrue(historial.contains("Peñarol"));
        assertTrue(historial.contains("Nacional"));
        
        //pruebo si se repiten los partidos, no deberian
        int AntesDeProgramar = division1.mostrarHistorial().cantElementos();
        liga.programarPartidos(division1);

        int DespuesDeProgramar = division1.mostrarHistorial().cantElementos();
        assertEquals(AntesDeProgramar, DespuesDeProgramar);

    }

}


