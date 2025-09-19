package com.example.ClasesProyecto;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DivisionTest {

    @Test
    void agregaBuscaImprimeYEliminaEquipos() {
        Division div = new Division("A", 8);

        Equipo e1 = new Equipo("PRL", "Peñarol", div);
        Equipo e2 = new Equipo("LIV", "Liverpool", div);

        // Insertamos el primero
        assertTrue(div.agregarEquipo(e1));

        // Desempatar stats para que compareTo != 0 (evita que la lista los considere "iguales")
        // Jugar partidos hasta que difieran
        int guard = 0;
        while (e1.compareTo(e2) == 0 && guard++ < 20) { // límite de seguridad
            new Partido(e1, e2, div).jugar();
        }

        // Ahora el segundo debería poder insertarse
        assertTrue(div.agregarEquipo(e2), "El segundo equipo no se insertó; compareTo probablemente seguía dando 0");

        assertEquals(2, div.cantElementos());

        // buscar (nos alcanza con que lo encuentre)
        assertNotNull(div.buscarEquipo(e1));
        assertNotNull(div.buscarEquipo(e2));

        // mostrar equipos (usa imprimir de la lista)
        String listado = div.mostrarEquipos();
        assertNotNull(listado);
        assertTrue(listado.contains("Peñarol"));
        assertTrue(listado.contains("Liverpool"));

        // eliminar
        assertTrue(div.eliminarEquipo(e1));
        assertEquals(1, div.cantElementos());
        assertNull(div.buscarEquipo(e1));
    }

    @Test
    void imprimirJugadoresIncluyePlanteles() {
        Division div = new Division("A", 8);

        Equipo e = new Equipo("PRL", "Peñarol", div);
        assertTrue(div.agregarEquipo(e));

        Jugador j = new Jugador("Cata", 22, "Defensa");
        assertTrue(e.agregarJugador(j));

        String out = div.imprimirJugadores();
        assertNotNull(out);
        assertTrue(out.contains("Equipos de la división A"));
        assertTrue(out.contains("Jugadores del equipo Peñarol"));
        assertTrue(out.contains("Cata")); // aparece en el plantel
    }

    @Test
    void registrarPartidoVaAlHistorialYSeConsulta() {
        Division div = new Division("A", 8);

        Equipo loc = new Equipo("PRL", "Peñarol", div);
        Equipo vis = new Equipo("LIV", "Liverpool", div);
        assertTrue(div.agregarEquipo(loc));
        assertTrue(div.agregarEquipo(vis));

        Partido p = new Partido(loc, vis, div);
        div.registrarPartido(p);

        assertFalse(div.mostrarHistorial().esVacia());
        assertSame(p, div.mostrarHistorial().tope());
    }

    @Test
    void yaJugaronDetectaIndependienteDelOrdenYRestauraLaPila() {
        Division div = new Division("A", 8);

        Equipo e1 = new Equipo("PRL", "Peñarol", div);
        Equipo e2 = new Equipo("LIV", "Liverpool", div);
        Equipo e3 = new Equipo("RCG", "Racing", div);
        assertTrue(div.agregarEquipo(e1));
        assertTrue(div.agregarEquipo(e2));
        assertTrue(div.agregarEquipo(e3));

        // Al inicio no jugaron
        assertFalse(div.yaJugaron(e1, e2));

        // Registramos un partido e1 vs e2
        Partido p = new Partido(e1, e2, div);
        div.registrarPartido(p);

        int sizeAntes = div.mostrarHistorial().cantElementos();

        // Debe detectar el cruce en ambos órdenes
        assertTrue(div.yaJugaron(e1, e2));
        assertTrue(div.yaJugaron(e2, e1));

        // Y no confundir con otros cruces
        assertFalse(div.yaJugaron(e1, e3));

        // La pila queda restaurada (mismo tamaño y mismo tope)
        int sizeDespues = div.mostrarHistorial().cantElementos();
        assertEquals(sizeAntes, sizeDespues);
        assertSame(p, div.mostrarHistorial().tope());
    }

    @Test
    void compareToAunNoImplementado() {
        Division div = new Division("A", 8);
        Division otra = new Division("B", 8);
        assertThrows(UnsupportedOperationException.class, () -> div.compareTo(otra));
    }
}
