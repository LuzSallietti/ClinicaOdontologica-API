package com.dh.clinicaOdontologica.service;


import com.dh.clinicaOdontologica.dto.PacienteDTO;
import com.dh.clinicaOdontologica.model.Paciente;
import com.dh.clinicaOdontologica.repository.IPacienteRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class PacienteService implements IPacienteService {
    @Autowired
    private IPacienteRepository pacienteRepository;
    private final static Logger logger = Logger.getLogger(PacienteService.class);



    @Override
    public Paciente crearPaciente(Paciente paciente) {
        logger.info("SAVING PACIENTE: " + paciente);
        return pacienteRepository.save(paciente);
    }

    @Override
    public Optional <Paciente> recuperarPaciente(Long id) {
        Optional<Paciente> paciente= pacienteRepository.findById(id);
        if(paciente.isPresent()){
            logger.info("GETTING PACIENTE BY ID : "+id + " = " + paciente);
            return paciente;
        } else {
            return null;
        }


    }

    @Override
    public Paciente modificarPaciente(Paciente paciente) {
        logger.info("UPDATING PACIENTE: " + paciente);
        return pacienteRepository.save(paciente);

    }

    @Override
    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
        logger.info("DELETING PACIENTE id: " + id);
    }

    @Override
    public List<Paciente> listarPacientes() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        logger.info("GETTING ALL PACIENTES: " + pacientes);
        return pacientes;
    }
}
