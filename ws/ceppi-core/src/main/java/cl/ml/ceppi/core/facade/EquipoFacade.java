/**
 * 
 */
package cl.ml.ceppi.core.facade;

import java.util.List;

import cl.ml.ceppi.core.model.equipo.Equipo;

/**
 * @author Maldonado León
 * 
 */
public interface EquipoFacade 
{
	void save(Equipo equipo);

	void update(Equipo equipo);

	void delete(Equipo equipo);

	List<Equipo> listEquipos();

	Equipo findEquipoById(int id);

}
