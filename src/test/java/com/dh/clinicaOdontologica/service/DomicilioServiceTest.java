package com.dh.clinicaOdontologica.service;

import com.dh.clinicaOdontologica.dto.DomicilioDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DomicilioServiceTest {
    @Autowired
    private DomicilioService domicilioService;
    private static DomicilioDTO domicilioDTO;


@BeforeAll
  public static void crearData(){
    domicilioDTO = new DomicilioDTO();
    domicilioDTO.setCalle("Las Peras");
    domicilioDTO.setNumero(245);
    domicilioDTO.setLocalidad("Los Olivos");
    domicilioDTO.setProvincia("Bs As");

}
    @Test
    void crearDomicilio() {
    domicilioService.crearDomicilio(domicilioDTO);
        System.out.println(domicilioService.listarDomicilios());
    }
}