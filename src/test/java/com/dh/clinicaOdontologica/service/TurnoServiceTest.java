package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.dto.OdontologoDTO;
import com.dh.clinicaOdontologica.dto.PacienteDTO;
import com.dh.clinicaOdontologica.dto.TurnoDTO;
import com.dh.clinicaOdontologica.model.Domicilio;
import com.dh.clinicaOdontologica.model.Paciente;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
class TurnoServiceTest {
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private TurnoService turnoService;

    public void cargarDataSet() {
      /*  Domicilio domicilio = new Domicilio(1L,"Los Alamos", 2020,"Las Varas", "Cordoba");
        PacienteDTO paciente = new PacienteDTO();
        paciente.setNombre("Laura");
        paciente.setApellido("Olmos");
        paciente.setDni(30256456);
        paciente.setEmail("laura@mail.com");
        paciente.setFechaAlta(LocalDate.of(2022,12,12));
        paciente.setDomicilio(domicilio);
        pacienteService.crearPaciente(paciente);
        OdontologoDTO odontologo = new OdontologoDTO();
        odontologo.setNombre("Aldo");
        odontologo.setApellido("Perez");
        odontologo.setMatricula(2569);
        odontologoService.crearOdontologo(odontologo);*/

    }
    @Test
    void crearTurno() {
       /* this.cargarDataSet();
        turnoService.crearTurno(new TurnoDTO(pacienteService.recuperarPaciente(1L).getId(),odontologoService.recuperarOdontologo(1L).getId(),LocalDate.of(2022,12,12),"12:30"));
        Assert.assertNotNull(turnoService.buscar(1));*/

    }

    @Test
    void recuperarTurno() {
    }

    @Test
    void modificarTurno() {
    }

    @Test
    void eliminarTurno() {
    }

    @Test
    void listarTurnos() {
    }
}