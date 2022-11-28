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
    public PacienteDTO recuperarPaciente(@PathVariable Long id){
        return pacienteService.recuperarPaciente(id);
    }
    @GetMapping
    public Collection<PacienteDTO> listarPacientes(){
        return pacienteService.listarPacientes();
    }


    @PostMapping
    public ResponseEntity<?> crearPaciente(@RequestBody PacienteDTO pacienteDTO){
        pacienteService.crearPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<?> modificarPaciente(@RequestBody PacienteDTO pacienteDTO){
        pacienteService.modificarPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Long id){
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
