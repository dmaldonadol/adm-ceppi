package cl.ml.ceppi.core.util;

import java.math.BigInteger;
import java.security.MessageDigest;

import org.apache.log4j.Logger;

public class Crypt {

	private static final Logger LOGGER = Logger.getLogger(Crypt.class); 
	
	public static String encrypt(String pass) 
	{
		String passEncrypt = null;
		try 
		{
			MessageDigest m = MessageDigest.getInstance("MD5");
	        m.update(pass.getBytes(), 0, pass.length());
	        passEncrypt = new BigInteger(1,m.digest()).toString(16);
		} 
		catch (Exception e) 
		{
			LOGGER.error("Error al encriptar la contraseña.", e);
		}
		
		return passEncrypt;
	}

}
