/**
 * Copyright (c) MaldonadoLeón 2010-2015
 * Factoría de Desarrollo de Software
 * Santiago de Chile, Region Metropolitana
 */
package cl.ml.ceppi.web.logic;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import cl.ml.ceppi.core.facade.EquipoFacade;
import cl.ml.ceppi.core.model.equipo.Equipo;
import cl.ml.ceppi.core.model.equipo.Jugador;
import cl.ml.ceppi.web.locator.ServiceLocator;


/**
 * ---------------------------------------------------------------------------
 * Maldonado León [ Administracion CEPPI ]
 * @author Juan Francisco Maldonado León - ( juan.maldonado.leon@gmail.com )
 * @date 21-09-2015
 * Description : 
 * ---------------------------------------------------------------------------
 */
public final class EquipoLogic 
{
	private static final Logger LOGGER = Logger.getLogger(EquipoLogic.class);
	private static EquipoFacade equipoFacade = (EquipoFacade) ServiceLocator.getInstance().getBean("equipoFacade");
	
	
	
	/**
	 * Lista los equipos del sistema
	 * @return
	 */
	public static Response findAll() 
	{
		try 
		{			
			return Response.status(Response.Status.OK).entity( equipoFacade.listEquipos() ).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al obtener la lista de equipos. ", e);
			return Response.status(Response.Status.PRECONDITION_FAILED).entity(null).build();
		}
	}
	
	
	/**
	 * Lista los equipos del sistema
	 * @return
	 */
	public static Response findById( int id ) 
	{
		try 
		{			
			return Response.status(Response.Status.OK).entity( equipoFacade.findEquipoById(id) ).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al obtener el equipo. ", e);
			return Response.status(Response.Status.PRECONDITION_FAILED).entity(null).build();
		}
	}
	
	
	
	/**
	 * Lista los equipos del sistema
	 * @return
	 */
	public static Response save( Equipo equipo ) 
	{
		try 
		{			
			equipoFacade.save(equipo);
			return Response.status(Response.Status.OK).entity( null ).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al guardar el equipo. ", e);
			return Response.status(Response.Status.PRECONDITION_FAILED).entity(null).build();
		}
	}
	
	
	/**
	 * Lista los equipos del sistema
	 * @return
	 */
	public static Response update( Equipo equipo ) 
	{
		try 
		{			
			equipoFacade.update(equipo);
			return Response.status(Response.Status.OK).entity( null ).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al actualizar el equipo. ", e);
			return Response.status(Response.Status.PRECONDITION_FAILED).entity(null).build();
		}
	}
	
	
	
	/**
	 * Lista los equipos del sistema
	 * @return
	 */
	public static Response remove( Equipo equipo ) 
	{
		try 
		{			
			equipoFacade.delete(equipo);
			return Response.status(Response.Status.OK).entity( null ).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al actualizar el equipo. ", e);
			return Response.status(Response.Status.PRECONDITION_FAILED).entity(null).build();
		}
	}
	
	
	/**
	 * Lista los equipos del sistema
	 * @return
	 */
	public static Response addPlayer( Equipo equipo, Jugador jugador ) 
	{
		try 
		{			
			Equipo equipox = equipoFacade.findEquipoById(equipo.getOid());
			equipox.getJuagadores().add(jugador);
			equipoFacade.update(equipox);
			return Response.status(Response.Status.OK).entity( null ).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al actualizar el equipo. ", e);
			return Response.status(Response.Status.PRECONDITION_FAILED).entity(null).build();
		}
	}
	
	
	/**
	 * Lista los equipos del sistema
	 * @return
	 */
	public static Response removePlayer( Equipo equipo, Jugador jugador ) 
	{
		try 
		{			
			Equipo equipox = equipoFacade.findEquipoById(equipo.getOid());
			equipox.getJuagadores().remove(jugador); // TODO: Check
			equipoFacade.update(equipox);
			return Response.status(Response.Status.OK).entity( null ).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al actualizar el equipo. ", e);
			return Response.status(Response.Status.PRECONDITION_FAILED).entity(null).build();
		}
	}
	
	
}
