package cl.ml.ceppi.core.facade;

import java.util.List;

import cl.ml.ceppi.core.model.socio.Socio;

/**
 * @author Maldonado León
 * 
 */
public interface SocioFacade 
{
	void save(Socio socio);

	void update(Socio socio);

	void delete(Socio socio);

	List<Socio> listSocio();

	Socio findSocioById(int id);
}
