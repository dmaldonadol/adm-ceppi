package cl.ml.ceppi.web.logic;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

import cl.ml.ceppi.core.facade.GastoFacade;
import cl.ml.ceppi.core.model.gasto.Gasto;
import cl.ml.ceppi.web.locator.ServiceLocator;
import cl.ml.ceppi.web.util.Constantes;

/**
 * 
 * @author Maldonado Leon
 *
 */
public class GastosLogic {
	
	private static final Logger LOGGER = Logger.getLogger(GastosLogic.class);

	public GastosLogic() {
	}

	/**
	 * Lista de ingresos
	 * @return
	 */
	public static Response listar() 
	{
		try 
		{
			GastoFacade facade = (GastoFacade) ServiceLocator.getInstance().getBean(Constantes.GASTO_FACADE);
			List<Gasto> lista = facade.listGastos();
			return Response.status(Status.OK).entity(lista).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al obtener lista de gastos", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * Guarda un ingreso
	 * @param obj
	 * @return
	 */
	public static Response save(Gasto obj) 
	{
		try 
		{
			GastoFacade facade = (GastoFacade) ServiceLocator.getInstance().getBean(Constantes.GASTO_FACADE);
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
	public static Response update(Gasto obj) 
	{
		try 
		{
			GastoFacade facade = (GastoFacade) ServiceLocator.getInstance().getBean(Constantes.GASTO_FACADE);
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
			GastoFacade facade = (GastoFacade) ServiceLocator.getInstance().getBean(Constantes.GASTO_FACADE);
			facade.delete(new Gasto(id));
			return Response.status(Status.OK).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al actualizar un ingreso", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

}
