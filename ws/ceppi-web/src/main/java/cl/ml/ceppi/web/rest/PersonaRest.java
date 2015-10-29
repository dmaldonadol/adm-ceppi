/**
 * Copyright (c) MaldonadoLeón 2010-2015
 * Factoría de Desarrollo de Software
 * Santiago de Chile, Region Metropolitana
 */
package cl.ml.ceppi.web.rest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import cl.ml.ceppi.web.logic.EquipoLogic;


/**
 * ---------------------------------------------------------------------------
 * Maldonado León [ Administracion CEPPI ]
 * @author Juan Francisco Maldonado León - ( juan.maldonado.leon@gmail.com )
 * @date 29-10-2015
 * Description : 
 * ---------------------------------------------------------------------------
 */
@Path("/private/persona")
public class PersonaRest 
{
	
	private static final Logger LOGGER = Logger.getLogger(PersonaRest.class);
	private HttpServletRequest request;
	
	
	
	
	
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
	
	
	
	@GET
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAll() 
	{
		LOGGER.info("[ init - listar equipos ]");
		return EquipoLogic.findAll();
	}
	
	
	@GET
	@Path("/{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getById(@PathParam("id") int id) 
	{
		LOGGER.info("[ init - find by id equipos ]");
		return EquipoLogic.findById(id);
	}
	
	
	
	@GET
	@Path("/search/rut{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getByRut(@PathParam("rut") String rut) 
	{
		LOGGER.info("[ init - find by id equipos ]");
		return EquipoLogic.findById(0);
	}
	
	
	
}
