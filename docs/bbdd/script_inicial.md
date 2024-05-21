# Script Inicial de la Base de Datos

Este script crea las tablas necesarias para el sistema de gestión de un restaurante, incluyendo usuarios, camareros, mesas, comandas, platos, menús y productos. Las tablas están relacionadas mediante claves foráneas para mantener la integridad referencial.

## Descripción de las Tablas

- **Usuarios**: Almacena la información de los usuarios del sistema, como su ID, nombre y rol.
- **Camareros**: Contiene información de los camareros, vinculados a los usuarios.
- **Mesas**: Representa las mesas del restaurante y su capacidad, así como el camarero asignado.
- **Comandas**: Almacena las comandas realizadas en las mesas.
- **Platos**: Contiene la información de los platos disponibles.
- **Menus**: Almacena los menús disponibles en el restaurante.
- **Productos**: Guarda los productos necesarios para preparar los platos, junto con su stock.
- **ComandaPlato**: Registra los platos incluidos en cada comanda.
- **MenuPlato**: Relaciona los menús con los platos que incluyen.
- **PlatoProducto**: Relaciona los platos con los productos necesarios para su preparación.

## Script SQL

```sql
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
