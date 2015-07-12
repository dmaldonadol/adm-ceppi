/**
 * 
 */
package cl.ml.ceppi.core.model.ingreso;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import cl.ml.ceppi.core.model.cuota.Cuota;
import cl.ml.ceppi.core.model.socio.Socio;

/**
 * @author Maldonado León
 * 
 */
@Entity
@SequenceGenerator(name = "SEC_INGRESO", sequenceName = "SEC_INGRESO")
@Table(name = "INGRESO")
public class Ingreso implements Serializable {
	private static final long serialVersionUID = 1070587907575253154L;
	@Id
	@GeneratedValue(generator = "SEC_INGRESO")
	@Column(name = "ID_INGRESO", nullable = false)
	private int oid;
	@Column
	private String fecha;
	@ManyToOne
	private Socio socio;
	@ManyToOne
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
