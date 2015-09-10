package cl.ml.ceppi.core.model.equipo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Maldonado León
 * 
 */
@Entity
@SequenceGenerator(name = "SEC_EQUIPO", sequenceName = "SEC_EQUIPO")
@Table(name = "EQUIPO")
public class Equipo implements Serializable 
{

	private static final long serialVersionUID = 240104970931764714L;

	@Id
	@GeneratedValue(generator = "SEC_EQUIPO")
	@Column(name = "ID_EQUIPO", nullable = false)
	private int oid;
	
	@Column(unique = true, length = 20, nullable = false)
	private String nombre;
	
	@Column(length = 50, nullable = false)
	private String descripcion;
	
	@Column(length = 4, nullable = false)
	private String anioLimite;
	
	@OneToMany
	private List<Jugador> juagadores = new ArrayList<Jugador>();

	/**
	 * 
	 */
	public Equipo() {
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Jugador> getJuagadores() {
		return juagadores;
	}

	public void setJuagadores(List<Jugador> juagadores) {
		this.juagadores = juagadores;
	}

	public String getAnioLimite() {
		return anioLimite;
	}

	public void setAnioLimite(String anioLimite) {
		this.anioLimite = anioLimite;
	}

}
