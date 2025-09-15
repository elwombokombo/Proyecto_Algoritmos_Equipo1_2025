package com.example.Interfaces;

import com.example.ClasesProyecto.Partido;
import com.example.lista.TDALista;
import java.time.LocalDateTime;

public interface IPartido {
    Boolean pilaVacia();
    String mostrarMarcador(Partido.Marcador marcador);
    int golesLocal();
    int golesVisitante();
    int maxGoles();

}
