/**
 * 
 */
package cl.ml.ceppi.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.ml.ceppi.core.dao.SocioDao;
import cl.ml.ceppi.core.model.socio.Socio;
import cl.ml.ceppi.core.service.SocioService;

/**
 * @author Maldonado León
 * 
 */
@Service("socioService")
public class SocioServiceImpl implements SocioService 
{
	@Autowired
	private SocioDao socioDao;

	@Transactional
	public void save(Socio socio) {
		socioDao.save(socio);
	}

	@Transactional
	public void update(Socio socio) {
		socioDao.update(socio);
	}

	@Transactional
	public void delete(Socio socio) {
		socioDao.delete(socio);
	}

	@Transactional
	public List<Socio> listSocio() {
		return socioDao.listSocio();
	}

	@Transactional
	public Socio findSocioById(int id) {
		return socioDao.findSocioById(id);
	}

}
