package cl.ml.ceppi.web.pojo;

import java.io.Serializable;

public class TipoPojo implements Serializable 
{
	private static final long serialVersionUID = 1L;

	private int oid;
	private String nombre;
	private String codigo;
	private String descripcion;
	
	
	public TipoPojo()
	{}
	
	public TipoPojo( int oid )
	{
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
