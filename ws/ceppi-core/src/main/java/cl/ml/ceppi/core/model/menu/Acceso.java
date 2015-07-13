package cl.ml.ceppi.core.model.menu;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import cl.ml.ceppi.core.model.usuario.Usuario;

/**
 * 
 * @author Maldonado León  
 * 
 */
@Entity
@SequenceGenerator(name = "SEC_ACCESO", sequenceName = "SEC_ACCESO")
@Table(name = "ACCESO")
public class Acceso implements Serializable 
{
	private static final long serialVersionUID = -8091708932288241505L;
	
	@Id
	@GeneratedValue(generator = "SEC_ACCESO")
	@Column(name = "ID_ACCESO", nullable = false)
	private int oid;
	
	@ManyToOne
	private Usuario usuario;
	
	@OneToMany
	private List<Item> items;

	public Acceso() {
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}
