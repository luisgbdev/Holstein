# ======= Procedimientos Almacenados =======

# 1. Calcular la facturación total de un día específico
DELIMITER //

CREATE PROCEDURE CalcularFacturacionDiaria(IN p_fecha DATE, OUT p_total DECIMAL(10, 2))
DETERMINISTIC
BEGIN
    SELECT SUM(Precio * Cantidad) INTO p_total
    FROM Comandas
    JOIN Menus ON Comandas.ID_menu = Menus.ID_menu
    WHERE DATE(Fecha) = p_fecha;
END //

# 2. Verificar la disponibilidad de una mesa en un horario específico
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

# 3. Calcular el salario total de un camarero en un período de tiempo específico
DELIMITER //

CREATE PROCEDURE CalcularSalarioCamarero(IN p_id_camarero INT, IN p_fecha_inicio DATE, IN p_fecha_fin DATE, OUT p_salario_total DECIMAL(10, 2))
DETERMINISTIC
BEGIN
    SELECT SUM(salario) INTO p_salario_total
    FROM Camareros
    WHERE ID_camarero = p_id_camarero
    AND DATE(horario_trabajo) BETWEEN p_fecha_inicio AND p_fecha_fin;
END //

# 4. Verificar si un plato está agotado en el menú
DELIMITER //

CREATE PROCEDURE VerificarPlatoAgotado(IN p_id_plato INT, OUT p_agotado BOOLEAN)
DETERMINISTIC
BEGIN
    DECLARE stock_actual INT;
   
    SELECT Stock INTO stock_actual
    FROM Productos
    WHERE ID_producto = p_id_plato;
   
    IF stock_actual <= 0 THEN
        SET p_agotado = TRUE;
    ELSE
        SET p_agotado = FALSE;
    END IF;
END //

# 5. Generar un reporte de ventas por camarero en un rango de fechas
DELIMITER //

CREATE PROCEDURE ReporteVentasCamarero(IN p_fecha_inicio DATE, IN p_fecha_fin DATE)
DETERMINISTIC
BEGIN
    SELECT Camareros.Nombre, COUNT(*) AS Total_Comandas
    FROM Comandas
    JOIN Mesas ON Comandas.ID_mesa = Mesas.ID_mesa
    JOIN Camareros ON Mesas.ID_camarero = Camareros.ID_camarero
    WHERE Fecha BETWEEN p_fecha_inicio AND p_fecha_fin
    GROUP BY Camareros.Nombre;
END //
