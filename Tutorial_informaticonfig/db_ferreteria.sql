use db_ferreteria;

ALTER TABLE articulos
MODIFY id BIGINT NOT NULL AUTO_INCREMENT;

UPDATE articulos
SET nombrearticulo = 'Taladro'
WHERE id = 51;

select * from articulos;

INSERT INTO articulos (id, nombrearticulo, precio, existencia) VALUES
(1, 'Martillo', 12.50, 50),
(2, 'Destornillador', 5.75, 120),
(3, 'Llave inglesa', 15.00, 30),
(4, 'Taladro', 85.99, 20),
(5, 'Sierra manual', 25.50, 15),
(6, 'Cinta métrica', 7.20, 80),
(7, 'Nivel de burbuja', 10.00, 40),
(8, 'Alicate', 8.75, 60),
(9, 'Brocas', 12.30, 50),
(10, 'Lijadora', 45.00, 10),
(11, 'Tornillos 50mm', 3.50, 200),
(12, 'Clavos 50mm', 2.75, 250),
(13, 'Cinta aislante', 4.20, 100),
(14, 'Pegamento industrial', 6.80, 60),
(15, 'Guantes de seguridad', 7.50, 70),
(16, 'Casco de seguridad', 15.00, 30),
(17, 'Mascarilla', 3.00, 100),
(18, 'Escalera', 65.00, 12),
(19, 'Sierra eléctrica', 120.00, 8),
(20, 'Llave de tubo', 18.00, 25),
(21, 'Pinzas', 9.50, 50),
(22, 'Flexómetro 5m', 6.50, 60),
(23, 'Sargentos', 20.00, 15),
(24, 'Cuchilla', 4.00, 80),
(25, 'Nivel láser', 55.00, 10),
(26, 'Martillo perforador', 90.00, 5),
(27, 'Sierra de calar', 70.00, 8),
(28, 'Llave combinada', 11.50, 40),
(29, 'Tornillos 30mm', 2.50, 180),
(30, 'Clavos 30mm', 2.00, 220),
(31, 'Cinta de enmascarar', 3.75, 100),
(32, 'Taladro inalámbrico', 95.00, 10),
(33, 'Pintura blanca 1L', 12.00, 50),
(34, 'Pintura negra 1L', 12.00, 45),
(35, 'Rodillo para pintura', 6.00, 60),
(36, 'Brocha 2"', 3.50, 70),
(37, 'Guantes de látex', 5.00, 80),
(38, 'Casco amarillo', 16.00, 25),
(39, 'Mascarilla N95', 5.50, 40),
(40, 'Escalera plegable', 80.00, 8),
(41, 'Sierra circular', 110.00, 6),
(42, 'Llave Allen', 7.50, 50),
(43, 'Tornillos 20mm', 1.75, 200),
(44, 'Clavos 20mm', 1.50, 220),
(45, 'Cinta adhesiva', 3.25, 100),
(46, 'Nivel de agua', 9.00, 35),
(47, 'Alicate de corte', 10.50, 45),
(48, 'Martillo de bola', 13.00, 20),
(49, 'Sierra para metales', 30.00, 12),
(50, 'Destornillador de precisión', 6.00, 60);



