/**
 * 
 */
package cl.ml.ceppi.core.facade;

import java.util.List;

import cl.ml.ceppi.core.model.tipo.CategoriaSocio;
import cl.ml.ceppi.core.model.tipo.CentroCosto;
import cl.ml.ceppi.core.model.tipo.Profesion;
import cl.ml.ceppi.core.model.tipo.TipoGasto;
import cl.ml.ceppi.core.model.tipo.TipoIngreso;
import cl.ml.ceppi.core.model.tipo.TipoProfesor;
import cl.ml.ceppi.core.model.tipo.TipoSocio;

/**
 * @author Maldonado León
 *
 */
public interface TipoFacade 
{
	void save(CategoriaSocio categoriaSocio);
	void save(CentroCosto centroCosto);
	void save(Profesion profesion);
	void save(TipoGasto tipoGasto);
	void save(TipoSocio tipoSocio);
	void save(TipoIngreso tipoIngreso);
	
	void update(CategoriaSocio categoriaSocio);
	void update(CentroCosto centroCosto);
	void update(Profesion profesion);
	void update(TipoGasto tipoGasto);
	void update(TipoSocio tipoSocio);
	void update(TipoIngreso tipoIngreso);
	
	void delete(CategoriaSocio categoriaSocio);
	void delete(CentroCosto centroCosto);
	void delete(Profesion profesion);
	void delete(TipoGasto tipoGasto);
	void delete(TipoSocio tipoSocio);
	void delete(TipoIngreso tipoIngreso);
	
	List<CategoriaSocio> listCategoriaSocio();
	List<CentroCosto> listCentroCosto();
	List<Profesion> listProfesion();
	List<TipoGasto> listTipoGasto();
	List<TipoSocio> listTipoSocio();
	List<TipoIngreso> listTipoIngreso();
	
	CategoriaSocio findCategoriaSocioById(int id);
	CentroCosto findCentroCostoById(int id);
	Profesion findProfesionById(int id);
	TipoGasto findTipoGastoById(int id);
	TipoSocio findTipoSocioById(int id);
	TipoIngreso findTipoIngresoById(int id);
	List<TipoProfesor> listTipoProfesor();
	void save(TipoProfesor obj);
	void update(TipoProfesor obj);
	void delete(TipoProfesor obj);
}
