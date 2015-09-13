/**
 * 
 */
package cl.ml.ceppi.core.facade;

import java.util.List;

import cl.ml.ceppi.core.model.gasto.Gasto;

/**
 * @author Maldonado León
 * 
 */
public interface GastoFacade 
{
	void save(Gasto obj);

	void update(Gasto obj);

	void delete(Gasto obj);

	List<Gasto> listGastos();

	Gasto findGastoById(int id);
}
