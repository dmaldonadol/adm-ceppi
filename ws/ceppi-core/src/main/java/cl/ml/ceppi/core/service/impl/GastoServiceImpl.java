/**
 * 
 */
package cl.ml.ceppi.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.ml.ceppi.core.dao.GastoDao;
import cl.ml.ceppi.core.model.gasto.Gasto;
import cl.ml.ceppi.core.service.GastoService;

/**
 * @author Maldonado León
 * 
 */
@Service("gastoService")
public class GastoServiceImpl implements GastoService 
{
	@Autowired
	private GastoDao dao;

	@Transactional
	public void save(Gasto obj) {
		dao.save(obj);
	}

	@Transactional
	public void update(Gasto obj) {
		dao.update(obj);
	}

	@Transactional
	public void delete(Gasto obj) {
		dao.delete(obj);
	}

	@Transactional
	public List<Gasto> listGastos() {
		return dao.listGastos();
	}

	@Transactional
	public Gasto findGastoById(int id) {
		return dao.findGastoById(id);
	}
	

}
