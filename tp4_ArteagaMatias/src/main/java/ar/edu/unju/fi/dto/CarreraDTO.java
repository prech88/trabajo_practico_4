package ar.edu.unju.fi.dto;

import org.springframework.stereotype.Component;

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
public class CarreraDTO {
	private Integer codigo;
	@NotBlank(message="Debe ingresar nombre de la carrera")
    @Size(min=3, max=50, message="El nombre debe contener como mínimo 3 caracteres y como máximo 50 caracteres")
    @Pattern(regexp= "[a-z A-Z ]*", message="Debe ingresar únicamente letras")
	private String nombre;
	@NotNull(message="Debe ingresar la cantidad de años")
    @Min(value = 1, message = "La cantidad de años debe ser al menos 1")
    @Max(value = 7, message = "La cantidad de años no puede ser mayor a 7")
	private Byte cantAnios;
	private Boolean estado;	
}
