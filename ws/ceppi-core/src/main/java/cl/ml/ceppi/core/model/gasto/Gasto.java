/**
 * 
 */
package cl.ml.ceppi.core.model.gasto;

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
import cl.ml.ceppi.core.model.tipo.CentroCosto;
import cl.ml.ceppi.core.model.tipo.TipoGasto;

/**
 * @author Maldonado León
 * 
 */
@Entity
@SequenceGenerator(name = "SEC_GASTO", sequenceName = "SEC_GASTO")
@Table(name = "GASTO")
public class Gasto implements Serializable {

	private static final long serialVersionUID = -1954990226741449568L;
	
	@Id
	@GeneratedValue(generator = "SEC_GASTO")
	@Column(name = "ID_GASTO", nullable = false)
	private int oid;
	
	@Column
	private String monto;
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Column
	private String detalle;
	
	@ManyToOne
	@JoinColumn(name = "ID_TIPO_GASTO")
	private TipoGasto tipoGasto;
	
	@ManyToOne
	@JoinColumn(name = "ID_CENTRO_COSTO")
	private CentroCosto centroCosto;

	@ManyToOne
	@JoinColumn(name = "ID_SOCIO")
	private Socio socio;
	
	/**
	 * 
	 */
	public Gasto() {
		// TODO Auto-generated constructor stub
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

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public TipoGasto getTipoGasto() {
		return tipoGasto;
	}

	public void setTipoGasto(TipoGasto tipoGasto) {
		this.tipoGasto = tipoGasto;
	}

	public CentroCosto getCentroCosto() {
		return centroCosto;
	}

	public void setCentroCosto(CentroCosto centroCosto) {
		this.centroCosto = centroCosto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

}
