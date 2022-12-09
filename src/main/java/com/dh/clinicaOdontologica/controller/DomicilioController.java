package com.dh.clinicaOdontologica.controller;

import com.dh.clinicaOdontologica.dto.DomicilioDTO;
import com.dh.clinicaOdontologica.model.Domicilio;
import com.dh.clinicaOdontologica.service.IDomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController {
    @Autowired
    IDomicilioService domicilioService;


    @GetMapping("/{id}")
    public ResponseEntity<Domicilio> recuperarDomicilio(@PathVariable Long id){
        Domicilio domicilio = domicilioService.recuperarDomicilio(id).orElse(null);
        return new ResponseEntity<>(domicilio, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<Domicilio>> listarDomicilios(){
        return new ResponseEntity<>(domicilioService.listarDomicilios(), HttpStatus.OK);
    }



    @PostMapping
    public ResponseEntity<Domicilio> crearDomicilio(@RequestBody Domicilio domicilio){
        return new ResponseEntity<>(domicilioService.crearDomicilio(domicilio), HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<Domicilio> modificarDomicilio(@RequestBody Domicilio domicilio){
        ResponseEntity<Domicilio> response = null;
        if(domicilio.getId() != null && domicilioService.recuperarDomicilio(domicilio.getId()).isPresent()){
            response = ResponseEntity.ok(domicilioService.modificarDomicilio(domicilio));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarDomicilio(@PathVariable Long id){
        ResponseEntity response = null;
        if(domicilioService.recuperarDomicilio(id).isPresent()) {
            domicilioService.eliminarDomicilio(id);
            response = ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        };

        return response;
    }

}
