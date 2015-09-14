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

import cl.ml.ceppi.core.model.socio.Socio;
import cl.ml.ceppi.web.logic.SocioLogic;

/**
 * 
 * @author Maldonado Leon
 * 
 */

@Path("/private/socio")
public class SocioRest 
{
	private static final Logger LOGGER = Logger.getLogger(SocioRest.class);

	private HttpServletRequest request;

	public SocioRest() {
		// TODO Auto-generated constructor stub
	}
	
	@GET
	@Path("/lista")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response lista() 
	{
		LOGGER.info("[ init - listar ingresos ]");
		return SocioLogic.lista();
	}
	
	
	@PUT
	@Path("/save")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response save(Socio obj) 
	{		
		LOGGER.info("[ init - guardar Socio ]");
		return SocioLogic.save(obj);
	}
	
	@PUT
	@Path("/update")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response update(Socio obj) 
	{		
		LOGGER.info("[ init - actualizar Socio ]");
		return SocioLogic.update(obj);
		
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response delete(@PathParam("id") int id) 
	{		
		LOGGER.info("[ init - eliminar Socio ]");
		return SocioLogic.delete(id);
		
	}
	
	@GET
	@Path("/byRut/{rut}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response byRut(@PathParam("rut") int rut) 
	{		
		LOGGER.info("[ init - buscar Socio por rut ]");
		return SocioLogic.byRut(rut);
		
	}
	

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

}
