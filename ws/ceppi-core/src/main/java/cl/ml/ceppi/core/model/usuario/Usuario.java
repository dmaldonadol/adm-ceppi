/**
 * 
 */
package cl.ml.ceppi.core.model.usuario;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import cl.ml.ceppi.core.model.persona.Persona;

/**
 * @author Maldonado León
 * 
 */
@Entity
@SequenceGenerator(name = "SEC_USUARIO", sequenceName = "SEC_USUARIO")
@Table(name = "USUARIO")
public class Usuario implements Serializable {
	private static final long serialVersionUID = -1065304047321416426L;
	
	@Id
	@GeneratedValue(generator = "SEC_USUARIO")
	@Column(name = "ID_USUARIO", nullable = false)
	private int oid;
	
	@Column(unique = true, length = 20, nullable = false)
	private String username;
	
	@Column(unique = true, length = 20, nullable = false)
	private String password;
	
	@OneToOne
	private Persona persona;

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

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
