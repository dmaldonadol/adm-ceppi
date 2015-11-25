package cl.ml.ceppi.core.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.ml.ceppi.core.dao.EquipoDao;
import cl.ml.ceppi.core.model.equipo.Equipo;
import cl.ml.ceppi.core.model.equipo.Jugador;
import cl.ml.ceppi.core.model.equipo.Profesor;

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
	public List<Equipo> listEquipos() 
	{
		List<Equipo> equipos = (List<Equipo>) getSession().createQuery("from Equipo").list();
		if( null != equipos )
		{
			for( Equipo equipo : equipos )
				initializeEquipo( equipo );
		}
		return equipos;
	}

	@Override
	public Equipo findEquipoById(int id) 
	{
		Criteria cr = getSession().createCriteria(Equipo.class);
		cr.add(Restrictions.eq("oid", id));
		Equipo equipo = (Equipo) cr.list().get(0);
		if(null != equipo)
		{
			initializeEquipo( equipo );
		}
		return equipo;
	}
	
	
	public void initializeEquipo( Equipo equipo  )
	{
		Hibernate.initialize( equipo.getJuagadores() );
		for( Jugador jugador : equipo.getJuagadores() )
		{
			jugador.setSkillJugador(null);
		}
		
		Hibernate.initialize( equipo.getProfesores() );
		for( Profesor profesor : equipo.getProfesores() )
		{
			
		}
		
	}

}
