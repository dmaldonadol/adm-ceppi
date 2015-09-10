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

import cl.ml.ceppi.web.logic.TipoLogic;
import cl.ml.ceppi.web.pojo.TipoPojo;

/**
 * 
 * @author Maldonado Leon
 * 
 */

@Path("/private/tipo")
public class TipoRest 
{
	private HttpServletRequest request;

	public TipoRest() {
		// TODO Auto-generated constructor stub
	}
	
	@GET
	@Path("/gasto")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listaGastos() 
	{		
		return TipoLogic.listaGastos();
		
	}
	
	@GET
	@Path("/socio")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listaSocios() 
	{		
		return TipoLogic.listaSocios();
		
	}
	
	@GET
	@Path("/categoria")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listaCategorias() 
	{		
		return TipoLogic.listaCategorias();
		
	}
	
	@GET
	@Path("/profesion")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listaProfesion() 
	{		
		return TipoLogic.listaProfesion();
		
	}
	
	@GET
	@Path("/centroCosto")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listaCentroCosto() 
	{		
		return TipoLogic.listaCentroCosto();
		
	}
	
	@GET
	@Path("/ingreso")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listaTipoIngreso() 
	{		
		return TipoLogic.listaTipoIngreso();
		
	}
	
	@POST
	@Path("/saveGasto")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response saveGastos(TipoPojo pojo) 
	{		
		return TipoLogic.saveGasto(pojo);
		
	}
	
	@PUT
	@Path("/socio")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response saveSocios(TipoPojo pojo) 
	{		
		return TipoLogic.saveSocio(pojo);
		
	}
	
	@PUT
	@Path("/categoria")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response saveCategoria(TipoPojo pojo) 
	{		
		return TipoLogic.saveCategoria(pojo);
		
	}
	
	@PUT
	@Path("/profesion")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response saveProfesion(TipoPojo pojo) 
	{		
		return TipoLogic.saveProfesion(pojo);
		
	}
	
	@PUT
	@Path("/centroCosto")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response saveCentroCosto(TipoPojo pojo) 
	{		
		return TipoLogic.saveCentroCosto(pojo);
		
	}
	
	@POST
	@Path("/gasto")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response updateGastos(TipoPojo pojo) 
	{		
		return TipoLogic.updateGasto(pojo);
		
	}
	
	@POST
	@Path("/socio")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response updateSocios(TipoPojo pojo) 
	{		
		return TipoLogic.updateSocio(pojo);
		
	}
	
	@POST
	@Path("/categoria")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response updateCategoria(TipoPojo pojo) 
	{		
		return TipoLogic.updateCategoria(pojo);
		
	}
	
	@POST
	@Path("/profesion")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response updateProfesion(TipoPojo pojo) 
	{		
		return TipoLogic.updateProfesion(pojo);
		
	}
	
	@POST
	@Path("/centroCosto")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response updateCentroCosto(TipoPojo pojo) 
	{		
		return TipoLogic.updateCentroCosto(pojo);
		
	}
	
	@DELETE
	@Path("/gasto/{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteGastos(@PathParam("id") int id) 
	{		
		return TipoLogic.deleteGasto(new TipoPojo(id));
		
	}
	
	@DELETE
	@Path("/socio/{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteSocios( @PathParam("id") int id) 
	{		
		return TipoLogic.deleteSocio( new TipoPojo(id) );
		
	}
	
	@DELETE
	@Path("/categoria/{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteCategoria(@PathParam("id") int id) 
	{		
		return TipoLogic.deleteCategoria(new TipoPojo(id));
		
	}
	
	@DELETE
	@Path("/profesion/{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteProfesion(@PathParam("id") int id) 
	{		
		return TipoLogic.deleteProfesion(new TipoPojo(id));
		
	}
	
	@DELETE
	@Path("/centroCosto/{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteCentroCosto(@PathParam("id") int id) 
	{		
		return TipoLogic.deleteCentroCosto(new TipoPojo(id));
		
	}
	
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
}
