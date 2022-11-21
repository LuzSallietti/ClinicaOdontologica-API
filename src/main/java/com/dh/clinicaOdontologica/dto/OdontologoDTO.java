package com.dh.clinicaOdontologica.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

//anotacion que nos sirve para indicarle a Jackson, que ignore el resto de atributos que tiene la entidad y que no están en el DTO.
@JsonIgnoreProperties(ignoreUnknown = true)

public class OdontologoDTO {
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer matricula;

    //Debemos tener 1 constructor vacio
    public OdontologoDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

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
}
