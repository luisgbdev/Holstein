CREATE TABLE Usuarios (
                          ID_usuario INT PRIMARY KEY,
                          Nombre VARCHAR(100),
                          Rol VARCHAR(50),
                          telefono int (9),
                          correo VARCHAR(50)
);

CREATE TABLE Camareros (
                           ID_camarero INT PRIMARY KEY,
                           Nombre VARCHAR(100),
                           ID_usuario INT,
                           salario INT,
                           turno VARCHAR(50) ,
                           horario_trabajo VARCHAR(50),
                           FOREIGN KEY (ID_usuario) REFERENCES Usuarios(ID_usuario)
);

CREATE TABLE Cocinero(
    id_usuario INT,
    salario DECIMAL(10,2),
    fecha_contratacion DATE NOT NULL,
    disponible BOOLEAN DEFAULT TRUE,
    PRIMARY KEY (id_usuario),
    FOREIGN KEY(id_usuario) REFERENCES USUARIOS(id)
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
                        id_chef int,
                        FOREIGN KEY (id_chef) REFERENCES CHEF(id_usuario)
);

CREATE TABLE Menus (
                       ID_menu INT PRIMARY KEY,
                       Nombre VARCHAR(100),
                       Precio int,
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
                           Tipo VARCHAR(100),
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
