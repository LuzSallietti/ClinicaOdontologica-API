package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.dto.OdontologoDTO;
import com.dh.clinicaOdontologica.model.Odontologo;
import com.dh.clinicaOdontologica.repository.IOdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class OdontologoService implements IOdontologoService {
    //implementa los metodos de la interfaz IOdontologoService > en ellos llama al repository
    //tiene como atributo EL REPOSITORY > se inyecta como dependencia
    @Autowired
    private IOdontologoRepository odontologoRepository;
    private final static Logger logger = Logger.getLogger(DomicilioService.class);




    @Override
    public Odontologo crearOdontologo(Odontologo odontologo) {
        logger.info("SAVING ODONTOLOGO: " + odontologo);
        return odontologoRepository.save(odontologo);
    }

    @Override
    public Optional <Odontologo> recuperarOdontologo(Long id) {
        Optional<Odontologo> odontologo= odontologoRepository.findById(id);

        if(odontologo.isPresent()){
            logger.info("GETTING ODONTOLOGO BY ID : "+id + " = " + odontologo);
            return odontologo;
        } else {
            return null;
        }

    }


    @Override
    public Odontologo modificarOdontologo(Odontologo odontologo) {
        logger.info("UPDATING ODONTOLOGO: " + odontologo);
        return odontologoRepository.save(odontologo);
    }

    @Override
    public void eliminarOdontologo(Long id) {
        odontologoRepository.deleteById(id);
        logger.info("DELETING ODONTOLOGO id: " + id);
    }

    @Override
    public List<Odontologo> listarOdontologos() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        logger.info("GETTING ALL ODONTOLOGOS: " + odontologos);
        return odontologos;
    }
}
