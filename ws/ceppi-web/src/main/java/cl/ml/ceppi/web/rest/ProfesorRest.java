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

import cl.ml.ceppi.core.model.equipo.Profesor;
import cl.ml.ceppi.web.logic.ProfesorLogic;


/**
 * ---------------------------------------------------------------------------
 * Maldonado Leon [ Administracion CEPPI ]
 * @author Juan Francisco Maldonado Leon - ( juan.maldonado.leon@gmail.com )
 * @date 14-09-2015
 * Description : 
 * ---------------------------------------------------------------------------
 */
@Path("/private/profesor")
public class ProfesorRest 
{
	private static final Logger LOGGER = Logger.getLogger(ProfesorRest.class);
	private HttpServletRequest request;
	
	
	
	@GET
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findAll() 
	{
		LOGGER.info("[ init - listar profesores ]");
		return ProfesorLogic.findAll();
	}
	
	
	@GET
	@Path("/{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getProfesorById(@PathParam("id") int id) 
	{
		LOGGER.info("[ init - find by id profesor ]");
		return ProfesorLogic.findById(id);
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response delete(@PathParam("id") int id) 
	{
		LOGGER.info("[ init - delete profesor ]");
		return ProfesorLogic.delete(id);
	}
	
	
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response save(Profesor profesor) 
	{
		LOGGER.info("[ init - save profesor ]");
		return ProfesorLogic.save(profesor);
	}
	
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response update(Profesor profesor) 
	{
		LOGGER.info("[ init - update profesor ]");
		return ProfesorLogic.update(profesor);
	}
	
	@GET
	@Path("/byRut/{rut}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getProfesorByRut(@PathParam("rut") String rut) 
	{
		LOGGER.info("[ init - find by rut profesor ]");
		return ProfesorLogic.findByRut(rut);
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
