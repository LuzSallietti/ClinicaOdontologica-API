package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.dto.OdontologoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest


class OdontologoServiceTest {
    @Autowired
    private OdontologoService odontologoService;

    @Test
    void testCrearOdontologo(){
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Lola");
        odontologoDTO.setApellido("Catala");
        odontologoDTO.setMatricula(2405);
        odontologoService.crearOdontologo(odontologoDTO);

        OdontologoDTO odontologoCreado = odontologoService.recuperarOdontologo(1L);
        assertTrue(odontologoCreado != null);

    }

}