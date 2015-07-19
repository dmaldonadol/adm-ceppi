package cl.ml.ceppi.web.locator;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class ServiceLocator 
{
	
	private static final String CONFIG_XML = "ceppi-beanLocations.xml"; 
	private static final transient Logger LOGGER = Logger.getLogger( ServiceLocator.class );
	private ApplicationContext context = null;
	private static ServiceLocator instace = null;
	
	
	/**
	 * Constructor privado por ser Singleton.
	 */
	private ServiceLocator()	{
	}

	/**
	 * 
	 * @return
	 */
	public static synchronized ServiceLocator getInstance()
	{
		if (instace == null || instace.context == null)
		{
			try 
			{
				LOGGER.info( "Inicializando la configuracion de Spring " + CONFIG_XML );
				ApplicationContext appContext = new ClassPathXmlApplicationContext( CONFIG_XML) ;
				instace  = new ServiceLocator();			
				instace.context = appContext;
			}
			catch (Exception e) 
			{
				LOGGER.error( "Error al inicializar el archivo de configuracion de SPRING", e );
			}
		}
			return instace;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Object getBean(String id)
	{
		return this.context.getBean(id);
	}

}
