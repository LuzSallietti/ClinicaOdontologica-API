package com.dh.clinicaOdontologica.services;

import com.dh.clinicaOdontologica.dto.OdontologoDTO;
import com.dh.clinicaOdontologica.model.Odontologo;
import com.dh.clinicaOdontologica.repository.IRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class OdontologoService {
    //tiene como atributo EL REPOSITORY
    private IRepository<Odontologo> odontologoRepository;

    //constructor
    public OdontologoService(IRepository<Odontologo> odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    public OdontologoDTO crearOdontologo(Odontologo o){
        Odontologo odontologo = odontologoRepository.agregar(o);
        ObjectMapper mapper = new ObjectMapper();
        OdontologoDTO odontologoDTO = mapper.convertValue(odontologo,OdontologoDTO.class);
        return odontologoDTO;
    }
    //Crear dos métodos en el servicio: uno que devuelva todos los odontologos y otro que devuelva el odontologo por su id.
    public List<OdontologoDTO> listarOdontologos(){
        //traigo el listado de la BD ficticia del repository, convierto c/u a DTO y lo devuelvo como array de DTO
        ObjectMapper mapper = new ObjectMapper();
        List<Odontologo> odontologos = odontologoRepository.listar();
        List<OdontologoDTO> odontologosDTO = new ArrayList<OdontologoDTO>();

        for(Odontologo o : odontologos) {
            OdontologoDTO odontologoDTO = mapper.convertValue(o, OdontologoDTO.class);
            odontologosDTO.add(odontologoDTO);
        }

        return odontologosDTO;
    }

    public OdontologoDTO buscarOdontologo(int id){
        ObjectMapper mapper = new ObjectMapper();
        Odontologo oEncontrado = odontologoRepository.buscar(id);
        OdontologoDTO odontologo = mapper.convertValue(oEncontrado, OdontologoDTO.class);

        return odontologo;

    }
    public OdontologoDTO actualizarOdontologo(Odontologo odontologo){
        ObjectMapper mapper = new ObjectMapper();
        Odontologo oModificado = odontologoRepository.actualizar(odontologo);
        return mapper.convertValue(oModificado, OdontologoDTO.class);
    }
    public Boolean eliminarOdontologo(int id){
        //aca no implemento el DTO?
        return odontologoRepository.eliminar(id);
    }




}
