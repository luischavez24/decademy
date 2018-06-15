package com.guis.decademy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guis.decademy.constants.ViewConstants;

@Controller
@RequestMapping("/administrar")
public class AdministrarController {
	@GetMapping("/malla/agregar")
	public String mallaAgregar () {
		return ViewConstants.ADMINISTRAR_MALLA_AGREGAR;
	}
}
