package cl.ml.ceppi.core.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.ml.ceppi.core.dao.GastoDao;
import cl.ml.ceppi.core.model.gasto.Gasto;

/**
 * @author Maldonado León
 * 
 */
@Repository("GastoDao")
public class GastoDaoImpl implements GastoDao {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Gasto obj) {
		getSession().persist(obj);
	}

	@Override
	public void update(Gasto obj) {
		getSession().update(obj);
	}

	@Override
	public void delete(Gasto obj) {
		getSession().delete(obj);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Gasto> listGastos() {
		return (List<Gasto>) getSession().createQuery("from Gasto").list();
	}

	@Override
	public Gasto findGastoById(int id) {
		Criteria cr = getSession().createCriteria(Gasto.class);
		cr.add(Restrictions.eq("oid", id));
		return (Gasto) cr.list().get(0);
	}

}
