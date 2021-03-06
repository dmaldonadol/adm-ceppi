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
		try 
		{
			PerfilFacade facade = (PerfilFacade) ServiceLocator.getInstance().getBean(Constantes.PERFIL_FACADE);
			
			List<MenuCompuesto> menu = facade.listMenuPerfil(perfil.getOid());
			
			for (MenuCompuesto menuCompuesto : menu) {
				menuCompuesto.setMenu(null);
				for (Menu item :menuCompuesto.getItemMenu()) 
				{
					item.setMenu(null);
				}
			}
			createMenu(menu);
			return menu;
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al obtener el menu por perfil.", e);
			return null;
		}
	}

	/**
	 * 
	 * @param menu
	 * @return
	 */
	private static String createMenu(List<MenuCompuesto> menu) 
	{
		StringBuilder builder = new StringBuilder();
		
		builder.append("<aside class=\"sidebar sidebar-left sidebar-menu\">");
		builder.append("<section class=\"content slimscroll\">");
		builder.append("<h5 class=\"heading\">Men&uacute;</h5>");
		builder.append("<ul class=\"topmenu topmenu-responsive\" data-toggle=\"menu\">");
		
		for (MenuCompuesto menuCompuesto : menu) 
		{
			builder.append("<li>");
			builder.append("<a href=\"javascript:void(0);\" data-target=\"#dashboard" + menuCompuesto.getCodigo() +"\" data-toggle=\"submenu\" data-parent=\".topmenu\">");
			builder.append("<span class=\"figure\"><i class=\"ico-dashboard2\"></i></span>");
			builder.append("<span class=\"text\">" + menuCompuesto.getNombre() + "</span>");
			builder.append("<span class=\"arrow\"></span>");
			builder.append("</a>");
			builder.append("<ul id=\"dashboard" + menuCompuesto.getCodigo() +"\" class=\"collapse \">");
			builder.append("<li class=\"submenu-header ellipsis\">" + menuCompuesto.getNombre() + "</li>");
			for (Menu subMenu : menuCompuesto.getItemMenu()) 
			{
				builder.append("<li>");
				builder.append("<a href=\"" + subMenu.getPath() + "\"><span class=\"text\">"+ subMenu.getNombre() + "</span></a>");
				builder.append("</li>");
			}
			builder.append("</ul>");
			builder.append("</li>");
		}
		
		builder.append("</ul>");
		builder.append("</section>");
		builder.append("</aside>");
		
		LOGGER.info("MENU: " + builder.toString());
		
		return builder.toString();
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
