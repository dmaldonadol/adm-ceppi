package cl.ml.ceppi.web.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

import cl.ml.ceppi.core.model.menu.Menu;
import cl.ml.ceppi.core.model.perfil.Perfil;
import cl.ml.ceppi.web.logic.PerfilLogic;
import cl.ml.ceppi.web.util.Constantes;

/**
 * 
 * @author Maldonado Leon
 * 
 */

@Path("/private/perfil")
public class PerfilRest 
{
	private static final Logger LOGGER = Logger.getLogger(PerfilRest.class);

	@Context
	private HttpServletRequest request;

	public PerfilRest() {
	}
	
	@GET
	@Path("/listar")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listaPerfiles() 
	{		
		LOGGER.info("[Init] - lista perfiles");
		return PerfilLogic.listaPerfiles();
		
	}
	
	@GET
	@Path("/{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findById( @PathParam("id") int id ) 
	{		
		LOGGER.info("[Init] - lista perfiles");
		return PerfilLogic.findById(id);
		
	}
	
	@PUT	
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response save(Perfil perfil) 
	{		
		LOGGER.info("[ init - guardar perfil ]");
		return PerfilLogic.save(perfil);
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response update(Perfil perfil) 
	{		
		LOGGER.info("[ init - actualizar perfil ]");
		return PerfilLogic.update(perfil);
		
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteGastos(@PathParam("id") int id) 
	{		
		LOGGER.info("[ init - eliminar perfil ]");
		return PerfilLogic.delete(new Perfil(id));
		
	}
	
	@GET
	@Path("/opciones/menu")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response opcionesMenu( ) 
	{		
		LOGGER.info("[Init] - Opciones menu");
		return PerfilLogic.opcionesMenu();
	}
	
	@GET
	@Path("/accesos")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response accesos( ) 
	{		
		LOGGER.info("[Init] - Opciones menu perfil");
		List<Menu> accesos = (List<Menu>) request.getSession().getAttribute(Constantes.USER_ACCESS);
		return Response.status(Status.OK).entity(accesos).build();
		
	}
	

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

}
