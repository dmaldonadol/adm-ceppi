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

import cl.ml.ceppi.core.model.gasto.Gasto;
import cl.ml.ceppi.web.logic.GastosLogic;

/**
 * 
 * @author Maldonado Leon
 * 
 */

@Path("/private/gasto")
public class GastoRest 
{
	private static final Logger LOGGER = Logger.getLogger(GastoRest.class);

	private HttpServletRequest request;

	public GastoRest() {
		
	}
	
	@GET
	@Path("/lista")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listar() 
	{
		LOGGER.info("[ init - listar gastos ]");
		return GastosLogic.listar();
	}
	
	
	@PUT
	@Path("/save")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response save(Gasto obj) 
	{		
		LOGGER.info("[ init - guardar gasto ]");
		return GastosLogic.save(obj);
	}
	
	@PUT
	@Path("/update")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response update(Gasto obj) 
	{		
		LOGGER.info("[ init - actualizar gasto ]");
		return GastosLogic.update(obj);
		
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response delete(@PathParam("id") int id) 
	{		
		LOGGER.info("[ init - eliminar gasto ]");
		return GastosLogic.delete(id);
		
	}
	

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

}
