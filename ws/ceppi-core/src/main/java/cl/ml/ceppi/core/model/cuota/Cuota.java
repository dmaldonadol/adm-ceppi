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
	
	@ManyToOne
	@JoinColumn(name = "ID_VALOR_CUOTA")
	private ValorCuota valorCuota;
	
	@Column(name = "PERIODO", nullable = false)
	private String periodo;

	public Cuota() {
		// TODO Auto-generated constructor stub
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public ValorCuota getValorCuota() {
		return valorCuota;
	}

	public void setValorCuota(ValorCuota valorCuota) {
		this.valorCuota = valorCuota;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

}
