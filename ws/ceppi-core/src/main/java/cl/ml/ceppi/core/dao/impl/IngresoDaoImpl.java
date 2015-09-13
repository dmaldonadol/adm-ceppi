package cl.ml.ceppi.core.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.ml.ceppi.core.dao.IngresoDao;
import cl.ml.ceppi.core.model.ingreso.Ingreso;

/**
 * @author Maldonado León
 * 
 */
@Repository("IngresoDao")
public class IngresoDaoImpl implements IngresoDao {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Ingreso obj) {
		getSession().persist(obj);
	}

	@Override
	public void update(Ingreso obj) {
		getSession().update(obj);
	}

	@Override
	public void delete(Ingreso obj) {
		getSession().delete(obj);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ingreso> listIngresos() {
		return (List<Ingreso>) getSession().createQuery("from Ingreso").list();
	}

	@Override
	public Ingreso findIngresoById(int id) {
		Criteria cr = getSession().createCriteria(Ingreso.class);
		cr.add(Restrictions.eq("oid", id));
		return (Ingreso) cr.list().get(0);
	}

}
