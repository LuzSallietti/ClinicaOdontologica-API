package com.dh.clinicaOdontologica.model;

public class Odontologo {
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer matricula;

    public Odontologo(Integer id, String nombre, String apellido, Integer matricula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }
    public Odontologo(){

    }

    //no es buena practica tener este getId pero lo uso de manera temporal
    public Integer getId() {
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
