package com.example.ClasesProyecto;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class EquipoTest {                 

    @Test
    public void agregarJugadorVinculaYCuenta() {  
        Division div = new Division("A", 8);
        Equipo e = new Equipo("PRL", "Peñarol", div);
        Jugador j = new Jugador("Amadea", 23, "Golero");

        assertTrue(e.agregarJugador(j));
        assertSame(e, j.getEquipo());
        assertEquals(1, e.cantidadDeJugadores());
        assertNotNull(e.buscarJugador(j));
    }

    @Test
    public void noPermiteJugadorEnDosEquipos() {
        Division div = new Division("A", 8);
        Equipo e1 = new Equipo("PRL", "Peñarol", div);
        Equipo e2 = new Equipo("LIV", "Liverpool", div);
        Jugador j = new Jugador("Pepe", 20, "Delantero");

        assertTrue(e1.agregarJugador(j));
        assertFalse(e2.agregarJugador(j));
        assertEquals(1, e1.cantidadDeJugadores());
        assertEquals(0, e2.cantidadDeJugadores());
    }

    @Test
    public void borrarJugadorLoQuitaDelPlantel() {
        Division div = new Division("A", 8);
        Equipo e = new Equipo("PRL", "Peñarol", div);
        Jugador j = new Jugador("Cata", 22, "Defensa");

        e.agregarJugador(j);
        assertNotNull(e.borrarJugador(j));
        assertEquals(0, e.cantidadDeJugadores());
    }
}
