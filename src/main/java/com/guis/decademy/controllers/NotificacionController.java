package com.guis.decademy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guis.decademy.constants.ViewConstants;
import com.guis.decademy.entity.Usuario;

@Controller("notificacionController")
@RequestMapping("/notificaciones")
public class NotificacionController {

	@Autowired
	@Qualifier("usuarioActual")
	private Usuario usuarioActual;
	
	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("loginUsuario", usuarioActual);
		model.addAttribute("tipo", "A");
		return ViewConstants.NOTIFICACIONES;
	}
	
}
