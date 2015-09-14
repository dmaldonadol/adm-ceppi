package cl.ml.ceppi.web.logic;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

import cl.ml.ceppi.core.facade.IngresoFacade;
import cl.ml.ceppi.core.facade.SocioFacade;
import cl.ml.ceppi.core.model.ingreso.Ingreso;
import cl.ml.ceppi.core.model.socio.Socio;
import cl.ml.ceppi.web.locator.ServiceLocator;
import cl.ml.ceppi.web.util.Constantes;

/**
 * 
 * @author Maldonado Leon
 *
 */
public class SocioLogic {
	
	private static final Logger LOGGER = Logger.getLogger(SocioLogic.class);

	public SocioLogic() {
	}

	/**
	 * Lista de ingresos
	 * @return
	 */
	public static Response lista() 
	{
		try 
		{
			SocioFacade facade = (SocioFacade) ServiceLocator.getInstance().getBean(Constantes.SOCIO_FACADE);
			List<Socio> lista = facade.listSocio();
			return Response.status(Status.OK).entity(lista).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al obtener lista de socios", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * Guarda un ingreso
	 * @param obj
	 * @return
	 */
	public static Response save(Socio obj) 
	{
		try 
		{
			SocioFacade facade = (SocioFacade) ServiceLocator.getInstance().getBean(Constantes.SOCIO_FACADE);
			facade.save(obj);
			return Response.status(Status.CREATED).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al guardar un socio", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * Actualiza un ingreso
	 * @param obj
	 * @return
	 */
	public static Response update(Socio obj) 
	{
		try 
		{
			SocioFacade facade = (SocioFacade) ServiceLocator.getInstance().getBean(Constantes.SOCIO_FACADE);
			facade.update(obj);
			return Response.status(Status.CREATED).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al actualizar un Socio", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * Elimina un ingreso
	 * @param id
	 * @return
	 */
	public static Response delete(int id) 
	{
		try 
		{
			SocioFacade facade = (SocioFacade) ServiceLocator.getInstance().getBean(Constantes.SOCIO_FACADE);
			facade.delete(new Socio(id));
			return Response.status(Status.OK).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al actualizar un Socio", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * Obtiene socio por rut
	 * @param rut
	 * @return
	 */
	public static Response byRut(int rut) 
	{
		try 
		{
			SocioFacade facade = (SocioFacade) ServiceLocator.getInstance().getBean(Constantes.SOCIO_FACADE);
			Socio socio = facade.findByRut(rut);
			return Response.status(Status.OK).entity(socio).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al obtener socio por rut.", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

}
