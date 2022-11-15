package com.dh.clinicaOdontologica.services;

import com.dh.clinicaOdontologica.controllers.dominio.Paciente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PacienteService {
    public Paciente crearPaciente(Paciente paciente){
//por ahora es lo que recibe por parametro desde la api
        Paciente paciente1 = new Paciente(paciente.getId(), paciente.getNombre(), paciente.getApellido(), paciente.getDni(), paciente.getEmail(), paciente.getFechaAlta());
        return paciente1;
    }

    //Crear dos métodos en el servicio: uno que devuelva todos los pacientes y otro que devuelva el paciente según su email.
    public List<Paciente> listarPacientes(){
        List<Paciente> listado = new ArrayList<>();
        Paciente paciente1 = new Paciente(2,"Juan", "Lopez", 25963458,"jjlopez@mail.com",LocalDate.of(2022,5,14));
        Paciente paciente2 = new Paciente(3,"Maria", "Lopez", 29852457,"marialopez@mail.com",LocalDate.of(2022,5,14));
        listado.add(paciente1);
        listado.add(paciente2);

        return listado;
    }

    public Paciente buscar(String email){
        //hace un llamado a la base de datos y busca por email, por ahora harcodeo
        Paciente pacienteEncontrado = null;

        List<Paciente> pacientesBD= listarPacientes();
        for (Paciente paciente : pacientesBD) {
            if(paciente.getEmail().equals(email)){
                pacienteEncontrado = paciente;
            }
        }

        return pacienteEncontrado;

    }
}
