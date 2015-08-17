package cl.ml.ceppi.core.service;

import java.util.List;

import cl.ml.ceppi.core.model.cuota.Cuota;
import cl.ml.ceppi.core.model.cuota.RegistroCuota;
import cl.ml.ceppi.core.model.cuota.ValorCuota;

/**
 * @author Maldonado León
 *
 */
public interface CuotaService 
{
	void save(Cuota cuota);
	void save(ValorCuota valorCuota);
	void save(RegistroCuota registroCuota);
	
	void update(Cuota cuota);
	void update(ValorCuota valorCuota);
	void update(RegistroCuota registroCuota);
	
	void delete(Cuota cuota);
	void delete(ValorCuota valorCuota);
	void delete(RegistroCuota registroCuota);
	
	List<Cuota> listaCuotas();
	List<ValorCuota> listaValorCuotas();
	List<RegistroCuota> listaRegistroCuotas();
		
	Cuota findCuotaById(int id);
	ValorCuota findValorCuotaById(int id);
	RegistroCuota findRegistroCuotaById(int id);
}
