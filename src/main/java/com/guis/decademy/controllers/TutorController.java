package com.guis.decademy.controllers;


import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guis.decademy.constants.TipoUsuario;
import com.guis.decademy.constants.ViewConstants;
import com.guis.decademy.entity.Usuario;

@Controller("tutorController")
@RequestMapping("/tutoria")
public class TutorController {

	public static final Log LOG = LogFactory.getLog(TutorController.class);
	
	private Map<String, String> misCursos = new HashMap<>();
	
	@Autowired
	@Qualifier("usuarioActual")
	private Usuario usuarioActual;
	
	public TutorController() {
		misCursos.put("algo3", "Algoritmica 3");
		misCursos.put("bd3", "Base de Datos 3");
		misCursos.put("io", "Investigación Opertiva");
		misCursos.put("ia", "Inteligencia Artificial");
	}
	
	@GetMapping("")
	public String index(Model model) {
		LOG.info("[/tutoria] - METHOD [index] -- Entrando al método ");
		model.addAttribute("loginUsuario", usuarioActual);
		model.addAttribute("tipo", TipoUsuario.TIPO_TUTOR);
		return ViewConstants.PROFESOR_INDEX;
	}
	
	@GetMapping("/{idCurso}")
	public String cursoTutoria (Model model, @PathVariable("idCurso") String idCurso) {

		LOG.info("[/tutoria] - METHOD [detalle] -- Entrando al método ");
		LOG.info("[/cursos] - METHOD [detalle] -- idCurso" +  idCurso);
		
		model.addAttribute("curso", misCursos.get(idCurso));
		model.addAttribute("tipo", TipoUsuario.TIPO_TUTOR);
		model.addAttribute("loginUsuario", usuarioActual);
		
		return ViewConstants.CURSOS_ADMINISTRAR;
	}
	
}
