package com.dh.clinicaOdontologica.service;


import com.dh.clinicaOdontologica.dto.TurnoDTO;
import com.dh.clinicaOdontologica.model.Turno;
import com.dh.clinicaOdontologica.repository.ITurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    @Autowired
    ObjectMapper mapper;

    private void guardarTurno(TurnoDTO turnoDTO){
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        turnoRepository.save(turno);
    }

    @Override
    public void crearTurno(TurnoDTO turnoDTO) {
        guardarTurno(turnoDTO);
    }

    @Override
    public TurnoDTO recuperarTurno(Long id) {
        Optional<Turno> turno= turnoRepository.findById(id);
        TurnoDTO turnoDTO = null;
        if(turno.isPresent()){
            turnoDTO = mapper.convertValue(turno, TurnoDTO.class);
        }
        return turnoDTO;
    }

    @Override
    public void modificarTurno(TurnoDTO turnoDTO) {
        guardarTurno(turnoDTO);
    }

    @Override
    public void eliminarTurno(Long id) {
        turnoRepository.deleteById(id);

    }

    @Override
    public Set<TurnoDTO> listarTurnos() {
        List<Turno> turnos = turnoRepository.findAll();
        Set<TurnoDTO> turnoDTOS = new HashSet<>();

        for (Turno turno : turnos) {
            turnoDTOS.add(mapper.convertValue(turno, TurnoDTO.class));
        }
        return turnoDTOS;
    }
}
