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

import cl.ml.ceppi.core.model.equipo.Jugador;
import cl.ml.ceppi.web.logic.JugadorLogic;


/**
 * ---------------------------------------------------------------------------
 * Maldonado León [ Administracion CEPPI ]
 * @author Juan Francisco Maldonado León - ( juan.maldonado.leon@gmail.com )
 * @date 29-10-2015
 * Description : 
 * ---------------------------------------------------------------------------
 */
@Path("/private/jugador")
public class JugadorRest 
{
	
	private static final Logger LOGGER = Logger.getLogger(JugadorRest.class);
	private HttpServletRequest request;
	
	
	@GET
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/search/rut/{rut}")
	public Response existPlayer(@PathParam("rut")  String rut ) 
	{
		return JugadorLogic.existPlayer(rut);
	}
	
	
	@GET
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAllPlayers() 
	{
		return JugadorLogic.findAll();
	}
	
	
	@GET
	@Path("/{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getPlayerById(@PathParam("id") int id) 
	{
		return JugadorLogic.findById(id);
	}
	
	
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response save(Jugador jugador) 
	{
		return JugadorLogic.save( jugador );
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response update( Jugador jugador ) 
	{
		return JugadorLogic.update( jugador );
	}
	
	
	@DELETE
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response remove( Jugador jugador ) 
	{
		return JugadorLogic.remove(jugador);
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
