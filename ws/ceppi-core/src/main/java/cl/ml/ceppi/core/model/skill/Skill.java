/**
 * 
 */
package cl.ml.ceppi.core.model.skill;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Maldonado León
 * 
 */
@Entity
@SequenceGenerator(name = "SEC_SKILL", sequenceName = "SEC_SKILL")
@Table(name = "SKILL")
public class Skill implements Serializable {

	private static final long serialVersionUID = 6272579091850707826L;

	@Id
	@GeneratedValue(generator = "SEC_SKILL")
	@Column(name = "ID_SKILL", nullable = false)
	private int oid;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "DESCRIPCION")
	private String descripcion;

	@Column(name = "TIPO")
	private TipoSkill tipo;

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TipoSkill getTipo() {
		return tipo;
	}

	public void setTipo(TipoSkill tipo) {
		this.tipo = tipo;
	}

}
