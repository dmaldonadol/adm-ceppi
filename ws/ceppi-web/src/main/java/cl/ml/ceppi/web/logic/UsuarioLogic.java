package cl.ml.ceppi.web.logic;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import cl.ml.ceppi.core.facade.UsuarioFacade;
import cl.ml.ceppi.core.model.usuario.Usuario;
import cl.ml.ceppi.core.util.Crypt;
import cl.ml.ceppi.web.locator.ServiceLocator;
import cl.ml.ceppi.web.util.Constantes;

/**
 * 
 * @author Maldonado León
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
	public static Response autenticar(String user, String pass, HttpServletRequest request) 
	{
		try 
		{
			UsuarioFacade usuarioFacade = (UsuarioFacade) ServiceLocator.getInstance().getBean(Constantes.USUARIO_FACADE);
			String password = Crypt.encrypt(pass);
			Usuario usuario = usuarioFacade.autenticar(user, password);
			request.getSession().setAttribute("usuario", usuario);
			return Response.status(Response.Status.OK).entity(null).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al autenticar usuario "+ user +".", e);
			return Response.status(Response.Status.PRECONDITION_FAILED).entity(null).build();
		}
	}
}
