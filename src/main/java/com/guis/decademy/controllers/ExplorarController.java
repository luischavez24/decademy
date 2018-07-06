package com.guis.decademy.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guis.decademy.constants.ViewConstants;
import com.guis.decademy.entity.Usuario;

@Controller
@RequestMapping("/explorar")
public class ExplorarController {
	
	private static final Log LOG = LogFactory.getLog(ExplorarController.class);
	@Autowired
	@Qualifier("usuarioActual")
	private Usuario usuarioActual;
	
	@GetMapping("/cursos")
	public String cursos(Model model) {
		model.addAttribute("loginUsuario", usuarioActual);
		LOG.info("[cursos]: Pagina devuelta => /explorar/cursos");
		return ViewConstants.EXPLORAR_CURSOS;
	}
	
}
