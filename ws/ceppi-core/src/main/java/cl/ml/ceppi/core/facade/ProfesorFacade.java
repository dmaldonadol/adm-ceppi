/**
 * 
 */
package cl.ml.ceppi.core.facade;

import java.util.List;

import cl.ml.ceppi.core.model.equipo.Profesor;

/**
 * @author Maldonado León
 * 
 */
public interface ProfesorFacade 
{
	void save(Profesor obj );

	void update(Profesor obj );

	void delete(Profesor obj );

	List<Profesor> listProfesores();

	Profesor findProfesorById(int id);

	Profesor findProfesorByRut(String rut);

}
