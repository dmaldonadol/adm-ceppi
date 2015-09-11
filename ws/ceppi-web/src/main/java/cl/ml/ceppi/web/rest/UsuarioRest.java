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

import cl.ml.ceppi.core.model.usuario.Usuario;
import cl.ml.ceppi.web.logic.UsuarioLogic;

/**
 * 
 * @author Maldonado Leon
 * 
 */

@Path("/private/usuario")
public class UsuarioRest 
{
	private static final Logger LOGGER = Logger.getLogger(UsuarioRest.class);

	private HttpServletRequest request;

	public UsuarioRest() {
		// TODO Auto-generated constructor stub
	}
	
	@GET
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listaUsuario() 
	{
		LOGGER.info("[ init - listar usuarios ]");
		return UsuarioLogic.listaUsuarios();
	}
	
	
	@GET
	@Path("/{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getUsuario(@PathParam("id") int id) 
	{
		LOGGER.info("[ init - obtener usuario por id ]");
		return UsuarioLogic.findUsuarioById(id);
	}
	
	
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response save(Usuario usuario) 
	{		
		LOGGER.info("[ init - guardar usuarios ]");
		return UsuarioLogic.save(usuario);
	}
	
	@PUT
	@Path("/update")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response update(Usuario usuario) 
	{		
		LOGGER.info("[ init - actualizar usuarios ]");
		return UsuarioLogic.update(usuario);
		
	}
	
	@DELETE
	@Path("/delete")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteGastos(Usuario usuario) 
	{		
		LOGGER.info("[ init - eliminar usuarios ]");
		return UsuarioLogic.delete(usuario);
		
	}
	

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

}
