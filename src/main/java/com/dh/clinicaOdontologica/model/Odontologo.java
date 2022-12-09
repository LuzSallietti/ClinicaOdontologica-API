package com.dh.clinicaOdontologica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "odontologos")
public class Odontologo {
    @Id
    @SequenceGenerator(name="odontologo_id",sequenceName="odontologo_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="odontologo_id")
    private Long id;
    private String nombre;
    private String apellido;
    private Integer matricula;
    // el odontologo tiene un Set de Turnos en relacion bidireccional?
    @OneToMany(mappedBy = "odontologo")
    @JsonIgnore
    private Set <Turno> turnos;

    public Odontologo(Long id, String nombre, String apellido, Integer matricula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }
    public Odontologo(){

    }

    //no es buena practica tener este getId pero lo uso de manera temporal
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    //no uso los setters por ahora, pero se usaran para realizar modificaciones de los registros
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Set<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
    }

    @Override
    public String toString() {
        return "Odontologo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", matricula=" + matricula +
                '}';
    }
}
