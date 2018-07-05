package com.guis.decademy.repository;
/*
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.guis.decademy.entity.Curso;

@Repository("cursosRepository")
public interface CursosRepository extends MongoRepository<Curso, String>{
	
}*/
/*
interface CursosRepositoryCustom {
	
	public List<Horario> findHorarios();
}

class CursosRepositoryCustomImpl implements CursosRepositoryCustom {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public List<Horario> findHorarios() {
		
		// Pipeline
		LookupOperation lookupCursos = Aggregation.lookup("cursos", "curso", "codigo", "curso");
		LookupOperation lookupTutor = Aggregation.lookup("tutores", "tutor", "codigo", "tutor");
		UnwindOperation unwindCursos = Aggregation.unwind("curso");
		UnwindOperation unwindTutor= Aggregation.unwind("tutor");
		
		// Creating a new aggregation
		Aggregation aggregation = Aggregation.newAggregation(lookupCursos, lookupTutor, unwindCursos,unwindTutor);
		AggregationResults<Horario> results = mongoTemplate.aggregate(aggregation, "horarios", Horario.class);
		return results.getMappedResults();
	}
	
}
*/