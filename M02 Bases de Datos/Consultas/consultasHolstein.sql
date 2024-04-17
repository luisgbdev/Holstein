Consulta 1: Visualización de mesas y camareros asignados

SELECT Mesas.ID_mesa, Mesas.Numero, Mesas.Capacidad, Camareros.Nombre AS NombreCamarero
FROM Mesas
         LEFT JOIN Camareros ON Mesas.ID_camarero = Camareros.ID_camarero;

Consulta 2: Registro comanda

 INSERT INTO Comandas (ID_mesa, Fecha) VALUES (id_mesa, NOW());

Consulta 3: Agregar un plato a una comanda

INSERT INTO ComandaPlato (ID_comanda, ID_plato, Cantidad) VALUES (id_comanda, id_plato, cantidad);

Consulta 4: Ver menús disponibles

SELECT * FROM Menus;

Consulta 5: Actualizar stock después de hacer un plato

UPDATE Productos
SET Stock = Stock - (SELECT SUM(Cantidad) FROM PlatoProducto WHERE ID_plato = id_plato)
WHERE ID_producto IN (SELECT ID_producto FROM PlatoProducto WHERE ID_plato = id_plato);



