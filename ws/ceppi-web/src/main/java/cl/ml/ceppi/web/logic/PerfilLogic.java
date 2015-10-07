package cl.ml.ceppi.web.logic;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

import cl.ml.ceppi.core.facade.PerfilFacade;
import cl.ml.ceppi.core.model.perfil.Perfil;
import cl.ml.ceppi.web.locator.ServiceLocator;
import cl.ml.ceppi.web.util.Constantes;

/**
 * 
 * @author Maldonado Le�n
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
	
	
	/**
	 * Lista los perfiles del sistema
	 * @return
	 */
	public static Response findById( int id ) 
	{
		try 
		{
			PerfilFacade perfilFacade = (PerfilFacade) ServiceLocator.getInstance().getBean("perfilFacade");
			return Response.status(Response.Status.OK).entity(perfilFacade.findPerfilById(id)).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al obtener la lista de Perfiles. ", e);
			return Response.status(Response.Status.PRECONDITION_FAILED).entity(null).build();
		}
	}
	
	/**
	 * Guarda un perfil
	 * @param obj
	 * @return
	 */
	public static Response save(Perfil obj) 
	{
		try 
		{
			PerfilFacade facade = (PerfilFacade) ServiceLocator.getInstance().getBean(Constantes.PERFIL_FACADE);
						
			facade.save(obj);
			
			return Response.status(Status.OK).entity(null).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al guardar un perfil.", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
	}

	/**
	 * Actualiza un perfil
	 * @param obj
	 * @return
	 */
	public static Response update(Perfil obj) 
	{
		try 
		{
			PerfilFacade facade = (PerfilFacade) ServiceLocator.getInstance().getBean(Constantes.PERFIL_FACADE);
			
			facade.update(obj);
			return Response.status(Status.OK).entity(null).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al actualizar un perfil.", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
	}

	/**
	 * Elimina un perfil
	 * @param obj
	 * @return
	 */
	public static Response delete(Perfil obj) 
	{
		try 
		{
			PerfilFacade facade = (PerfilFacade) ServiceLocator.getInstance().getBean(Constantes.PERFIL_FACADE);
			
			facade.delete(obj);
			return Response.status(Status.OK).entity(null).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al eliminar un perfil.", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
	}

}
