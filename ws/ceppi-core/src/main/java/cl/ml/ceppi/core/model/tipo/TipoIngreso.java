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
@SequenceGenerator(name = "SEC_TIPO_INGRESO", sequenceName = "SEC_TIPO_INGRESO")
@Table(name = "TIPO_INGRESO")
public class TipoIngreso implements Serializable{

	private static final long serialVersionUID = 3090757832227438377L;
	
	@Id
	@GeneratedValue(generator = "SEC_TIPO_INGRESO")
	@Column(name = "ID_TIPO_INGRESO", nullable = false)
	private int oid;
	
	@Column(unique = true, length = 10, nullable = false)
	private String codigo;
	
	@Column(length = 50, nullable = false)
	private String nombre;
	
	@Column
	private String descripcion;

	/**
	 * 
	 */
	public TipoIngreso() {
		// TODO Auto-generated constructor stub
	}
	
	

	public TipoIngreso(String codigo, String nombre, String descripcion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}



	public TipoIngreso(int oid, String codigo, String nombre, String descripcion) {
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
