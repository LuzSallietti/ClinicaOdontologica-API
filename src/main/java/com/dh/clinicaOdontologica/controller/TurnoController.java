package com.dh.clinicaOdontologica.controller;


import com.dh.clinicaOdontologica.dto.DomicilioDTO;
import com.dh.clinicaOdontologica.dto.TurnoDTO;
import com.dh.clinicaOdontologica.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    ITurnoService turnoService;

    @GetMapping("/{id}")
    public TurnoDTO recuperarTurno(@PathVariable Long id){
        return turnoService.recuperarTurno(id);
    }

    @GetMapping
    public Collection<TurnoDTO> listarTurnos(){
        return turnoService.listarTurnos();
    }


    @PostMapping
    public ResponseEntity<?> crearTurno(@RequestBody TurnoDTO turnoDTO){
        turnoService.crearTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<?> modificarTurno(@RequestBody TurnoDTO turnoDTO){
        turnoService.modificarTurno(turnoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTurno(@PathVariable Long id){
        turnoService.eliminarTurno(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
