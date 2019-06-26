/**
 * 
 */
package cl.ml.ceppi.core.model.usuario;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import cl.ml.ceppi.core.model.perfil.Perfil;
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

	@Column(name = "USERNAME", unique = true, length = 20, nullable = false)
	private String username;

	@Column(name = "PASSWORD", unique = true, length = 50, nullable = false)
	private String password;

	@OneToOne
	@JoinColumn(name = "ID_PERFIL")
	private Perfil perfil;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_PERSONA")
	private Persona persona;

	@Transient
	private String menuHtml;

	/**
	 * 
	 */
	public Usuario() {
	}

	public Usuario(String username, String pass, Persona persona, Perfil perfil) {
		this.username = username;
		this.password = pass;
		this.persona = persona;
		this.perfil = perfil;
	}

	/**
	 * 
	 * @param oid
	 */
	public Usuario(int oid) {
		this.setOid(oid);
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

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public String getMenuHtml() {
		return menuHtml;
	}

	public void setMenuHtml(String menuHtml) {
		this.menuHtml = menuHtml;
	}

}
