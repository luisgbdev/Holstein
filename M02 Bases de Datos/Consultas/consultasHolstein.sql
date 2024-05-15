-- Obtener todos los usuarios
SELECT * FROM Usuarios;

-- Obtener todos los camareros
SELECT * FROM Camareros;

-- Obtener todos los cocineros
SELECT * FROM Cocinero;

-- Obtener todas las mesas con su camarero asignado (si lo tienen)
SELECT Mesas.ID_mesa, Mesas.Numero, Mesas.Capacidad, Mesas.Disponibilidad, Camareros.Nombre AS Nombre_camarero
FROM Mesas
LEFT JOIN Camareros ON Mesas.ID_camarero = Camareros.ID_camarero;

-- Obtener todos los platos y su respectivo chef
SELECT Platos.ID_plato, Platos.Nombre, Platos.Descripcion, Cocinero.id_usuario AS ID_chef, Cocinero.salario AS Salario_chef
FROM Platos
LEFT JOIN Cocinero ON Platos.id_chef = Cocinero.id_usuario;

-- Obtener todos los menús
SELECT * FROM Menus;

-- Obtener todas las comandas junto con los detalles de mesa y menú
SELECT Comandas.ID_comanda, Comandas.Fecha, Mesas.Numero AS Numero_mesa, Menus.Nombre AS Nombre_menu
FROM Comandas
JOIN Mesas ON Comandas.ID_mesa = Mesas.ID_mesa
JOIN Menus ON Comandas.ID_menu = Menus.ID_menu;

-- Obtener todos los productos disponibles
SELECT * FROM Productos WHERE Stock > 0;

-- Obtener todos los pedidos de una mesa específica
SELECT Comandas.ID_comanda, Comandas.Fecha, Mesas.Numero AS Numero_mesa, Menus.Nombre AS Nombre_menu
FROM Comandas
JOIN Mesas ON Comandas.ID_mesa = Mesas.ID_mesa
JOIN Menus ON Comandas.ID_menu = Menus.ID_menu
WHERE Mesas.Numero = 'numero_mesa_deseado';

-- Obtener todos los platos pedidos en una comanda específica
SELECT Platos.Nombre AS Nombre_plato, ComandaPlato.Cantidad
FROM ComandaPlato
JOIN Platos ON ComandaPlato.ID_plato = Platos.ID_plato
WHERE ComandaPlato.ID_comanda = 'id_comanda_deseado';

-- Obtener todos los camareros que trabajan en un turno específico
SELECT * FROM Camareros WHERE turno = 'turno_deseado';

-- Obtener todos los platos que contienen un ingrediente específico
SELECT Platos.Nombre AS Nombre_plato, Platos.Descripcion
FROM Platos
JOIN PlatoProducto ON Platos.ID_plato = PlatoProducto.ID_plato
JOIN Productos ON PlatoProducto.ID_producto = Productos.ID_producto
WHERE Productos.Nombre LIKE '%nombre_ingrediente%';

-- Obtener el número total de mesas disponibles
SELECT COUNT(*) AS Total_mesas_disponibles FROM Mesas WHERE Disponibilidad = 'disponible';

-- Obtener el top N de platos más pedidos
SELECT Platos.Nombre AS Nombre_plato, SUM(ComandaPlato.Cantidad) AS Total_pedidos
FROM ComandaPlato
JOIN Platos ON ComandaPlato.ID_plato = Platos.ID_plato
GROUP BY ComandaPlato.ID_plato
ORDER BY Total_pedidos DESC
LIMIT N;

-- Obtener los platos de un menú específico
SELECT Platos.Nombre AS Nombre_plato, Platos.Descripcion
FROM Platos
JOIN MenuPlato ON Platos.ID_plato = MenuPlato.ID_plato
JOIN Menus ON MenuPlato.ID_menu = Menus.ID_menu
WHERE Menus.Nombre = 'nombre_menu_deseado';

-- Obtener todos los platos de un tipo específico
SELECT * FROM Platos WHERE tipo = 'tipo_deseado';

-- Obtener plato separado por ingredientes
SELECT Platos.Nombre AS Nombre_plato, GROUP_CONCAT(Ingredientes.Nombre SEPARATOR ', ') AS Ingredientes
FROM Platos
JOIN PlatoIngredientes ON Platos.ID_plato = PlatoIngredientes.ID_plato
JOIN Ingredientes ON PlatoIngredientes.ID_ingrediente = Ingredientes.ID_ingrediente
GROUP BY Platos.ID_plato;

-- Obtener precio platos
SELECT Platos.Nombre AS Nombre_plato, PreciosPlatos.Precio
FROM Platos
JOIN PreciosPlatos ON Platos.ID_plato = PreciosPlatos.ID_plato;

-- Obtener precio total
SELECT SUM(Platos.Precio * ComandaPlato.Cantidad) AS Precio_total
FROM ComandaPlato
JOIN Platos ON ComandaPlato.ID_plato = Platos.ID_plato
WHERE ComandaPlato.ID_comanda = 'id_comanda_deseado';

-- Obtener detalles menú

SELECT * FROM Menus WHERE ID_menu = 'id_menu_deseado';

-- Obtener detalles mesa

SELECT * FROM Mesas WHERE ID_mesa = 'id_mesa_deseado';



