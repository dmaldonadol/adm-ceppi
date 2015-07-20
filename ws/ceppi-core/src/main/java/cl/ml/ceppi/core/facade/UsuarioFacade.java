/**
 * 
 */
package cl.ml.ceppi.core.facade;

import java.util.List;

import cl.ml.ceppi.core.model.usuario.Usuario;

/**
 * @author Maldonado León
 * 
 */
public interface UsuarioFacade 
{
	void save(Usuario usuario);

	void update(Usuario usuario);

	void delete(Usuario usuario);

	List<Usuario> listUsuario();

	Usuario findUsuarioById(int id);
}
