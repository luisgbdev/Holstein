CREATE DATABASE IF NOT EXISTS holstein;
USE holstein;

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



-- Cargar datos en la tabla Usuarios
LOAD DATA INFILE 'C:/Users/luiss/OneDrive/Documentos/csv/Usuarios.csv'
INTO TABLE Usuarios
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(ID_usuario, Nombre, Rol, telefono, correo);

-- Cargar datos en la tabla Camareros
LOAD DATA INFILE 'C:/Users/luiss/OneDrive/Documentos/csv/Camarero.csv'
INTO TABLE Camareros
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(ID_camarero, Nombre, ID_usuario, salario, turno, horario_trabajo);

-- Cargar datos en la tabla Cocinero
LOAD DATA INFILE 'C:/Users/luiss/OneDrive/Documentos/csv/Cocineros.csv'
INTO TABLE Cocinero
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(id_usuario, salario, fecha_contratacion, disponible);

-- Cargar datos en la tabla Mesas
LOAD DATA INFILE 'C:/Users/luiss/OneDrive/Documentos/csv/Mesas.csv'
INTO TABLE Mesas
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(ID_mesa, Numero, Capacidad, Disponibilidad, ID_camarero);

-- Cargar datos en la tabla Platos
LOAD DATA INFILE 'C:/Users/luiss/OneDrive/Documentos/csv/Platos.csv'
INTO TABLE Platos
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(ID_plato, Nombre, Descripcion, id_chef);

-- Cargar datos en la tabla Menus
LOAD DATA INFILE 'C:/Users/luiss/OneDrive/Documentos/csv/Menu.csv'
INTO TABLE Menus
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(ID_menu, Nombre, Precio, tipo, Descripcion);

-- Cargar datos en la tabla Comandas
LOAD DATA INFILE 'C:/Users/luiss/OneDrive/Documentos/csv/Comandas.csv'
INTO TABLE Comandas
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(ID_comanda, ID_mesa, ID_menu, Fecha);

-- Cargar datos en la tabla Productos
LOAD DATA INFILE 'C:/Users/luiss/OneDrive/Documentos/csv/Productos.csv'
INTO TABLE Productos
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(ID_producto, Nombre, Descripcion, Stock);

-- Cargar datos en la tabla ComandaPlato
LOAD DATA INFILE 'C:/Users/luiss/OneDrive/Documentos/csv/ComandaPlato.csv'
INTO TABLE ComandaPlato
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(ID_comanda, ID_plato, Cantidad);

drop database holstein