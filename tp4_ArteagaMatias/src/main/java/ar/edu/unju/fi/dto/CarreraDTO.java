package ar.edu.unju.fi.dto;

import org.springframework.stereotype.Component;

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
	private String nombre;
	private Byte cantAnios;
	private Boolean estado;	
}
