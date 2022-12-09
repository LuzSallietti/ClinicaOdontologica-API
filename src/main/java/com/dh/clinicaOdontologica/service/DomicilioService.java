package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.GlobalExceptionHandler;

import com.dh.clinicaOdontologica.model.Domicilio;
import com.dh.clinicaOdontologica.repository.IDomicilioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class DomicilioService implements IDomicilioService {
    @Autowired
    private IDomicilioRepository domicilioRepository;
    private final static Logger logger = Logger.getLogger(DomicilioService.class);

    @Autowired
    ObjectMapper mapper;


    @Override
    public Domicilio crearDomicilio(Domicilio domicilio) {
        logger.info("SAVING DOMICILIO: " + domicilio);
        return domicilioRepository.save(domicilio);
    }

    @Override
    public Optional<Domicilio> recuperarDomicilio(Long id) {
        Optional<Domicilio> domicilio= domicilioRepository.findById(id);
        if(domicilio.isPresent()){
            logger.info("GETTING DOMICILIO BY ID : "+id + " = " + domicilio);
        }
        return domicilio;
    }

    @Override
    public Domicilio modificarDomicilio(Domicilio domicilio) {
        logger.info("UPDATING DOMICILIO: " + domicilio);
        return domicilioRepository.save(domicilio);
    }

    @Override
    public void eliminarDomicilio(Long id) {
        domicilioRepository.deleteById(id);
        logger.info("DELETING DOMICILIO id: " + id);

    }

    @Override
    public List<Domicilio> listarDomicilios() {
        List<Domicilio> domicilios = domicilioRepository.findAll();

        logger.info("GETTING ALL DOMICILIOS: " + domicilios);
        return domicilios;
    }
}
