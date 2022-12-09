package com.dh.clinicaOdontologica.service;


import com.dh.clinicaOdontologica.dto.TurnoDTO;
import com.dh.clinicaOdontologica.model.Turno;
import com.dh.clinicaOdontologica.repository.ITurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TurnoService implements ITurnoService{
    @Autowired
    private ITurnoRepository turnoRepository;
    private final static Logger logger = Logger.getLogger(DomicilioService.class);


    @Override
    public Turno crearTurno(Turno turno) {
        logger.info("SAVING TURNO: " + turno);
        return turnoRepository.save(turno);
    }

    @Override
    public Optional<Turno> recuperarTurno(Long id) {
        Optional<Turno> turno= turnoRepository.findById(id);

        if(turno.isPresent()){
            logger.info("GETTING TURNO BY ID : "+id + " = " + turno);
            return turno;
        } else {
            return null;
        }

    }

    @Override
    public Turno modificarTurno(Turno turno) {
        logger.info("UPDATING TURNO: " + turno);
        return turnoRepository.save(turno);
    }

    @Override
    public void eliminarTurno(Long id) {
        logger.info("DELETING TURNO id: " + id);
        turnoRepository.deleteById(id);
    }

    @Override
    public List<Turno> listarTurnos() {
        List<Turno> turnos = turnoRepository.findAll();
        logger.info("GETTING ALL TURNOS: " + turnos);
        return turnos;
    }
}
