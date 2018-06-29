package com.guis.decademy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guis.decademy.constants.ViewConstants;

@Controller
@RequestMapping("/retos")
public class RetosController {

	
	@GetMapping("/{idCurso}/{idTema}")
	public String detalle(@PathVariable("idCurso") String curso,
			@PathVariable("idTema") String idTema) {
		return ViewConstants.RETOS_DETALLE;
	}
}
