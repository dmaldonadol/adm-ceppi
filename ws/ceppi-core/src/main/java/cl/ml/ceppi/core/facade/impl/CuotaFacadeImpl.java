package cl.ml.ceppi.core.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.ml.ceppi.core.facade.CuotaFacade;
import cl.ml.ceppi.core.model.cuota.Cuota;
import cl.ml.ceppi.core.model.cuota.RegistroCuota;
import cl.ml.ceppi.core.model.cuota.ValorCuota;
import cl.ml.ceppi.core.service.CuotaService;

/**
 * @author Maldonado León
 *
 */
@Service("cuotaFacade")
public class CuotaFacadeImpl implements CuotaFacade 
{
	@Autowired
	private CuotaService cuotaService;

	@Transactional
	public void save(Cuota cuota) {
		cuotaService.save(cuota);
	}

	@Transactional
	public void save(ValorCuota valorCuota) {
		cuotaService.save(valorCuota);		
	}

	@Transactional
	public void save(RegistroCuota registroCuota) {
		cuotaService.save(registroCuota);		
	}

	@Transactional
	public void update(Cuota cuota) {
		cuotaService.update(cuota);		
	}

	@Transactional
	public void update(ValorCuota valorCuota) {
		cuotaService.update(valorCuota);		
	}

	@Transactional
	public void update(RegistroCuota registroCuota) {
		cuotaService.update(registroCuota);		
	}

	@Transactional
	public void delete(Cuota cuota) {
		cuotaService.delete(cuota);		
	}

	@Transactional
	public void delete(ValorCuota valorCuota) {
		cuotaService.delete(valorCuota);		
	}

	@Transactional
	public void delete(RegistroCuota registroCuota) {
		cuotaService.delete(registroCuota);		
	}

	@Transactional
	public List<Cuota> listaCuotas() {
		return cuotaService.listaCuotas();
	}

	@Transactional
	public List<ValorCuota> listaValorCuotas() {
		return cuotaService.listaValorCuotas();
	}

	@Transactional
	public List<RegistroCuota> listaRegistroCuotas(int idsocio, int anio) {
		return cuotaService.listaRegistroCuotas(idsocio, anio);
	}

	@Transactional
	public Cuota findCuotaById(int id) {
		return cuotaService.findCuotaById(id);
	}

	@Transactional
	public ValorCuota findValorCuotaById(int id) {
		return cuotaService.findValorCuotaById(id);
	}

	@Transactional
	public RegistroCuota findRegistroCuotaById(int id) {
		return cuotaService.findRegistroCuotaById(id);
	}

	@Transactional
	public ValorCuota findValorCuota(ValorCuota obj) {
		return cuotaService.findValorCuota(obj);
	}

	@Transactional
	public RegistroCuota findRegistroCuota(String anio, String mes, int idsocio) {
		return cuotaService.findRegistroCuota(anio, mes, idsocio);
	}
}
