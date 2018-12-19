package cl.ml.ceppi.test;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cl.ml.ceppi.core.facade.PerfilFacade;
import cl.ml.ceppi.core.facade.PersonaFacade;
import cl.ml.ceppi.core.facade.TipoFacade;
import cl.ml.ceppi.core.facade.UsuarioFacade;
import cl.ml.ceppi.core.model.acceso.Acceso;
import cl.ml.ceppi.core.model.estado.Genero;
import cl.ml.ceppi.core.model.menu.Menu;
import cl.ml.ceppi.core.model.menu.MenuCompuesto;
import cl.ml.ceppi.core.model.menu.MenuSimple;
import cl.ml.ceppi.core.model.menu.Permiso;
import cl.ml.ceppi.core.model.perfil.Perfil;
import cl.ml.ceppi.core.model.persona.Persona;
import cl.ml.ceppi.core.model.tipo.TipoGasto;
import cl.ml.ceppi.core.model.tipo.TipoIngreso;
import cl.ml.ceppi.core.model.tipo.TipoSocio;
import cl.ml.ceppi.core.model.usuario.Usuario;
import cl.ml.ceppi.core.util.Crypt;

public class InitData {

	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		try 
		{
			ApplicationContext appContext = new ClassPathXmlApplicationContext("ceppi-beanLocations-admin.xml");
			TipoFacade tipoFacade = (TipoFacade) appContext.getBean("tipoFacade");
			PersonaFacade personaFacade = (PersonaFacade) appContext.getBean("personaFacade");
			UsuarioFacade usuarioFacade = (UsuarioFacade) appContext.getBean("usuarioFacade");
			PerfilFacade perfilFacade = (PerfilFacade) appContext.getBean("perfilFacade");
			
//			List<Acceso> lista = perfilFacade.listaAccesoByIdPerfil(1);
//			List<MenuCompuesto> menu = perfilFacade.listMenu();
//			
//			for (MenuCompuesto acceso : menu) {
//				System.out.println(acceso.getNombre());
//				for (Menu menuCompuesto : acceso.getItemMenu()) {
//					System.out.println(">> " + menuCompuesto.getNombre());
//				}
//			}
			
			TipoSocio tipoSocio = new TipoSocio("0001", "ACTIVO", "ACTIVO");
			tipoFacade.save(tipoSocio);
			
			Persona persona = new Persona();
			persona.setNombre("David");
			persona.setApellidoPaterno("Maldonado");
			persona.setApellidoMaterno("Leon");
			persona.setRut("16020016");
			persona.setDv("2");
			persona.setEmail("maldonadoleon@gmail.com");
			persona.setGenero(Genero.MASCULINO);
			persona.setEstatura("170");
			persona.setPeso("65");
			persona.setFechaNacimiento(new Date());
			personaFacade.save(persona);
			
			/* MENU ADMINISTRACION */
			MenuCompuesto menuCompuesto = new MenuCompuesto();
			menuCompuesto.setCodigo("0001");
			menuCompuesto.setNombre("Administración");
			menuCompuesto.setOrden("1");
			menuCompuesto.setPath("");
			
			MenuSimple menuUsuario = new MenuSimple();
			menuUsuario.setCodigo("0011");
			menuUsuario.setNombre("Usuario");
			menuUsuario.setOrden("1");
			menuUsuario.setPath("inicio#/administracion/usuarios");
			menuUsuario.setMenu(menuCompuesto);

			MenuSimple menuPerfil = new MenuSimple();
			menuPerfil.setCodigo("0012");
			menuPerfil.setNombre("Perfil");
			menuPerfil.setOrden("2");
			menuPerfil.setPath("inicio#/administracion/perfiles");
			menuPerfil.setMenu(menuCompuesto);
			
			MenuSimple menuPersona = new MenuSimple();
			menuPersona.setCodigo("0013");
			menuPersona.setNombre("Socio");
			menuPersona.setOrden("3");
			menuPersona.setPath("inicio#/administracion/socios");
			menuPersona.setMenu(menuCompuesto);

			menuCompuesto.getItemMenu().add(menuPersona);
			menuCompuesto.getItemMenu().add(menuUsuario);
			menuCompuesto.getItemMenu().add(menuPerfil);

			perfilFacade.saveMenu(menuCompuesto);
			
			/* MENU PLANTEL */
			menuCompuesto = new MenuCompuesto();
			menuCompuesto.setCodigo("0002");
			menuCompuesto.setNombre("Plantel");
			menuCompuesto.setOrden("2");
			menuCompuesto.setPath("");
			
			menuPersona = new MenuSimple();
			menuPersona.setCodigo("0021");
			menuPersona.setNombre("Equipos");
			menuPersona.setOrden("1");
			menuPersona.setPath("inicio#/mantenedores/equipos");
			menuPersona.setMenu(menuCompuesto);
			
			menuUsuario = new MenuSimple();
			menuUsuario.setCodigo("0022");
			menuUsuario.setNombre("Profesores");
			menuUsuario.setOrden("2");
			menuUsuario.setPath("inicio#/mantenedores/profesores");
			menuUsuario.setMenu(menuCompuesto);

			menuPerfil = new MenuSimple();
			menuPerfil.setCodigo("0023");
			menuPerfil.setNombre("Jugadores");
			menuPerfil.setOrden("3");
			menuPerfil.setPath("inicio#/mantenedores/jugadores");
			menuPerfil.setMenu(menuCompuesto);

			menuCompuesto.getItemMenu().add(menuPersona);
			menuCompuesto.getItemMenu().add(menuUsuario);
			menuCompuesto.getItemMenu().add(menuPerfil);

			perfilFacade.saveMenu(menuCompuesto);
			
			/* MENU MANTENEDORES */
			menuCompuesto = new MenuCompuesto();
			menuCompuesto.setCodigo("0003");
			menuCompuesto.setNombre("Mantenedores");
			menuCompuesto.setOrden("3");
			menuCompuesto.setPath("");
			
			MenuSimple subMenu2 = new MenuSimple();
			subMenu2.setCodigo("0031");
			subMenu2.setNombre("Categoria Socio");
			subMenu2.setOrden("1");
			subMenu2.setPath("inicio#/mantenedor/categoria");
			subMenu2.setMenu(menuCompuesto);
			
			MenuSimple subMenu3 = new MenuSimple();
			subMenu3.setCodigo("0032");
			subMenu3.setNombre("Centro de Costo");
			subMenu3.setOrden("2");
			subMenu3.setPath("inicio#/mantenedor/centrocosto");
			subMenu3.setMenu(menuCompuesto);
			
			MenuSimple subMenu4 = new MenuSimple();
			subMenu4.setCodigo("0033");
			subMenu4.setNombre("Profesión");
			subMenu4.setOrden("3");
			subMenu4.setPath("inicio#/mantenedor/profesion");
			subMenu4.setMenu(menuCompuesto);
			
			MenuSimple subMenu5 = new MenuSimple();
			subMenu5.setCodigo("0034");
			subMenu5.setNombre("Tipo Gasto");
			subMenu5.setOrden("4");
			subMenu5.setPath("inicio#/mantenedor/tipogasto");
			subMenu5.setMenu(menuCompuesto);
			
			MenuSimple subMenu7 = new MenuSimple();
			subMenu7.setCodigo("0035");
			subMenu7.setNombre("Tipo Ingreso");
			subMenu7.setOrden("5");
			subMenu7.setPath("inicio#/mantenedor/tipoingreso");
			subMenu7.setMenu(menuCompuesto);
			
			MenuSimple subMenu1 = new MenuSimple();
			subMenu1.setCodigo("0036");
			subMenu1.setNombre("Tipo Socio");
			subMenu1.setOrden("6");
			subMenu1.setPath("inicio#/mantenedor/tiposocio");
			subMenu1.setMenu(menuCompuesto);
			
			MenuSimple subMenu6 = new MenuSimple();
			subMenu6.setCodigo("0037");
			subMenu6.setNombre("Tipo Profesor");
			subMenu6.setOrden("7");
			subMenu6.setPath("inicio#/mantenedor/tipoprofesor");
			subMenu6.setMenu(menuCompuesto);
			
			menuCompuesto.getItemMenu().add(subMenu1);
			menuCompuesto.getItemMenu().add(subMenu2);
			menuCompuesto.getItemMenu().add(subMenu3);
			menuCompuesto.getItemMenu().add(subMenu4);
			menuCompuesto.getItemMenu().add(subMenu5);
			menuCompuesto.getItemMenu().add(subMenu6);
			menuCompuesto.getItemMenu().add(subMenu7);

			perfilFacade.saveMenu(menuCompuesto);
			
			/* MENU FINANZAS */
			menuCompuesto = new MenuCompuesto();
			menuCompuesto.setCodigo("0004");
			menuCompuesto.setNombre("Finanzas");
			menuCompuesto.setOrden("3");
			menuCompuesto.setPath("");
			
			subMenu1 = new MenuSimple();
			subMenu1.setCodigo("0041");
			subMenu1.setNombre("Pago de Cuotas");
			subMenu1.setOrden("1");
			subMenu1.setPath("inicio#/ingreso/cuotas");
			subMenu1.setMenu(menuCompuesto);
			
			subMenu2 = new MenuSimple();
			subMenu2.setCodigo("0042");
			subMenu2.setNombre("Valor Cuota");
			subMenu2.setOrden("2");
			subMenu2.setPath("inicio#/ingreso/valorCuota");
			subMenu2.setMenu(menuCompuesto);
			
			subMenu3 = new MenuSimple();
			subMenu3.setCodigo("0043");
			subMenu3.setNombre("Otros Ingresos");
			subMenu3.setOrden("3");
			subMenu3.setPath("inicio#/ingreso/otros");
			subMenu3.setMenu(menuCompuesto);
			
			subMenu4 = new MenuSimple();
			subMenu4.setCodigo("0044");
			subMenu4.setNombre("Gastos");
			subMenu4.setOrden("4");
			subMenu4.setPath("inicio#/ingreso/gastos");
			subMenu4.setMenu(menuCompuesto);

			menuCompuesto.getItemMenu().add(subMenu1);
			menuCompuesto.getItemMenu().add(subMenu2);
			menuCompuesto.getItemMenu().add(subMenu3);
			menuCompuesto.getItemMenu().add(subMenu4);

			perfilFacade.saveMenu(menuCompuesto);
		
			/* MENU REPORTES */
			menuCompuesto = new MenuCompuesto();
			menuCompuesto.setCodigo("0005");
			menuCompuesto.setNombre("Reportes");
			menuCompuesto.setOrden("5");
			menuCompuesto.setPath("");
			
			subMenu1 = new MenuSimple();
			subMenu1.setCodigo("0051");
			subMenu1.setNombre("Reporte 1");
			subMenu1.setOrden("1");
			subMenu1.setPath("#");
			subMenu1.setMenu(menuCompuesto);
			
			subMenu2 = new MenuSimple();
			subMenu2.setCodigo("0052");
			subMenu2.setNombre("Reporte 2");
			subMenu2.setOrden("2");
			subMenu2.setPath("#");
			subMenu2.setMenu(menuCompuesto);
			
			subMenu3 = new MenuSimple();
			subMenu3.setCodigo("0053");
			subMenu3.setNombre("Reporte 3");
			subMenu3.setOrden("3");
			subMenu3.setPath("#");
			subMenu3.setMenu(menuCompuesto);

			menuCompuesto.getItemMenu().add(subMenu1);
			menuCompuesto.getItemMenu().add(subMenu2);
			menuCompuesto.getItemMenu().add(subMenu3);

			perfilFacade.saveMenu(menuCompuesto);
			
//			/* PERFILES */
			Perfil perfil = new Perfil();
			perfil.setCodigo("0001");
			perfil.setNombre("Administrador");
			perfil.setDescripcion("Administrador del sistema");
			perfilFacade.save(perfil);
			
			Usuario usuario = new Usuario();
			usuario.setUsername("admin");
			usuario.setPassword(Crypt.encrypt("ceppiadmin"));
			usuario.setPersona(persona);
			usuario.setPerfil(perfil);
			usuarioFacade.save(usuario);

			perfil = new Perfil();
			perfil.setCodigo("0002");
			perfil.setNombre("Tesorero");
			perfil.setDescripcion("Administra el dinero del club");
			perfilFacade.save(perfil);

			perfil = new Perfil();
			perfil.setCodigo("0003");
			perfil.setNombre("Recaudador");
			perfil.setDescripcion("Ingresa cuotas al sistema");
			perfilFacade.save(perfil);
			
			TipoGasto tipoGasto = new TipoGasto("0001", "Locomocion", "Locomocion");
			TipoGasto tipoGasto1 = new TipoGasto("0002", "Colacion", "Colacion");
			TipoGasto tipoGasto2 = new TipoGasto("0003", "Articulos de Oficina", "Articulos de Oficina");
			tipoFacade.save(tipoGasto);
			tipoFacade.save(tipoGasto1);
			tipoFacade.save(tipoGasto2);
			
			TipoIngreso tipoIngreso = new TipoIngreso("0001", "Donacion", "Donacion");
			TipoIngreso tipoIngreso1 = new TipoIngreso("0002", "Bingo", "Bingo");
			TipoIngreso tipoIngreso2 = new TipoIngreso("0003", "Rifa", "Rifa");
			tipoFacade.save(tipoIngreso);
			tipoFacade.save(tipoIngreso1);
			tipoFacade.save(tipoIngreso2);
			
			Acceso acceso = null;
			List<MenuCompuesto> accesos = perfilFacade.listMenu();
			Perfil perfilAdm = perfilFacade.findPerfilById(1);
			
			for (MenuCompuesto items : accesos) 
			{
				for ( Menu submenu : items.getItemMenu())
				{
					acceso = new Acceso();
					acceso.setPerfil(perfilAdm);
					acceso.setPermiso(Permiso.E);
					acceso.setItemsMenu(submenu);
					perfilFacade.saveAcceso(acceso);
				}
			}			
			
			System.out.println("------------------------------------------");
			System.out.println("Fin Ejecucion");
			System.out.println("------------------------------------------");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
