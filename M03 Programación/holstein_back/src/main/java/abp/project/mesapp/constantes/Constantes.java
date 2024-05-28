
package abp.project.mesapp.constantes;

public class Constantes {
    //CONEXIONES
    public static final String USER = "root";
    public static final String PASS = "Sabores1234";
    public static final String SCHEMA = "vialacteadesabores";
    public static final String BBDD = "jdbc:mysql://localhost:3307/";
    //RUTAS DE ARCHIVO
    //public static final String PATH="src/main/java/org/ilernabarcelona/files/csv/";
    public static final String PATH="src/main/java/abp/project/mesapp/files/csv/";
    //RUTAS DE ARCHIVO ESPECÍFICO
    public static final String rutaDelArchivoCSVUsuario="Usuarios.csv";
    public static final  String rutaDelArchivoCSVChef="Chefs.csv";
    public static final  String rutaDelArchivoCSVCamarero="Camareros.csv";
    public static final String rutaDelArchivoCSVMesa="Mesas.csv";
    public static final String rutaDelArchivoCSVCliente="Clientes.csv";
    public static final String rutaDelArchivoCSVClienteMesa="Clientes_Mesas.csv";
    public static final String rutaDelArchivoCSVComanda="Comandas.csv";
    public static final String rutaDelArchivoCSVMenu="Menus.csv";
    public static final String rutaDelArchivoCSVMenuComanda="Menus_Comandas.csv";
    public static final String rutaDelArchivoCSVPlato="Platos.csv";
    public static final String rutaDelArchivoCSVMenuPlato ="Menus_Platos.csv";
    public static final String rutaDelArchivoCSVProductos ="Productos.csv";
    public static final String rutaDelArchivoCSVPlatoProducto ="Platos_Productos.csv";
    //INSERTS AUTOMÁTICOS
    public static final String INSERT_USUARIO = "INSERT INTO USUARIO VALUES(?,?,?,?,?,?,?,?,?)";
    public static final String INSERT_CHEF ="INSERT INTO CHEF VALUES(?,?,?,?)";
    public static final String INSERT_CAMARERO ="INSERT INTO CAMARERO VALUES(?,?,?,?)";
    public static final String INSERT_MESA ="INSERT INTO MESA VALUES(?,?,?,?)";
    public static final String INSERT_CLIENTE ="INSERT INTO CLIENTE VALUES(?,?,?)";
    public static final String INSERT_CLIENTE_MESA ="INSERT INTO CLIENTE_MESA VALUES(?,?,?)";
    public static final String INSERT_COMANDA ="INSERT INTO COMANDA VALUES(?,?,?,?)";
    public static final String INSERT_MENU="INSERT INTO MENU VALUES(?,?,?,?)";
    public static final String INSERT_MENU_COMANDAS="INSERT INTO MENU_COMANDA VALUES(?,?,?)";
    public static final String INSERT_PLATO ="INSERT INTO PLATO VALUES(?,?,?,?)";
    public static final String INSERT_MENU_PLATO="INSERT INTO MENU_PLATO VALUES(?,?)";
    public static final String INSERT_PRODUCTO ="INSERT INTO PRODUCTO VALUES(?,?,?,?)";
    public static final String INSERT_PLATOS_PRODUCTOS="INSERT INTO PLATO_PRODUCTO VALUES(?,?)";
    //SELECTS FUNCIONES Y PROCEDIMIENTOS JAVA
    //SELECTS EXCLUSIVOS JAVA
    public static final String SELECT_USUARIO="SELECT email,contrasena FROM USUARIO where email=? and contrasena =?";
    //CORREGIR LISTAR MESAS
    public static final String LISTAR_MESAS="SELECT m.num_mesa, m.disponibilidad, COUNT(cm.id_usuario) AS num_comensales\n" +
            "FROM MESA m\n" +
            "LEFT JOIN CLIENTE_MESA cm  m.num_mesa = cm.num_mesa\n" +
            "GROUP BY m.num_mesa\n" +
            "ORDER BY m.num_mesa";
    public static final String LISTAR_COMANDAS="SELECT id_comanda,fecha,pagado,num_mesa FROM COMANDA WHERE fecha = ? ORDER BY fecha";
    public static final String LISTAR_MENUS_PLATOS="SELECT m.id_menu, m.nombre_menu, p.id_plato, p.nombre_plato\n" +
            "FROM MENU m\n" +
            "LEFT JOIN MENU_PLATO mp ON m.id_menu = mp.id_menu\n" +
            "LEFT JOIN PLATO p ON mp.id_plato = p.id_plato\n" +
            "ORDER BY m.id_menu";
    public static final String LISTAR_PLATOS_NOMBRE="SELECT id_plato,nombre_plato,descripcion,id_chef FROM PLATO ORDER BY nombre_plato";
    public static final String MOSTRAR_INGREDIENTES="SELECT p.nombre_plato, pr.nombre\n" +
            "FROM PLATO p\n" +
            "INNER JOIN PLATO_PRODUCTO pp ON p.id_plato = pp.id_plato\n" +
            "INNER JOIN PRODUCTO pr ON pp.id_producto = pr.id_producto\n" +
            "ORDER BY p.nombre_plato, pr.nombre";
    public static final String MOSTRAR_ALERGENOS="SELECT DISTINCT alergenos FROM MENU_COMANDA";
    public static final String MOSTRAR_INGREDIENTESYSTOCK="SELECT nombre, stock FROM PRODUCTO";
    public static final String CAMBIO_DISPONIBILIDAD="UPDATE MESA SET disponibilidad = NOT disponibilidad WHERE num_mesa = ?";



}
