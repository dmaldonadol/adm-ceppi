/**
 * 
 */
package cl.ml.ceppi.core.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.ml.ceppi.core.dao.TipoDao;
import cl.ml.ceppi.core.model.tipo.CategoriaSocio;
import cl.ml.ceppi.core.model.tipo.CentroCosto;
import cl.ml.ceppi.core.model.tipo.Profesion;
import cl.ml.ceppi.core.model.tipo.TipoGasto;
import cl.ml.ceppi.core.model.tipo.TipoSocio;

/**
 * @author Maldonado León
 *
 */
@Repository("TipoDao")
public class TipoDaoImpl implements TipoDao 
{
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(CategoriaSocio categoriaSocio) {
		getSession().persist(categoriaSocio);
	}

	@Override
	public void save(CentroCosto centroCosto) {
		getSession().persist(centroCosto);
	}

	@Override
	public void save(Profesion profesion) {
		getSession().persist(profesion);
	}

	@Override
	public void save(TipoGasto tipoGasto) {
		getSession().persist(tipoGasto);
	}

	@Override
	public void save(TipoSocio tipoSocio) {
		getSession().persist(tipoSocio);
	}

	@Override
	public void update(CategoriaSocio categoriaSocio) {
		getSession().update(categoriaSocio);
	}

	@Override
	public void update(CentroCosto centroCosto) {
		getSession().update(centroCosto);
	}

	@Override
	public void update(Profesion profesion) {
		getSession().update(profesion);
	}

	@Override
	public void update(TipoGasto tipoGasto) {
		getSession().update(tipoGasto);
	}

	@Override
	public void update(TipoSocio tipoSocio) {
		getSession().update(tipoSocio);
	}

	@Override
	public void delete(CategoriaSocio categoriaSocio) {
		getSession().delete(categoriaSocio);
	}

	@Override
	public void delete(CentroCosto centroCosto) {
		getSession().delete(centroCosto);
	}

	@Override
	public void delete(Profesion profesion) {
		getSession().delete(profesion);
	}

	@Override
	public void delete(TipoGasto tipoGasto) {
		getSession().delete(tipoGasto);
	}

	@Override
	public void delete(TipoSocio tipoSocio) {
		getSession().delete(tipoSocio);
	}

	@Override
	public List<CategoriaSocio> listCategoriaSocio() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CentroCosto> listCentroCosto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Profesion> listProfesion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoGasto> listTipoGasto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoSocio> listTipoSocio() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoriaSocio findCategoriaSocioById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CentroCosto findCentroCostoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Profesion findProfesionById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoGasto findTipoGastoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoSocio findTipoSocioById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
