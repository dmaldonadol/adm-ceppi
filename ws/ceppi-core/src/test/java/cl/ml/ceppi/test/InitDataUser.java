package cl.ml.ceppi.test;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cl.ml.ceppi.core.facade.PerfilFacade;
import cl.ml.ceppi.core.facade.PersonaFacade;
import cl.ml.ceppi.core.facade.UsuarioFacade;
import cl.ml.ceppi.core.model.estado.Genero;
import cl.ml.ceppi.core.model.perfil.Perfil;
import cl.ml.ceppi.core.model.persona.Persona;
import cl.ml.ceppi.core.model.usuario.Usuario;
import cl.ml.ceppi.core.util.Crypt;

public class InitDataUser {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			ApplicationContext appContext = new ClassPathXmlApplicationContext("ceppi-beanLocations-admin.xml");
			PersonaFacade personaFacade = (PersonaFacade) appContext.getBean("personaFacade");
			UsuarioFacade usuarioFacade = (UsuarioFacade) appContext.getBean("usuarioFacade");
			PerfilFacade perfilFacade = (PerfilFacade) appContext.getBean("perfilFacade");

			Persona leo = new Persona("Leonardo", "Guzman", "Faber", "10725901", "5", "leonardo.guzman.faber@gmail.com", Genero.MASCULINO, "190", "80", new Date());
			Persona rodrigo = new Persona("Rodrigo", "Santana", "Bustos", "11840886", "1", "r@gmail.com", Genero.MASCULINO, "190", "80", new Date());
			Persona hector = new Persona("Hector", "Olguin", "Mateluna", "7077269", "8", "h@gmail.com", Genero.MASCULINO, "190", "80", new Date());
			Persona bernardo = new Persona("Bernardo", "Guzman", "Faber", "16074448", "0", "b@gmail.com", Genero.MASCULINO, "190", "80", new Date());
			Persona patricio = new Persona("Patricio", "Sanchez", "Rojas", "8061010", "6", "p@gmail.com", Genero.MASCULINO, "190", "80", new Date());
			
			personaFacade.save(leo);
			personaFacade.save(rodrigo);
			personaFacade.save(hector);
			personaFacade.save(bernardo);
			personaFacade.save(patricio);

//			/* PERFILES */
			Perfil perfil = new Perfil();
			perfil.setCodigo("0004");
			perfil.setNombre("Presidente");
			perfil.setDescripcion("Presidente");
			perfilFacade.save(perfil);
			
			Usuario usuario = new Usuario("lguzman", Crypt.encrypt("lguzman9015"), leo, perfil);
			usuarioFacade.save(usuario);

			perfil = new Perfil();
			perfil.setCodigo("0005");
			perfil.setNombre("Vice Presidente");
			perfil.setDescripcion("Vice Presidente");
			perfilFacade.save(perfil);
			
			usuario = new Usuario("rsantana", Crypt.encrypt("rsantana8861"), leo, perfil);
			usuarioFacade.save(usuario);

			perfil = new Perfil();
			perfil.setCodigo("0006");
			perfil.setNombre("Secretario");
			perfil.setDescripcion("Secretario");
			perfilFacade.save(perfil);
			
			usuario = new Usuario("bguzman", Crypt.encrypt("bguzman4480"), leo, perfil);
			usuarioFacade.save(usuario);
			
			perfil = new Perfil();
			perfil.setCodigo("0007");
			perfil.setNombre("Director");
			perfil.setDescripcion("Director");
			perfilFacade.save(perfil);
			
			usuario = new Usuario("psanchez", Crypt.encrypt("psanchez0106"), leo, perfil);
			usuarioFacade.save(usuario);
			
			perfil = new Perfil();
			perfil.setCodigo("0008");
			perfil.setNombre("Tesorero");
			perfil.setDescripcion("Tesorero");
			perfilFacade.save(perfil);
			
			usuario = new Usuario("holguin", Crypt.encrypt("holguin2698"), leo, perfil);
			usuarioFacade.save(usuario);

			System.out.println("------------------------------------------");
			System.out.println("Fin Ejecucion");
			System.out.println("------------------------------------------");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
