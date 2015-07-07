/**
 * 
 */
package cl.ml.ceppi.core.model.ingreso;

import cl.ml.ceppi.core.model.cuota.Cuota;
import cl.ml.ceppi.core.model.socio.Socio;

/**
 * @author dmaldonado
 * 
 */
public class Ingreso {
	private int oid;
	private String fecha;
	private Socio socio;
	private Cuota cuota;

	/**
	 * 
	 */
	public Ingreso() {
		// TODO Auto-generated constructor stub
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Cuota getCuota() {
		return cuota;
	}

	public void setCuota(Cuota cuota) {
		this.cuota = cuota;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

}
