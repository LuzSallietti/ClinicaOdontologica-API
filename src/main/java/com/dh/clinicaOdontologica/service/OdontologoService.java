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

    //inyectar el Mapper
    @Autowired
    ObjectMapper mapper;

//metodo reutilizable para CREAR y MODIFICAR
    private void guardarOdontologo(OdontologoDTO odontologoDTO){
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        odontologoRepository.save(odontologo);
        logger.info("SAVING ODONTOLOGO: " + odontologoDTO);
    }

    @Override
    public void crearOdontologo(OdontologoDTO odontologoDTO) {
        guardarOdontologo(odontologoDTO);
    }

    @Override
    public OdontologoDTO recuperarOdontologo(Long id) {
        Optional<Odontologo> odontologo= odontologoRepository.findById(id);
        OdontologoDTO odontologoDTO = null;
        if(odontologo.isPresent()){
            odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
            logger.info("GETTING ODONTOLOGO BY ID : "+id + " = " + odontologoDTO);
        }
        return odontologoDTO;
    }


    @Override
    public void modificarOdontologo(OdontologoDTO odontologoDTO) {
        guardarOdontologo(odontologoDTO);
    }

    @Override
    public void eliminarOdontologo(Long id) {
        odontologoRepository.deleteById(id);
        logger.info("DELETING ODONTOLOGO id: " + id);
    }

    @Override
    public Set<OdontologoDTO> listarOdontologos() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        Set<OdontologoDTO> odontologoDTOS = new HashSet<>();

        for (Odontologo odontologo : odontologos) {
            odontologoDTOS.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
        logger.info("GETTING ALL ODONTOLOGOS: " + odontologoDTOS);
        return odontologoDTOS;
    }
}
