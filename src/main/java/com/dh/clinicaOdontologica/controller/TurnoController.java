package com.dh.clinicaOdontologica.controller;


import com.dh.clinicaOdontologica.model.Turno;
import com.dh.clinicaOdontologica.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    ITurnoService turnoService;

    @GetMapping("/{id}")
    public ResponseEntity<Turno> recuperarTurno(@PathVariable Long id){
        Turno turno = turnoService.recuperarTurno(id).orElse(null);
        return new ResponseEntity<>(turno, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Turno>> listarTurnos(){
        return new ResponseEntity(turnoService.listarTurnos(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Turno> crearTurno(@RequestBody Turno turno){
        return new ResponseEntity(turnoService.crearTurno(turno),HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<Turno> modificarTurno(@RequestBody Turno turno){
        ResponseEntity response = null;
        if(turno.getId() != null && turnoService.recuperarTurno(turno.getId()).isPresent()){
            response = ResponseEntity.ok(turnoService.modificarTurno(turno));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Long id){
        ResponseEntity response = null;
        if(turnoService.recuperarTurno(id).isPresent()) {
            turnoService.eliminarTurno(id);
            response = ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        };
        return response;
    }
}
