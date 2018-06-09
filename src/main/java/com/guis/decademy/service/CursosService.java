package com.guis.decademy.service;

import java.util.List;

import com.guis.decademy.entity.Curso;
import com.guis.decademy.entity.Horario;
/**
 * 
 * @author lucho
 */
public interface CursosService {
	/**
	 * Permite listar todos los cursos que 
	 * exiten registrados en el sistema.
	 * @return Una lista del clase Curso
	 */
	public List<Curso> findAll();
	
	/**
	 * Permite insertar un nuevo curso al sistema
	 * @param curso
	 * El curso que se desea insertar
	 * @return El curso que se ha insertado
	 */
	public Curso insertCurso(Curso curso);
	
	/**
	 * 
	 * @return
	 */
	public List<Horario> findHorarios();
}
