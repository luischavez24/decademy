package com.guis.decademy.controllers;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guis.decademy.constants.ViewConstants;

@Controller
@RequestMapping("/cursos")
public class CursosController {
	
	private static final Log LOG  = LogFactory.getLog(CursosController.class);
		
	private Map<String, String> cursos = new HashMap<>();
	public CursosController() {
		cursos.put("ia", "Inteligencia Artificial");
		cursos.put("algo3", "Algoritmica 3");
		cursos.put("so", "Sistemas Operativos");
		cursos.put("bd3", "Bases de Datos 3");
	}
	@GetMapping("")
	public String index () {
		LOG.info("[/cursos] - METHOD [index] -- Entrando al método ");
		return ViewConstants.CURSOS_INDEX;
	}
	
	@GetMapping("/{idCurso}")
	public String detalle (Model model, @PathVariable("idCurso") String idCurso) {
		
		LOG.info("[/cursos] - METHOD [detalle] -- Entrando al método ");
		LOG.info("[/cursos] - METHOD [detalle] -- idCurso" +  idCurso);
		
		model.addAttribute("curso", cursos.get(idCurso));
		return ViewConstants.CURSOS_DETALLE;
	}
	
	@GetMapping("/{idCurso}/horario")
	public String horario (@PathVariable("idCurso") String idCurso) {
		return ViewConstants.CURSOS_HORARIO;
	}
	
	@GetMapping("/{idCurso}/temario")
	public String temario (@PathVariable("idCurso") String idCurso) {
		return ViewConstants.CURSOS_TEMARIO;
	}
	
	@GetMapping("/{idCurso}/temario/{idTema}")
	public String temarioDetalle (@PathVariable("idCurso") String idCurso, 
			@PathVariable("idTema") String idTema) {
		return ViewConstants.CURSOS_TEMARIO_DETALLE;
	}
	
	@GetMapping("/{idCurso}/temario/{idTema}/iniciar")
	public String temarioIniciar (@PathVariable("idCurso") String idCurso, 
			@PathVariable("idTema") String idTema) {
		return ViewConstants.CURSOS_TEMARIO_DETALLE;
	}
	
	@GetMapping("/{idCurso}/informacion")
	public String informacion (@PathVariable("idCurso") String idCurso) {
		return ViewConstants.CURSOS_INFORMACION;
	}
	
	@GetMapping("/{idCurso}/publicaciones")
	public String publicaciones (@PathVariable("idCurso") String idCurso) {
		return ViewConstants.CURSOS_PUBLICACIONES;
	}
	
	@GetMapping("/administrar")
	public String administrar () {
		return ViewConstants.CURSOS_ADMINISTRAR;
	}
	
	@GetMapping("/{idCurso}/alumnos")
	public String alumnos (@PathVariable("idCurso") String idCurso) {
		return ViewConstants.CURSOS_PUBLICACIONES;
	}
 }
