package cl.ml.ceppi.core.model.cuota;

import java.io.Serializable;

import cl.ml.ceppi.core.model.estado.EstadoCuota;

/**
 * 
 * @author Maldonado León
 * 
 */
public class Cuota implements Serializable{

	private static final long serialVersionUID = -8313810574976479543L;
	private int oid;
	private ValorCuota valorCuota;
	private String periodo;
	private EstadoCuota estadoCuota;

	public Cuota() {
		// TODO Auto-generated constructor stub
	}

}
