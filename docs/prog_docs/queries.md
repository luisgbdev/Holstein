# Queries

En este documento se presentan las diferentes consultas SQL utilizadas en la aplicación para interactuar con la base de datos. Estas consultas están organizadas para obtener información específica de las tablas `Usuarios`, `Camareros`, `Cocinero`, `Mesas`, `Platos`, `Menus`, `Comandas`, `Productos`, y otras entidades relacionadas. A continuación se detallan las consultas disponibles.

## Lista de Consultas

### Obtener todos los usuarios
Consulta para obtener todos los registros de la tabla `Usuarios`.

```sql
String query = Queries.GET_ALL_USERS;
SELECT * FROM Usuarios;
```


### Obtener todos los camareros
Consulta para obtener todos los registros de la tabla `Camareros`.

```sql
String query = Queries.GET_ALL_WAITERS;
SELECT * FROM Camareros;

```

### Obtener todos los cocineros
Consulta para obtener todos los registros de la tabla `Cocineros`.

```sql
String query = Queries.GET_ALL_COOKS;
SELECT * FROM Cocinero;


```


### Obtener todos los cocineros
Consulta para obtener todos los registros de la tabla `Cocineros`.

```sql
String query = Queries.GET_ALL_COOKS;
SELECT * FROM Cocinero;


```


### Obtener todos los cocineros
Consulta para obtener todos los registros de la tabla `Cocineros`.

```sql
String query = Queries.GET_ALL_COOKS;
SELECT * FROM Cocinero;


```


### Obtener todas las mesas con su camarero asignado
Consulta para obtener todas las mesas junto con su camarero asignado, si lo tienen.

```sql
String query = Queries.GET_ALL_TABLES_WITH_WAITER;
SELECT Mesas.ID_mesa, Mesas.Numero, Mesas.Capacidad, Mesas.Disponibilidad, Camareros.Nombre AS Nombre_camarero
FROM Mesas
LEFT JOIN Camareros ON Mesas.ID_camarero = Camareros.ID_camarero;

```


### Obtener todos los platos y su respectivo chef
Consulta para obtener todos los platos junto con su respectivo chef.

```sql
String query = Queries.GET_ALL_DISHES_WITH_CHEF;
SELECT Platos.ID_plato, Platos.Nombre, Platos.Descripcion, Cocinero.id_usuario AS ID_chef, Cocinero.salario AS Salario_chef
FROM Platos
LEFT JOIN Cocinero ON Platos.id_chef = Cocinero.id_usuario;
```

### Obtener todos los menús
Consulta para obtener todos los registros de la tabla 
`Menus`.
```sql
String query = Queries.GET_ALL_MENUS;
SELECT * FROM Menus;

```
