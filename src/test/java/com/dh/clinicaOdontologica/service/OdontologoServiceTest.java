package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.dto.OdontologoDTO;
import org.junit.BeforeClass;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class OdontologoServiceTest {
    @Autowired
    private OdontologoService odontologoService;
    private static OdontologoDTO odontologo;


    @BeforeAll
    public static void crearOdontologo(){
        odontologo = new OdontologoDTO();
        odontologo.setNombre("Lisa");
        odontologo.setApellido("Simpson");
        odontologo.setMatricula(2405);

        System.out.println(odontologo);

    }

    @Test
    void AcrearUnOdontologo(){

        odontologoService.crearOdontologo(odontologo);

    }

    @Test
    void BlistarOdontologos(){
        System.out.println(odontologoService.listarOdontologos());
        assertTrue(odontologoService.listarOdontologos() != null);
    }
    @Test
    void EeliminarOdontologo(){
        odontologoService.eliminarOdontologo(1L);
        assertNull((odontologoService.recuperarOdontologo(1L)));
    }

    @Test
    void CrecuperarOdontologo(){
        assertNotNull(odontologoService.recuperarOdontologo(1L));
    }

    @Test
    void DactualizarOdontologo(){
        odontologo.setId(1L);
        odontologo.setNombre("Laura");
        odontologo.setApellido("Catala Olmos");
        odontologo.setMatricula(2505);
        odontologoService.modificarOdontologo(odontologo);
        OdontologoDTO recuperado = odontologoService.recuperarOdontologo(1L);
        assertTrue(recuperado.getNombre().equals("Laura"));
        System.out.println(recuperado);
    }

}