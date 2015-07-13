/**
 * 
 */
package cl.ml.ceppi.core.dao;

import java.util.List;

import cl.ml.ceppi.core.model.tipo.CategoriaSocio;
import cl.ml.ceppi.core.model.tipo.CentroCosto;
import cl.ml.ceppi.core.model.tipo.Profesion;
import cl.ml.ceppi.core.model.tipo.TipoGasto;
import cl.ml.ceppi.core.model.tipo.TipoSocio;

/**
 * @author Maldonado León
 *
 */
public interface TipoDao 
{
	void save(CategoriaSocio categoriaSocio);
	void save(CentroCosto centroCosto);
	void save(Profesion profesion);
	void save(TipoGasto tipoGasto);
	void save(TipoSocio tipoSocio);
	
	void update(CategoriaSocio categoriaSocio);
	void update(CentroCosto centroCosto);
	void update(Profesion profesion);
	void update(TipoGasto tipoGasto);
	void update(TipoSocio tipoSocio);
	
	void delete(CategoriaSocio categoriaSocio);
	void delete(CentroCosto centroCosto);
	void delete(Profesion profesion);
	void delete(TipoGasto tipoGasto);
	void delete(TipoSocio tipoSocio);
	
	List<CategoriaSocio> listCategoriaSocio();
	List<CentroCosto> listCentroCosto();
	List<Profesion> listProfesion();
	List<TipoGasto> listTipoGasto();
	List<TipoSocio> listTipoSocio();
	
	CategoriaSocio findCategoriaSocioById(int id);
	CentroCosto findCentroCostoById(int id);
	Profesion findProfesionById(int id);
	TipoGasto findTipoGastoById(int id);
	TipoSocio findTipoSocioById(int id);
}
