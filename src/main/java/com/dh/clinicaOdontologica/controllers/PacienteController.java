package com.dh.clinicaOdontologica.controllers;

import com.dh.clinicaOdontologica.controllers.dominio.Paciente;
import com.dh.clinicaOdontologica.services.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    private PacienteService pacienteService = new PacienteService();

    //puedo crear este getter para acceder al servicio desde HomeController?
    public PacienteService getPacienteService() {
        return pacienteService;
    }
    //endpoint->Crear

    @PostMapping("/crear")
    public Paciente crearPaciente(@RequestBody Paciente paciente){
        return pacienteService.crearPaciente(paciente);

    }

    //endpoint->Listar
    @GetMapping("/listar")
    public List<Paciente> listar(){
        return pacienteService.listarPacientes();
    }

    //endpoint->Buscar
    @GetMapping("/{email}")
    public Paciente buscar(@PathVariable String email){
        return pacienteService.buscar(email);
    }

    //endpoint-> practicar ResponseEntity
    @GetMapping("/saludo")
    ResponseEntity<String> saludo(){
        return new ResponseEntity<>("Bienvenido paciente", HttpStatus.OK);
    }

    //endpoint->practicar ResponseEntity
    @PostMapping("/registrar")
    ResponseEntity<Paciente>registrar(@RequestBody Paciente paciente){
        return new ResponseEntity<>(pacienteService.crearPaciente(paciente),HttpStatus.CREATED);
    }

    @PutMapping("/actualizar")
    ResponseEntity<Paciente> actualizar(@RequestBody Paciente paciente){
        ResponseEntity response = null;
        if(pacienteService.buscar(paciente.getEmail())==null){
            response = new ResponseEntity<>("Email no encontrado",HttpStatus.NOT_FOUND);
        } else {
            //acá el service ejecuta la actualizacion y devuelve el paciente modificado
            response = new ResponseEntity<>("Actualizado correctamente",HttpStatus.OK);
        }
    return response;
    }
}
