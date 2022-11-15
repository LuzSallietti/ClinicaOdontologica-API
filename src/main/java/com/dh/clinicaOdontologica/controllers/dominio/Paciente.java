package com.dh.clinicaOdontologica.controllers.dominio;

import java.time.LocalDate;
import java.util.Date;

public class Paciente {
    private int id;
    private String nombre;
    private String apellido;
    private int dni;
    private String email;
    private LocalDate fechaAlta;
    //falta el domicilio --> vendrá de la clase Domicilio
    //segun ejercicio de la clase integradora del 11/11, el paciente tambien tiene asignado un odontologo


    public Paciente(int id, String nombre, String apellido, int dni, String email, LocalDate fechaAlta) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.fechaAlta = fechaAlta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                ", email='" + email + '\'' +
                ", fechaAlta=" + fechaAlta +
                '}';
    }
}
