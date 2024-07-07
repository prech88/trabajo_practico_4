package ar.edu.unju.fi.model;

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
@Table(name = "docentes")
public class Docente {
	@Id
	@NotNull(message="Debe ingresar el legajo")
    @Min(value = 1000, message = "El numero de legajo debe ser mayor a 1000")
    @Max(value = 99999999, message = "El numero de legajo debe ser menor a 99999999")
	private Integer legajo;
	@NotBlank(message="Debe ingresar nombre para el docente")
    @Size(min=3, max=30, message="El nombre debe contener como mínimo 3 caracteres y como máximo 30 caracteres")
    @Pattern(regexp= "[a-z A-Z ]*", message="Debe ingresar únicamente letras")
	private String nombre;
	@NotBlank(message="Debe ingresar apellido para el docente")
    @Size(min=3, max=30, message="El apellido debe contener como mínimo 3 caracteres y como máximo 30 caracteres")
    @Pattern(regexp= "[a-z A-Z ]*", message="Debe ingresar únicamente letras")
	private String apellido;
	private Long telefono;
}