# Funciones

Este documento contiene una descripción detallada de las funciones utilizadas en el sistema de gestión de mesas y comandas del restaurante.

## 1. Visualización de mesas y camareros asignados

La función `VerMesasYCamareros` devuelve un texto con la información de cada mesa y el camarero asignado a ella. 

```sql
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

## 2. Registrar Comanda

La función `RegistrarComanda` registra una nueva comanda en la base de datos y devuelve el ID de la comanda creada.

La función `RegistrarComanda` toma tres parámetros:
- `p_id_mesa`: El ID de la mesa asociada a la comanda.
- `p_id_menu`: El ID del menú asociado a la comanda.
- `p_fecha`: La fecha y hora en que se realiza la comanda.

Luego, inserta una nueva fila en la tabla `Comandas` con los valores proporcionados para la mesa, el menú y la fecha. Posteriormente, devuelve el ID de la comanda recién creada.

```sql
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

## 3. Agregar Plato a Comanda

Esta función `AgregarPlatoAComanda` agrega un plato específico a una comanda existente en la base de datos y devuelve el ID del registro creado.

La función `AgregarPlatoAComanda` toma tres parámetros:
- `p_id_comanda`: El ID de la comanda a la que se agregará el plato.
- `p_id_plato`: El ID del plato que se agregará a la comanda.
- `p_cantidad`: La cantidad del plato que se agregará a la comanda.

La función luego inserta una nueva fila en la tabla `ComandaPlato` con los valores proporcionados para el ID de la comanda, el ID del plato y la cantidad. Finalmente, devuelve el ID del registro de la comanda-plato recién creado.

```sql
DELIMITER //

CREATE FUNCTION AgregarPlatoAComanda(p_id_comanda INT, p_id_plato INT, p_cantidad INT) RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE registro_id INT;
   
    INSERT INTO ComandaPlato(ID_comanda, ID_plato, cantidad)
    VALUES (p_id_comanda, p_id_plato, p_cantidad);
   
    SET registro_id = LAST_INSERT_ID();
   
    RETURN registro_id;
END //

## 4. Mostrar Menús Disponibles

La función `MostrarMenusDisponibles` recupera los nombres de todos los menús disponibles en la base de datos y los devuelve como una cadena de texto separada por comas.

La función `MostrarMenusDisponibles` no toma ningún parámetro. Recupera los nombres de todos los menús disponibles en la tabla `Menus` y los concatena en una sola cadena de texto separada por comas.

```sql
DELIMITER //

CREATE FUNCTION MostrarMenusDisponibles() RETURNS TEXT
DETERMINISTIC
BEGIN
    DECLARE resultado TEXT;
   
    SELECT GROUP_CONCAT(nombre SEPARATOR ', ') INTO resultado
    FROM Menus;
   
    RETURN resultado;
END //

