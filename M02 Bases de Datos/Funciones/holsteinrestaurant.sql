DROP DATABASE IF EXISTS Holstein;
CREATE DATABASE IF NOT EXISTS Holstein;
use Holstein;

CREATE TABLE Usuarios (
	ID_usuario INT PRIMARY KEY,
	nombre VARCHAR(100),
	rol VARCHAR(50),
	telefono int (9),
	correo VARCHAR(50)
);

CREATE TABLE Cocinero (
    ID_cocinero INT PRIMARY KEY,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    correo VARCHAR(50),
    salario INT,
    telefono INT,
    ID_usuario INT,
    FOREIGN KEY (ID_usuario) REFERENCES Usuarios(ID_usuario)
);

CREATE TABLE Cliente (
    ID_cliente INT PRIMARY KEY,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    correo VARCHAR(50),
    ID_usuario INT,
    FOREIGN KEY (ID_usuario) REFERENCES Usuarios(ID_usuario)
);


CREATE TABLE Camareros (
	ID_camarero INT PRIMARY KEY,
	nombre VARCHAR(100),
	ID_usuario INT,
	salario INT,
	turno VARCHAR(50) ,
	horario_trabajo VARCHAR(50),
	FOREIGN KEY (ID_usuario) REFERENCES Usuarios(ID_usuario)
);

CREATE TABLE Mesas (
	ID_mesa INT PRIMARY KEY,
	numero INT,
	capacidad INT,
	disponibilidad VARCHAR(50),
	ID_camarero INT,
	FOREIGN KEY (ID_camarero) REFERENCES Camareros(ID_camarero)
);

CREATE TABLE Platos (
	ID_plato INT PRIMARY KEY,
	nombre VARCHAR(100),
	descripcion TEXT
);

CREATE TABLE Menus (
	ID_menu INT PRIMARY KEY,
	nombre VARCHAR(100),
	precio int,
	tipo VARCHAR(50),
	descripcion TEXT
);

CREATE TABLE Comandas (
	ID_comanda INT PRIMARY KEY,
	ID_mesa INT,
	ID_menu INT,
	fecha DATETIME,
	FOREIGN KEY (ID_mesa) REFERENCES Mesas(ID_mesa),
	FOREIGN KEY (ID_menu) REFERENCES Menus(ID_menu)
);

CREATE TABLE Productos (
	ID_producto INT PRIMARY KEY,
	tipo VARCHAR(100),
	descripcion TEXT,
	stock INT
);

CREATE TABLE ComandaPlato (
	ID_comanda INT,
	ID_plato INT,
	cantidad INT,
	PRIMARY KEY (ID_comanda, ID_plato),
	FOREIGN KEY (ID_comanda) REFERENCES Comandas(ID_comanda),
	FOREIGN KEY (ID_plato) REFERENCES Platos(ID_plato)
);

CREATE TABLE MenuPlato (
	ID_menu INT,
	ID_plato INT,
	PRIMARY KEY (ID_menu, ID_plato),
	FOREIGN KEY (ID_menu) REFERENCES Menus(ID_menu),
	FOREIGN KEY (ID_plato) REFERENCES Platos(ID_plato)
);

CREATE TABLE PlatoProducto (
	ID_plato INT,
	ID_producto INT,
    Cantidad INT,
	PRIMARY KEY (ID_plato, ID_producto),
	FOREIGN KEY (ID_plato) REFERENCES Platos(ID_plato),
	FOREIGN KEY (ID_producto) REFERENCES Productos(ID_producto)
);

# ========== FUNCIONES ==========

# Visualización de mesas y camareros asignados

DELIMITER //

CREATE FUNCTION VerMesasYCamareros() RETURNS TEXT
DETERMINISTIC
BEGIN
    DECLARE resultado TEXT;

    SELECT CONCAT('Mesa ', Mesas.numero, ': ', Camareros.nombre, ' (ID Camarero: ', Camareros.ID_camarero, ')') INTO resultado
    FROM Mesas
    LEFT JOIN Camareros ON Mesas.ID_camarero = Camareros.ID_camarero;

    RETURN resultado;
END //

# 2 Registro de las comandas

DELIMITER //

CREATE FUNCTION RegistrarComanda(p_id_mesa INT, p_id_menu INT, p_fecha DATETIME) RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE comanda_id INT;
    
    INSERT INTO Comandas(ID_mesa, ID_menu, fecha)
    VALUES (p_id_mesa, p_id_menu, p_fecha);
    
    SET comanda_id = LAST_INSERT_ID();
    
    RETURN comanda_id;
