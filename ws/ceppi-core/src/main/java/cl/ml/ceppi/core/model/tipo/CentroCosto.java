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
@SequenceGenerator(name = "SEC_CENTRO_COSTO", sequenceName = "SEC_CENTRO_COSTO")
@Table(name = "CENTRO_COSTO")
public class CentroCosto implements Serializable {
	private static final long serialVersionUID = -139712273252199785L;

	@Id
	@GeneratedValue(generator = "SEC_CENTRO_COSTO")
	@Column(name = "ID_CENTRO_COSTO", nullable = false)
	private int oid;

	@Column(name = "CODIGO", unique = true, length = 10, nullable = false)
	private String codigo;

	@Column(name = "NOMBRE", length = 50, nullable = false)
	private String nombre;

	@Column(name = "DESCRIPCION")
	private String descripcion;

	/**
	 * 
	 */
	public CentroCosto() {
		// TODO Auto-generated constructor stub
	}

	public CentroCosto(String codigo, String nombre, String descripcion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public CentroCosto(int oid, String codigo, String nombre, String descripcion) {
		super();
		this.oid = oid;
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
