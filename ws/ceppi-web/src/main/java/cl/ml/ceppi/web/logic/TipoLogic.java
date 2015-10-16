package cl.ml.ceppi.web.logic;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

import cl.ml.ceppi.core.facade.TipoFacade;
import cl.ml.ceppi.core.model.tipo.CategoriaSocio;
import cl.ml.ceppi.core.model.tipo.CentroCosto;
import cl.ml.ceppi.core.model.tipo.Profesion;
import cl.ml.ceppi.core.model.tipo.TipoGasto;
import cl.ml.ceppi.core.model.tipo.TipoIngreso;
import cl.ml.ceppi.core.model.tipo.TipoProfesor;
import cl.ml.ceppi.core.model.tipo.TipoSocio;
import cl.ml.ceppi.web.locator.ServiceLocator;
import cl.ml.ceppi.web.pojo.TipoPojo;
import cl.ml.ceppi.web.util.Constantes;

/**
 * 
 * @author Maldonado León
 *
 */
public class TipoLogic 
{
	private static final Logger LOGGER = Logger.getLogger(TipoLogic.class);

	/**
	 * 
	 * @return
	 */
	public static Response listaGastos() 
	{
		Response response;
		try 
		{
			TipoFacade facade = (TipoFacade) ServiceLocator.getInstance().getBean(Constantes.TIPO_FACADE);
			List<TipoGasto> lista =	facade.listTipoGasto();
			
			response = Response.status(Status.OK).entity(lista).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al obtener la lista de Gastos.", e);
			response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
		
		return response;
	}

	public static Response listaCentroCosto() {
		Response response;
		try 
		{
			TipoFacade facade = (TipoFacade) ServiceLocator.getInstance().getBean(Constantes.TIPO_FACADE);
			List<CentroCosto> lista =	facade.listCentroCosto();
			
			response = Response.status(Status.OK).entity(lista).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al obtener la lista de Centro de Costo.", e);
			response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
		
		return response;
	}

	/**
	 * Obtiene la lista de profesiones
	 * @return
	 */
	public static Response listaProfesion() 
	{
		Response response;
		try 
		{
			TipoFacade facade = (TipoFacade) ServiceLocator.getInstance().getBean(Constantes.TIPO_FACADE);
			List<Profesion> lista =	facade.listProfesion();
			
			response = Response.status(Status.OK).entity(lista).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al obtener la lista de Profesiones.", e);
			response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
		
		return response;
	}

	/**
	 * Obtiene la lista de categorias de socio
	 * @return
	 */
	public static Response listaCategorias() 
	{
		Response response;
		try 
		{
			TipoFacade facade = (TipoFacade) ServiceLocator.getInstance().getBean(Constantes.TIPO_FACADE);
			List<CategoriaSocio> lista =	facade.listCategoriaSocio();
			
			response = Response.status(Status.OK).entity(lista).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al obtener la lista de Categorias.", e);
			response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
		
		return response;
	}

	/**
	 * Obtiene la lista de tipos de socios
	 * @return
	 */
	public static Response listaSocios() 
	{
		Response response;
		try 
		{
			TipoFacade facade = (TipoFacade) ServiceLocator.getInstance().getBean(Constantes.TIPO_FACADE);
			List<TipoSocio> lista =	facade.listTipoSocio();
			
			response = Response.status(Status.OK).entity(lista).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al obtener la lista de Socios.", e);
			response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
		
		return response;
	}

	/**
	 * Guarda un tipo de Gasto
	 * @param pojo
	 * @return
	 */
	public static Response saveGasto(TipoPojo pojo) {
		Response response;
		try 
		{
			TipoFacade facade = (TipoFacade) ServiceLocator.getInstance().getBean(Constantes.TIPO_FACADE);
			TipoGasto obj = new TipoGasto(pojo.getCodigo(), pojo.getNombre(), pojo.getDescripcion());
			facade.save(obj);
			response = Response.status(Status.CREATED).entity(null).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al guardar tipo de Gasto.", e);
			response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
		return response;
	}

	/**
	 * Guarda un tipo de Socio
	 * @param pojo
	 * @return
	 */
	public static Response saveSocio(TipoPojo pojo) {
		Response response;
		try 
		{
			TipoFacade facade = (TipoFacade) ServiceLocator.getInstance().getBean(Constantes.TIPO_FACADE);
			TipoSocio obj = new TipoSocio(pojo.getCodigo(), pojo.getNombre(), pojo.getDescripcion());
			facade.save(obj);
			response = Response.status(Status.CREATED).entity(null).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al guardar tipo de Socio.", e);
			response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
		return response;
	}

	/**
	 * Guarda tipo de Categoria de Socio
	 * @param pojo
	 * @return
	 */
	public static Response saveCategoria(TipoPojo pojo) {
		Response response;
		try 
		{
			TipoFacade facade = (TipoFacade) ServiceLocator.getInstance().getBean(Constantes.TIPO_FACADE);
			CategoriaSocio obj = new CategoriaSocio(pojo.getCodigo(), pojo.getNombre(), pojo.getDescripcion());
			facade.save(obj);
			response = Response.status(Status.CREATED).entity(null).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al guardar tipo de Categoria de Socio.", e);
			response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
		return response;
	}

	/**
	 * Guarda tipo de Profesion
	 * @param pojo
	 * @return
	 */
	public static Response saveProfesion(TipoPojo pojo) {
		Response response;
		try 
		{
			TipoFacade facade = (TipoFacade) ServiceLocator.getInstance().getBean(Constantes.TIPO_FACADE);
			Profesion obj = new Profesion(pojo.getCodigo(), pojo.getNombre(), pojo.getDescripcion());
			facade.save(obj);
			response = Response.status(Status.CREATED).entity(null).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al guardar tipo de Profesion.", e);
			response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
		return response;
	}

	/**
	 * Guarda tipo de Centro de Costo
	 * @param pojo
	 * @return
	 */
	public static Response saveCentroCosto(TipoPojo pojo) {
		Response response;
		try 
		{
			TipoFacade facade = (TipoFacade) ServiceLocator.getInstance().getBean(Constantes.TIPO_FACADE);
			CentroCosto obj = new CentroCosto(pojo.getCodigo(), pojo.getNombre(), pojo.getDescripcion());
			facade.save(obj);
			response = Response.status(Status.CREATED).entity(null).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al guardar tipo de Centro de Costo.", e);
			response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
		return response;
	}

	/**
	 * Actualiza un tipo de gasto
	 * @param pojo
	 * @return
	 */
	public static Response updateGasto(TipoPojo pojo) {
		Response response;
		try 
		{
			TipoFacade facade = (TipoFacade) ServiceLocator.getInstance().getBean(Constantes.TIPO_FACADE);
			TipoGasto obj = new TipoGasto(pojo.getOid(), pojo.getCodigo(), pojo.getNombre(), pojo.getDescripcion());
			facade.update(obj);
			response = Response.status(Status.OK).entity(null).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al actualizar tipo de gasto.", e);
			response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
		return response;
	}

	/**
	 * Actualiza un tipo de Socio
	 * @param pojo
	 * @return
	 */
	public static Response updateSocio(TipoPojo pojo) {
		Response response;
		try 
		{
			TipoFacade facade = (TipoFacade) ServiceLocator.getInstance().getBean(Constantes.TIPO_FACADE);
			TipoSocio obj = new TipoSocio(pojo.getOid(), pojo.getCodigo(), pojo.getNombre(), pojo.getDescripcion());
			facade.update(obj);
			response = Response.status(Status.OK).entity(null).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al actualizar tipo de socio.", e);
			response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
		return response;
	}

	/**
	 * Actualiza tipo de categoria de socio
	 * @param pojo
	 * @return
	 */
	public static Response updateCategoria(TipoPojo pojo) {
		Response response;
		try 
		{
			TipoFacade facade = (TipoFacade) ServiceLocator.getInstance().getBean(Constantes.TIPO_FACADE);
			CategoriaSocio obj = new CategoriaSocio(pojo.getOid(), pojo.getCodigo(), pojo.getNombre(), pojo.getDescripcion());
			facade.update(obj);
			response = Response.status(Status.OK).entity(null).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al actualizar tipo de categoria socio.", e);
			response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
		return response;
	}

	/**
	 * Actualiza tipo de Profesion
	 * @param pojo
	 * @return
	 */
	public static Response updateProfesion(TipoPojo pojo) {
		Response response;
		try 
		{
			TipoFacade facade = (TipoFacade) ServiceLocator.getInstance().getBean(Constantes.TIPO_FACADE);
			Profesion obj = new Profesion(pojo.getOid(), pojo.getCodigo(), pojo.getNombre(), pojo.getDescripcion());
			facade.update(obj);
			response = Response.status(Status.OK).entity(null).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al actualizar tipo de profesion.", e);
			response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
		return response;
	}
	
	/**
	 * Actualiza centro de costo
	 * @param pojo
	 * @return
	 */
	public static Response updateCentroCosto(TipoPojo pojo) {
		Response response;
		try 
		{
			TipoFacade facade = (TipoFacade) ServiceLocator.getInstance().getBean(Constantes.TIPO_FACADE);
			CentroCosto obj = new CentroCosto(pojo.getOid(), pojo.getCodigo(), pojo.getNombre(), pojo.getDescripcion());
			facade.update(obj);
			response = Response.status(Status.OK).entity(null).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al actualizar centro de costo.", e);
			response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
		return response;
	}

	/**
	 * Eliminar tipo gasto
	 * @param pojo
	 * @return
	 */
	public static Response deleteGasto(TipoPojo pojo) {
		Response response;
		try 
		{
			TipoFacade facade = (TipoFacade) ServiceLocator.getInstance().getBean(Constantes.TIPO_FACADE);
			TipoGasto obj = new TipoGasto(pojo.getOid(), pojo.getCodigo(), pojo.getNombre(), pojo.getDescripcion());
			facade.delete(obj);
			response = Response.status(Status.OK).entity(null).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al eliminar tipo de gasto.", e);
			response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
		return response;
	}
	
	/**
	 * Eliminar tipo socio
	 * @param pojo
	 * @return
	 */
	public static Response deleteSocio(TipoPojo pojo) {
		Response response;
		try 
		{
			TipoFacade facade = (TipoFacade) ServiceLocator.getInstance().getBean(Constantes.TIPO_FACADE);
			TipoSocio obj = new TipoSocio(pojo.getOid(), pojo.getCodigo(), pojo.getNombre(), pojo.getDescripcion());
			facade.delete(obj);
			response = Response.status(Status.OK).entity(null).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al eliminar tipo socio.", e);
			response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
		return response;
	}

	/**
	 * Eliminar categoria socio
	 * @param pojo
	 * @return
	 */
	public static Response deleteCategoria(TipoPojo pojo) {
		Response response;
		try 
		{
			TipoFacade facade = (TipoFacade) ServiceLocator.getInstance().getBean(Constantes.TIPO_FACADE);
			CategoriaSocio obj = new CategoriaSocio(pojo.getOid(), pojo.getCodigo(), pojo.getNombre(), pojo.getDescripcion());
			facade.delete(obj);
			response = Response.status(Status.OK).entity(null).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al eliminar categoria socio.", e);
			response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
		return response;
	}

	/**
	 * Eliminar profesion
	 * @param pojo
	 * @return
	 */
	public static Response deleteProfesion(TipoPojo pojo) {
		Response response;
		try 
		{
			TipoFacade facade = (TipoFacade) ServiceLocator.getInstance().getBean(Constantes.TIPO_FACADE);
			Profesion obj = new Profesion(pojo.getOid(), pojo.getCodigo(), pojo.getNombre(), pojo.getDescripcion());
			facade.delete(obj);
			response = Response.status(Status.OK).entity(null).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al eliminar profesion.", e);
			response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
		return response;
	}

	/**
	 * Eliminar centro de costo
	 * @param pojo
	 * @return
	 */
	public static Response deleteCentroCosto(TipoPojo pojo) {
		Response response;
		try 
		{
			TipoFacade facade = (TipoFacade) ServiceLocator.getInstance().getBean(Constantes.TIPO_FACADE);
			CentroCosto obj = new CentroCosto(pojo.getOid(), pojo.getCodigo(), pojo.getNombre(), pojo.getDescripcion());
			facade.delete(obj);
			response = Response.status(Status.OK).entity(null).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al eliminar centro de costo.", e);
			response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
		return response;
	}

	/**
	 * Elimina un tipo de ingreso
	 * @return
	 */
	public static Response listaTipoIngreso() {
		Response response;
		
		try 
		{
			TipoFacade facade = (TipoFacade) ServiceLocator.getInstance().getBean(Constantes.TIPO_FACADE);
			List<TipoIngreso> lista =	facade.listTipoIngreso();
			
			response = Response.status(Status.OK).entity(lista).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al obtener la lista de Ingreso.", e);
			response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
		
		return response;
	}

	/**
	 * Actualiza un tipo de ingreso
	 * @param pojo
	 * @return
	 */
	public static Response updateTipoIngreso(TipoPojo pojo) 
	{
		try 
		{
			TipoFacade facade = (TipoFacade) ServiceLocator.getInstance().getBean(Constantes.TIPO_FACADE);
			TipoIngreso obj = new TipoIngreso(pojo.getOid(), pojo.getCodigo(), pojo.getNombre(), pojo.getDescripcion());
			facade.update(obj);
			return Response.status(Status.OK).entity(null).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al actualizar tipo de ingreso.", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
	}

	/**
	 * Elimina un tipo de ingreso
	 * @param pojo
	 * @return
	 */
	public static Response deleteTipoIngreso(TipoPojo pojo) 
	{
		try 
		{
			TipoFacade facade = (TipoFacade) ServiceLocator.getInstance().getBean(Constantes.TIPO_FACADE);
			TipoIngreso obj = new TipoIngreso(pojo.getOid(), pojo.getCodigo(), pojo.getNombre(), pojo.getDescripcion());
			facade.delete(obj);
			return Response.status(Status.OK).entity(null).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al eliminar tipo ingreso.", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
	}

	/**
	 * 
	 * @return
	 */
	public static Response listaProfesores() 
	{
		try 
		{
			TipoFacade facade = (TipoFacade) ServiceLocator.getInstance().getBean(Constantes.TIPO_FACADE);
			List<TipoProfesor> lista =	facade.listTipoProfesor();
			
			return Response.status(Status.OK).entity(lista).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al obtener la lista de Profesores.", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
	}

	/**
	 * 
	 * @param pojo
	 * @return
	 */
	public static Response saveProfesor(TipoPojo pojo) 
	{
		try 
		{
			TipoFacade facade = (TipoFacade) ServiceLocator.getInstance().getBean(Constantes.TIPO_FACADE);
			TipoProfesor obj = new TipoProfesor(pojo.getCodigo(), pojo.getNombre(), pojo.getDescripcion());
			facade.save(obj);
			return Response.status(Status.CREATED).entity(null).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al guardar tipo de profesor.", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
	}

	/**
	 * 
	 * @param pojo
	 * @return
	 */
	public static Response updateProfesor(TipoPojo pojo) 
	{
		try 
		{
			TipoFacade facade = (TipoFacade) ServiceLocator.getInstance().getBean(Constantes.TIPO_FACADE);
			TipoProfesor obj = new TipoProfesor(pojo.getOid(), pojo.getCodigo(), pojo.getNombre(), pojo.getDescripcion());
			facade.update(obj);
			return Response.status(Status.OK).entity(null).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al actualizar tipo de profesor.", e);
			return  Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
	}

	/**
	 * 
	 * @param tipoPojo
	 * @return
	 */
	public static Response deleteTipoProfesor(TipoPojo pojo) 
	{
		try 
		{
			TipoFacade facade = (TipoFacade) ServiceLocator.getInstance().getBean(Constantes.TIPO_FACADE);
			TipoProfesor obj = new TipoProfesor(pojo.getOid(), pojo.getCodigo(), pojo.getNombre(), pojo.getDescripcion());
			facade.delete(obj);
			return Response.status(Status.OK).entity(null).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al eliminar tipo profesor.", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
	}

}
