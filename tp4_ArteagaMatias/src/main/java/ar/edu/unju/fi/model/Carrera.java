package ar.edu.unju.fi.model;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "carreras")
public class Carrera {
	@Id
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
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Materia> materias;
}
