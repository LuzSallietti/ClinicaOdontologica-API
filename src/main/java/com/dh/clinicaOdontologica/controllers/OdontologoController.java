package com.dh.clinicaOdontologica.controllers;

import com.dh.clinicaOdontologica.dto.OdontologoDTO;
import com.dh.clinicaOdontologica.model.Odontologo;
import com.dh.clinicaOdontologica.model.Paciente;
import com.dh.clinicaOdontologica.repository.impl.OdontologoRepository;
import com.dh.clinicaOdontologica.services.OdontologoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    //lleva como atributo servicio una instancia del servicio--> que recibe una instancia del repositorio (BD)
    private OdontologoService odontologoService = new OdontologoService(new OdontologoRepository());

    //endpoint-->READ (all)
    @GetMapping("/listar")
    public ResponseEntity<List<OdontologoDTO>> listar(){
        return new ResponseEntity<>(odontologoService.listarOdontologos(),HttpStatus.OK);
    }
    //endpoint --> READ (id)
    @GetMapping("buscar/{id}")
    public ResponseEntity<OdontologoDTO> buscar(@PathVariable Integer id){
        return ResponseEntity.ok(odontologoService.buscarOdontologo(id));
    }
    //endpoint --> CREATE
    @PostMapping("/crear")
    public ResponseEntity<OdontologoDTO> crear(@RequestBody Odontologo odontologo){
        return new ResponseEntity<>(odontologoService.crearOdontologo(odontologo), HttpStatus.CREATED);
    }
    //endpoint--> DELETE
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id) {
        ResponseEntity response = null;
        if (odontologoService.eliminarOdontologo(id))
            response = ResponseEntity.status(HttpStatus.OK).build();
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    //endpoint --> UPDATE
    @PutMapping("/actualizar")
    public ResponseEntity<OdontologoDTO> actualizar(@RequestBody Odontologo odontologo){
        return new ResponseEntity<>(odontologoService.actualizarOdontologo(odontologo), HttpStatus.OK);
    }



}
