package cl.ml.ceppi.web.rest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import cl.ml.ceppi.core.model.ingreso.Ingreso;
import cl.ml.ceppi.web.logic.IngresoLogic;

/**
 * 
 * @author Maldonado Leon
 * 
 */

@Path("/private/ingreso")
public class IngresoRest 
{
	private static final Logger LOGGER = Logger.getLogger(IngresoRest.class);

	private HttpServletRequest request;

	public IngresoRest() {
		// TODO Auto-generated constructor stub
	}
	
	@GET
	@Path("/lista")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listaIngresos() 
	{
		LOGGER.info("[ init - listar ingresos ]");
		return IngresoLogic.listaIngresos();
	}
	
	
	@PUT
	@Path("/save")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response save(Ingreso obj) 
	{		
		LOGGER.info("[ init - guardar ingreso ]");
		return IngresoLogic.save(obj);
	}
	
	@PUT
	@Path("/update")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response update(Ingreso obj) 
	{		
		LOGGER.info("[ init - actualizar ingreso ]");
		return IngresoLogic.update(obj);
		
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response delete(@PathParam("id") int id) 
	{		
		LOGGER.info("[ init - eliminar ingreso ]");
		return IngresoLogic.delete(id);
		
	}
	

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

}
