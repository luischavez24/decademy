package com.guis.decademy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guis.decademy.constants.ViewConstants;

@Controller
@RequestMapping("/progreso")
public class ProgresoController {
	
	@GetMapping("/consulta/{idAlumno}")
	public String consulta(@PathVariable("idAlumno") String idAlumno) {
		return ViewConstants.PROGRESO_CONSULTA;
	}
	@GetMapping("/alumno/{idAlumno}")
	public String alumno(@PathVariable("idAlumno") String idAlumno) {
		return ViewConstants.PROGRESO_ALUMNO;
	}
}
