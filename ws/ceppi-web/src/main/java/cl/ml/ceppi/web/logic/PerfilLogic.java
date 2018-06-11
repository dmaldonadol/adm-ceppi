package cl.ml.ceppi.web.logic;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import cl.ml.ceppi.core.facade.PerfilFacade;
import cl.ml.ceppi.core.model.acceso.Acceso;
import cl.ml.ceppi.core.model.menu.Menu;
import cl.ml.ceppi.core.model.menu.MenuCompuesto;
import cl.ml.ceppi.core.model.menu.Permiso;
import cl.ml.ceppi.core.model.perfil.Perfil;
import cl.ml.ceppi.web.locator.ServiceLocator;
import cl.ml.ceppi.web.util.Constantes;

/**
 * 
 * @author Maldonado Le�n
 *
 */
public class PerfilLogic {
	
	private static final Logger LOGGER = Logger.getLogger(PerfilLogic.class);

	public PerfilLogic() {
	}

	/**
	 * Lista los perfiles del sistema
	 * @return
	 */
	public static Response listaPerfiles() 
	{
		try 
		{
			PerfilFacade perfilFacade = (PerfilFacade) ServiceLocator.getInstance().getBean("perfilFacade");
			return Response.status(Response.Status.OK).entity(perfilFacade.listPerfil()).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al obtener la lista de Perfiles. ", e);
			return Response.status(Response.Status.PRECONDITION_FAILED).entity(null).build();
		}
	}
	
	
	/**
	 * Lista los perfiles del sistema
	 * @return
	 */
	public static Response findById( int id ) 
	{
		try 
		{
			PerfilFacade perfilFacade = (PerfilFacade) ServiceLocator.getInstance().getBean("perfilFacade");
			Perfil perfil = perfilFacade.findPerfilById(id);
			List<Acceso> accesos = perfilFacade.listaAccesoByIdPerfil(id);
			List<String> permisos = new ArrayList<String>();
			for (Acceso acceso : accesos) 
			{
				permisos.add(acceso.getItemsMenu().getCodigo());
			}
			perfil.setPermisos(permisos);
			
			return Response.status(Response.Status.OK).entity(perfil).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al obtener la lista de Perfiles. ", e);
			return Response.status(Response.Status.PRECONDITION_FAILED).entity(null).build();
		}
	}
	
	/**
	 * Guarda un perfil
	 * @param obj
	 * @return
	 */
	public static Response save(Perfil obj) 
	{
		try 
		{
			PerfilFacade facade = (PerfilFacade) ServiceLocator.getInstance().getBean(Constantes.PERFIL_FACADE);
						
			facade.save(obj);

			Acceso acceso = null;
			for (String codigo : obj.getPermisos()) 
			{
				Menu menu = facade.findMenuByCodigo(codigo);
				acceso = new Acceso();
				acceso.setItemsMenu(menu);
				acceso.setPerfil(obj);
				acceso.setPermiso(Permiso.E);
				
				facade.saveAcceso(acceso);
			}
			
			return Response.status(Status.OK).entity(null).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al guardar un perfil.", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
	}

	/**
	 * Actualiza un perfil
	 * @param obj
	 * @return
	 */
	public static Response update(Perfil obj) 
	{
		try 
		{
			PerfilFacade facade = (PerfilFacade) ServiceLocator.getInstance().getBean(Constantes.PERFIL_FACADE);
			
			List<Acceso> accesosOld = facade.listaAccesoByIdPerfil(obj.getOid());
			
			for (Acceso acceso : accesosOld) 
			{
				facade.delete(acceso);
			}
			
			Acceso acceso = null;
			for (String codigo : obj.getPermisos()) 
			{
				Menu menu = facade.findMenuByCodigo(codigo);
				acceso = new Acceso();
				acceso.setItemsMenu(menu);
				acceso.setPerfil(obj);
				acceso.setPermiso(Permiso.E);
				
				facade.saveAcceso(acceso);
			}
			
			facade.update(obj);
			return Response.status(Status.OK).entity(null).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al actualizar un perfil.", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
	}

	/**
	 * Elimina un perfil
	 * @param obj
	 * @return
	 */
	public static Response delete(Perfil obj) 
	{
		try 
		{
			PerfilFacade facade = (PerfilFacade) ServiceLocator.getInstance().getBean(Constantes.PERFIL_FACADE);
			
			facade.delete(obj);
			return Response.status(Status.OK).entity(null).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al eliminar un perfil.", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
	}

	/**
	 * 
	 * @return
	 */
	public static Response opcionesMenu() 
	{
		try 
		{
			PerfilFacade facade = (PerfilFacade) ServiceLocator.getInstance().getBean(Constantes.PERFIL_FACADE);
			List<MenuCompuesto> lista = facade.listMenu();
			
			for (MenuCompuesto menuCompuesto : lista) {
				for (Menu item :menuCompuesto.getItemMenu()) {
					item.setMenu(null);
				}
			}
			
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(lista);
			return Response.status(Status.OK).entity(json).build();
		}
		catch (Exception e) 
		{
			LOGGER.error("Error al obtener opciones de menu.", e);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(null).build();
		}
	}

}
