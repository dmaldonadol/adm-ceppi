/**
 * 
 */
package cl.ml.ceppi.core.model.equipo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import cl.ml.ceppi.core.model.persona.Persona;
import cl.ml.ceppi.core.model.tipo.TipoProfesor;

/**
 * @author Maldonado León
 * 
 */
@Entity
@SequenceGenerator(name = "SEC_PROFESOR", sequenceName = "SEC_PROFESOR")
@Table(name = "PROFESOR")
public class Profesor implements Serializable {

	private static final long serialVersionUID = -153115785512062943L;

	@Id
	@GeneratedValue(generator = "SEC_PROFESOR")
	@Column(name = "ID_PROFESOR", nullable = false)
	private int oid;
	
	@ManyToOne
	@JoinColumn(name = "ID_TIPO_PROFESOR")
	private TipoProfesor tipoProfesor;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "ID_PERSONA")
	private Persona persona;

	/**
	 * 
	 */
	public Profesor() {
		// TODO Auto-generated constructor stub
	}

	public Profesor(int id) {
		this.oid = id;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}	

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public TipoProfesor getTipoProfesor() {
		return tipoProfesor;
	}

	public void setTipoProfesor(TipoProfesor tipoProfesor) {
		this.tipoProfesor = tipoProfesor;
	}

}
