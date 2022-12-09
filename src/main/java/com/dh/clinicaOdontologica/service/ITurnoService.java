package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.dto.DomicilioDTO;
import com.dh.clinicaOdontologica.dto.TurnoDTO;
import com.dh.clinicaOdontologica.model.Turno;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ITurnoService {
    Turno crearTurno(Turno turno);
    Optional <Turno> recuperarTurno(Long id);
    Turno modificarTurno(Turno turno);
    void eliminarTurno(Long id);
    List<Turno> listarTurnos();
}
