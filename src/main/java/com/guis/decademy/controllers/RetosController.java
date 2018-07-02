package com.guis.decademy.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guis.decademy.constants.ViewConstants;
import com.guis.decademy.entity.Pregunta;

@Controller
@RequestMapping("/retos")
public class RetosController {

	private static final Log LOG = LogFactory.getLog(RetosController.class);
	private List<Pregunta> preguntas;

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
	public String detalle(Model model,
			@PathVariable("idCurso") String idCurso,
			@PathVariable("idTema") String idTema) {
		
		model.addAttribute("preguntas", preguntas);
		model.addAttribute("idCurso", idCurso);
		LOG.info(preguntas);
		return ViewConstants.RETOS_DETALLE;
	}
}
