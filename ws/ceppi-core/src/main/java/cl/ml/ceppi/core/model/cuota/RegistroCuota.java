package cl.ml.ceppi.core.model.cuota;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import cl.ml.ceppi.core.model.estado.EstadoCuota;
import cl.ml.ceppi.core.model.usuario.Usuario;

/**
 * 
 * @author Maldonado León
 * 
 */

@Entity
@SequenceGenerator(name = "SEC_REGISTRO_CUOTA", sequenceName = "SEC_REGISTRO_CUOTA")
@Table(name = "REGISTRO_CUOTA")
public class RegistroCuota implements Serializable {
	private static final long serialVersionUID = 4019799253697585195L;

	@Id
	@GeneratedValue(generator = "SEC_REGISTRO_CUOTA")
	@Column(name = "ID_REGISTRO_CUOTA", nullable = false)
	private int oid;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "ID_CUOTA")
	private Cuota cuota;
	
	@OneToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ESTADO")
	private EstadoCuota estadoCuota;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHA_COBRO", nullable = false)
	private Date fechaCobro;

	public RegistroCuota() {
		// TODO Auto-generated constructor stub
	}
	
	public RegistroCuota(Cuota cuota, Usuario usuario, EstadoCuota estadoCuota, Date fechaCobro) 
	{
		super();
		this.cuota = cuota;
		this.usuario = usuario;
		this.estadoCuota = estadoCuota;
		this.fechaCobro = fechaCobro;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public Cuota getCuota() {
		return cuota;
	}

	public void setCuota(Cuota cuota) {
		this.cuota = cuota;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public EstadoCuota getEstadoCuota() {
		return estadoCuota;
	}

	public void setEstadoCuota(EstadoCuota estadoCuota) {
		this.estadoCuota = estadoCuota;
	}

	public Date getFechaCobro() {
		return fechaCobro;
	}

	public void setFechaCobro(Date fechaCobro) {
		this.fechaCobro = fechaCobro;
	}

}
