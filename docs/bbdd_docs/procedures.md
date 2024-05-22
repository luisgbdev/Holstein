# Procedimientos Almacenados

En este documento se presentan varios procedimientos almacenados diseñados para operaciones comunes en la gestión de un restaurante. Estos procedimientos permiten calcular la facturación diaria, verificar la disponibilidad de mesas, calcular el salario de un camarero, verificar la disponibilidad de un plato en el menú y generar un reporte de ventas por camarero en un rango de fechas.

## 1. Calcular la facturación total de un día específico

Este procedimiento calcula la facturación total de un día específico sumando el precio total de todas las comandas realizadas en dicho día.

```sql
DELIMITER //

CREATE PROCEDURE CalcularFacturacionDiaria(IN p_fecha DATE, OUT p_total DECIMAL(10, 2))
DETERMINISTIC
BEGIN
    SELECT SUM(Precio * Cantidad) INTO p_total
    FROM Comandas
    JOIN Menus ON Comandas.ID_menu = Menus.ID_menu
    WHERE DATE(Fecha) = p_fecha;
END //


## 2. Verificar Disponibilidad de Mesa

Este procedimiento almacenado verifica la disponibilidad de una mesa en un horario específico. Toma como entrada el ID de la mesa y la fecha y hora en cuestión, y devuelve un valor booleano que indica si la mesa está disponible o no en ese momento.

### Descripción del Procedimiento

El procedimiento realiza los siguientes pasos:

1. Declara las variables `capacidad_mesa` y `ocupacion` para almacenar la capacidad máxima de la mesa y el número de comandas realizadas en esa mesa para la fecha y hora proporcionadas, respectivamente.

2. Consulta la capacidad de la mesa con el ID proporcionado en la tabla de Mesas y la almacena en la variable `capacidad_mesa`.

3. Cuenta el número de comandas realizadas en la mesa con el ID proporcionado para la fecha y hora especificadas en la tabla de Comandas y lo almacena en la variable `ocupacion`.

4. Compara el número de comandas registradas (`ocupacion`) con la capacidad máxima de la mesa (`capacidad_mesa`). Si el número de comandas es menor que la capacidad máxima, establece el valor de salida `p_disponible` en TRUE, lo que indica que la mesa está disponible. De lo contrario, establece `p_disponible` en FALSE, indicando que la mesa está ocupada.

### Uso del Procedimiento

Para utilizar este procedimiento, proporciona el ID de la mesa y la fecha y hora que deseas verificar. El procedimiento devolverá TRUE si la mesa está disponible en ese momento y FALSE si está ocupada.

Por ejemplo, puedes llamar al procedimiento de la siguiente manera en tu aplicación:

```sql
DELIMITER //

CREATE PROCEDURE VerificarDisponibilidadMesa(IN p_id_mesa INT, IN p_fecha_hora DATETIME, OUT p_disponible BOOLEAN)
DETERMINISTIC
BEGIN
    DECLARE capacidad_mesa INT;
    DECLARE ocupacion INT;
   
    SELECT Capacidad INTO capacidad_mesa
    FROM Mesas
    WHERE ID_mesa = p_id_mesa;
   
    SELECT COUNT(*) INTO ocupacion
    FROM Comandas
    WHERE ID_mesa = p_id_mesa
    AND Fecha = p_fecha_hora;
   
    IF ocupacion < capacidad_mesa THEN
        SET p_disponible = TRUE;
    ELSE
        SET p_disponible = FALSE;
    END IF;
END //
