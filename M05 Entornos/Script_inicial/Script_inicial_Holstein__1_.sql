CREATE TABLE Usuarios (
                          ID_usuario INT PRIMARY KEY,
                          Nombre VARCHAR(100),
                          Rol VARCHAR(50)
);

CREATE TABLE Camareros (
                           ID_camarero INT PRIMARY KEY,
                           Nombre VARCHAR(100),
                           ID_usuario INT,
                           FOREIGN KEY (ID_usuario) REFERENCES Usuarios(ID_usuario)
);

CREATE TABLE Mesas (
                       ID_mesa INT PRIMARY KEY,
                       Numero INT,
                       Capacidad INT,
                       ID_camarero INT,
                       FOREIGN KEY (ID_camarero) REFERENCES Camareros(ID_camarero)
);

CREATE TABLE Comandas (
                          ID_comanda INT PRIMARY KEY,
                          ID_mesa INT,
                          Fecha DATETIME,
                          FOREIGN KEY (ID_mesa) REFERENCES Mesas(ID_mesa)
);

CREATE TABLE Platos (
                        ID_plato INT PRIMARY KEY,
                        Nombre VARCHAR(100),
                        Descripcion TEXT
);

CREATE TABLE Menus (
                       ID_menu INT PRIMARY KEY,
                       Nombre VARCHAR(100)
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
