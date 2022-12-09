package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.dto.DomicilioDTO;
import com.dh.clinicaOdontologica.model.Domicilio;


import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IDomicilioService {
    Domicilio crearDomicilio(Domicilio domicilio);
    Optional<Domicilio> recuperarDomicilio(Long id);
    Domicilio modificarDomicilio(Domicilio domicilio);
    void eliminarDomicilio(Long id);
    List<Domicilio> listarDomicilios();
}
