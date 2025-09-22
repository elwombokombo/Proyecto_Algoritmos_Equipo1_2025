
        
package com.example.ClasesProyecto;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;;

public class DivisionTest{
     
    private Division division;

    @Test
    //@DisplayName("getNombre() devuelve el nombre de la división")
    void testGetNombre() {
        division = new Division("Primera", 20);
        assertEquals("Primera", division.getNombre());
    }

    @Test
    //@DisplayName("getCantidadEquipos() devuelve la cantidad configurada")
    void testGetCantidadEquipos() {
        division = new Division("Primera", 20);
        assertEquals(20, division.getCantidadEquipos());
    }

    // @DisplayName("agregar y buscar equipos por objeto y por nombre")
    @Test
    void testAgregarYBuscarEquipos() {
        Division division = new Division("A", 3);

        Equipo e1 = new Equipo("LIV", "Liverpool", division);
        Equipo e2 = new Equipo("PRL", "Peñarol", division);
        Equipo e3 = new Equipo("DAN", "Danubio", division);
        
        // Agregar equipos
        assertTrue(division.agregarEquipo(e1));
        assertTrue(division.agregarEquipo(e2));
        assertTrue(division.agregarEquipo(e3));
        assertEquals(3, division.cantElementos());

        // Buscar equipos
        assertNotNull(division.buscarEquipo(e2));
        assertEquals("Peñarol", division.buscarEquipoPorNombre("Peñarol").getNombre());

        // Mostrar equipos
        String listado = division.mostrarEquipos();
        assertNotNull(listado);
        assertTrue(listado.contains("Liverpool"));
        assertTrue(listado.contains("Peñarol"));
        assertTrue(listado.contains("Danubio"));

        // Eliminar Liverpool
        assertTrue(division.eliminarEquipoPorNombre("Liverpool"));
        assertEquals(2, division.cantElementos());
        assertFalse(division.mostrarEquipos().contains("Liverpool"));
        assertNull(division.buscarEquipoPorNombre("Liverpool"));

    }


    // @DisplayName("imprimirJugadores() incluye planteles")
    @Test
    void testImprimirJugadoresIncluyePlanteles() {
        Division division = new Division("A", 8);

        Equipo equipo = new Equipo("PRL", "Peñarol", division);
        assertTrue(division.agregarEquipo(equipo));

        Jugador j = new Jugador("Cata", 22, "Defensa");
        assertTrue(equipo.agregarJugador(j));

        String out = division.imprimirJugadores();
        assertTrue(out.contains("Equipos de la división A"));
        assertTrue(out.contains("Peñarol"));
        assertTrue(out.contains("Cata"));
    }

    // @DisplayName("mostrarHistorialString() restaura la pila")
    @Test
    void testRegistrarPartidoYMostrarHistorialStringRestauraPila() {
        Division division = new Division("A", 8);

        Equipo loc = new Equipo("PRL", "Peñarol", division);
        Equipo vis = new Equipo("LIV", "Liverpool", division);
        assertTrue(division.agregarEquipo(loc));
        assertTrue(division.agregarEquipo(vis));

        Partido p1 = new Partido(loc, vis, division);
        Partido p2 = new Partido(vis, loc, division);
        division.registrarPartido(p1);
        division.registrarPartido(p2);

        assertEquals(2, division.mostrarHistorial().cantElementos());
        Partido topeAntes = division.mostrarHistorial().tope();

        String hs = division.mostrarHistorialString();
        assertTrue(hs.contains("Peñarol"));
        assertTrue(hs.contains("Liverpool"));
        assertEquals(2, division.mostrarHistorial().cantElementos());
        assertSame(topeAntes, division.mostrarHistorial().tope());
    }

    @Test
    void testYaJugaronIndependienteDelOrden() {
        Division division = new Division("A", 8);

        Equipo e1 = new Equipo("PRL", "Peñarol", division);
        Equipo e2 = new Equipo("LIV", "Liverpool", division);
        Equipo e3 = new Equipo("RAC", "Racing", division);
        assertTrue(division.agregarEquipo(e1));
        assertTrue(division.agregarEquipo(e2));
        assertTrue(division.agregarEquipo(e3));

        assertFalse(division.yaJugaron(e1, e2));

        Partido p = new Partido(e1, e2, division);
        division.registrarPartido(p);

        assertFalse(division.yaJugaron(e1, e2));
        assertFalse(division.yaJugaron(e2, e1));
        assertFalse(division.yaJugaron(e1, e3));
    }

    @Test
    void testJugarTodosLosPartidosMantieneHistorial() {
        Division division = new Division("A", 8);

        Equipo e1 = new Equipo("PRL", "Peñarol", division);
        Equipo e2 = new Equipo("LIV", "Liverpool", division);
        Equipo e3 = new Equipo("RAC", "Racing", division);
        assertTrue(division.agregarEquipo(e1));
        assertTrue(division.agregarEquipo(e2));
        assertTrue(division.agregarEquipo(e3));

        Partido p1 = new Partido(e1, e2, division);
        Partido p2 = new Partido(e2, e3, division);
        division.registrarPartido(p1);
        division.registrarPartido(p2);

        int tamAntes = division.mostrarHistorial().cantElementos();

        division.jugarTodosLosPartidos();

        assertTrue(p1.terminado());
        assertTrue(p2.terminado());
        assertEquals(tamAntes, division.mostrarHistorial().cantElementos());

        String tabla = division.tablaDePosiciones();
        assertTrue(tabla.contains("Peñarol"));
        assertTrue(tabla.contains("Liverpool"));
        assertTrue(tabla.contains("Racing"));
        assertTrue(tabla.startsWith("Tabla de posiciones"));
    }
}


