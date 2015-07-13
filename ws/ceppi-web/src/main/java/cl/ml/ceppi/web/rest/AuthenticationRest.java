/**
 * 
 */
package cl.ml.ceppi.web.rest;

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

import cl.ml.ceppi.core.model.usuario.Usuario;

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
	public static final String USER_SESSION = "USER";
	
	@Context
    private HttpServletRequest request;
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public Response login( Usuario usuario )
	{
		try 
		{
			if( usuario.getUsername().equals("admin") && usuario.getPassword().equals("admin") )
			{
				HttpSession session = request.getSession( true );
				session.setAttribute( USER_SESSION , usuario );
				
				LOGGER.info( "El usuario " + usuario.getUsername() + " ha iniciado sesion correctamente" );
				return Response.status(Status.OK).build();
			}
			else
			{
				LOGGER.error( "Usuario y/o clave no validos");
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