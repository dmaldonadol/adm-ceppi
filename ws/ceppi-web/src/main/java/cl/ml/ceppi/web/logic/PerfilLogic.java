package cl.ml.ceppi.web.logic;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import cl.ml.ceppi.core.facade.PerfilFacade;
import cl.ml.ceppi.web.locator.ServiceLocator;

/**
 * 
 * @author Maldonado León
 *
 */
public class PerfilLogic {
	
	private static final Logger LOGGER = Logger.getLogger(PerfilLogic.class);

	public PerfilLogic() {
	}

	/**
	 * Lista los perfiles del sistema
	 * @return
	 */
	public static Response listaPerfiles() 
	{
		try 
		{
			PerfilFacade perfilFacade = (PerfilFacade) ServiceLocator.getInstance().getBean("perfilFacade");
			return Response.status(Response.Status.OK).entity(perfilFacade.listPerfil()).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al obtener la lista de Perfiles. ", e);
			return Response.status(Response.Status.PRECONDITION_FAILED).entity(null).build();
		}
		
	}

}
