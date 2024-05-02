DROP DATABASE IF EXISTS holstein;
CREATE DATABASE IF NOT EXISTS holstein;
use holstein;

CREATE TABLE Usuarios (
    ID_usuario INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(100),
    Rol VARCHAR(50),
    telefono INT(9),
    correo VARCHAR(50)
);

CREATE TABLE Camareros (
    ID_camarero INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(100),
    ID_usuario INT,
    salario INT,
    turno VARCHAR(50),
    horario_trabajo VARCHAR(50),
    FOREIGN KEY (ID_usuario) REFERENCES Usuarios(ID_usuario)
);

CREATE TABLE Cocinero (
    id_usuario INT PRIMARY KEY,
    salario DECIMAL(10,2),
    fecha_contratacion DATE NOT NULL,
    disponible BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (id_usuario) REFERENCES Usuarios(ID_usuario)
);

CREATE TABLE Mesas (
    ID_mesa INT PRIMARY KEY,
    Numero INT,
    Capacidad INT,
    Disponibilidad VARCHAR(50),
    ID_camarero INT,
    FOREIGN KEY (ID_camarero) REFERENCES Camareros(ID_camarero)
);

CREATE TABLE Platos (
    ID_plato INT PRIMARY KEY,
    Nombre VARCHAR(100),
    Descripcion TEXT,
    id_chef INT,
    FOREIGN KEY (id_chef) REFERENCES Cocinero(id_usuario)
);

CREATE TABLE Menus (
    ID_menu INT PRIMARY KEY,
    Nombre VARCHAR(100),
    Precio INT,
    tipo VARCHAR(50),
    Descripcion TEXT
);

CREATE TABLE Comandas (
    ID_comanda INT PRIMARY KEY,
    ID_mesa INT,
    ID_menu INT,
    Fecha DATETIME,
    FOREIGN KEY (ID_mesa) REFERENCES Mesas(ID_mesa),
    FOREIGN KEY (ID_menu) REFERENCES Menus(ID_menu)
);

CREATE TABLE Productos (
    ID_producto INT PRIMARY KEY,
    Nombre VARCHAR(100),
    Descripcion TEXT,
    Stock INT
);

CREATE TABLE ComandaPlato (
    ID_comanda INT,
    ID_plato INT,
    Cantidad INT,
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

# Datos de la tabla Usuarios
LOAD DATA INFILE 'C:/ArchivosCSV/Usuarios.csv'
INTO TABLE Usuarios
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(ID_usuario, Nombre, Rol, telefono, correo);

# Datos de la tabla Camareros
LOAD DATA INFILE 'C:/ArchivosCSV/Camarero.csv'
INTO TABLE Camareros
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(ID_camarero, Nombre, ID_usuario, salario, turno, horario_trabajo);

# Datos de la tabla Cocinero
LOAD DATA INFILE 'C:/ArchivosCSV/Cocineros.csv'
INTO TABLE Cocinero
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(id_usuario, salario, fecha_contratacion, disponible);

# Datos de la tabla Mesas
LOAD DATA INFILE 'C:/ArchivosCSV/Mesas.csv'
INTO TABLE Mesas
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(ID_mesa, Numero, Capacidad, Disponibilidad, ID_camarero);

# Datos de la tabla Platos
LOAD DATA INFILE 'C:/ArchivosCSV/Platos.csv'
INTO TABLE Platos
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(ID_plato, Nombre, Descripcion, id_chef);

# Datos de la tabla Menus
LOAD DATA INFILE 'C:/ArchivosCSV/Menu.csv'
INTO TABLE Menus
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(ID_menu, Nombre, Precio, tipo, Descripcion);

# Datos de la tabla Comandas
LOAD DATA INFILE 'C:/ArchivosCSV/Comandas.csv'
INTO TABLE Comandas
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(ID_comanda, ID_mesa, ID_menu, Fecha);

# Datos de la tabla Productos
LOAD DATA INFILE 'C:/ArchivosCSV/Productos.csv'
INTO TABLE Productos
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(ID_producto, Nombre, Descripcion, Stock);

# Datos de la tabla ComandaPlato
LOAD DATA INFILE 'C:/ArchivosCSV/ComandaPlato.csv'
INTO TABLE ComandaPlato
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(ID_comanda, ID_plato, Cantidad);


GRANT ALL PRIVILEGES ON holstein.* TO 'root'@'localhost' IDENTIFIED BY 'root';