package com.dh.clinicaOdontologica.controller;

import com.dh.clinicaOdontologica.dto.OdontologoDTO;
import com.dh.clinicaOdontologica.model.Odontologo;
import com.dh.clinicaOdontologica.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    @Autowired
    IOdontologoService odontologoService;

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> recuperarOdontologo(@PathVariable Long id){
        Odontologo odontologo = odontologoService.recuperarOdontologo(id).orElse(null);
        return new ResponseEntity<>(odontologo, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Odontologo>> listarOdontologos(){
        return new ResponseEntity(odontologoService.listarOdontologos(),HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Odontologo> crearOdontologo(@RequestBody Odontologo odontologo){

        return new ResponseEntity(odontologoService.crearOdontologo(odontologo),HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<Odontologo> modificarOdontologo(@RequestBody Odontologo odontologo){
        ResponseEntity response = null;
        if(odontologo.getId() != null && odontologoService.recuperarOdontologo(odontologo.getId()).isPresent()){
            response = ResponseEntity.ok(odontologoService.modificarOdontologo(odontologo));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Long id){
        ResponseEntity<String> response = null;
        odontologoService.eliminarOdontologo(id);
        response = ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        return response;
    }



}
