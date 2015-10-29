/**
 * Copyright (c) MaldonadoLeón 2010-2015
 * Factoría de Desarrollo de Software
 * Santiago de Chile, Region Metropolitana
 */
package cl.ml.ceppi.web.logic;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

import cl.ml.ceppi.core.facade.ProfesorFacade;
import cl.ml.ceppi.core.model.equipo.Profesor;
import cl.ml.ceppi.web.locator.ServiceLocator;
import cl.ml.ceppi.web.util.Constantes;


/**
 * ---------------------------------------------------------------------------
 * Maldonado León [ Administracion CEPPI ]
 * @author Juan Francisco Maldonado León - ( juan.maldonado.leon@gmail.com )
 * @date 21-09-2015
 * Description : 
 * ---------------------------------------------------------------------------
 */
public final class ProfesorLogic 
{
	private static final Logger LOGGER = Logger.getLogger(ProfesorLogic.class);
	private static ProfesorFacade profesorFacade = (ProfesorFacade) ServiceLocator.getInstance().getBean(Constantes.PROFESOR_FACADE);
	
	
	
	/**
	 * Lista los profesors del sistema
	 * @return
	 */
	public static Response findAll() 
	{
		try 
		{			
			return Response.status(Response.Status.OK).entity( profesorFacade.listProfesores() ).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al obtener la lista de profesores. ", e);
			return Response.status(Response.Status.PRECONDITION_FAILED).entity(null).build();
		}
	}
	
	
	/**
	 * Lista los profesor del sistema
	 * @return
	 */
	public static Response findById( int id ) 
	{
		try 
		{			
			return Response.status(Response.Status.OK).entity( profesorFacade.findProfesorById(id) ).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al obtener el profesor. ", e);
			return Response.status(Response.Status.PRECONDITION_FAILED).entity(null).build();
		}
	}
	
	
	
	/**
	 * Lista los profesor del sistema
	 * @return
	 */
	public static Response save( Profesor obj ) 
	{
		try 
		{			
			profesorFacade.save(obj);
			return Response.status(Response.Status.OK).entity( null ).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al guardar el profesor. ", e);
			return Response.status(Response.Status.PRECONDITION_FAILED).entity(null).build();
		}
	}
	
	
	/**
	 * Lista los profesor del sistema
	 * @return
	 */
	public static Response update( Profesor obj ) 
	{
		try 
		{			
			profesorFacade.update(obj);
			return Response.status(Response.Status.OK).entity( null ).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al actualizar el profesor. ", e);
			return Response.status(Response.Status.PRECONDITION_FAILED).entity(null).build();
		}
	}
	
	
	
	/**
	 * Lista los profesor del sistema
	 * @return
	 */
	public static Response remove( Profesor obj ) 
	{
		try 
		{			
			profesorFacade.delete(obj);
			return Response.status(Response.Status.OK).entity( null ).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al actualizar el profesor. ", e);
			return Response.status(Response.Status.PRECONDITION_FAILED).entity(null).build();
		}
	}


	/**
	 * 
	 * @param rut
	 * @return
	 */
	public static Response findByRut(String rut) {
		try 
		{			
			Profesor profesor = profesorFacade.findProfesorByRut(rut);
			
			if ( null != profesor )
			{
				return Response.status(Status.OK).entity(profesor).build();
			}
			else
			{
				return Response.status(Status.NOT_FOUND).build();
			}
		}
		catch (Exception e) 
		{
			LOGGER.error("Error find by rut profesor. ", e);
			return Response.status(Response.Status.PRECONDITION_FAILED).entity(null).build();
		}
	}


	/**
	 * 
	 * @param id
	 * @return
	 */
	public static Response delete(int id) {
		try 
		{			
			Profesor profesor = new Profesor(id);
			
			profesorFacade.delete(profesor);
			
			return Response.status(Status.NOT_FOUND).build();
			
		}
		catch (Exception e) 
		{
			LOGGER.error("Error delete profesor. ", e);
			return Response.status(Response.Status.PRECONDITION_FAILED).entity(null).build();
		}
	}
	
	
}
