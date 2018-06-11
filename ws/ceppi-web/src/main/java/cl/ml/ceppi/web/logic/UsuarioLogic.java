package cl.ml.ceppi.web.logic;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

import cl.ml.ceppi.core.facade.PerfilFacade;
import cl.ml.ceppi.core.facade.UsuarioFacade;
import cl.ml.ceppi.core.model.menu.Menu;
import cl.ml.ceppi.core.model.menu.MenuCompuesto;
import cl.ml.ceppi.core.model.perfil.Perfil;
import cl.ml.ceppi.core.model.usuario.Usuario;
import cl.ml.ceppi.core.util.Crypt;
import cl.ml.ceppi.web.locator.ServiceLocator;
import cl.ml.ceppi.web.util.Constantes;

/**
 * 
 * @author Maldonado Le�n
 *
 */
public class UsuarioLogic {
	
	private static final Logger LOGGER = Logger.getLogger(UsuarioLogic.class);

	public UsuarioLogic() {
	}

	/**
	 * Autenticar usuario
	 * @param user
	 * @param pass
	 * @param request
	 * @return
	 */
	public static Usuario autenticar(String user, String pass) 
	{
		Usuario usuario = null;
		try 
		{
			UsuarioFacade usuarioFacade = (UsuarioFacade) ServiceLocator.getInstance().getBean(Constantes.USUARIO_FACADE);
			String password = Crypt.encrypt(pass);
			usuario = usuarioFacade.autenticar(user, password);
			
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al autenticar usuario "+ user +".", e);
		}
		return usuario;
	}
	
	/**
	 * Obtiene el acceso por perfil
	 * @param perfil
	 * @return
	 */
	public static List<MenuCompuesto> acceso(Perfil perfil)
	{
		List<MenuCompuesto> menu = null;
		try 
		{
			PerfilFacade facade = (PerfilFacade) ServiceLocator.getInstance().getBean(Constantes.PERFIL_FACADE);
			
			menu = facade.listMenuPerfil(perfil.getOid());
			
			for (MenuCompuesto menuCompuesto : menu) {
				menuCompuesto.setMenu(null);
				for (Menu item :menuCompuesto.getItemMenu()) 
				{
					item.setMenu(null);
				}
			}
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al obtener el menu por perfil.", e);
		}
		return menu;
	}

	/**
	 * Obtiene la lista de usuarios
	 * @return
	 */
	public static Response listaUsuarios() 
	{
		try 
		{
			UsuarioFacade facade = (UsuarioFacade) ServiceLocator.getInstance().getBean(Constantes.USUARIO_FACADE);
			List<Usuario> lista = facade.listUsuario();
			return Response.status(Status.OK).entity(lista).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al guardar un usuario.", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
	}

	/**
	 * Guarda un usuario
	 * @param usuario
	 * @return
	 */
	public static Response save(Usuario usuario) 
	{
		try 
		{
			UsuarioFacade facade = (UsuarioFacade) ServiceLocator.getInstance().getBean(Constantes.USUARIO_FACADE);
			
			String pass = Crypt.encrypt(usuario.getPassword());
			usuario.setPassword(pass);
			
			facade.save(usuario);
			
			return Response.status(Status.OK).entity(null).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al guardar un usuario.", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
	}

	/**
	 * Actualiza un usuario
	 * @param usuario
	 * @return
	 */
	public static Response update(Usuario usuario) 
	{
		try 
		{
			UsuarioFacade facade = (UsuarioFacade) ServiceLocator.getInstance().getBean(Constantes.USUARIO_FACADE);
			
			String pass = Crypt.encrypt(usuario.getPassword());
			usuario.setPassword(pass);
			
			facade.update(usuario);
			return Response.status(Status.OK).entity(null).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al actualizar un usuario.", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
	}

	/**
	 * Elimina un usuario
	 * @param usuario
	 * @return
	 */
	public static Response delete(Usuario usuario) 
	{
		try 
		{
			UsuarioFacade facade = (UsuarioFacade) ServiceLocator.getInstance().getBean(Constantes.USUARIO_FACADE);
			
			facade.delete(usuario);
			return Response.status(Status.OK).entity(null).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al eliminar un usuario.", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
	}
	
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public static Response findUsuarioById(int id)
	{
		try 
		{
			UsuarioFacade facade = (UsuarioFacade) ServiceLocator.getInstance().getBean(Constantes.USUARIO_FACADE);
			Usuario usuario = facade.findUsuarioById(id);
			return Response.status(Status.OK).entity(usuario).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al obtener el usuario " + id, e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
	}
}
