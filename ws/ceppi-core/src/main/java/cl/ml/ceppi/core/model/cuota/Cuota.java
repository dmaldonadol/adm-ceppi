package cl.ml.ceppi.core.model.cuota;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import cl.ml.ceppi.core.model.socio.Socio;

/**
 * 
 * @author Maldonado León
 * 
 */
@Entity
@SequenceGenerator(name = "SEC_CUOTA", sequenceName = "SEC_CUOTA")
@Table(name = "CUOTA")
public class Cuota implements Serializable {

	private static final long serialVersionUID = -8313810574976479543L;

	@Id
	@GeneratedValue(generator = "SEC_CUOTA")
	@Column(name = "ID_CUOTA", nullable = false)
	private int oid;

//	@ManyToOne(cascade = { CascadeType.ALL })
//	@JoinColumn(name = "ID_VALOR")
//	private Valor valor;
	@Column(name = "VALOR")
	private String valor;

	@Column(name = "ANIO", nullable = false)
	private String anio;

	@Column(name = "MES", nullable = false)
	private String mes;

	@ManyToOne
	@JoinColumn(name = "ID_SOCIO")
	private Socio socio;

	public Cuota() {
		// TODO Auto-generated constructor stub
	}

	public Cuota(String valor, String anio, String mes, Socio socio) {
		super();
		this.valor = valor;
		this.anio = anio;
		this.mes = mes;
		this.socio = socio;
	}

	public Cuota(int id) {
		this.oid = id;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
