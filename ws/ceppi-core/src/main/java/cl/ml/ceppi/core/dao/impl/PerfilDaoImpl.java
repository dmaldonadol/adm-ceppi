package cl.ml.ceppi.core.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.ml.ceppi.core.dao.PerfilDao;
import cl.ml.ceppi.core.model.acceso.Acceso;
import cl.ml.ceppi.core.model.menu.Menu;
import cl.ml.ceppi.core.model.menu.MenuCompuesto;
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
	public List<MenuCompuesto> listMenu() {
		Criteria cr = getSession().createCriteria(Menu.class);
		cr.add(Restrictions.isNull("menu"));
		cr.addOrder(Order.asc("orden"));
		
		List<MenuCompuesto> menu = (List<MenuCompuesto>) cr.list();
		
		for (MenuCompuesto item : menu) 
		{
			Criteria crs = getSession().createCriteria(Menu.class);
			crs.add(Restrictions.eq("menu", item));
			crs.addOrder(Order.asc("orden"));
			item.setItemMenu(crs.list());
			item.setMenu(null);
		}
		
		return menu;
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
	
	@SuppressWarnings("unchecked")
	public List<Acceso> listaAccesoByIdPerfil(int id)
	{
		Criteria cr = getSession().createCriteria(Acceso.class);
		cr.add(Restrictions.eq("perfil.oid", id));
		return (List<Acceso>)cr.list();
	}

	@Override
	public void saveAcceso(Acceso acceso) {
		getSession().persist(acceso);
	}

	@Override
	public Acceso findAccesoById(int id) {
		Criteria cr = getSession().createCriteria(Acceso.class);
		cr.add(Restrictions.eq("oid", id));
		return (Acceso) cr.uniqueResult();
	}

	@Override
	public Menu findMenuByCodigo(String codigo) {
		Criteria cr = getSession().createCriteria(Menu.class);
		cr.add(Restrictions.eq("codigo", codigo));
		return (Menu) cr.uniqueResult();
	}

	@Override
	public void delete(Acceso acceso) {
		getSession().delete(acceso);
	}

}
