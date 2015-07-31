/**
 * 
 */
package cl.ml.ceppi.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.ml.ceppi.core.dao.PersonaDao;
import cl.ml.ceppi.core.model.persona.Persona;
import cl.ml.ceppi.core.service.PersonaService;

/**
 * @author Maldonado León
 * 
 */
@Service("personaService")
public class PersonaServiceImpl implements PersonaService 
{
	@Autowired
	private PersonaDao personaDao;

	@Transactional
	public void save(Persona usuario) {
		personaDao.save(usuario);
	}

	@Transactional
	public void update(Persona usuario) {
		personaDao.update(usuario);
	}

	@Transactional
	public void delete(Persona usuario) {
		personaDao.delete(usuario);
	}

	@Transactional
	public List<Persona> listPersonas() {
		return personaDao.listPersonas();
	}

	@Transactional
	public Persona findPersonaById(int id) {
		return personaDao.findPersonaById(id);
	}
	
	@Transactional
	public Persona findPersonaByRut(String rut) {
		return personaDao.findPersonaByRut(rut);
	}

}
