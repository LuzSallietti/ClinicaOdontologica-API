package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.dto.PacienteDTO;
import com.dh.clinicaOdontologica.model.Paciente;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IPacienteService {
    Paciente crearPaciente(Paciente paciente);
    Optional <Paciente> recuperarPaciente(Long id);
    Paciente modificarPaciente(Paciente paciente);
    void eliminarPaciente(Long id);
    List<Paciente> listarPacientes();

}
