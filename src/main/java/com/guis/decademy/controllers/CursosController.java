package com.guis.decademy.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guis.decademy.constants.ViewConstants;
import com.guis.decademy.entity.Alumno;
import com.guis.decademy.entity.ResultadoExamen;
import com.guis.decademy.entity.Usuario;

@Controller
@RequestMapping("/cursos")
public class CursosController {
	
	@Autowired
	@Qualifier("usuarioActual")
	private Usuario usuarioActual;
	
	
	@Autowired
	@Qualifier("usuarios")
	private List<Usuario> usuarios;
	
	private static final Log LOG  = LogFactory.getLog(CursosController.class);
		
	private Map<String, String> cursos = new HashMap<>();
	public CursosController() {
		cursos.put("ia", "Inteligencia Artificial");
		cursos.put("algo3", "Algoritmica 3");
		cursos.put("so", "Sistemas Operativos");
		cursos.put("bd2", "Bases de Datos 2");
	}
	@GetMapping("")
	public String index (Model model) {
		LOG.info("[/cursos] - METHOD [index] -- Entrando al método ");
		model.addAttribute("loginUsuario", usuarioActual);
		return ViewConstants.CURSOS_INDEX;
	}
	
	@GetMapping("/{idCurso}")
	public String detalle (Model model, @PathVariable("idCurso") String idCurso) {
		
		LOG.info("[/cursos] - METHOD [detalle] -- Entrando al método ");
		LOG.info("[/cursos] - METHOD [detalle] -- idCurso" +  idCurso);
		
		Optional<Alumno> alumno = usuarios.stream()
				.filter(u -> {
					if(u instanceof Alumno) {
						Alumno a = (Alumno) u ;
						return a.getUsername().equals(usuarioActual.getUsername());
					} else {
						return false;
					}
				})
				.map(u -> (Alumno) u)
				.findFirst();
		double promedio = 0;
		Integer idTemaMinimo =  0;
		Double valMinimo = Double.MAX_VALUE;
		
		if(alumno.isPresent()) {
			// Agrupo los datos
			Map<Integer, List<ResultadoExamen>> resultadosAnteriores = alumno.get().getResultados().stream()
					.filter(r -> r.getIdCurso().equals(idCurso))
					.collect(Collectors.groupingBy(ResultadoExamen::getIdTema));
			
			
			// Genera un mapa clave valor con los valores de todas las pruebas de ese tema y le saca
			// el minimo
			for(Map.Entry<Integer, List<ResultadoExamen>> resultados : resultadosAnteriores.entrySet()) {
				
				promedio += resultados.getValue().stream()
							.map(r -> r.getPorcentajeBuenas() * 20)
							.max(Double::compareTo).get();
				
				Double val = resultados.getValue().stream()
							.map(r -> r.getPorcentajeBuenas() * 20)
							.min(Double::compareTo).get();
				
				if( val < valMinimo) {
					valMinimo = val;
					idTemaMinimo = resultados.getKey();
				}
			}
			
			promedio /= resultadosAnteriores.size();			
		} else {
			promedio = -1;
		}
		
		model.addAttribute("promedio", promedio);
		model.addAttribute("idTemaMinimo", idTemaMinimo);
		
		
		model.addAttribute("loginUsuario", usuarioActual);
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
