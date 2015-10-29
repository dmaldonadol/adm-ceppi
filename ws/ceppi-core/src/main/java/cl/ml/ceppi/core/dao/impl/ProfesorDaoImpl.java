package cl.ml.ceppi.core.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.ml.ceppi.core.dao.ProfesorDao;
import cl.ml.ceppi.core.model.equipo.Profesor;

/**
 * @author Maldonado León
 * 
 */
@Repository("ProfesorDao")
public class ProfesorDaoImpl implements ProfesorDao {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Profesor obj) {
		getSession().merge(obj);
	}

	@Override
	public void update(Profesor obj) {
		getSession().update(obj);
	}

	@Override
	public void delete(Profesor obj) {
		getSession().delete(obj);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Profesor> listProfesores() {
		return (List<Profesor>) getSession().createQuery("from Profesor").list();
	}

	@Override
	public Profesor findProfesorById(int id) {
		Criteria cr = getSession().createCriteria(Profesor.class);
		cr.add(Restrictions.eq("oid", id));
		return (Profesor) cr.list().get(0);
	}

	@Override
	public Profesor findProfesorByRut(String rut) {
		Criteria cr = getSession().createCriteria(Profesor.class);
		cr.createAlias("persona", "persona");
		cr.add(Restrictions.eq("persona.rut", rut));
		
		if ( cr.list().size() > 0 )
		{
			return (Profesor) cr.list().get(0);
		}
		else
		{
			return null;
		}
		
	}

}
