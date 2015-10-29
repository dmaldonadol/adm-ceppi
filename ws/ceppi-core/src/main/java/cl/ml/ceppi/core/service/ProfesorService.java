package cl.ml.ceppi.core.service;

import java.util.List;

import cl.ml.ceppi.core.model.equipo.Profesor;

/**
 * @author Maldonado León
 *
 */
public interface ProfesorService 
{
	void save(Profesor obj);

	void update(Profesor obj);

	void delete(Profesor obj);

	List<Profesor> listProfesores();

	Profesor findProfesorById(int id);
	
	Profesor findProfesorByRut(String rut);
}
