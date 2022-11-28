package com.dh.clinicaOdontologica.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//anotacion que nos sirve para indicarle a Jackson, que ignore el resto de atributos que tiene la entidad y que no están en el DTO.
@JsonIgnoreProperties(ignoreUnknown = true)

public class DomicilioDTO {
    private Long id;
    private String calle;
    private int numero;
    private String localidad;
    private String provincia;

    //Debemos tener 1 constructor vacio
    public DomicilioDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
