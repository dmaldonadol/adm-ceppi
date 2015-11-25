/**
 * Copyright (c) MaldonadoLeón 2010-2015
 * Factoría de Desarrollo de Software
 * Santiago de Chile, Region Metropolitana
 */
package cl.ml.ceppi.web.rest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import cl.ml.ceppi.core.model.equipo.Equipo;
import cl.ml.ceppi.core.model.equipo.Jugador;
import cl.ml.ceppi.web.logic.EquipoLogic;


/**
 * ---------------------------------------------------------------------------
 * Maldonado León [ Administracion CEPPI ]
 * @author Juan Francisco Maldonado León - ( juan.maldonado.leon@gmail.com )
 * @date 14-09-2015
 * Description : 
 * ---------------------------------------------------------------------------
 */
@Path("/private/equipo")
public class EquipoRest 
{
	private static final Logger LOGGER = Logger.getLogger(EquipoRest.class);
	private HttpServletRequest request;
	
	
	
	@GET
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAllTeams() 
	{
		LOGGER.info("[ init - listar equipos ]");
		return EquipoLogic.findAll();
	}
	
	
	@GET
	@Path("/{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getTeamById(@PathParam("id") int id) 
	{
		return EquipoLogic.findById(id);
	}
	
	
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response save(Equipo equipo) 
	{
		LOGGER.info("[ init - save equipos ]");
		return EquipoLogic.save(equipo);
	}
	
	
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/{idEquipo}/jugadores/")
	public Response addPlayer( @PathParam("idEquipo") int idEquipo, Jugador jugador ) 
	{
		LOGGER.info("[ init - save equipos ]");
		return EquipoLogic.addPlayer( new Equipo( idEquipo ), jugador);
	}
	
	
	@DELETE
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/{idEquipo}/jugadores/{idJugador}")
	public Response removePlayer( @PathParam("idEquipo") int idEquipo,@PathParam("idJugador") int idJugador ) 
	{
		LOGGER.info("[ init - save equipos ]");
		Jugador jugador =  new Jugador();
		jugador.setOid(idJugador);
		return EquipoLogic.removePlayer(new Equipo( idEquipo ), jugador );
	}
	
	
	@DELETE
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response remove( Equipo equipo ) 
	{
		LOGGER.info("[ init - save equipos ]");
		return EquipoLogic.remove(equipo);
	}
	
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response update(Equipo equipo) 
	{
		LOGGER.info("[ init - update equipos ]");
		return EquipoLogic.update(equipo);
	}
	
	
	/**
	 * @return the request
	 */
	public HttpServletRequest getRequest() {
		return request;
	}
	/**
	 * @param request the request to set
	 */
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	

}
