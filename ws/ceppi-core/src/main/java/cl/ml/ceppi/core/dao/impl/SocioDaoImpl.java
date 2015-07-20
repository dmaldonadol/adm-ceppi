package cl.ml.ceppi.core.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.ml.ceppi.core.dao.SocioDao;
import cl.ml.ceppi.core.model.socio.Socio;

/**
 * @author Maldonado León
 * 
 */
@Repository("SocioDao")
public class SocioDaoImpl implements SocioDao {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Socio socio) {
		getSession().persist(socio);
	}

	@Override
	public void update(Socio socio) {
		getSession().update(socio);
	}

	@Override
	public void delete(Socio socio) {
		getSession().delete(socio);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Socio> listSocio() {
		return (List<Socio>) getSession().createQuery("from Socio").list();
	}

	@Override
	public Socio findSocioById(int id) {
		Criteria cr = getSession().createCriteria(Socio.class);
		cr.add(Restrictions.eq("oid", id));
		return (Socio) cr.list().get(0);
	}

}
