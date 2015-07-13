/**
 * 
 */
package cl.ml.ceppi.core.model.tipo;

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
@SequenceGenerator(name = "SEC_CATEGORIA_SOCIO", sequenceName = "SEC_CATEGORIA_SOCIO")
@Table(name = "CATEGORIA_SOCIO")
public class CategoriaSocio implements Serializable {
	private static final long serialVersionUID = -7254379492221123102L;

	@Id
	@GeneratedValue(generator = "SEC_CATEGORIA_SOCIO")
	@Column(name = "ID_CATEGORIA_SOCIO", nullable = false)
	private int oid;
	@Column
	private String nombre;
	@Column
	private String descripcion;

	/**
	 * 
	 */
	public CategoriaSocio() {
		// TODO Auto-generated constructor stub
	}

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

}
