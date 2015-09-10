/**
 * 
 */
package cl.ml.ceppi.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.ml.ceppi.core.dao.EquipoDao;
import cl.ml.ceppi.core.model.equipo.Equipo;
import cl.ml.ceppi.core.service.EquipoService;

/**
 * @author Maldonado León
 * 
 */
@Service("equipoService")
public class EquipoServiceImpl implements EquipoService 
{
	@Autowired
	private EquipoDao dao;

	@Transactional
	public void save(Equipo equipo) {
		dao.save(equipo);
	}

	@Transactional
	public void update(Equipo equipo) {
		dao.update(equipo);
	}

	@Transactional
	public void delete(Equipo equipo) {
		dao.delete(equipo);
	}

	@Transactional
	public List<Equipo> listEquipos() {
		return dao.listEquipos();
	}

	@Transactional
	public Equipo findEquipoById(int id) {
		return dao.findEquipoById(id);
	}

}
