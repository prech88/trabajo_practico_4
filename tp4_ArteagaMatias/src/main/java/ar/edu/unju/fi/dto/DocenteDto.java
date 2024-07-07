package ar.edu.unju.fi.dto;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;
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
public class DocenteDto {
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
