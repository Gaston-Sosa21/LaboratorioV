
INSERT INTO `biblioteca_grupo_11`.`nacionalidades`
(`id`,
`descripcion`)
VALUES
(1,
'Argentina');

INSERT INTO `biblioteca_grupo_11`.`nacionalidades`
(`id`,
`descripcion`)
VALUES
(2,
'Brasil');

INSERT INTO `biblioteca_grupo_11`.`nacionalidades`
(`id`,
`descripcion`)
VALUES
(3,
'Uruguay');

INSERT INTO `biblioteca_grupo_11`.`autores`
(`id`,
`apellido`,
`email`,
`nombre`,
`idNacionalidad`)
VALUES
(1,
'Rowling',
'jkrowling@gmail.com',
'J.K',
1);

INSERT INTO `biblioteca_grupo_11`.`autores`
(`id`,
`apellido`,
`email`,
`nombre`,
`idNacionalidad`)
VALUES
(2,
'Cervantes',
'migue@gmail.com',
'Miguel',
1);

INSERT INTO `biblioteca_grupo_11`.`autores`
(`id`,
`apellido`,
`email`,
`nombre`,
`idNacionalidad`)
VALUES
(3,
'Simpson',
'meromero@gmail.com',
'Homero',
1);

INSERT INTO `biblioteca_grupo_11`.`autores`
(`id`,
`apellido`,
`email`,
`nombre`,
`idNacionalidad`)
VALUES
(3,
'Collins',
'susy@gmail.com',
'Suzanne',
3);

INSERT INTO `biblioteca_grupo_11`.`libros`
(`ISBN`,
`cantidad_paginas`,
`descripcion`,
`fecha_lanzamiento`,
`idioma`,
`titulo`,
`idAutor`)
VALUES
('DONQ_123',
100,
'De la mancha',
curdate(),
'Espaniol',
'Don Quijote',
2);

INSERT INTO `biblioteca_grupo_11`.`libros`
(`ISBN`,
`cantidad_paginas`,
`descripcion`,
`fecha_lanzamiento`,
`idioma`,
`titulo`,
`idAutor`)
VALUES
('HRRY_111',
100,
'La piedra filosofal',
curdate(),
'Espaniol',
'Harry Potter 1',
1);

INSERT INTO `biblioteca_grupo_11`.`libros`
(`ISBN`,
`cantidad_paginas`,
`descripcion`,
`fecha_lanzamiento`,
`idioma`,
`titulo`,
`idAutor`)
VALUES
('HRRY_222',
100,
'La camara secreta',
curdate(),
'Espaniol',
'Harry Potter 2',
1);

INSERT INTO `biblioteca_grupo_11`.`libros`
(`ISBN`,
`cantidad_paginas`,
`descripcion`,
`fecha_lanzamiento`,
`idioma`,
`titulo`,
`idAutor`)
VALUES
('ODI_777',
100,
'Odisea',
curdate(),
'Espaniol',
'La Odisea',
3);

INSERT INTO `biblioteca_grupo_11`.`libros`
(`ISBN`,
`cantidad_paginas`,
`descripcion`,
`fecha_lanzamiento`,
`idioma`,
`titulo`,
`idAutor`)
VALUES
('JHAM_555',
100,
'Un hambre',
curdate(),
'Espaniol',
'Los juegos del hambre',
4);

INSERT INTO `biblioteca_grupo_11`.`usuario`
(`idusuario`,
`nombre`,
`clave`)
VALUES
('1',
'admin',
'admin');







