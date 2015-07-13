/**
 * 
 */
package cl.ml.ceppi.core.model.equipo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import cl.ml.ceppi.core.model.persona.Persona;

/**
 * @author Maldonado León
 * 
 */
@Entity
@SequenceGenerator(name = "SEC_JUGADOR", sequenceName = "SEC_JUGADOR")
@Table(name = "JUGADOR")
public class Jugador implements Serializable {

	private static final long serialVersionUID = -153115785512062943L;

	@Id
	@GeneratedValue(generator = "SEC_JUGADOR")
	@Column(name = "ID_JUGADOR", nullable = false)
	private int oid;

	@Column
	private String numero;

	@Column
	private String posicion;

	@OneToMany
	private List<SkillJugador> skillJugador;
	
	@OneToOne
	@JoinColumn(name = "ID_PERSONA")
	private Persona persona;

	// @ManyToMany
	// private Equipo equipo;

	/**
	 * 
	 */
	public Jugador() {
		// TODO Auto-generated constructor stub
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public List<SkillJugador> getSkillJugador() {
		return skillJugador;
	}

	public void setSkillJugador(List<SkillJugador> skillJugador) {
		this.skillJugador = skillJugador;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	// public Equipo getEquipo() {
	// return equipo;
	// }
	//
	// public void setEquipo(Equipo equipo) {
	// this.equipo = equipo;
	// }

}
