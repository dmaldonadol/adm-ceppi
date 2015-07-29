package cl.ml.ceppi.core.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.ml.ceppi.core.facade.UsuarioFacade;
import cl.ml.ceppi.core.model.usuario.Usuario;
import cl.ml.ceppi.core.service.UsuarioService;

/**
 * @author Maldonado León
 * 
 */
@Service("usuarioFacade")
public class UsuarioFacadeImpl implements UsuarioFacade {
	@Autowired
	private UsuarioService usuarioService;

	@Transactional
	public void save(Usuario usuario) {
		usuarioService.save(usuario);
	}

	@Transactional
	public void update(Usuario usuario) {
		usuarioService.update(usuario);
	}

	@Transactional
	public void delete(Usuario usuario) {
		usuarioService.delete(usuario);
	}

	@Transactional
	public List<Usuario> listUsuario() {
		return usuarioService.listUsuario();
	}

	@Transactional
	public Usuario findUsuarioById(int id) {
		return usuarioService.findUsuarioById(id);
	}
	
	@Transactional
	public Usuario autenticar(String user, String pass) {
		return usuarioService.autenticar(user, pass);
	}

}
