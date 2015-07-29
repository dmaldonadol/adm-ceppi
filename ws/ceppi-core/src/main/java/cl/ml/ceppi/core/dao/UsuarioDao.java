package cl.ml.ceppi.core.dao;

import java.util.List;

import cl.ml.ceppi.core.model.usuario.Usuario;

/**
 * @author Maldonado León
 *
 */
public interface UsuarioDao 
{
	void save(Usuario usuario);
	
	void update(Usuario usuario);
	
	void delete(Usuario usuario);
	
	List<Usuario> listUsuario();
		
	Usuario findUsuarioById(int id);
	
	Usuario autenticar(String user, String pass);
}
