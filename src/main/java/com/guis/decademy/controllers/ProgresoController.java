package com.guis.decademy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guis.decademy.constants.ViewConstants;
import com.guis.decademy.entity.Usuario;

@Controller
@RequestMapping("/progreso")
public class ProgresoController {
	@Autowired
	@Qualifier("usuarioActual")
	private Usuario usuarioActual;
	@GetMapping("/consulta/{idAlumno}")
	public String consulta(Model model, @PathVariable("idAlumno") String idAlumno) {
		model.addAttribute("loginUsuario", usuarioActual);
		return ViewConstants.PROGRESO_CONSULTA;
	}
	@GetMapping("/alumno/{idAlumno}")
	public String alumno(Model model, @PathVariable("idAlumno") String idAlumno) {
		model.addAttribute("loginUsuario", usuarioActual);
		return ViewConstants.PROGRESO_ALUMNO;
	}
}
