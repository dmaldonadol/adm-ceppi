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
import cl.ml.ceppi.core.model.menu.MenuCompuesto;
import cl.ml.ceppi.core.model.menu.MenuSimple;
import cl.ml.ceppi.core.model.perfil.Perfil;
import cl.ml.ceppi.core.model.persona.Persona;
import cl.ml.ceppi.core.model.tipo.TipoGasto;
import cl.ml.ceppi.core.model.tipo.TipoIngreso;
import cl.ml.ceppi.core.model.tipo.TipoSocio;
import cl.ml.ceppi.core.model.usuario.Usuario;
import cl.ml.ceppi.core.util.Crypt;
import cl.ml.ceppi.core.model.estado.Genero;

public class InitData {

	public static void main(String[] args) {

		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("ceppi-beanLocations-admin.xml");
			TipoFacade tipoFacade = (TipoFacade) appContext.getBean("tipoFacade");
			PersonaFacade personaFacade = (PersonaFacade) appContext.getBean("personaFacade");
			UsuarioFacade usuarioFacade = (UsuarioFacade) appContext.getBean("usuarioFacade");
			PerfilFacade perfilFacade = (PerfilFacade) appContext.getBean("perfilFacade");
			
			List<Acceso> lista = perfilFacade.listaAccesoByIdPerfil(1);
			
			for (Acceso acceso : lista) {
				System.out.println(acceso.getItemsMenu().getNombre());
			}
			
			TipoSocio tipoSocio = new TipoSocio("0001", "TP1", "TP1");
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
			persona.setTipoSocio(tipoSocio);
			persona.setFechaNacimiento(new Date());
			personaFacade.save(persona);
			
			/* MENU ADMINISTRACION */
			MenuCompuesto menuCompuesto = new MenuCompuesto();
			menuCompuesto.setCodigo("0001");
			menuCompuesto.setNombre("Administración");
			menuCompuesto.setOrden("1");
			menuCompuesto.setPath("");
			
			MenuSimple menuPersona = new MenuSimple();
			menuPersona.setCodigo("0011");
			menuPersona.setNombre("Socio");
			menuPersona.setOrden("1");
			menuPersona.setPath("/templateSocio");
			menuPersona.setMenu(menuCompuesto);
			
			MenuSimple menuUsuario = new MenuSimple();
			menuUsuario.setCodigo("0012");
			menuUsuario.setNombre("Usuario");
			menuUsuario.setOrden("2");
			menuUsuario.setPath("/templateUsuario");
			menuUsuario.setMenu(menuCompuesto);

			MenuSimple menuPerfil = new MenuSimple();
			menuPerfil.setCodigo("0013");
			menuPerfil.setNombre("Perfil");
			menuPerfil.setOrden("3");
			menuPerfil.setPath("/templatePerfil");
			menuPerfil.setMenu(menuCompuesto);

			menuCompuesto.getItemMenu().add(menuPersona);
			menuCompuesto.getItemMenu().add(menuUsuario);
			menuCompuesto.getItemMenu().add(menuPerfil);

			perfilFacade.saveMenu(menuCompuesto);
			
			/* MENU MANTENEDORES */
			menuCompuesto = new MenuCompuesto();
			menuCompuesto.setCodigo("0002");
			menuCompuesto.setNombre("Mantenedores");
			menuCompuesto.setOrden("2");
			menuCompuesto.setPath("");
			
			MenuSimple subMenu1 = new MenuSimple();
			subMenu1.setCodigo("0021");
			subMenu1.setNombre("Tipo Socio");
			subMenu1.setOrden("1");
			subMenu1.setPath("/templateTipoSocio");
			subMenu1.setMenu(menuCompuesto);
			
			MenuSimple subMenu2 = new MenuSimple();
			subMenu2.setCodigo("0022");
			subMenu2.setNombre("Categoria Socio");
			subMenu2.setOrden("2");
			subMenu2.setPath("/templateCategoriaSocio");
			subMenu2.setMenu(menuCompuesto);
			
			MenuSimple subMenu3 = new MenuSimple();
			subMenu3.setCodigo("0023");
			subMenu3.setNombre("Centro de Costo");
			subMenu3.setOrden("3");
			subMenu3.setPath("/templateCentoCosto");
			subMenu3.setMenu(menuCompuesto);
			
			MenuSimple subMenu4 = new MenuSimple();
			subMenu4.setCodigo("0024");
			subMenu4.setNombre("Profesión");
			subMenu4.setOrden("4");
			subMenu4.setPath("/templateProfesion");
			subMenu4.setMenu(menuCompuesto);
			
			MenuSimple subMenu5 = new MenuSimple();
			subMenu5.setCodigo("0025");
			subMenu5.setNombre("Tipo Gasto");
			subMenu5.setOrden("5");
			subMenu5.setPath("/templateTipoGasto");
			subMenu5.setMenu(menuCompuesto);
			
			MenuSimple subMenu6 = new MenuSimple();
			subMenu6.setCodigo("0026");
			subMenu6.setNombre("Equipo");
			subMenu6.setOrden("6");
			subMenu6.setPath("/templateEquipo");
			subMenu6.setMenu(menuCompuesto);
			
			MenuSimple subMenu7 = new MenuSimple();
			subMenu7.setCodigo("0027");
			subMenu7.setNombre("Tipo Ingreso");
			subMenu7.setOrden("7");
			subMenu7.setPath("/templateTipoIngreso");
			subMenu7.setMenu(menuCompuesto);

			menuCompuesto.getItemMenu().add(subMenu1);
			menuCompuesto.getItemMenu().add(subMenu2);
			menuCompuesto.getItemMenu().add(subMenu3);
			menuCompuesto.getItemMenu().add(subMenu4);
			menuCompuesto.getItemMenu().add(subMenu5);
			menuCompuesto.getItemMenu().add(subMenu6);
			menuCompuesto.getItemMenu().add(subMenu7);

			perfilFacade.saveMenu(menuCompuesto);
			
			/* MENU INGRESOS */
			menuCompuesto = new MenuCompuesto();
			menuCompuesto.setCodigo("0003");
			menuCompuesto.setNombre("Ingresos");
			menuCompuesto.setOrden("3");
			menuCompuesto.setPath("");
			
			subMenu1 = new MenuSimple();
			subMenu1.setCodigo("0031");
			subMenu1.setNombre("Ingreso");
			subMenu1.setOrden("1");
			subMenu1.setPath("/templateIngreso");
			subMenu1.setMenu(menuCompuesto);
			
			subMenu2 = new MenuSimple();
			subMenu2.setCodigo("0032");
			subMenu2.setNombre("Valor Cuota");
			subMenu2.setOrden("2");
			subMenu2.setPath("/templateValorCuota");
			subMenu2.setMenu(menuCompuesto);

			menuCompuesto.getItemMenu().add(subMenu1);
			menuCompuesto.getItemMenu().add(subMenu2);

			perfilFacade.saveMenu(menuCompuesto);

			/* MENU EGRESOS */
			menuCompuesto = new MenuCompuesto();
			menuCompuesto.setCodigo("0004");
			menuCompuesto.setNombre("Gastos");
			menuCompuesto.setOrden("4");
			menuCompuesto.setPath("");
			
			subMenu1 = new MenuSimple();
			subMenu1.setCodigo("0041");
			subMenu1.setNombre("Gasto");
			subMenu1.setOrden("1");
			subMenu1.setPath("/templateGasto");
			subMenu1.setMenu(menuCompuesto);		

			menuCompuesto.getItemMenu().add(subMenu1);

			perfilFacade.saveMenu(menuCompuesto);
			
			/* PERFILES */
			Perfil perfil = new Perfil();
			perfil.setCodigo("0001");
			perfil.setNombre("Administrador");
			perfil.setDescripcion("Todopoderoso del sistema");
			perfilFacade.save(perfil);
			
			Usuario usuario = new Usuario();
			usuario.setUsername("admin");
			usuario.setPassword(Crypt.encrypt("admin"));
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
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
