/**
 * Copyright (c) MaldonadoLeón 2010-2015
 * Factoría de Desarrollo de Software
 * Santiago de Chile, Region Metropolitana
 */
package cl.ml.ceppi.web.logic;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import cl.ml.ceppi.core.facade.JugadorFacade;
import cl.ml.ceppi.core.facade.PersonaFacade;
import cl.ml.ceppi.core.model.equipo.Jugador;
import cl.ml.ceppi.core.model.persona.Persona;
import cl.ml.ceppi.web.locator.ServiceLocator;


/**
 * ---------------------------------------------------------------------------
 * Maldonado León [ Administracion CEPPI ]
 * @author Juan Francisco Maldonado León - ( juan.maldonado.leon@gmail.com )
 * @date 21-09-2015
 * Description : 
 * ---------------------------------------------------------------------------
 */
public class JugadorLogic 
{
	
	private static final Logger LOGGER = Logger.getLogger(JugadorLogic.class);
	private static JugadorFacade facade = (JugadorFacade) ServiceLocator.getInstance().getBean("jugadorFacade");
	private static PersonaFacade facadxe = (PersonaFacade) ServiceLocator.getInstance().getBean("personaFacade");
	
	
	
	
	

	/**
	 * Lista los equipos del sistema
	 * @return
	 */
	public static Response findAll() 
	{
		try 
		{			
			return Response.status(Response.Status.OK).entity( facade.listJugadores() ).build();
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
			return Response.status(Response.Status.OK).entity( facade.findJugadorById(id) ).build();
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
	public static Response save( Jugador jugador ) 
	{
		try 
		{	
			Persona persona = facadxe.findPersonaByRut(jugador.getPersona().getRut());
			if( null != persona )
			{
				jugador.setPersona(persona);
			}
//			else
//			{
//				Persona personax = facadxe.save(jugador.getPersona());
//				jugador.setPersona(personax);
//			}
			facade.save(jugador);
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
	public static Response update( Jugador jugador  ) 
	{
		try 
		{			
			facade.update(jugador);
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
	public static Response remove( Jugador jugador ) 
	{
		try 
		{			
			facade.delete(jugador);
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
	public static Response existPlayer( String rut ) 
	{
		try 
		{			
			Jugador jugador = facade.findJugadorByRut( rut );
			return Response.status(null !=  jugador ? Response.Status.OK : Response.Status.NOT_FOUND ).entity( jugador ).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al buscar el jugador. ", e);
			return Response.status(Response.Status.PRECONDITION_FAILED).entity(null).build();
		}
	}
	

}
