package com.guis.decademy.controllers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guis.decademy.constants.ViewConstants;
import com.guis.decademy.entity.Curso;
import com.guis.decademy.entity.Profesor;
import com.guis.decademy.entity.Usuario;

@Controller
@RequestMapping("/explorar")
public class ExplorarController {
	
	private static final Log LOG = LogFactory.getLog(ExplorarController.class);
	@Autowired
	@Qualifier("usuarioActual")
	private Usuario usuarioActual;
	
	@Autowired
	@Qualifier("cursos")
	private List<Curso> cursos;
	
	
	@GetMapping("/cursos")
	public String cursos(Model model) {
		model.addAttribute("loginUsuario", usuarioActual);
		model.addAttribute("cursos", cursos);
		LOG.info("[cursos]: Pagina devuelta => /explorar/cursos");
		return ViewConstants.EXPLORAR_CURSOS;
	}
	
	@GetMapping("/profesores/{idCurso}")
	public String profesores(Model model, @PathVariable("idCurso") String idCurso) {
		
		Curso curso = cursos.stream()
				.filter(c -> c.getIdCurso().equals(idCurso))
				.findFirst().get();
		
		model.addAttribute("loginUsuario", usuarioActual);
		model.addAttribute("idCurso", idCurso);
		model.addAttribute("curso", curso);
		
		LOG.info("[cursos]: Pagina devuelta => /explorar/cursos");
		return ViewConstants.EXPLORAR_PROFESORES;
	}
	
	@GetMapping("/horario/{idCurso}/{idProfesor}")
	public String horario(Model model,
			@PathVariable("idCurso") String idCurso,
			@PathVariable("idProfesor") String idProfesor) {
		
		Curso curso = cursos.stream()
				.filter(c -> c.getIdCurso().equals(idCurso))
				.findFirst().get();
		Profesor profesor = curso.getProfesores().stream()
				.filter(p -> p.getUsername().equals(idProfesor))
				.findFirst().get();
		
		model.addAttribute("curso", curso);
		model.addAttribute("profesor", String.format("%s %s", profesor.getNombres(), profesor.getApellidos()));
		model.addAttribute("loginUsuario", usuarioActual);
		LOG.info("[cursos]: Pagina devuelta => /explorar/cursos");
		return ViewConstants.EXPLORAR_HORARIO;
	}
	
}
