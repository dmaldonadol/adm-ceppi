package cl.ml.ceppi.web.rest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import cl.ml.ceppi.web.logic.PerfilLogic;

/**
 * 
 * @author Maldonado Le�n
 * 
 */

@Path("/private/perfil")
public class PerfilRest 
{
	private static final Logger LOGGER = Logger.getLogger(PerfilRest.class);

	private HttpServletRequest request;

	public PerfilRest() {
		// TODO Auto-generated constructor stub
	}
	
	@GET
	@Path("/listar")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listaBitacoraTelefonos() 
	{		
		LOGGER.info("[Init] - lista perfiles");
		return PerfilLogic.listaPerfiles();
		
	}
	

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

}
