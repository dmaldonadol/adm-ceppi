package cl.ml.ceppi.web.logic;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

import cl.ml.ceppi.core.facade.CuotaFacade;
import cl.ml.ceppi.core.facade.SocioFacade;
import cl.ml.ceppi.core.model.cuota.Cuota;
import cl.ml.ceppi.core.model.cuota.RegistroCuota;
import cl.ml.ceppi.core.model.cuota.Valor;
import cl.ml.ceppi.core.model.cuota.ValorCuota;
import cl.ml.ceppi.core.model.estado.EstadoCuota;
import cl.ml.ceppi.core.model.socio.Socio;
import cl.ml.ceppi.core.model.tipo.CategoriaSocio;
import cl.ml.ceppi.core.model.tipo.TipoSocio;
import cl.ml.ceppi.core.model.usuario.Usuario;
import cl.ml.ceppi.web.locator.ServiceLocator;
import cl.ml.ceppi.web.util.Constantes;

/**
 * 
 * @author Maldonado Leon
 *
 */
public class CuotaLogic {
	
	private static final Logger LOGGER = Logger.getLogger(CuotaLogic.class);

	public CuotaLogic() {
	}

	/**
	 * Lista de ingresos
	 * @return
	 */
	public static Response listar() 
	{
		try 
		{
			CuotaFacade facade = (CuotaFacade) ServiceLocator.getInstance().getBean(Constantes.CUOTA_FACADE);
			List<Cuota> lista = facade.listaCuotas();
			return Response.status(Status.OK).entity(lista).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al obtener lista de cuotas", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * Guarda un ingreso
	 * @param obj
	 * @return
	 */
	public static Response save(Cuota obj) 
	{
		try 
		{
			CuotaFacade facade = (CuotaFacade) ServiceLocator.getInstance().getBean(Constantes.CUOTA_FACADE);
			facade.save(obj);
			return Response.status(Status.CREATED).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al guardar una cuota", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * Actualiza un ingreso
	 * @param obj
	 * @return
	 */
	public static Response update(Cuota obj) 
	{
		try 
		{
			CuotaFacade facade = (CuotaFacade) ServiceLocator.getInstance().getBean(Constantes.CUOTA_FACADE);
			facade.update(obj);
			return Response.status(Status.CREATED).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al actualizar una cuota", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * Elimina un ingreso
	 * @param id
	 * @return
	 */
	public static Response delete(int id) 
	{
		try 
		{
			CuotaFacade facade = (CuotaFacade) ServiceLocator.getInstance().getBean(Constantes.CUOTA_FACADE);
			facade.delete(new Cuota(id));
			return Response.status(Status.OK).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al eliminar una cuota", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * 
	 * @return
	 */
	public static Response listarValorCuota() 
	{
		try 
		{
			CuotaFacade facade = (CuotaFacade) ServiceLocator.getInstance().getBean(Constantes.CUOTA_FACADE);
			List<ValorCuota> lista = facade.listaValorCuotas();
			return Response.status(Status.OK).entity(lista).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al obtener lista de valor cuotas", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * 
	 * @param obj
	 * @return
	 */
	public static Response saveValorCuota(ValorCuota obj) {
		try 
		{
			CuotaFacade facade = (CuotaFacade) ServiceLocator.getInstance().getBean(Constantes.CUOTA_FACADE);
			facade.save(obj);
			return Response.status(Status.CREATED).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al guardar un valor cuota", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * 
	 * @param obj
	 * @return
	 */
	public static Response updateValorCuota(ValorCuota obj) {
		try 
		{
			CuotaFacade facade = (CuotaFacade) ServiceLocator.getInstance().getBean(Constantes.CUOTA_FACADE);
			facade.update(obj);
			return Response.status(Status.CREATED).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al actualizar un valor cuota", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public static Response deleteValorCuota(int id) {
		try 
		{
			CuotaFacade facade = (CuotaFacade) ServiceLocator.getInstance().getBean(Constantes.CUOTA_FACADE);
			facade.delete(new ValorCuota(id));
			return Response.status(Status.OK).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al elimina un valor cuota", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * 
	 * @param tipo
	 * @param categoria
	 * @return
	 */
	public static Response findValorCuota(int tipo, int categoria) {
		try 
		{
			ValorCuota obj = new ValorCuota(0, new TipoSocio(tipo), new CategoriaSocio(categoria));
			CuotaFacade facade = (CuotaFacade) ServiceLocator.getInstance().getBean(Constantes.CUOTA_FACADE);
			ValorCuota cuota = facade.findValorCuota(obj);
			
			if ( null != cuota )
			{
				return Response.status(Status.CREATED).build();
			}
			else
			{
				return Response.status(Status.OK).build();
			}
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al obtener lista de valor cuotas", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * 
	 * @param idsocio
	 * @param anio
	 * @return
	 */
	public static Response registroCuotas(int idsocio, int anio) 
	{
		try 
		{
			CuotaFacade facade = (CuotaFacade) ServiceLocator.getInstance().getBean(Constantes.CUOTA_FACADE);
			List<RegistroCuota> registro = facade.listaRegistroCuotas(idsocio, anio);
			
			return Response.status(Status.OK).entity(registro).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al obtener lista de registro de cuotas", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * 
	 * @param req
	 * @param anio
	 * @param mes
	 * @param idsocio
	 * @return
	 */
	public static Response pagar(HttpServletRequest req, String anio, String mes, int idsocio) 
	{
		try 
		{
			CuotaFacade facade = (CuotaFacade) ServiceLocator.getInstance().getBean(Constantes.CUOTA_FACADE);
			SocioFacade sociofacade = (SocioFacade) ServiceLocator.getInstance().getBean(Constantes.SOCIO_FACADE);
			
			Usuario usuario = (Usuario) req.getSession().getAttribute(Constantes.USER_SESSION);
			
			Socio socio = sociofacade.findSocioById(idsocio);
			ValorCuota valorcuota = facade.findValorCuota(new ValorCuota(0, socio.getTipoSocio(), socio.getCategoriaSocio()));
			Valor valor = new Valor(0, valorcuota.getValor(), valorcuota.getTipoSocio(), valorcuota.getCategoriaSocio());
			
			Cuota cuota = new Cuota(valor, anio, mes, socio);
			
			RegistroCuota registroCuota = new RegistroCuota(cuota, usuario, EstadoCuota.PAGADA, new Date());
			facade.save(registroCuota);
			
			return Response.status(Status.CREATED).entity(registroCuota).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al obtener lista de registro de cuotas", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	/**
	 * 
	 * @param anio
	 * @param mes
	 * @param idsocio
	 * @return
	 */
	public static Response verRegistro(String anio, String mes, int idsocio) 
	{
		try 
		{
			CuotaFacade facade = (CuotaFacade) ServiceLocator.getInstance().getBean(Constantes.CUOTA_FACADE);
			RegistroCuota registroCuota = facade.findRegistroCuota(anio, mes, idsocio);
			
			return Response.status(Status.OK).entity(registroCuota).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al obtener lista de registro de cuotas", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

}
