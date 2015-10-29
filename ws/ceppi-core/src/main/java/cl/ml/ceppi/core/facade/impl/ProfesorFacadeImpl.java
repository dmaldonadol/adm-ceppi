package cl.ml.ceppi.core.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.ml.ceppi.core.facade.ProfesorFacade;
import cl.ml.ceppi.core.model.equipo.Profesor;
import cl.ml.ceppi.core.service.ProfesorService;

/**
 * @author Maldonado León
 * 
 */
@Service("profesorFacade")
public class ProfesorFacadeImpl implements ProfesorFacade {
	@Autowired
	private ProfesorService service;

	@Transactional
	public void save(Profesor obj) {
		service.save(obj);
	}

	@Transactional
	public void update(Profesor obj) {
		service.update(obj);
	}

	@Transactional
	public void delete(Profesor obj) {
		service.delete(obj);
	}

	@Transactional
	public List<Profesor> listProfesores() {
		return service.listProfesores();
	}

	@Transactional
	public Profesor findProfesorById(int id) {
		return service.findProfesorById(id);
	}

	@Transactional
	public Profesor findProfesorByRut(String rut) {
		return service.findProfesorByRut(rut);
	}
}
