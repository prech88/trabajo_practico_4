package ar.edu.unju.fi.model;

public class Docente {
	private Integer legajo;
	private String nombre;
	private String apellido;
	private Long telefono;
	
	public Docente() {
		// TODO Auto-generated constructor stub
	}

	public Docente(Integer legajo, String nombre, String apellido, Long telefono) {
		this.legajo = legajo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}

	public Integer getLegajo() {
		return legajo;
	}

	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}
	
}
