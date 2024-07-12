INSERT INTO carreras (codigo, nombre, cant_anios, estado) VALUES (1000, 'Ingenieria Informatica', 5, true);
INSERT INTO carreras (codigo, nombre, cant_anios, estado) VALUES (1001, 'Analista Programador Universitario', 3, true);
INSERT INTO carreras (codigo, nombre, cant_anios, estado) VALUES (1002, 'Ingenieria en Minas', 5, true);
INSERT INTO carreras (codigo, nombre, cant_anios, estado) VALUES (1003, 'Ingenieria Industrial', 5, true);
INSERT INTO carreras (codigo, nombre, cant_anios, estado) VALUES (1004, 'Ingenieria Quimica', 5, true);

INSERT INTO docentes (legajo, telefono, apellido, nombre) VALUES (1000, 432789, 'Vega', 'Ariel');
INSERT INTO docentes (legajo, telefono, apellido, nombre) VALUES (1001, 458621, 'Apaza', 'Carolina');
INSERT INTO docentes (legajo, telefono, apellido, nombre) VALUES (1003, 489543, 'Rodriguez', 'Juan Carlos');
INSERT INTO docentes (legajo, telefono, apellido, nombre) VALUES (1004, 457862, 'Tolaba', 'Ana Carolina');
INSERT INTO docentes (legajo, telefono, apellido, nombre) VALUES (1005, 437916, 'Zapana', 'Jose');
INSERT INTO docentes (legajo, telefono, apellido, nombre) VALUES (1006, 468943, 'Villarrubia ', 'Maria Fernanda');

INSERT INTO alumnos (dni, nombre, apellido, email, telefono, fecha_nac, domicilio, lu) VALUES (36589124, 'Juan', 'Perez', 'juan.perez@example.com', 245689956, '2000-01-01', 'Calle Falsa 123', 1234);
INSERT INTO alumnos (dni, nombre, apellido, email, telefono, fecha_nac, domicilio, lu) VALUES (37548936, 'Matias', 'Anachuri', 'fad654@example.com', 243468219, '2000-01-01', 'Calle Falsa 123', 4321);
INSERT INTO alumnos (dni, nombre, apellido, email, telefono, fecha_nac, domicilio, lu) VALUES (39265434, 'Alejandro', 'Alameda', 'rot9856.perez@example.com', 242589631, '2000-01-01', 'Calle Falsa 123', 9561);
INSERT INTO alumnos (dni, nombre, apellido, email, telefono, fecha_nac, domicilio, lu) VALUES (36231865, 'Mario', 'Gonzalez', 'one52@example.com', 241346795, '2000-01-01', 'Calle Falsa 123', 5846);
INSERT INTO alumnos (dni, nombre, apellido, email, telefono, fecha_nac, domicilio, lu) VALUES (34023459, 'Octavio', 'Gutierrez', 'pocho33@example.com', 242976589, '2000-01-01', 'Calle Falsa 123', 3245);
INSERT INTO alumnos (dni, nombre, apellido, email, telefono, fecha_nac, domicilio, lu) VALUES (33568971, 'Ana', 'Burgos', 'omega8@example.com', 249853246, '2000-01-01', 'Calle Falsa 123', 8569);
INSERT INTO alumnos (dni, nombre, apellido, email, telefono, fecha_nac, domicilio, lu) VALUES (35554198, 'Maria', 'Casasola', 'elpato@example.com', 243249786, '2000-01-01', 'Calle Falsa 123', 2358);
INSERT INTO alumnos (dni, nombre, apellido, email, telefono, fecha_nac, domicilio, lu) VALUES (36537954, 'Leonel', 'Perez', 'otromail@example.com', 241068359, '2000-01-01', 'Calle Falsa 123', 9563);
INSERT INTO alumnos (dni, nombre, apellido, email, telefono, fecha_nac, domicilio, lu) VALUES (37589924, 'Marta', 'Aleman', 'juanho@example.com', 2403561287, '2000-01-01', 'Calle Falsa 123', 1248);
INSERT INTO alumnos (dni, nombre, apellido, email, telefono, fecha_nac, domicilio, lu) VALUES (36583214, 'Joel', 'Paredes', 'unvicio@example.com', 242065809, '2000-01-01', 'Calle Falsa 123', 1345);

INSERT INTO materias (codigo_materia, nombre, curso, cant_horas, modalidad, legajo, codigo) VALUES (2000, 'Programacion Visual', '1A', 4, true, 1000, 1001);
INSERT INTO materias (codigo_materia, nombre, curso, cant_horas, modalidad, legajo, codigo) VALUES (2001, 'Metodologia de la Programacion', '1C', 6, false, 1004, 1000);
INSERT INTO materias (codigo_materia, nombre, curso, cant_horas, modalidad, legajo, codigo) VALUES (2002, 'Teoria de la Informacion y la Comunicacion', '1B', 6, true, 1006, 1000);
INSERT INTO materias (codigo_materia, nombre, curso, cant_horas, modalidad, legajo, codigo) VALUES (2003, 'Desarrollo Sistematico de Programas', '1D', 4, false, 1005, 1000);