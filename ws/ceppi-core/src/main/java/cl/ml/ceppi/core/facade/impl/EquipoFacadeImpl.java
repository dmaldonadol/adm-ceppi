package cl.ml.ceppi.core.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.ml.ceppi.core.facade.EquipoFacade;
import cl.ml.ceppi.core.model.equipo.Equipo;
import cl.ml.ceppi.core.service.EquipoService;

/**
 * @author Maldonado León
 * 
 */
@Service("equipoFacade")
public class EquipoFacadeImpl implements EquipoFacade {
	@Autowired
	private EquipoService service;

	@Transactional
	public void save(Equipo equipo) {
		service.save(equipo);
	}

	@Transactional
	public void update(Equipo equipo) {
		service.update(equipo);
	}

	@Transactional
	public void delete(Equipo equipo) {
		service.delete(equipo);
	}

	@Transactional
	public List<Equipo> listEquipos() {
		return service.listEquipos();
	}

	@Transactional
	public Equipo findEquipoById(int id) {
		return service.findEquipoById(id);
	}
}
