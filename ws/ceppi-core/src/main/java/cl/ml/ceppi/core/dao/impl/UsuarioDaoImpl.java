package cl.ml.ceppi.core.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.ml.ceppi.core.dao.UsuarioDao;
import cl.ml.ceppi.core.model.usuario.Usuario;

/**
 * @author Maldonado León
 * 
 */
@Repository("UsuarioDao")
public class UsuarioDaoImpl implements UsuarioDao {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Usuario usuario) {
		getSession().persist(usuario);
	}

	@Override
	public void update(Usuario usuario) {
		getSession().update(usuario);
	}

	@Override
	public void delete(Usuario usuario) {
		getSession().delete(usuario);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listUsuario() {
		return (List<Usuario>) getSession().createQuery("from Usuario").list();
	}

	@Override
	public Usuario findUsuarioById(int id) {
		Criteria cr = getSession().createCriteria(Usuario.class);
		cr.add(Restrictions.eq("oid", id));
		return (Usuario) cr.list().get(0);
	}

}
