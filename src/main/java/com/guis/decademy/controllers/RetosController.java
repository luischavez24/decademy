package com.guis.decademy.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guis.decademy.constants.ViewConstants;
import com.guis.decademy.entity.Alumno;
import com.guis.decademy.entity.Pregunta;
import com.guis.decademy.entity.ResultadoExamen;
import com.guis.decademy.entity.Usuario;

@Controller
@RequestMapping("/retos")
public class RetosController {

	@Autowired
	@Qualifier("usuarioActual")
	private Usuario usuarioActual;
	
	private static final Log LOG = LogFactory.getLog(RetosController.class);
	private List<Pregunta> preguntas;
	
	@Autowired
	@Qualifier("usuarios")
	private List<Usuario> usuarios;
	
	public RetosController() {
		cargaDePreguntas();
	}
	
	private void cargaDePreguntas() {
		Pregunta p1 = new Pregunta();
		p1.setPregunta("Cuando un algoritmo se está ejecutando y la cantidad de datos de entrada varia se pueden tener varios efectos en su eficiencia. Estos efectos pueden ser:");
		p1.addOpcion("Aumento del tiempo de ejecución en forma lineal");
		p1.addOpcion("Aumento del tiempo de ejecución en forma polinómica");
		p1.addOpcion("Aumento del tiempo de ejecución en forma exponencial");
		p1.addOpcion("Todas las anteriores");
		p1.setRespuesta(3);
		
		Pregunta p2 = new Pregunta();
		p2.setPregunta("Cuando un algoritmo aumenta su su tiempo de ejecución con respecto a su cantidad de datos de forma exponecial se dice que puede entrar en la clase:");
		p2.addOpcion("Clase P");
		p2.addOpcion("Clase NP");
		p2.addOpcion("Clase P/NP");
		p2.addOpcion("Ninguna de las anteriores");
		p2.setRespuesta(1);
		
		Pregunta p3 = new Pregunta();
		p3.setPregunta("Un problema el cual tiene una solución en un tiempo razonable de ejecución pertence a la clase:");
		p3.addOpcion("Clase P");
		p3.addOpcion("Clase NP");
		p3.addOpcion("Clase P/NP");
		p3.addOpcion("Ninguna de las anteriores");
		p3.setRespuesta(0);
		
		preguntas = new ArrayList<>();
		preguntas.add(p1);
		preguntas.add(p2);
		preguntas.add(p3);
	}
	
	@GetMapping("/{idCurso}/{idTema}")
	public String detalle(@CookieValue("username") String username,
			Model model,
			@PathVariable("idCurso") String idCurso,
			@PathVariable("idTema") int idTema) {
		model.addAttribute("loginUsuario", usuarioActual);
		Optional<Alumno> alumno = usuarios.stream()
				.filter(u -> {
					if(u instanceof Alumno) {
						Alumno a = (Alumno) u ;
						return a.getUsername().equals(username);
					} else {
						return false;
					}
				})
				.map(u -> (Alumno) u)
				.findFirst();
		
		// TODO: Implementar agente inteligente, saque el promedio de un curso y de acuerdo a ese promedio que te mande a realizar de nuevo el reto del tema con menor nota
		// TODO: Mostrar el agente inteligente
		// TODO: Mostrar las calificaciones por tema (al ultimo)
		
		List<ResultadoExamen> resultadosAnteriores = alumno.get().getResultados().stream()
				.filter(r -> r.getIdCurso().equals(idCurso) && r.getIdTema() == idTema)
				.sorted((r1, r2) -> r1.getFechaExamen().compareTo(r2.getFechaExamen()))
				.limit(5)
				.collect(Collectors.toList());

		ResultadoExamen resultado = new ResultadoExamen();
		
		Collections.shuffle(preguntas);
		
		resultado.setIdCurso(idCurso);
		resultado.setIdTema(idTema);
		model.addAttribute("resultado", resultado);
		model.addAttribute("preguntas", preguntas.stream().limit(3).collect(Collectors.toList()));
		model.addAttribute("idCurso", idCurso);
		model.addAttribute("resultadosAnteriores", resultadosAnteriores);
		
		LOG.info(preguntas);
		return ViewConstants.RETOS_DETALLE;
	}
	
	@PostMapping("/guardarResultado")
	public String guardarResultado(
			@CookieValue("username") String username, 
			@ModelAttribute("resultado") ResultadoExamen resultado) {
		
		resultado.setFechaExamen(LocalDate.now());
		Optional<Alumno> alumno = usuarios.stream()
				.filter(u -> {
					if(u instanceof Alumno) {
						Alumno a = (Alumno) u ;
						return a.getUsername().equals(username);
					} else {
						return false;
					}
				})
				.map(u -> (Alumno) u)
				.findFirst();
		if(alumno.isPresent()) {
			alumno.get().addResultado(resultado);
		}
		
		LOG.info(resultado);
		
		return String.format("redirect:/cursos/%s", resultado.getIdCurso());
	}
}
