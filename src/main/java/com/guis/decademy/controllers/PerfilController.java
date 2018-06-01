package com.guis.decademy.controllers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guis.decademy.constants.ViewNames;
import com.guis.decademy.entity.Curso;
import com.guis.decademy.service.CursosService;

@Controller
@RequestMapping("/perfil")
public class PerfilController {
	
	private static final Log LOG = LogFactory.getLog(PerfilController.class);
	@Autowired
	@Qualifier("cursosService")
	private CursosService cursosService;
	
	@GetMapping("/cursos")
	public String cursos() {
		
		LOG.info("[Página devuelta]: '/perfil/cursos'");
		
		return ViewNames.PERFIL_CURSOS;
	}
	
	@GetMapping("/findCursos")
	@ResponseBody
	public List<Curso> findCursos() {
		
		List<Curso> cursos = cursosService.findAll();
		
		LOG.info("[findByNombreCurso] Response: " + cursos);
		
		return cursos;
	}
	
}
