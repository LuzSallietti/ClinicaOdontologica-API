package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.model.Domicilio;
import com.dh.clinicaOdontologica.model.Odontologo;
import com.dh.clinicaOdontologica.model.Paciente;
import com.dh.clinicaOdontologica.model.Turno;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class TurnoServiceTest {
    @Autowired
    private DomicilioService domicilioService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private TurnoService turnoService;
    @Autowired
    private OdontologoService odontologoService;

    private static Turno turno;


    public void cargarData() {
        Domicilio domicilio = new Domicilio("Av Cerrito", 589, "CABA", "Buenos Aires");
        domicilioService.crearDomicilio(domicilio);

        Paciente paciente = pacienteService.crearPaciente(new Paciente("Lorena", "Holms",12853879, "lorena@mail.com", LocalDate.of(2022,12,12),domicilio));

        Odontologo odontologo = odontologoService.crearOdontologo(new Odontologo("Lisa", "Simpson", 2345));

        turno = new Turno(paciente, odontologo,LocalDate.of(2022,12,12), "17:00");

    }

    @Test
    void AcrearTurno() {
        cargarData();
        assertNotNull(turnoService.crearTurno(turno));
    }

    @Test
    void BrecuperarTurno() {
        assertTrue(turnoService.recuperarTurno(1L) != null);
    }

    @Test
    void DeliminarTurno() {
        turnoService.eliminarTurno(1L);
        assertNull(turnoService.recuperarTurno(1L));
    }

    @Test
    void ClistarTurnos() {
        assertTrue(turnoService.listarTurnos() != null);
    }
}