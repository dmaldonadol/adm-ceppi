package cl.ml.ceppi.core.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.ml.ceppi.core.dao.TipoDao;
import cl.ml.ceppi.core.model.tipo.CategoriaSocio;
import cl.ml.ceppi.core.model.tipo.CentroCosto;
import cl.ml.ceppi.core.model.tipo.Profesion;
import cl.ml.ceppi.core.model.tipo.TipoGasto;
import cl.ml.ceppi.core.model.tipo.TipoIngreso;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<CategoriaSocio> listCategoriaSocio() {
		return (List<CategoriaSocio>) getSession().createQuery("from CategoriaSocio").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CentroCosto> listCentroCosto() {
		return (List<CentroCosto>) getSession().createQuery("from CentroCosto").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Profesion> listProfesion() {
		return (List<Profesion>) getSession().createQuery("from Profesion").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoGasto> listTipoGasto() {
		return (List<TipoGasto>) getSession().createQuery("from TipoGasto").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoSocio> listTipoSocio() {
		return (List<TipoSocio>) getSession().createQuery("from TipoSocio").list();
	}

	@Override
	public CategoriaSocio findCategoriaSocioById(int id) {
		Criteria cr = getSession().createCriteria(CategoriaSocio.class);
		cr.add(Restrictions.eq("oid", id));
		return (CategoriaSocio) cr.list().get(0);
	}

	@Override
	public CentroCosto findCentroCostoById(int id) {
		Criteria cr = getSession().createCriteria(CentroCosto.class);
		cr.add(Restrictions.eq("oid", id));
		return (CentroCosto) cr.list().get(0);
	}

	@Override
	public Profesion findProfesionById(int id) {
		Criteria cr = getSession().createCriteria(Profesion.class);
		cr.add(Restrictions.eq("oid", id));
		return (Profesion) cr.list().get(0);
	}

	@Override
	public TipoGasto findTipoGastoById(int id) {
		Criteria cr = getSession().createCriteria(TipoGasto.class);
		cr.add(Restrictions.eq("oid", id));
		return (TipoGasto) cr.list().get(0);
	}

	@Override
	public TipoSocio findTipoSocioById(int id) {
		Criteria cr = getSession().createCriteria(TipoSocio.class);
		cr.add(Restrictions.eq("oid", id));
		return (TipoSocio) cr.list().get(0);
	}

	@Override
	public void save(TipoIngreso tipoIngreso) {
		getSession().persist(tipoIngreso);
	}

	@Override
	public void update(TipoIngreso tipoIngreso) {
		getSession().update(tipoIngreso);
	}

	@Override
	public void delete(TipoIngreso tipoIngreso) {
		getSession().delete(tipoIngreso);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoIngreso> listTipoIngreso() {
		return (List<TipoIngreso>) getSession().createQuery("from TipoIngreso").list();
	}

	@Override
	public TipoIngreso findTipoIngresoById(int id) {
		Criteria cr = getSession().createCriteria(TipoIngreso.class);
		cr.add(Restrictions.eq("oid", id));
		return (TipoIngreso) cr.list().get(0);
	}

}
