package com.dh.clinicaOdontologica.model;

import org.springframework.web.bind.annotation.CrossOrigin;

import java.sql.Time;
import java.time.LocalDate;
import javax.persistence.*;
@Entity
@Table(name = "turnos")

public class Turno {
    @Id
    @SequenceGenerator(name="turno_id",sequenceName="turno_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="turno_id")
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="paciente_id", nullable = false)
    private Paciente paciente;
    @ManyToOne(fetch = FetchType.EAGER)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", paciente=" + paciente +
                ", odontologo=" + odontologo +
                ", fecha=" + fecha +
                ", hora='" + hora + '\'' +
                '}';
    }
}
