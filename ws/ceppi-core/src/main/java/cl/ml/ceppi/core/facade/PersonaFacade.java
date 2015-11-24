/**
 * 
 */
package cl.ml.ceppi.core.facade;

import java.util.List;

import cl.ml.ceppi.core.model.persona.Persona;

/**
 * @author Maldonado León
 * 
 */
public interface PersonaFacade 
{
	Persona save(Persona persona);
	Persona saveDos(Persona persona);

	void update(Persona persona);

	void delete(Persona persona);

	List<Persona> listPersonas();

	Persona findPersonaById(int id);
	
	Persona findPersonaByRut(String rut);
	
}
