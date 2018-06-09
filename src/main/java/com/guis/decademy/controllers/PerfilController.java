package com.guis.decademy.controllers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guis.decademy.constants.ViewNames;
import com.guis.decademy.entity.Curso;
import com.guis.decademy.entity.Horario;
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
		
		LOG.info("[cursos]: Página devuelta => '/perfil/cursos'");
		
		return ViewNames.PERFIL_CURSOS;
	}
	
	@GetMapping("/cursos/virtual")
	public String virtual() {
		LOG.info("[virtual]: Página devuelta => '/perfil/virtual'");
		return ViewNames.PERFIL_VIRTUAL;
	}
	
	@GetMapping("/findCursos")
	@ResponseBody
	public List<Curso> findCursos() {
		
		List<Curso> cursos = cursosService.findAll();
		
		LOG.info("[findCursos]: Response body => " + cursos);
		
		return cursos;
	}
	
	@GetMapping("/findHorarios")
	@ResponseBody
	public List<Horario> findHorarios() {
		
		List<Horario> horarios = cursosService.findHorarios();
		
		LOG.info("[findHorarios]: Response body => " + horarios);
		
		return horarios;
	}

	@PostMapping("/insertarCurso")
	@ResponseBody
	public String insertarCurso(@RequestBody Curso curso) {
		
		cursosService.insertCurso(curso);
		
		LOG.info("[insertarCurso]: Objeto insertado => " + curso);
		
		return "Inserción completa";
	}	
}
