package cl.ml.ceppi.core.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.ml.ceppi.core.dao.JugadorDao;
import cl.ml.ceppi.core.model.equipo.Jugador;

/**
 * @author Maldonado León
 * 
 */
@Repository("JugadorDao")
public class JugadorDaoImpl implements JugadorDao 
{
	
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Jugador obj) {
		getSession().persist(obj);
	}

	@Override
	public void update(Jugador obj) {
		getSession().update(obj);
	}

	@Override
	public void delete(Jugador obj) {
		getSession().delete(obj);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Jugador> listJugadores() {
		List<Jugador> jugadores = (List<Jugador>) getSession().createQuery("from Jugador").list();
		for( Jugador jugador : jugadores )
		{
			Hibernate.initialize(jugador.getSkillJugador() );
		}
		return jugadores;
	}

	@Override
	public Jugador findJugadorById(int id) {
		Criteria cr = getSession().createCriteria(Jugador.class);
		cr.add(Restrictions.eq("oid", id));
		Jugador jg = (Jugador) cr.list().get(0);
		if(null != jg)
		{
			Hibernate.initialize( jg.getSkillJugador() );
		}
		return (Jugador) cr.list().get(0);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Jugador> listJugadoresHastaAnio(String anio)
	{
		Criteria cr = getSession().createCriteria(Jugador.class);
		cr.createAlias("persona.fechaNacimiento", "fechaNacimiento");
		cr.add(Restrictions.le("extract(year from fechaNacimiento)", anio));
//		DetachedCriteria criteria = DetachedCriteria.forClass(Jugador.class);
//		criteria.add(Restrictions.le("persona.fechaNacimiento", anio));
		return (List<Jugador>)cr.list();
	}

	@Override
	public Jugador findJugadorByRut(String rut) 
	{
		Criteria cr = getSession().createCriteria(Jugador.class);
		cr.createAlias("persona.rut", "rut");
		cr.add(Restrictions.eq("rut", rut));
		Jugador jugador =  cr.list().isEmpty() ? (Jugador)cr.list().get(0) : null;
		return jugador;
	}

}
