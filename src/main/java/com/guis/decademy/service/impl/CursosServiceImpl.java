package com.guis.decademy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.guis.decademy.entity.Curso;
import com.guis.decademy.entity.Horario;
import com.guis.decademy.repository.CursosRepository;
import com.guis.decademy.service.CursosService;

@Service("cursosService")
public class CursosServiceImpl implements CursosService{

	@Autowired
	@Qualifier("cursosRepository")
	private CursosRepository cursosRepository;
	
	@Override
	public List<Curso> findAll() {
		return cursosRepository.findAll();
	}

	@Override
	public Curso insertCurso(Curso curso) {
		Curso nuevoCurso = cursosRepository.insert(curso);
		return nuevoCurso;
	}

	@Override
	public List<Horario> findHorarios() {
		
		return cursosRepository.findHorarios();
	}
}
