package cl.ml.ceppi.core.service;

import java.util.List;

import cl.ml.ceppi.core.model.ingreso.Ingreso;

/**
 * @author Maldonado León
 *
 */
public interface IngresoService 
{
	void save(Ingreso obj);

	void update(Ingreso obj);

	void delete(Ingreso obj);

	List<Ingreso> listIngresos();

	Ingreso findIngresoById(int id);
	
}
