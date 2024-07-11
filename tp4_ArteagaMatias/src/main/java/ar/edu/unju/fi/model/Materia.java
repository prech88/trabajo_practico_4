package ar.edu.unju.fi.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.dto.AlumnoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.ManyToOne;
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
@Table(name = "materias")
public class Materia {

    @Id
    @NotNull(message = "Debe ingresar el codigo")
    @Min(value = 1000, message = "El numero de codigo debe ser mayor a 1000")
    @Max(value = 99999999, message = "El numero de codigo debe ser menor a 99999999")
    private Integer codigoMateria;

    @NotBlank(message = "Debe ingresar el nombre de la materia")
    @Size(min = 3, max = 50, message = "El nombre debe contener como mínimo 3 caracteres y como máximo 50 caracteres")
    @Pattern(regexp = "[a-z A-Z ]*", message = "Debe ingresar únicamente letras")
    private String nombre;

    private String curso;
    private Byte cantHoras;
    private Boolean modalidad;

    @OneToOne
    @JoinColumn(name = "legajo")
    private Docente docente;

    @ManyToOne
    @JoinColumn(name = "codigo")
    private Carrera carrera;

    @ManyToMany(mappedBy = "materias", fetch = FetchType.LAZY)
    private Set<Alumno> alumnos = new HashSet<>();
}
