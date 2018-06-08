package cl.ml.ceppi.core.model.socio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import cl.ml.ceppi.core.model.estado.Estado;
import cl.ml.ceppi.core.model.persona.Persona;
import cl.ml.ceppi.core.model.tipo.CategoriaSocio;
import cl.ml.ceppi.core.model.tipo.TipoSocio;

/**
 * 
 * @author Maldonado León
 * 
 */
@Entity
@SequenceGenerator(name = "SEC_SOCIO", sequenceName = "SEC_SOCIO")
@Table(name = "SOCIO")
public class Socio implements Serializable {

	private static final long serialVersionUID = 257402133488075225L;

	@Id
	@GeneratedValue(generator = "SEC_SOCIO")
	@Column(name = "ID_SOCIO", nullable = false)
	private int oid;

	@Column(name = "ESTADO")
	private Estado estado;

	@ManyToOne
	@JoinColumn(name = "ID_TIPO_SOCIO")
	private TipoSocio tipoSocio;

	@ManyToOne
	@JoinColumn(name = "ID_CATEGORIA_SOCIO")
	private CategoriaSocio categoriaSocio;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "ID_PERSONA")
	private Persona persona;
	
	@Column(name = "FECHA_INGRESO")
	@Temporal(TemporalType.DATE)
	private Date fechaIngreso;
	
	@Transient
	private String valorCuota;
	
	@Transient
	private String estadoComercial;

	public Socio() {
		// TODO Auto-generated constructor stub
	}

	public Socio(int id) {
		this.oid = id;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public TipoSocio getTipoSocio() {
		return tipoSocio;
	}

	public void setTipoSocio(TipoSocio tipoSocio) {
		this.tipoSocio = tipoSocio;
	}

	public CategoriaSocio getCategoriaSocio() {
		return categoriaSocio;
	}

	public void setCategoriaSocio(CategoriaSocio categoriaSocio) {
		this.categoriaSocio = categoriaSocio;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getValorCuota() {
		return valorCuota;
	}

	public void setValorCuota(String valorCuota) {
		this.valorCuota = valorCuota;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getEstadoComercial() {
		return estadoComercial;
	}

	public void setEstadoComercial(String estadoComercial) {
		this.estadoComercial = estadoComercial;
	}

}
