package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.dto.OdontologoDTO;
import com.dh.clinicaOdontologica.model.Odontologo;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IOdontologoService {
    Odontologo crearOdontologo(Odontologo odontologo);
    Optional<Odontologo> recuperarOdontologo(Long id);
    Odontologo modificarOdontologo(Odontologo odontologo);
    void eliminarOdontologo(Long id);
    List<Odontologo> listarOdontologos();


}
