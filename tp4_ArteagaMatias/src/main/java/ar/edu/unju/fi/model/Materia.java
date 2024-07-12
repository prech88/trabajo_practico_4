package ar.edu.unju.fi.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.ManyToOne;
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
@Table(name = "materias")
public class Materia {

    @Id
    private Integer codigoMateria;
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
