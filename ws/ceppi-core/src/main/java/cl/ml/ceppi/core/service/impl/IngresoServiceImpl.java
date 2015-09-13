/**
 * 
 */
package cl.ml.ceppi.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.ml.ceppi.core.dao.IngresoDao;
import cl.ml.ceppi.core.model.ingreso.Ingreso;
import cl.ml.ceppi.core.service.IngresoService;

/**
 * @author Maldonado León
 * 
 */
@Service("ingresoService")
public class IngresoServiceImpl implements IngresoService 
{
	@Autowired
	private IngresoDao dao;

	@Transactional
	public void save(Ingreso obj) {
		dao.save(obj);
	}

	@Transactional
	public void update(Ingreso obj) {
		dao.update(obj);
	}

	@Transactional
	public void delete(Ingreso obj) {
		dao.delete(obj);
	}

	@Transactional
	public List<Ingreso> listIngresos() {
		return dao.listIngresos();
	}

	@Transactional
	public Ingreso findIngresoById(int id) {
		return dao.findIngresoById(id);
	}
	

}
