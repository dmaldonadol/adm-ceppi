package cl.ml.ceppi.core.service;

import java.util.List;

import cl.ml.ceppi.core.model.gasto.Gasto;

/**
 * @author Maldonado León
 *
 */
public interface GastoService 
{
	void save(Gasto obj);

	void update(Gasto obj);

	void delete(Gasto obj);

	List<Gasto> listGastos();

	Gasto findGastoById(int id);
	
}
