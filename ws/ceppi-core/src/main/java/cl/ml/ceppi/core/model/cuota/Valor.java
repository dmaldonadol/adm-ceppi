package cl.ml.ceppi.core.model.cuota;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import cl.ml.ceppi.core.model.tipo.CategoriaSocio;
import cl.ml.ceppi.core.model.tipo.TipoSocio;

/**
 * 
 * @author Maldonado León
 * 
 */

@Entity
@SequenceGenerator(name = "SEC_VALOR", sequenceName = "SEC_VALOR")
@Table(name = "VALOR")
public class Valor implements Serializable {

	private static final long serialVersionUID = 2888630646540937616L;

	@Id
	@GeneratedValue(generator = "SEC_VALOR")
	@Column(name = "ID_VALOR", nullable = false)
	private int oid;

	@Column(name = "VALOR", nullable = false)
	private String valor;

	@OneToOne
	@JoinColumn(name = "ID_TIPO_SOCIO")
	private TipoSocio tipoSocio;

	@OneToOne
	@JoinColumn(name = "ID_CATEGORIA_SOCIO")
	private CategoriaSocio categoriaSocio;

	public Valor() {
		// TODO Auto-generated constructor stub
	}

	public Valor(int id) {
		this.oid = id;
	}

	public Valor(int id, String valor, TipoSocio tipoSocio, CategoriaSocio categoriaSocio) {
		this.oid = id;
		this.tipoSocio = tipoSocio;
		this.categoriaSocio = categoriaSocio;
		this.valor = valor;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
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

}
