/**
 * 
 */
package cl.ml.ceppi.core.model.tipo;

/**
 * @author dmaldonado
 * 
 */
public class TipoSocio {
	private int oid;
	private String nombre;
	private String descripcion;

	/**
	 * 
	 */
	public TipoSocio() {
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
