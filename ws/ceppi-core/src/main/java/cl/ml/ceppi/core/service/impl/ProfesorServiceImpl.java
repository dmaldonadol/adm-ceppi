/**
 * 
 */
package cl.ml.ceppi.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.ml.ceppi.core.dao.ProfesorDao;
import cl.ml.ceppi.core.model.equipo.Profesor;
import cl.ml.ceppi.core.service.ProfesorService;

/**
 * @author Maldonado León
 * 
 */
@Service("profesorService")
public class ProfesorServiceImpl implements ProfesorService 
{
	@Autowired
	private ProfesorDao dao;

	@Transactional
	public void save(Profesor obj) {
		dao.save(obj);
	}

	@Transactional
	public void update(Profesor obj) {
		dao.update(obj);
	}

	@Transactional
	public void delete(Profesor obj) {
		dao.delete(obj);
	}

	@Transactional
	public List<Profesor> listProfesores() {
		return dao.listProfesores();
	}

	@Transactional
	public Profesor findProfesorById(int id) {
		return dao.findProfesorById(id);
	}

	@Transactional
	public Profesor findProfesorByRut(String rut) {
		return dao.findProfesorByRut(rut);
	}

}
