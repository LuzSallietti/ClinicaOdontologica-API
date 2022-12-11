package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.model.Odontologo;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class OdontologoServiceTest {
    @Autowired
    private OdontologoService odontologoService;
   private static Odontologo odontologo;


    @BeforeAll
    public static void crearOdontologo(){
        odontologo = new Odontologo();
        odontologo.setNombre("Lisa");
        odontologo.setApellido("Simpson");
        odontologo.setMatricula(2405);
    }

    @Test
    void AcrearUnOdontologo(){

        odontologoService.crearOdontologo(odontologo);
        assertTrue(odontologoService.listarOdontologos().size()>0);

    }

    @Test
    void BlistarOdontologos(){
        assertTrue(odontologoService.listarOdontologos() != null);
    }
    @Test
    void EeliminarOdontologo(){
        odontologoService.eliminarOdontologo(1L);
        assertTrue((odontologoService.recuperarOdontologo(1L).isEmpty()));
    }

    @Test
    void CrecuperarOdontologo(){
        assertNotNull(odontologoService.recuperarOdontologo(1L));
    }

    @Test
    void DactualizarOdontologo(){
        Odontologo oActualizado = new Odontologo(1L, "Laura", "Olmos", 2507);
        odontologoService.modificarOdontologo(oActualizado);
        Optional <Odontologo> recuperado = odontologoService.recuperarOdontologo(1L);
        assertTrue(recuperado.get().getNombre() == "Laura");
    }

}