package cl.ml.ceppi.core.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.ml.ceppi.core.dao.PerfilDao;
import cl.ml.ceppi.core.model.menu.Menu;
import cl.ml.ceppi.core.model.perfil.Perfil;

/**
 * @author Maldonado León
 * 
 */
@Repository("PerfilDao")
public class PerfilDaoImpl implements PerfilDao {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Perfil perfil) {
		getSession().persist(perfil);
	}

	@Override
	public void saveMenu(Menu menu) {
		getSession().persist(menu);
	}

	@Override
	public void update(Perfil perfil) {
		getSession().update(perfil);
	}

	@Override
	public void update(Menu menu) {
		getSession().update(menu);
	}

	@Override
	public void delete(Perfil perfil) {
		getSession().delete(perfil);
	}

	@Override
	public void delete(Menu menu) {
		getSession().delete(menu);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Perfil> listPerfil() {
		return (List<Perfil>) getSession().createQuery("from Perfil").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> listMenu() {
		return (List<Menu>) getSession().createQuery("from Menu").list();
	}

	@Override
	public Perfil findPerfilById(int id) {
		Criteria cr = getSession().createCriteria(Perfil.class);
		cr.add(Restrictions.eq("oid", id));
		return (Perfil) cr.list().get(0);
	}

	@Override
	public Menu findMenuById(int id) {
		Criteria cr = getSession().createCriteria(Menu.class);
		cr.add(Restrictions.eq("oid", id));
		return (Menu) cr.list().get(0);
	}

}
