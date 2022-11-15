package com.dh.clinicaOdontologica.controllers;

import com.dh.clinicaOdontologica.controllers.dominio.Odontologo;
import com.dh.clinicaOdontologica.controllers.dominio.Paciente;
import com.dh.clinicaOdontologica.services.OdontologoService;
import com.dh.clinicaOdontologica.services.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class HomeController {
    @GetMapping("/")
    //Model es clase propia de Spring
    public String welcome(Model model) {
        Paciente paciente = new PacienteService().crearPaciente(new Paciente(2, "Samu", "Perez",25897456,"lola@mail.com", LocalDate.of(2022,12,17)));
        Odontologo odontologo = new OdontologoService().buscar(2);

        model.addAttribute("nombre",paciente.getNombre());
        model.addAttribute("apellido", paciente.getApellido());
        model.addAttribute("matricula", odontologo.getMatricula());
        return "index";
    }
}
