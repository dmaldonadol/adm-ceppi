package cl.ml.ceppi.core.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.ml.ceppi.core.dao.EquipoDao;
import cl.ml.ceppi.core.model.equipo.Equipo;

/**
 * @author Maldonado León
 * 
 */
@Repository("EquipoDao")
public class EquipoDaoImpl implements EquipoDao {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Equipo equipo) {
		getSession().persist(equipo);
	}

	@Override
	public void update(Equipo equipo) {
		getSession().update(equipo);
	}

	@Override
	public void delete(Equipo equipo) {
		getSession().delete(equipo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Equipo> listEquipos() {
		return (List<Equipo>) getSession().createQuery("from Equipo").list();
	}

	@Override
	public Equipo findEquipoById(int id) {
		Criteria cr = getSession().createCriteria(Equipo.class);
		cr.add(Restrictions.eq("oid", id));
		return (Equipo) cr.list().get(0);
	}

}
