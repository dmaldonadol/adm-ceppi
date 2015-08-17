/**
 * 
 */
package cl.ml.ceppi.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.ml.ceppi.core.dao.CuotaDao;
import cl.ml.ceppi.core.model.cuota.Cuota;
import cl.ml.ceppi.core.model.cuota.RegistroCuota;
import cl.ml.ceppi.core.model.cuota.ValorCuota;
import cl.ml.ceppi.core.service.CuotaService;

/**
 * @author Maldonado León
 * 
 */
@Service("cuotaDao")
public class CuotaServiceImpl implements CuotaService {
	@Autowired
	private CuotaDao cuotaDao;

	@Transactional
	public void save(Cuota cuota) {
		cuotaDao.save(cuota);
	}

	@Transactional
	public void save(ValorCuota valorCuota) {
		cuotaDao.save(valorCuota);		
	}

	@Transactional
	public void save(RegistroCuota registroCuota) {
		cuotaDao.save(registroCuota);		
	}

	@Transactional
	public void update(Cuota cuota) {
		cuotaDao.update(cuota);		
	}

	@Transactional
	public void update(ValorCuota valorCuota) {
		cuotaDao.update(valorCuota);		
	}

	@Transactional
	public void update(RegistroCuota registroCuota) {
		cuotaDao.update(registroCuota);		
	}

	@Transactional
	public void delete(Cuota cuota) {
		cuotaDao.delete(cuota);		
	}

	@Transactional
	public void delete(ValorCuota valorCuota) {
		cuotaDao.delete(valorCuota);		
	}

	@Transactional
	public void delete(RegistroCuota registroCuota) {
		cuotaDao.delete(registroCuota);		
	}

	@Transactional
	public List<Cuota> listaCuotas() {
		return cuotaDao.listaCuotas();
	}

	@Transactional
	public List<ValorCuota> listaValorCuotas() {
		return cuotaDao.listaValorCuotas();
	}

	@Transactional
	public List<RegistroCuota> listaRegistroCuotas() {
		return cuotaDao.listaRegistroCuotas();
	}

	@Transactional
	public Cuota findCuotaById(int id) {
		return cuotaDao.findCuotaById(id);
	}

	@Transactional
	public ValorCuota findValorCuotaById(int id) {
		return cuotaDao.findValorCuotaById(id);
	}

	@Transactional
	public RegistroCuota findRegistroCuotaById(int id) {
		return cuotaDao.findRegistroCuotaById(id);
	}

}
