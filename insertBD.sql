
INSERT INTO `biblioteca_grupo_11`.`nacionalidades`
(`id`,
`descripcion`)
VALUES
(1,
'Argentina');

INSERT INTO `biblioteca_grupo_11`.`autores`
(`id`,
`apellido`,
`email`,
`nombre`,
`idNacionalidad`)
VALUES
(1,
'Lopez',
'lopez@gmail.com',
'Pepe',
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
('TIT_123',
100,
'Se hunde',
curdate(),
'Espaniol',
'Titanic',
1);


INSERT INTO `biblioteca_grupo_11`.`bibliotecas`
(`id`,
`estado`,
`fecha_alta`,
`ISBN_Libro`)
VALUES
(1,
0,
curdate(),
'TIT_123');

INSERT INTO `biblioteca_grupo_11`.`bibliotecas`
(`id`,
`estado`,
`fecha_alta`,
`ISBN_Libro`)
VALUES
(2,
1,
DATE_ADD(NOW(),INTERVAL 20 DAY),
'TIT_123');

INSERT INTO `biblioteca_grupo_11`.`bibliotecas`
(`id`,
`estado`,
`fecha_alta`,
`ISBN_Libro`)
VALUES
(3,
1,
DATE_ADD(NOW(),INTERVAL 65 DAY),
'TIT_123');





