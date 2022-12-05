package com.dh.clinicaOdontologica.controller;

import com.dh.clinicaOdontologica.dto.DomicilioDTO;
import com.dh.clinicaOdontologica.service.IDomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController {
    @Autowired
    IDomicilioService domicilioService;

    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @GetMapping("/{id}")
    public DomicilioDTO recuperarDomicilio(@PathVariable Long id){
        return domicilioService.recuperarDomicilio(id);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @GetMapping
    public Collection<DomicilioDTO> listarDomicilios(){
        return domicilioService.listarDomicilios();
    }


    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @PostMapping
    public ResponseEntity<?> crearDomicilio(@RequestBody DomicilioDTO domicilioDTO){
        domicilioService.crearDomicilio(domicilioDTO);
        return ResponseEntity.ok(HttpStatus.CREATED);

    }
    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @PutMapping
    public ResponseEntity<?> modificarDomicilio(@RequestBody DomicilioDTO domicilioDTO){
        domicilioService.modificarDomicilio(domicilioDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarDomicilio(@PathVariable Long id){
        domicilioService.eliminarDomicilio(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
