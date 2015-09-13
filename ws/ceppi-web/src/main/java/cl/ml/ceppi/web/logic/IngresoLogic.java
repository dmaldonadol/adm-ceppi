package cl.ml.ceppi.web.logic;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

import cl.ml.ceppi.core.facade.IngresoFacade;
import cl.ml.ceppi.core.model.ingreso.Ingreso;
import cl.ml.ceppi.web.locator.ServiceLocator;
import cl.ml.ceppi.web.util.Constantes;

/**
 * 
 * @author Maldonado Leon
 *
 */
public class IngresoLogic {
	
	private static final Logger LOGGER = Logger.getLogger(IngresoLogic.class);

	public IngresoLogic() {
	}

	/**
	 * Lista de ingresos
	 * @return
	 */
	public static Response listaIngresos() 
	{
		try 
		{
			IngresoFacade facade = (IngresoFacade) ServiceLocator.getInstance().getBean(Constantes.INGRESO_FACADE);
			List<Ingreso> lista = facade.listIngresos();
			return Response.status(Status.OK).entity(lista).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al obtener lista de ingresos", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * Guarda un ingreso
	 * @param obj
	 * @return
	 */
	public static Response save(Ingreso obj) 
	{
		try 
		{
			IngresoFacade facade = (IngresoFacade) ServiceLocator.getInstance().getBean(Constantes.INGRESO_FACADE);
			facade.save(obj);
			return Response.status(Status.CREATED).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al guardar un ingreso", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * Actualiza un ingreso
	 * @param obj
	 * @return
	 */
	public static Response update(Ingreso obj) 
	{
		try 
		{
			IngresoFacade facade = (IngresoFacade) ServiceLocator.getInstance().getBean(Constantes.INGRESO_FACADE);
			facade.update(obj);
			return Response.status(Status.CREATED).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al actualizar un ingreso", e);
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
			IngresoFacade facade = (IngresoFacade) ServiceLocator.getInstance().getBean(Constantes.INGRESO_FACADE);
			facade.delete(new Ingreso(id));
			return Response.status(Status.OK).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al actualizar un ingreso", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

}
