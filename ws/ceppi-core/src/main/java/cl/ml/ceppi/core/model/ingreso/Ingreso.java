/**
 * 
 */
package cl.ml.ceppi.core.model.ingreso;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import cl.ml.ceppi.core.model.socio.Socio;
import cl.ml.ceppi.core.model.tipo.TipoIngreso;

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

	@Column(name = "MONTO")
	private String monto;

	@Column(name = "FECHA")
	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name = "DETALLE")
	private String detalle;

	@ManyToOne
	@JoinColumn(name = "ID_TIPO_INGRESO")
	private TipoIngreso tipoIngreso;

	@ManyToOne
	@JoinColumn(name = "ID_SOCIO")
	private Socio socio;

	/**
	 * 
	 */
	public Ingreso() {
		// TODO Auto-generated constructor stub
	}

	public Ingreso(int id) {
		this.oid = id;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public TipoIngreso getTipoIngreso() {
		return tipoIngreso;
	}

	public void setTipoIngreso(TipoIngreso tipoIngreso) {
		this.tipoIngreso = tipoIngreso;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

}
