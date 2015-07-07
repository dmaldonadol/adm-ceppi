/**
 * 
 */
package cl.ml.ceppi.core.model.usuario;

import cl.ml.ceppi.core.model.persona.Persona;

/**
 * @author dmaldonado
 * 
 */
public class Usuario extends Persona {
	private int oid;
	private String username;
	private String password;

	/**
	 * 
	 */
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
