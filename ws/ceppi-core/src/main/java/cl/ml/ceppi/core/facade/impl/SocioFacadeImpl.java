package cl.ml.ceppi.core.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.ml.ceppi.core.facade.SocioFacade;
import cl.ml.ceppi.core.model.socio.Socio;
import cl.ml.ceppi.core.service.SocioService;

/**
 * @author Maldonado León
 * 
 */
@Service("socioFacade")
public class SocioFacadeImpl implements SocioFacade {
	@Autowired
	private SocioService socioService;

	@Transactional
	public void save(Socio socio) {
		socioService.save(socio);
	}

	@Transactional
	public void update(Socio socio) {
		socioService.update(socio);
	}

	@Transactional
	public void delete(Socio socio) {
		socioService.delete(socio);
	}

	@Transactional
	public List<Socio> listSocio() {
		return socioService.listSocio();
	}

	@Transactional
	public Socio findSocioById(int id) {
		return socioService.findSocioById(id);
	}

}
