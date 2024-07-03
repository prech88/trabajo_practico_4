package ar.edu.unju.fi.model;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "alumnos")
public class Alumno {
	@Id
	private Integer dni;
	private String nombre;
	private String apellido;
	private String email;
	private Long telefono;
	private LocalDate fechaNac;
	private String domicilio;
	private Integer lu;
}
