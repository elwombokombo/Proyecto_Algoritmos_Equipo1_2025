package com.example.ClasesProyecto;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Tests de Partido SIN modificar la clase de producción.
 * Se validan propiedades invariantes y consistencia de estadísticas.
 */
public class PartidoTest {

    @Test
    public void jugarActualizaEstadisticasYRegistraEnHistorial() {
        Division div = new Division("A", 8);

        div.historialPartidos = new com.example.lista.impl.PilaListaEnlazada<>();

        Equipo local = new Equipo("PRL", "Peñarol", div);
        Equipo vis   = new Equipo("LIV", "Liverpool", div);

        Partido p = new Partido(local, vis, div);

        assertEquals(0, local.getPartidosTerminados());
        assertEquals(0, vis.getPartidosTerminados());
        assertEquals(0, local.getPuntos());
        assertEquals(0, vis.getPuntos());

        p.jugar();
        // inicia y finaliza
        assertTrue(p.terminado());

        assertEquals(1, local.getPartidosTerminados());
        assertEquals(1, vis.getPartidosTerminados());

        int sumaPuntos = local.getPuntos() + vis.getPuntos();
        assertTrue(sumaPuntos == 3 || sumaPuntos == 2, "La suma de puntos debe ser 3 (ganador) o 2 (empate)");

        assertEquals(local.getGolesAFavor(),  vis.getGolesEnContra());
        assertEquals(vis.getGolesAFavor(),    local.getGolesEnContra());

        // queda reg en el historial
        assertNotNull(div.mostrarHistorial());
        assertFalse(div.mostrarHistorial().esVacia());
    }

    @Test
    public void jugarEsIdempotenteNoDuplicaEstadisticas() {
        Division div = new Division("A", 8);
        div.historialPartidos = new com.example.lista.impl.PilaListaEnlazada<>();

        Equipo local = new Equipo("PRL", "Peñarol", div);
        Equipo vis   = new Equipo("LIV", "Liverpool", div);

        Partido p = new Partido(local, vis, div);

        p.jugar();

        int puntosLocal  = local.getPuntos();
        int puntosVisita = vis.getPuntos();
        int pjLocal      = local.getPartidosTerminados();
        int pjVisita     = vis.getPartidosTerminados();

        p.jugar();

        assertEquals(puntosLocal,  local.getPuntos());
        assertEquals(puntosVisita, vis.getPuntos());
        assertEquals(pjLocal,      local.getPartidosTerminados());
        assertEquals(pjVisita,     vis.getPartidosTerminados());
    }

    @Test
    public void compareToUsaDiferenciaDeGoles() {
        Division div = new Division("A", 8);
        div.historialPartidos = new com.example.lista.impl.PilaListaEnlazada<>();

        Equipo a = new Equipo("A", "A", div);
        Equipo b = new Equipo("B", "B", div);
        Equipo c = new Equipo("C", "C", div);
        Equipo d = new Equipo("D", "D", div);

        Partido p1 = new Partido(a, b, div);
        Partido p2 = new Partido(c, d, div);

        p1.jugar();
        p2.jugar();

        int diff1 = p1.getGolesLocal() - p1.getGolesVisitante();
        int diff2 = p2.getGolesLocal() - p2.getGolesVisitante();

        assertEquals(Integer.compare(diff1, diff2), p1.compareTo(p2));
    }

    @Test
    public void formatoDeMarcadorEsValido() {
        Division div = new Division("A", 8);
        div.historialPartidos = new com.example.lista.impl.PilaListaEnlazada<>();

        Equipo local = new Equipo("PRL", "Peñarol", div);
        Equipo vis   = new Equipo("LIV", "Liverpool", div);

        Partido p = new Partido(local, vis, div);
        p.jugar();

        String m = p.getMarcador();

        assertTrue(m.contains("Peñarol"));
        assertTrue(m.contains("Liverpool"));
        assertTrue(m.contains(" - "));

        int gL = p.getGolesLocal();
        int gV = p.getGolesVisitante();
        assertTrue(gL >= 0 && gL <= 5);
        assertTrue(gV >= 0 && gV <= 5);
    }
}
