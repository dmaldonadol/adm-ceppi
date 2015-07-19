/**
 * 
 */
package cl.ml.ceppi.core.model.perfil;

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
@SequenceGenerator(name = "SEC_PERFIL", sequenceName = "SEC_PERFIL")
@Table(name = "PERFIL")
public class Perfil implements Serializable {

	private static final long serialVersionUID = 180819603754451937L;

	@Id
	@GeneratedValue(generator = "SEC_PERFIL")
	@Column(name = "ID_PERFIL", nullable = false)
	private int oid;

	@Column
	private String codigo;

	@Column
	private String nombre;
	
	@Column
	private String descripcion;

	public Perfil() {
		// TODO Auto-generated constructor stub
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
