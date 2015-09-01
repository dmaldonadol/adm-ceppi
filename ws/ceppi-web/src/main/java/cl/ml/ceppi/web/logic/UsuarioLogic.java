package cl.ml.ceppi.web.logic;

import java.util.List;

import org.apache.log4j.Logger;

import cl.ml.ceppi.core.facade.PerfilFacade;
import cl.ml.ceppi.core.facade.UsuarioFacade;
import cl.ml.ceppi.core.model.acceso.Acceso;
import cl.ml.ceppi.core.model.perfil.Perfil;
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
	public static List<Acceso> acceso(Perfil perfil)
	{
		List<Acceso> acceso = null;
		try 
		{
			PerfilFacade facade = (PerfilFacade) ServiceLocator.getInstance().getBean(Constantes.PERFIL_FACADE);
			acceso = facade.listaAccesoByIdPerfil(perfil.getOid());
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al obtener el menu por perfil.", e);
		}
		return acceso;
	}
}