END //

# 3 Agregar un plato a la comanda
DELIMITER //

CREATE FUNCTION AgregarPlatoAComanda(p_id_comanda INT,
    p_id_plato INT,
    p_cantidad INT
) RETURNS INT DETERMINISTIC
BEGIN
    DECLARE registro_id INT;
    
    INSERT INTO ComandaPlato(ID_comanda, ID_plato, cantidad)
    VALUES (p_id_comanda, p_id_plato, p_cantidad);
    
    SET registro_id = LAST_INSERT_ID();
    
    RETURN registro_id;
END //

# 4 Mostrar los menús disponibles

DELIMITER //

CREATE FUNCTION MostrarMenusDisponibles() RETURNS TEXT
DETERMINISTIC
BEGIN
    DECLARE resultado TEXT;
    
    SELECT GROUP_CONCAT(nombre SEPARATOR ', ') INTO resultado
    FROM Menus;
    
    RETURN resultado;
END //

# 5 Actualizar el stock de los productos después de hacer un plato

DELIMITER //

CREATE FUNCTION ActualizarStockProductos(p_id_plato INT) RETURNS BOOLEAN
DETERMINISTIC
BEGIN
    DECLARE actualizado BOOLEAN DEFAULT FALSE;

	# Actualización
    UPDATE Productos P
    INNER JOIN PlatoProducto PP ON P.ID_producto = PP.ID_producto
    SET P.stock = P.stock - PP.Cantidad
    WHERE PP.ID_plato = p_id_plato;

	# Verificar que hay más de una unidad
    IF ROW_COUNT() > 0 THEN
        SET actualizado = TRUE;
    END IF;

    RETURN actualizado;
END //

SHOW VARIABLES LIKE "secure_file_priv";

LOAD DATA INFILE 'C:/Program Files/MySQL/MySQL Workbench 8.0 CE/holstein.csv'
INTO TABLE Usuarios
FIELDS TERMINATED BY ';' 
ENCLOSED BY '"'
ROWS TERMINATED BY '\n'
IGNORE 1 ROWS
(ID_usuario, nombre, rol);

# Datos Importados de la tabla Camareros
LOAD DATA INFILE 'C:/xampp/mysql/holstein.csv'
INTO TABLE Camareros
FIELDS TERMINATED BY ';' 
ENCLOSED BY '"'
ROWS TERMINATED BY '\n'
IGNORE 1 ROWS
(ID_camarero, nombre, ID_usuario);

# Datos Importados de la tabla Mesas
LOAD DATA INFILE 'C:/xampp/mysql/holstein.csv'
INTO TABLE Mesas
FIELDS TERMINATED BY ';' 
ENCLOSED BY '"'
ROWS TERMINATED BY '\n'
IGNORE 1 ROWS
(ID_mesa, numero, capacidad, ID_camarero);

-- Importar datos de Comandas
LOAD DATA INFILE 'C:/xampp/mysql/holstein.csv'
INTO TABLE Comandas
FIELDS TERMINATED BY ';' 
ENCLOSED BY '"'
ROWS TERMINATED BY '\n'
IGNORE 1 ROWS
(ID_comanda, ID_mesa, fecha);

-- Importar datos de Platos
LOAD DATA INFILE 'C:/xampp/mysql/holstein.csv'
INTO TABLE Platos
FIELDS TERMINATED BY ';' 
ENCLOSED BY '"'
ROWS TERMINATED BY '\n'
IGNORE 1 ROWS
(ID_plato, nombre, descripcion);

-- Importar datos de Menus
LOAD DATA INFILE 'C:/xampp/mysql/holstein.csv'
INTO TABLE Menus
FIELDS TERMINATED BY ';' 
ENCLOSED BY '"'
ROWS TERMINATED BY '\n'
IGNORE 1 ROWS
(ID_menu, nombre, precio, tipo, descripcion);

-- Importar datos de Productos
LOAD DATA INFILE 'C:/xampp/mysql/holstein.csv'
INTO TABLE Productos
FIELDS TERMINATED BY ';' 
ENCLOSED BY '"'
ROWS TERMINATED BY '\n'
IGNORE 1 ROWS
(ID_producto, tipo, descripcion, stock);

-- Importar datos de ComandaPlato
LOAD DATA INFILE 'C:/xampp/mysql/holstein.csv'
INTO TABLE ComandaPlato
FIELDS TERMINATED BY ';' 
ENCLOSED BY '"'
ROWS TERMINATED BY '\n'
IGNORE 1 ROWS
(ID_comanda, ID_plato, cantidad);
