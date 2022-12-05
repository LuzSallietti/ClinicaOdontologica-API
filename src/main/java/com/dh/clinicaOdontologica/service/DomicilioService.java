package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.GlobalExceptionHandler;
import com.dh.clinicaOdontologica.dto.DomicilioDTO;
import com.dh.clinicaOdontologica.model.Domicilio;
import com.dh.clinicaOdontologica.repository.IDomicilioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DomicilioService implements IDomicilioService {
    @Autowired
    private IDomicilioRepository domicilioRepository;
    private final static Logger logger = Logger.getLogger(DomicilioService.class);

    @Autowired
    ObjectMapper mapper;

    private void guardarDomicilio(DomicilioDTO domicilioDTO){
        Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);
        domicilioRepository.save(domicilio);
        logger.info("SAVING: " + domicilioDTO);
    }

    @Override
    public void crearDomicilio(DomicilioDTO domicilioDTO) {
        guardarDomicilio(domicilioDTO);
    }

    @Override
    public DomicilioDTO recuperarDomicilio(Long id) {
        Optional<Domicilio> domicilio= domicilioRepository.findById(id);
        DomicilioDTO domicilioDTO = null;
        if(domicilio.isPresent()){
            domicilioDTO = mapper.convertValue(domicilio, DomicilioDTO.class);
            logger.info("GETTING BY ID : "+id + " = " + domicilioDTO);
        }
        return domicilioDTO;
    }

    @Override
    public void modificarDomicilio(DomicilioDTO domicilioDTO) {
        guardarDomicilio(domicilioDTO);
    }

    @Override
    public void eliminarDomicilio(Long id) {
        domicilioRepository.deleteById(id);
        logger.info("DELETING DOMICILIO id: " + id);

    }

    @Override
    public Set<DomicilioDTO> listarDomicilios() {
        List<Domicilio> domicilios = domicilioRepository.findAll();
        Set<DomicilioDTO> domicilioDTOS = new HashSet<>();

        for (Domicilio domicilio : domicilios) {
            domicilioDTOS.add(mapper.convertValue(domicilio, DomicilioDTO.class));
        }
        logger.info("GETTING ALL DOMICILIOS: " + domicilioDTOS);
        return domicilioDTOS;
    }
}
