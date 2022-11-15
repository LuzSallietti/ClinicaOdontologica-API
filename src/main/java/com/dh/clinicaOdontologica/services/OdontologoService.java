package com.dh.clinicaOdontologica.services;

import com.dh.clinicaOdontologica.controllers.dominio.Odontologo;
import com.dh.clinicaOdontologica.controllers.dominio.Paciente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OdontologoService {

    public Odontologo crearOdontologo(){
        Odontologo odontologo = new Odontologo(1,"Mara","Castro",7894);
        return odontologo;
    }
    //Crear dos métodos en el servicio: uno que devuelva todos los odontologos y otro que devuelva el odontologo por su id.
    public List<Odontologo> listarOdontologos(){
        List<Odontologo> listado = new ArrayList<>();
        Odontologo odontologo1 = new Odontologo(2,"Rodrigo","Kiop",4578);
        Odontologo odontologo2 = new Odontologo(3,"Lisa", "Simpson", 7412);
        listado.add(odontologo1);
        listado.add(odontologo2);

        return listado;
    }

    public Odontologo buscar(int id){
        //hace un llamado a la base de datos y busca por id, por ahora harcodeo
        Odontologo odontologoEncontrado = null;

        List<Odontologo> odontologosBD= listarOdontologos();
        for (Odontologo o : odontologosBD) {
            if(o.getId() == id){
                odontologoEncontrado = o;
            }
        }

        return odontologoEncontrado;

    }


}
