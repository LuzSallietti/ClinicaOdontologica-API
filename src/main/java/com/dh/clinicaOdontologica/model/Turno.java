package com.dh.clinicaOdontologica.model;

import java.sql.Time;
import java.time.LocalDate;
import javax.persistence.*;
@Entity
@Table(name = "turnos")

public class Turno {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name="paciente_id", nullable = false)
    private Paciente paciente;
    @ManyToOne
    @JoinColumn(name="odontologo_id", nullable = false)
    private Odontologo odontologo;
    private LocalDate fecha;
    //hora va a ser un String?
    private String hora;

    public Turno(){

    }
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
