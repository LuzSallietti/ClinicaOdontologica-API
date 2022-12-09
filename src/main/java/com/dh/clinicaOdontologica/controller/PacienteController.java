package com.dh.clinicaOdontologica.controller;


import com.dh.clinicaOdontologica.dto.PacienteDTO;
import com.dh.clinicaOdontologica.model.Paciente;
import com.dh.clinicaOdontologica.service.IPacienteService;
import com.dh.clinicaOdontologica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    IPacienteService pacienteService;

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> recuperarPaciente(@PathVariable Long id){
        Paciente paciente = pacienteService.recuperarPaciente(id).orElse(null);
        return new ResponseEntity<>(paciente, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Paciente>> listarPacientes(){
        return new ResponseEntity<>(pacienteService.listarPacientes(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Paciente> crearPaciente(@RequestBody Paciente paciente){

        return new ResponseEntity<>(pacienteService.crearPaciente(paciente), HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<Paciente> modificarPaciente(@RequestBody Paciente paciente){
        ResponseEntity response = null;
        if(paciente.getId() != null && pacienteService.recuperarPaciente(paciente.getId()).isPresent()){
            response = ResponseEntity.ok(pacienteService.modificarPaciente(paciente));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPaciente(@PathVariable Long id){
        ResponseEntity response = null;
        if(pacienteService.recuperarPaciente(id).isPresent()) {
            pacienteService.eliminarPaciente(id);
            response = ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        };

        return response;
    }


}
