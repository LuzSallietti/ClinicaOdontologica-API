package com.dh.clinicaOdontologica.repository.impl;

import com.dh.clinicaOdontologica.model.Odontologo;
import com.dh.clinicaOdontologica.repository.IRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OdontologoRepository implements IRepository<Odontologo> {
    //por ahora estoy creando un repostorio/BD ficticio de odontologos como atributo
    private List<Odontologo> odontologos;

    public OdontologoRepository() {
        this.odontologos = cargarOdontologos();
    }

    @Override
    public Odontologo agregar(Odontologo odontologo) {
        //lo agrego a mi BD ficticia ¿sin validaciones?
        this.odontologos.add(odontologo);
        return odontologo;
    }

    @Override
    public List<Odontologo> listar() {
        //retorna la BD ficticia
        return odontologos;
    }

    @Override
    public Odontologo actualizar(Odontologo odontologo) {
        //implementacion ficticia --> no voy a eliminar y crear en la BD
        //no deberia recibir el id por parametro en vez del odontologo?
        //y que pasa si el id no existe?
        eliminar(odontologo.getId());
        agregar(odontologo);
        return odontologo;
    }

    @Override
    public Boolean eliminar(Integer id) {
        for (Odontologo odontologo : odontologos) {
            if (odontologo.getId() == id){
                odontologos.remove(odontologo);
                return true;
            }

        }
        return false;
    }

    @Override
    public Odontologo buscar(Integer id) {
        Odontologo odontologo = null;
        for (Odontologo o : odontologos) {
            if(o.getId() == id){
                odontologo = o;
            }
        }
        return odontologo;
    }

    private List<Odontologo> cargarOdontologos(){
        List<Odontologo> odontologossCargados = new ArrayList<>();
        Odontologo od1 = new Odontologo(1,"Lola","Lopez",2407);
        Odontologo od2 = new Odontologo(2,"Camila", "Suarez",7845);
        odontologossCargados.add(od1);
        odontologossCargados.add(od2);
        return odontologossCargados;
    }
}
