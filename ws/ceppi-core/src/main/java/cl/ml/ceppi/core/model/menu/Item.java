package cl.ml.ceppi.core.model.menu;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author Maldonado León
 *
 */
@Entity
@SequenceGenerator(name = "SEC_ITEM", sequenceName = "SEC_ITEM")
@Table(name = "ITEM")
public class Item implements Serializable {

	private static final long serialVersionUID = 8015270775274569824L;

	@Id
	@GeneratedValue(generator = "SEC_ITEM")
	@Column(name = "ID_ITEM", nullable = false)
	private int oid;
	
	@Column
	private String nombre;
	@Column
	private String path;
	@Column
	private String orden;
	@Column
	private Permiso permiso;
	@ManyToOne
	private List<Item> lista;

	public Item() {
		// TODO Auto-generated constructor stub
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getOrden() {
		return orden;
	}

	public void setOrden(String orden) {
		this.orden = orden;
	}

	public Permiso getPermiso() {
		return permiso;
	}

	public void setPermiso(Permiso permiso) {
		this.permiso = permiso;
	}

	public List<Item> getLista() {
		return lista;
	}

	public void setLista(List<Item> lista) {
		this.lista = lista;
	}

}
