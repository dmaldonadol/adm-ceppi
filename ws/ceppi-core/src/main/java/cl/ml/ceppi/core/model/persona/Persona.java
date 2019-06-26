/**
 * 
 */
package cl.ml.ceppi.core.model.persona;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import cl.ml.ceppi.core.model.estado.Genero;

/**
 * @author Maldonado León
 * 
 */
@Entity
@SequenceGenerator(name = "SEC_PERSONA", sequenceName = "SEC_PERSONA")
@Table(name = "PERSONA")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Persona implements Serializable {

	private static final long serialVersionUID = 8554029070080556470L;

	@Id
	@GeneratedValue(generator = "SEC_PERSONA")
	@Column(name = "ID_PERSONA", nullable = false)
	private int oid;

	@Column(name = "RUT", unique = true, length = 10)
	private String rut;

	@Column(name = "DV", length = 1)
	private String dv;

	@Column(name = "NOMBRE", nullable = false, length = 100)
	private String nombre;

	@Column(name = "APE_PATERNO", nullable = false, length = 100)
	private String apellidoPaterno;

	@Column(name = "APE_MATERNO", length = 100)
	private String apellidoMaterno;

	@Column(name = "EMAIL", length = 50)
	private String email;

	@Column(name = "ESTATURA")
	private String estatura;

	@Column(name = "PESO")
	private String peso;

	@Column(name = "GENERO")
	@Enumerated(EnumType.STRING)
	private Genero genero;

	@Column(name = "FECHA_NACIMIENTO")
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;

	/**
	 * 
	 */
	public Persona() {
		// TODO Auto-generated constructor stub
	}

	public Persona(String nombre, String apepaterno, String apematerno, String rut, String dv, String email,
			Genero genero, String estatura, String peso, Date fechanac) {
		this.nombre = nombre;
		this.apellidoPaterno = apepaterno;
		this.apellidoMaterno = apematerno;
		this.rut = rut;
		this.dv = dv;
		this.email = email;
		this.genero = genero;
		this.estatura = estatura;
		this.peso = peso;
		this.fechaNacimiento = fechanac;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getDv() {
		return dv;
	}

	public void setDv(String dv) {
		this.dv = dv;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstatura() {
		return estatura;
	}

	public void setEstatura(String estatura) {
		this.estatura = estatura;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}
