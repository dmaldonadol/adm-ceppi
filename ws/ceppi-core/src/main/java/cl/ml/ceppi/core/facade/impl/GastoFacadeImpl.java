package cl.ml.ceppi.core.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.ml.ceppi.core.facade.GastoFacade;
import cl.ml.ceppi.core.model.gasto.Gasto;
import cl.ml.ceppi.core.service.GastoService;

/**
 * @author Maldonado León
 * 
 */
@Service("gastoFacade")
public class GastoFacadeImpl implements GastoFacade {
	@Autowired
	private GastoService service;

	@Transactional
	public void save(Gasto obj) {
		service.save(obj);
	}

	@Transactional
	public void update(Gasto obj) {
		service.update(obj);
	}

	@Transactional
	public void delete(Gasto obj) {
		service.delete(obj);
	}

	@Transactional
	public List<Gasto> listGastos() {
		return service.listGastos();
	}

	@Transactional
	public Gasto findGastoById(int id) {
		return service.findGastoById(id);
	}
	
}
