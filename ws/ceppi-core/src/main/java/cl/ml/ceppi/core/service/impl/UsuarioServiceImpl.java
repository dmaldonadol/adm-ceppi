/**
 * 
 */
package cl.ml.ceppi.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.ml.ceppi.core.dao.UsuarioDao;
import cl.ml.ceppi.core.model.usuario.Usuario;
import cl.ml.ceppi.core.service.UsuarioService;

/**
 * @author Maldonado León
 * 
 */
@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService 
{
	@Autowired
	private UsuarioDao usuarioDao;

	@Transactional
	public void save(Usuario usuario) {
		usuarioDao.save(usuario);
	}

	@Transactional
	public void update(Usuario usuario) {
		usuarioDao.update(usuario);
	}

	@Transactional
	public void delete(Usuario usuario) {
		usuarioDao.delete(usuario);
	}

	@Transactional
	public List<Usuario> listUsuario() {
		return usuarioDao.listUsuario();
	}

	@Transactional
	public Usuario findUsuarioById(int id) {
		return usuarioDao.findUsuarioById(id);
	}

}
