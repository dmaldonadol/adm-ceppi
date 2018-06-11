/**
 * 
 */
package cl.ml.ceppi.core.model.perfil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

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

	@Column(name = "CODIGO")
	private String codigo;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "DESCRIPCION")
	private String descripcion;

	@Transient
	private List<String> permisos = new ArrayList<String>();

	/**
	 * 
	 */
	public Perfil() {
	}

	/**
	 * 
	 * @param oid
	 */
	public Perfil(int oid) {
		this.setOid(oid);
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

	public List<String> getPermisos() {
		return permisos;
	}

	public void setPermisos(List<String> permisos) {
		this.permisos = permisos;
	}

}
