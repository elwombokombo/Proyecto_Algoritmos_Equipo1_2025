package com.example.ClasesProyecto;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//ver si jugador guarda las variables 
class JugadorTest {

    @BeforeEach
    void resetContadorId() {
        Jugador.contadorId = 0;
    }

    @Test
    void constructorGuardaValoresIniciales() {
        Jugador j = new Jugador("Pepe", 20, "Delantero");

        assertEquals("Pepe", j.getNombre());
        assertEquals(20, j.getEdad());
        assertEquals("Delantero", j.getPosicion());
        assertEquals(1, j.getId());           
        assertNull(j.getEquipo());              

        assertEquals(0, j.getGolesConvertidos());
        assertEquals(0, j.getTarjetasRecibidas());
        assertEquals(0, j.getPartidosDisputados());
        assertEquals(0, j.getSancionesPendientes());
    }

    @Test
    void idsSonAutoincrementales() {
        Jugador j1 = new Jugador("A", 18, "Defensa");
        Jugador j2 = new Jugador("B", 19, "Mediocampista");

        assertEquals(1, j1.getId());
        assertEquals(2, j2.getId());
        assertTrue(j2.getId() > j1.getId());
    }

    @Test
    void operacionesActualizanContadores() {
        Jugador j = new Jugador("Juan", 25, "Mediocampista");

        j.sumarGol();
        j.sumarGol();
        j.sumarTarjeta();
        j.registrarPartido();
        j.agregaSancion();
        j.cumpleSancion(); 
        
        assertEquals(2, j.getGolesConvertidos());
        assertEquals(1, j.getTarjetasRecibidas());
        assertEquals(1, j.getPartidosDisputados());
        assertEquals(0, j.getSancionesPendientes());
    }
}