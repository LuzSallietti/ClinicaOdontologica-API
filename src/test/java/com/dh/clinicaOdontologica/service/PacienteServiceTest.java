package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.model.Domicilio;
import com.dh.clinicaOdontologica.model.Paciente;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class PacienteServiceTest {
    @Autowired
    private DomicilioService domicilioService;
    @Autowired
    private PacienteService pacienteService;

    public void cargarData() {
        Domicilio domicilio = new Domicilio("Av Cerrito", 589, "CABA", "Buenos Aires");
        domicilioService.crearDomicilio(domicilio);
        Paciente p = pacienteService.crearPaciente(new Paciente("Lorena", "Holms",12853879, "lorena@mail.com", LocalDate.of(2022,12,12),domicilio));

    }

   @Test
    void AcrearPaciente() {
        cargarData();
       assertNotNull(pacienteService.recuperarPaciente(1L));
    }

    @Test
    void CrecuperarPaciente() {
        assertTrue(pacienteService.recuperarPaciente(1L) != null);
    }

    @Test
    void DeliminarPaciente() {
        pacienteService.eliminarPaciente(1L);
        assertNull(pacienteService.recuperarPaciente(1L));
    }

    @Test
    void BlistarPacientes() {
        assertTrue(pacienteService.listarPacientes() != null);
    }
}