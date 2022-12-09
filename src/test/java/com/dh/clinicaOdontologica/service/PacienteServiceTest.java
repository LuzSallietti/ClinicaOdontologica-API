package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.dto.DomicilioDTO;
import com.dh.clinicaOdontologica.dto.OdontologoDTO;
import com.dh.clinicaOdontologica.dto.PacienteDTO;
import com.dh.clinicaOdontologica.model.Domicilio;
import com.dh.clinicaOdontologica.model.Paciente;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

@TestMethodOrder(MethodOrderer.MethodName.class)
class PacienteServiceTest {
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private DomicilioService domicilioService;

    private static PacienteDTO pacienteDTO;
    private static DomicilioDTO domicilioDTO;
    private static Domicilio domicilionormal;


    @BeforeAll
    public static void crearData(){
        domicilioDTO = new DomicilioDTO();
        domicilioDTO.setId(1L);
        domicilioDTO.setCalle("Los Naranjos");
        domicilioDTO.setNumero(434);
        domicilioDTO.setLocalidad("Las Varas");
        domicilioDTO.setProvincia("Cordoba");

        domicilionormal = new Domicilio();
        domicilionormal.setId(1L);
        domicilionormal.setCalle("Los Naranjos");
        domicilionormal.setNumero(434);
        domicilionormal.setLocalidad("Las Varas");
        domicilionormal.setProvincia("Cordoba");




        pacienteDTO = new PacienteDTO();
        pacienteDTO.setNombre("Luz");
        pacienteDTO.setApellido("Sallietti");
        pacienteDTO.setDni(30303567);
        pacienteDTO.setEmail("luz@mail.com");
        pacienteDTO.setFechaAlta(LocalDate.of(2022,12,12));
        pacienteDTO.setDomicilio(domicilionormal);

    }


    @Test
    void AcrearDomicilio() {

        domicilioService.crearDomicilio(domicilioDTO);

    }
    @Test
    void BcrearPaciente() {
        /*pacienteService.crearPaciente(paciente);*/
    }

    @Test
    void CrecuperarPaciente() {
        System.out.println(pacienteService.listarPacientes());
        pacienteService.listarPacientes();
    }

    @Test
    void modificarPaciente() {
    }

    @Test
    void eliminarPaciente() {
    }

    @Test
    void listarPacientes() {
    }
}