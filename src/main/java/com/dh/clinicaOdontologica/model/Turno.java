package com.dh.clinicaOdontologica.model;

import java.sql.Time;
import java.time.LocalDate;

public class Turno {
    Paciente paciente;
    Odontologo odontologo;
    LocalDate fecha;
    //hora va a ser un String?
    String hora;

    public Turno(Paciente paciente, Odontologo odontologo, LocalDate fecha, String hora) {
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
