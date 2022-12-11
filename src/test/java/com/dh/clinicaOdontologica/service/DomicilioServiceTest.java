package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.model.Domicilio;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class DomicilioServiceTest {
    @Autowired
    private DomicilioService domicilioService;
    private static Domicilio domicilio;

    @BeforeAll

    public static  void crearData() {
        domicilio = new Domicilio();
        domicilio.setCalle("Los Alamos");
        domicilio.setNumero(1456);
        domicilio.setLocalidad("Los Polvorines");
        domicilio.setProvincia("Bs As");
    }

    @Test
    void AcrearDomicilio() {
        domicilioService.crearDomicilio(domicilio);
        assertTrue(domicilioService.listarDomicilios().size()>0);
    }

    @Test
    void BrecuperarDomicilio() {
        assertTrue(domicilioService.recuperarDomicilio(1L) != null);

    }

    @Test
    void DeliminarDomicilio() {
        domicilioService.eliminarDomicilio(1L);
        assertTrue(domicilioService.recuperarDomicilio(1L).isEmpty());
    }

    @Test
    void ClistarDomicilios() {
        assertTrue(domicilioService.listarDomicilios() != null);
    }
}