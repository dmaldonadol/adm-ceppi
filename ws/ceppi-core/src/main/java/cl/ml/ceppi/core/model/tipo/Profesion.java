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
@SequenceGenerator(name = "SEC_PROFESION", sequenceName = "SEC_PROFESION")
@Table(name = "PROFESION")
public class Profesion implements Serializable {
	private static final long serialVersionUID = -7033070437508223564L;

	@Id
	@GeneratedValue(generator = "SEC_PROFESION")
	@Column(name = "ID_PROFESION", nullable = false)
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
	public Profesion() {
		// TODO Auto-generated constructor stub
	}

	public Profesion(String codigo, String nombre, String descripcion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Profesion(int oid, String codigo, String nombre, String descripcion) {
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
