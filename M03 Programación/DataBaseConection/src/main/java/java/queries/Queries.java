package queries;

public class Queries {
    // Obtener todos los usuarios
    public static final String GET_ALL_USERS = "SELECT * FROM Usuarios;";

    // Obtener todos los camareros
    public static final String GET_ALL_WAITERS = "SELECT * FROM Camareros;";

    // Obtener todos los cocineros
    public static final String GET_ALL_COOKS = "SELECT * FROM Cocinero;";

    // Obtener todas las mesas con su camarero asignado (si lo tienen)
    public static final String GET_ALL_TABLES_WITH_WAITER = "SELECT Mesas.ID_mesa, Mesas.Numero, Mesas.Capacidad, Mesas.Disponibilidad, Camareros.Nombre AS Nombre_camarero " +
            "FROM Mesas " +
            "LEFT JOIN Camareros ON Mesas.ID_camarero = Camareros.ID_camarero;";

    // Obtener todos los platos y su respectivo chef
    public static final String GET_ALL_DISHES_WITH_CHEF = "SELECT Platos.ID_plato, Platos.Nombre, Platos.Descripcion, Cocinero.id_usuario AS ID_chef, Cocinero.salario AS Salario_chef " +
            "FROM Platos " +
            "LEFT JOIN Cocinero ON Platos.id_chef = Cocinero.id_usuario;";

    // Obtener todos los menús
    public static final String GET_ALL_MENUS = "SELECT * FROM Menus;";

    // Obtener todas las comandas junto con los detalles de mesa y menú
    public static final String GET_ALL_ORDERS_WITH_DETAILS = "SELECT Comandas.ID_comanda, Comandas.Fecha, Mesas.Numero AS Numero_mesa, Menus.Nombre AS Nombre_menu " +
            "FROM Comandas " +
            "JOIN Mesas ON Comandas.ID_mesa = Mesas.ID_mesa " +
            "JOIN Menus ON Comandas.ID_menu = Menus.ID_menu;";

    // Obtener todos los productos disponibles
    public static final String GET_ALL_AVAILABLE_PRODUCTS = "SELECT * FROM Productos WHERE Stock > 0;";

    // Obtener todos los pedidos de una mesa específica
    public static final String GET_ORDERS_BY_TABLE = "SELECT Comandas.ID_comanda, Comandas.Fecha, Mesas.Numero AS Numero_mesa, Menus.Nombre AS Nombre_menu " +
            "FROM Comandas " +
            "JOIN Mesas ON Comandas.ID_mesa = Mesas.ID_mesa " +
            "JOIN Menus ON Comandas.ID_menu = Menus.ID_menu " +
            "WHERE Mesas.Numero = ?;";

    // Obtener todos los platos pedidos en una comanda específica
    public static final String GET_DISHES_BY_ORDER = "SELECT Platos.Nombre AS Nombre_plato, ComandaPlato.Cantidad " +
            "FROM ComandaPlato " +
            "JOIN Platos ON ComandaPlato.ID_plato = Platos.ID_plato " +
            "WHERE ComandaPlato.ID_comanda = ?;";

    // Obtener todos los camareros que trabajan en un turno específico
    public static final String GET_WAITERS_BY_SHIFT = "SELECT * FROM Camareros WHERE turno = ?;";

    // Obtener todos los platos que contienen un ingrediente específico
    public static final String GET_DISHES_BY_INGREDIENT = "SELECT Platos.Nombre AS Nombre_plato, Platos.Descripcion " +
            "FROM Platos " +
            "JOIN PlatoProducto ON Platos.ID_plato = PlatoProducto.ID_plato " +
            "JOIN Productos ON PlatoProducto.ID_producto = Productos.ID_producto " +
            "WHERE Productos.Nombre LIKE ?;";

    // Obtener el número total de mesas disponibles
    public static final String GET_TOTAL_AVAILABLE_TABLES = "SELECT COUNT(*) AS Total_mesas_disponibles FROM Mesas WHERE Disponibilidad = 'disponible';";

    // Obtener el top N de platos más pedidos
    public static final String GET_TOP_N_ORDERED_DISHES = "SELECT Platos.Nombre AS Nombre_plato, SUM(ComandaPlato.Cantidad) AS Total_pedidos " +
            "FROM ComandaPlato " +
            "JOIN Platos ON ComandaPlato.ID_plato = Platos.ID_plato " +
            "GROUP BY ComandaPlato.ID_plato " +
            "ORDER BY Total_pedidos DESC " +
            "LIMIT ?;";

    // Obtener los platos de un menú específico
    public static final String GET_DISHES_BY_MENU = "SELECT Platos.Nombre AS Nombre_plato, Platos.Descripcion " +
            "FROM Platos " +
            "JOIN MenuPlato ON Platos.ID_plato = MenuPlato.ID_plato " +
            "JOIN Menus ON MenuPlato.ID_menu = Menus.ID_menu " +
            "WHERE Menus.Nombre = ?;";
}

"String query = Queries.GET_ALL_USERS;"
