package cl.ml.ceppi.core.model.equipo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import cl.ml.ceppi.core.model.estado.Genero;

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
	
	@Column
	@Enumerated(EnumType.STRING)
	private Genero genero;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Jugador> juagadores = new ArrayList<Jugador>();
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Profesor> profesores = new ArrayList<Profesor>();

	/**
	 * 
	 */
	public Equipo() {
	}
	
	/**
	 * 
	 */
	public Equipo(int oid) {
		this.setOid(oid);
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

	/**
	 * @return the genero
	 */
	public Genero getGenero() {
		return genero;
	}

	/**
	 * @param genero the genero to set
	 */
	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	/**
	 * @return the profesores
	 */
	public List<Profesor> getProfesores() {
		return profesores;
	}

	/**
	 * @param profesores the profesores to set
	 */
	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}

}
