package cl.ml.ceppi.core.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.ml.ceppi.core.facade.PersonaFacade;
import cl.ml.ceppi.core.model.persona.Persona;
import cl.ml.ceppi.core.service.PersonaService;

/**
 * @author Maldonado León
 * 
 */
@Service("personaFacade")
public class PersonaFacadeImpl implements PersonaFacade 
{
	@Autowired
	private PersonaService personaService;

	@Transactional
	public void save(Persona persona) {
		personaService.save(persona);
	}

	@Transactional
	public void update(Persona persona) {
		personaService.update(persona);
	}

	@Transactional
	public void delete(Persona persona) {
		personaService.delete(persona);
	}

	@Transactional
	public List<Persona> listPersonas() {
		return personaService.listPersonas();
	}

	@Transactional
	public Persona findPersonaById(int id) {
		return personaService.findPersonaById(id);
	}
	
	@Transactional
	public Persona findPersonaByRut(String rut) {
		return personaService.findPersonaByRut(rut);
	}
	
}
