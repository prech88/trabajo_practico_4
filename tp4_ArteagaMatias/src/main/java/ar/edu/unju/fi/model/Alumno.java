package ar.edu.unju.fi.model;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
	@NotNull(message="Debe ingresar el DNI")
    @Min(value = 10000000, message = "El numero de DNI es incorrecto o tiene un formato no valido")
    @Max(value = 99999999, message = "El numero de DNI es incorrecto o tiene un formato no valido")
	private Integer dni;
	@NotBlank(message="Debe ingresar nombre para el alumno")
    @Size(min=3, max=30, message="El nombre debe contener como mínimo 3 caracteres y como máximo 30 caracteres")
    @Pattern(regexp= "[a-z A-Z ]*", message="Debe ingresar únicamente letras")
	private String nombre;
	@NotBlank(message="Debe ingresar apellido para el alumno")
    @Size(min=3, max=30, message="El apellido debe contener como mínimo 3 caracteres y como máximo 30 caracteres")
    @Pattern(regexp= "[a-z A-Z ]*", message="Debe ingresar únicamente letras")
	private String apellido;
	private String email;
	private Long telefono;
	private LocalDate fechaNac;
	private String domicilio;
	@NotNull(message="Debe ingresar el nuemero de libreta universitaria")
    @Min(value = 1000, message = "El numero de LU es incorrecto o tiene un formato no valido")
    @Max(value = 99999, message = "El numero de LU es incorrecto o tiene un formato no valido")
	private Integer lu;
}
