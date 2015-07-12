/**
 * 
 */
package cl.ml.ceppi.bussines.connection;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author Maldonado León
 *
 */
public class Connection {
	
	private static ApplicationContext _instance = null;
	private Map<String, Object> data;

	/**
	 * 
	 */
	public Connection() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @return
	 */
	public static ApplicationContext getInstance()
	{
		if( null == _instance )
		{
			_instance = new GenericXmlApplicationContext("spring-config.xml");
		}
		return _instance;
	}


	/**
	 * @return the data
	 */
	public Map<String, Object> getData() {
		return data;
	}


	/**
	 * @param data the data to set
	 */
	public void setData(Map<String, Object> data) {
		this.data = data;
	}

}
