package cl.ml.ceppi.core.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.ml.ceppi.core.dao.PersonaDao;
import cl.ml.ceppi.core.model.persona.Persona;

/**
 * @author Maldonado León
 * 
 */
@Repository("PersonaDao")
public class PersonaDaoImpl implements PersonaDao {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Persona persona) {
		getSession().persist(persona);
	}

	@Override
	public void update(Persona persona) {
		getSession().update(persona);
	}

	@Override
	public void delete(Persona persona) {
		getSession().delete(persona);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> listPersonas() {
		return (List<Persona>) getSession().createQuery("from Persona").list();
	}

	@Override
	public Persona findPersonaById(int id) {
		Criteria cr = getSession().createCriteria(Persona.class);
		cr.add(Restrictions.eq("oid", id));
		return (Persona) cr.list().get(0);
	}
	
	@Override
	public Persona findPersonaByRut(String rut) {
		Criteria cr = getSession().createCriteria(Persona.class);
		cr.add(Restrictions.eq("rut", rut));
		if ( cr.list().size() > 0 )
		{
			return (Persona) cr.list().get(0);
		}
		else
		{
			return null;
		}
	}

}
