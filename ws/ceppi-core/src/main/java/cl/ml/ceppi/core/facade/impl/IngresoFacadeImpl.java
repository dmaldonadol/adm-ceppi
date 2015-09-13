package cl.ml.ceppi.core.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.ml.ceppi.core.facade.IngresoFacade;
import cl.ml.ceppi.core.model.ingreso.Ingreso;
import cl.ml.ceppi.core.service.IngresoService;

/**
 * @author Maldonado León
 * 
 */
@Service("ingresoFacade")
public class IngresoFacadeImpl implements IngresoFacade {
	@Autowired
	private IngresoService service;

	@Transactional
	public void save(Ingreso obj) {
		service.save(obj);
	}

	@Transactional
	public void update(Ingreso obj) {
		service.update(obj);
	}

	@Transactional
	public void delete(Ingreso obj) {
		service.delete(obj);
	}

	@Transactional
	public List<Ingreso> listIngresos() {
		return service.listIngresos();
	}

	@Transactional
	public Ingreso findIngresoById(int id) {
		return service.findIngresoById(id);
	}
	
}
