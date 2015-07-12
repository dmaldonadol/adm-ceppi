package cl.ml.ceppi.core.model.cuota;

import java.io.Serializable;

import cl.ml.ceppi.core.model.estado.Estado;
import cl.ml.ceppi.core.model.tipo.CategoriaSocio;
import cl.ml.ceppi.core.model.tipo.TipoSocio;

/**
 * 
 * @author Maldonado León
 * 
 */
public class ValorCuota implements Serializable{

	private static final long serialVersionUID = 2888630646540937616L;
	private int oid;
	private String valor;
	private TipoSocio tipoSocio;
	private CategoriaSocio categoriaSocio;
	private Estado estado;

	public ValorCuota() {
		// TODO Auto-generated constructor stub
	}

}
