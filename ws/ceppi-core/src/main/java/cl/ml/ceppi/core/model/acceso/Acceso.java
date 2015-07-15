package cl.ml.ceppi.core.model.acceso;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import cl.ml.ceppi.core.model.menu.Menu;
import cl.ml.ceppi.core.model.menu.Permiso;
import cl.ml.ceppi.core.model.perfil.Perfil;

/**
 * 
 * @author Maldonado León
 * 
 */
@Entity
@SequenceGenerator(name = "SEC_ACCESO", sequenceName = "SEC_ACCESO")
@Table(name = "ACCESO")
public class Acceso implements Serializable {
	private static final long serialVersionUID = -8091708932288241505L;

	@Id
	@GeneratedValue(generator = "SEC_ACCESO")
	@Column(name = "ID_ACCESO", nullable = false)
	private int oid;

	@ManyToOne
	@JoinColumn(name = "ID_PERFIL")
	private Perfil perfil;

	@ManyToOne
	@JoinColumn(name = "ID_MENU")
	private Menu itemsMenu;
	
	@Column
	@Enumerated(EnumType.STRING)
	private Permiso permiso;

	public Acceso() {
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Menu getItemsMenu() {
		return itemsMenu;
	}

	public void setItemsMenu(Menu itemsMenu) {
		this.itemsMenu = itemsMenu;
	}

	public Permiso getPermiso() {
		return permiso;
	}

	public void setPermiso(Permiso permiso) {
		this.permiso = permiso;
	}

}
