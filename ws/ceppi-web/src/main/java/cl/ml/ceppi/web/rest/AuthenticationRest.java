/**
 * 
 */
package cl.ml.ceppi.web.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

import cl.ml.ceppi.core.model.menu.Menu;
import cl.ml.ceppi.core.model.menu.MenuCompuesto;
import cl.ml.ceppi.core.model.usuario.Usuario;
import cl.ml.ceppi.web.logic.UsuarioLogic;
import cl.ml.ceppi.web.util.Constantes;

/**
 * 
 * ---------------------------------------------------------------------------
 * Maldonado León [ Administracion CEPPI ]
 * @author Juan Francisco Maldonado León - ( juan.maldonado.leon@gmail.com )
 * @date 12-07-2015
 * Description : 
 * ---------------------------------------------------------------------------
 */
@Path("/authentication")
public class AuthenticationRest {
	
	private static final Logger LOGGER = Logger.getLogger(AuthenticationRest.class.getCanonicalName());
	
	@Context
    private HttpServletRequest request;
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public Response login(Usuario user)
	{
		try 
		{
			Usuario usuario = UsuarioLogic.autenticar(user.getUsername(), user.getPassword());
			
			if (null != usuario)
			{
				HttpSession session = request.getSession( true );
				
				List<MenuCompuesto> acceso = UsuarioLogic.acceso(usuario.getPerfil());
				
				session.setAttribute( Constantes.USER_SESSION , usuario );
				session.setAttribute( Constantes.USER_ACCESS , acceso );
				
				return Response.status(Status.OK).build();
			}
			else
			{
				return Response.status(Status.UNAUTHORIZED).build();
			}
		}
		catch( Exception e )
		{
			LOGGER.error( "Ocurrio un error inesperado", e );
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@POST
	public Response loginForm( 	@FormParam("username") String userName, 
							@FormParam("password") String password )
	{
		Usuario usuario = new Usuario();
		usuario.setUsername( userName);
		usuario.setPassword(password);
		return login(usuario);
	}
	
	
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	public Response loginJSON( Usuario usuario )
	{
		return login(usuario);
	}
	
	
	@DELETE
	public Response logout()
	{
		HttpSession session = request.getSession(false);
		if( null != session )
			session.invalidate();
		return Response.status(Status.OK).build();
	}
}