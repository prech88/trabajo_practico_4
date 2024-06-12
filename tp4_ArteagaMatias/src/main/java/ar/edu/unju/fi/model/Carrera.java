package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

@Component
public class Carrera {
	private Integer codigo;
	private String nombre;
	private Byte cantAños;
	private Boolean estado;
	
	public Carrera() {
		// TODO Auto-generated constructor stub
	}

	public Carrera(Integer codigo, String nombre, Byte cantAños, Boolean estado) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.cantAños = cantAños;
		this.estado = estado;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Byte getCantAños() {
		return cantAños;
	}

	public void setCantAños(Byte cantAños) {
		this.cantAños = cantAños;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
}
