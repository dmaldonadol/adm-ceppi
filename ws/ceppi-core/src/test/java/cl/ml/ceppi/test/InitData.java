package cl.ml.ceppi.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cl.ml.ceppi.core.facade.TipoFacade;
import cl.ml.ceppi.core.model.tipo.Profesion;

public class InitData {

	public static void main(String[] args) 
	{
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("ceppi-beanLocations-admin.xml");
		TipoFacade tipoFacade = (TipoFacade) appContext.getBean("tipoFacade");
		
//		Profesion profesion = new Profesion();
//		profesion.setNombre("Ingeniero");
//		profesion.setDescripcion("Ingeniero");
//		
//		tipoFacade.save(profesion);
		
		Profesion prof = tipoFacade.findProfesionById(1);
		prof.setDescripcion("Ingenieria Informatica");
		tipoFacade.delete(prof);
		
//		System.out.println(tipoFacade.findProfesionById(1).getOid());
//		
//		for (Profesion p : tipoFacade.listProfesion()) 
//		{
//			System.out.println(p.getDescripcion());
//		}
	}

}
