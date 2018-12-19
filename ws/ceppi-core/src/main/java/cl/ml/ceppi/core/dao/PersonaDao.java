package cl.ml.ceppi.core.dao;

import java.util.List;

import cl.ml.ceppi.core.model.persona.Persona;

/**
 * @author Maldonado León
 *
 */
public interface PersonaDao 
{
	void save(Persona persona);

	void update(Persona persona);

	void delete(Persona persona);

	List<Persona> listPersonas();

	Persona findPersonaById(int id);
	
	Persona findPersonaByRut(String rut);
}
