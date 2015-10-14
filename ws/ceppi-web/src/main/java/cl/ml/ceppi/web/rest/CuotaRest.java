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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import cl.ml.ceppi.core.model.cuota.Cuota;
import cl.ml.ceppi.core.model.cuota.ValorCuota;
import cl.ml.ceppi.web.logic.CuotaLogic;

/**
 * 
 * @author Maldonado Leon
 * 
 */

@Path("/private/cuota")
public class CuotaRest 
{
	private static final Logger LOGGER = Logger.getLogger(CuotaRest.class);
	@Context
	private HttpServletRequest request;

	public CuotaRest() {
		
	}
	
	@GET
	@Path("/lista")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listar() 
	{
		LOGGER.info("[ init - listar cuota ]");
		return CuotaLogic.listar();
	}
	
	@GET
	@Path("/listaValorCuota")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listarValorCuota() 
	{
		LOGGER.info("[ init - listar valor cuota ]");
		return CuotaLogic.listarValorCuota();
	}
	
	
	@PUT
	@Path("/save")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response save(Cuota obj) 
	{		
		LOGGER.info("[ init - guardar cuota ]");
		return CuotaLogic.save(obj);
	}
	
	@PUT
	@Path("/saveValorCuota")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response saveValorCuota(ValorCuota obj) 
	{		
		LOGGER.info("[ init - guardar valor cuota ]");
		return CuotaLogic.saveValorCuota(obj);
	}
	
	@POST
	@Path("/update")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response update(Cuota obj) 
	{		
		LOGGER.info("[ init - actualizar cuota ]");
		return CuotaLogic.update(obj);
		
	}
	
	@POST
	@Path("/updateValorCuota")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response updateValorCuota(ValorCuota obj) 
	{		
		LOGGER.info("[ init - actualizar cuota ]");
		return CuotaLogic.updateValorCuota(obj);
		
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response delete(@PathParam("id") int id) 
	{		
		LOGGER.info("[ init - eliminar cuota ]");
		return CuotaLogic.delete(id);
		
	}
	
	@DELETE
	@Path("/deleteValorCuota/{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteValorCuota(@PathParam("id") int id) 
	{		
		LOGGER.info("[ init - eliminar valor cuota ]");
		return CuotaLogic.deleteValorCuota(id);
	}
	
	@GET
	@Path("/findValorCuota/{tipo}/{categoria}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findValorCuota(@PathParam("tipo") int tipo, @PathParam("categoria") int categoria) 
	{
		LOGGER.info("[ init - buscar valor cuota ]");
		return CuotaLogic.findValorCuota(tipo, categoria);
	}
	
	@GET
	@Path("/registroCuotas/{idsocio}/{anio}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response registroCuotas(@PathParam("idsocio") int idsocio, @PathParam("anio") int anio) 
	{
		LOGGER.info("[ init - registro de cuotas ]");
		return CuotaLogic.registroCuotas(idsocio, anio);
	}
	
	@PUT
	@Path("/pagar/{anio}/{mes}/{socio}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response pagar(@PathParam("anio") String anio, @PathParam("mes") String mes, @PathParam("socio") int idsocio) 
	{		
		LOGGER.info("[ init - guardar cuota ]");
		return CuotaLogic.pagar(getRequest(), anio, mes, idsocio);
	}
	
	@GET
	@Path("/verRegistro/{anio}/{mes}/{socio}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response verRegistro(@PathParam("anio") String anio, @PathParam("mes") String mes, @PathParam("socio") int idsocio) 
	{
		LOGGER.info("[ init - registro de cuotas ]");
		return CuotaLogic.verRegistro(anio, mes, idsocio);
	}
	
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

}
