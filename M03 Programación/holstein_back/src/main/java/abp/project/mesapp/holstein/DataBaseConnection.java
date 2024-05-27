package abp.project.mesapp.holstein;

import abp.project.mesapp.model.*;
import abp.project.mesapp.util.CheckError;
import abp.project.mesapp.util.Constantes;
import abp.project.mesapp.data.FileManager;
import lombok.Getter;

import java.sql.*;
import java.util.ArrayList;

public class DataBaseConnection {
    //GETTER CONEXION
    @Getter
    private static Connection conn;
    public ArrayList<Usuario> usuarios;
    public ArrayList<Cocinero> cocineros;
    public ArrayList<Camarero> camareros;
    public ArrayList<Mesa> mesas;
    public ArrayList<Cliente> clientes;
    public ArrayList<Comanda> comandas;
    public ArrayList<Menu> menus;
    public ArrayList<abp.project.mesapp.model.Plato> platos;
    public ArrayList<MenuPlato> menus_platos;
    public ArrayList<Producto> productos;
    public ArrayList<PlatoProducto> platos_productos;


    public void init() throws SQLException {
        //Conectamos
        conectar();
        //Cargamos datos
        cargaDeDatosCSV();
        System.out.println("CARGA DE DATOS COMPLETADA :)!");
        //Desconectamos
        desconectar();
    }

    public static Connection getConnection()throws CheckError {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(Constantes.BBDD + Constantes.SCHEMA, Constantes.USER, Constantes.PASS);
        } catch (SQLException e) {
            throw new CheckError(CheckError.ERROR_CONNECT_BBDD);
        }
        return conn;
    }

    private void cargaDeDatosCSV() throws SQLException {
        //Instanciamos el fileManager
        FileManager fm = new FileManager();
        //USUARIOS
        usuarios = fm.cargaUsuariosCSV(Constantes.PATH+Constantes.rutaDelArchivoCSVUsuario);
        for (Usuario usuario : usuarios) {
            //Añadimos las querys
            insertUsuario(usuario);
        }
        //CHEFS
        cocineros = fm.cargaChefsCSV(Constantes.PATH+Constantes.rutaDelArchivoCSVChef);
        for (Cocinero cocinero : cocineros) {
            //Añadimos las querys
            insertCocinero(cocinero);
        }
        //CAMARERO
        camareros = fm.cargaCamarerosCSV(Constantes.PATH+Constantes.rutaDelArchivoCSVCamarero);
        for (Camarero camarero : camareros) {
            //Añadimos las querys
            insertCamarero(camarero);
        }
        //MESA
        mesas = fm.cargaMesaCSV(Constantes.PATH+Constantes.rutaDelArchivoCSVMesa);
        for (Mesa mesa : mesas) {
            //Añadimos las querys
            insertMesa(mesa);
        }
        //CLIENTE
        clientes = fm.cargaClientesCSV(Constantes.PATH+Constantes.rutaDelArchivoCSVCliente);
        for (Cliente cliente : clientes) {
            //Añadimos las querys
            insertCliente(cliente);
        }
        //CLIENTE_MESA
        clientes_mesas = fm.cargaClientes_MesasCSV(Constantes.PATH+Constantes.rutaDelArchivoCSVClienteMesa);
        for (Cliente_Mesa cliente_Mesa : clientes_mesas) {
            insertCliente_Mesa(cliente_Mesa);
        }
        //COMANDA
        comandas = fm.cargaComandasCSV(Constantes.PATH+Constantes.rutaDelArchivoCSVComanda);
        for (Comanda comanda : comandas) {
            insertComanda(comanda);
        }
        //MENU
        menus = fm.cargaMenuCSV(Constantes.PATH+Constantes.rutaDelArchivoCSVMenu);
        for (Menu menu : menus){
            insertMenu(menu);
        }
        //MENU_COMANDA
        menus_comandas = fm.cargaMenu_ComandasCSV(Constantes.PATH+Constantes.rutaDelArchivoCSVMenuComanda);
        for (Menu_Comanda menu_comanda : menus_comandas){
            insertMenu_Comanda(menu_comanda);
        }
        //PLATO
        platos = fm.cargaPlatoCSV(Constantes.PATH+Constantes.rutaDelArchivoCSVPlato);
        for (abp.project.mesapp.model.Plato plato : platos){
            insertPlato(plato);
        }
        //MENU_PLATO
        menus_platos = fm.cargaMenu_Plato(Constantes.PATH+Constantes.rutaDelArchivoCSVMenuPlato);
        for (MenuPlato menuPlato : menus_platos){
            insertMenu_Plato(menuPlato);
        }
        //PRODUCTO
        productos = fm.cargaProductosCSV(Constantes.PATH+Constantes.rutaDelArchivoCSVProductos);
        for (Producto producto : productos) {
            insertProducto(producto);
        }
        //PLATO PRODUCTO
        platosproductos = fm.cargaPlato_Producto(Constantes.PATH+Constantes.rutaDelArchivoCSVPlatoProducto);
        for (PlatoProducto platoProducto : platosproductos){
            insertPlato_Producto(platoProducto);
        }


    }




    // INSERT BBDD
    //USUARIO
    private void insertUsuario(Usuario usuario) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(Constantes.INSERT_USUARIO);
        ps.setInt(1, usuario.getId_usuario());
        // NOMBRE
        ps.setString(2, usuario.getNombre());
        // APPELLIDO1
        ps.setString(3, usuario.getApellido1());
        // APELLIDO2
        ps.setString(4, usuario.getApellido2());
        // FECHA_NACIMIENTO
        ps.setDate(5, usuario.getFecha_nacimiento());
        // EMAIL
        ps.setString(6, usuario.getEmail());
        // FECHA_REGISTRO
        ps.setDate(7, usuario.getFecha_registro());
        // TELEFONO
        ps.setString(8, usuario.getTelefono());
        //CONTRASEÑA
        ps.setString(9,usuario.getContrasena());
        //System.out.println(ps);
        int result = ps.executeUpdate();
        if (result == 0) {
            System.out.println("ERROR: no hay nada que actualizar");
        }

    }
    //CHEF
    private void insertChef(Cocinero cocinero) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(Constantes.INSERT_CHEF);
        //ID_USUARIO
        ps.setInt(1,cocinero.getId_usuario());
        //SALARIO
        ps.setDouble(2,cocinero.getSalario());
        //FECHA_CONTRATACION
        ps.setDate(3,cocinero.getFechaContratacion());
        //DISPONIBLE
        ps.setBoolean(4,cocinero.isDisponible());
        //System.out.println(ps);
        int result = ps.executeUpdate();
        if (result == 0) {
            System.out.println("ERROR: no hay nada que actualizar");
        }
    }
    //CAMARERO
    private void insertCamarero(Camarero camarero) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(Constantes.INSERT_CAMARERO);
        //ID_USUARIO
        ps.setInt(1,camarero.getId_usuario());
        //SALARIO
        ps.setDouble(2,camarero.getSalario());
        //FECHA_CONTRATACION
        ps.setDate(3,camarero.getFecha_contratacion());
        //DISPONIBLE
        ps.setBoolean(4,camarero.isDisponibilidad());
        //System.out.println(ps);
        int result = ps.executeUpdate();
        if (result == 0) {
            System.out.println("ERROR: no hay nada que actualizar");
        }
    }
    //MESA
    private void insertMesa(Mesa mesa) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(Constantes.INSERT_MESA);
        //NUM_MESA
        ps.setInt(1,mesa.getMesa());
        //ID_CAMARERO
        ps.setInt(2,mesa.getId_camarero());
        //FECHA_REGISTRO
        ps.setDate(3,mesa.getFecha_registro());
        //DISPONIBILIDAD
        ps.setBoolean(4,mesa.isDisponibilidad());
        //System.out.println(ps);
        int result = ps.executeUpdate();
        if (result == 0) {
            System.out.println("ERROR: no hay nada que actualizar");
        }

    }
    //CLIENTE
    private void insertCliente(Cliente cliente) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(Constantes.INSERT_CLIENTE);
        //ID_USUARIO
        ps.setInt(1, cliente.getId_usuario());
        //COMENSALES
        ps.setInt(2, cliente.getComensales());
        //FECHA_ULTIMARESERVA
        ps.setDate(3, cliente.getFecha_ultimaReserva());
        //System.out.println(ps);
        int result = ps.executeUpdate();
        if (result == 0) {
            System.out.println("ERROR: no hay nada que actualizar");
        }
    }
  
     //COMANDA
     private void insertComanda(Comanda comanda) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(Constantes.INSERT_COMANDA);
        //ID_COMANDA
         ps.setInt(1,comanda.getId_comanda());
         //FECHA
         ps.setDate(2,comanda.getFecha());
         //PAGADO
         ps.setBoolean(3,comanda.isPagado());
         //NUM_MESA
         ps.setInt(4,comanda.getNum_mesa());
         //System.out.println(ps);
         int result = ps.executeUpdate();
         if (result == 0) {
             System.out.println("ERROR: no hay nada que actualizar");
         }
     }
     //MENU
     private void insertMenu(Menu menu) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(Constantes.INSERT_MENU);
         //ID_MENU
         ps.setInt(1,menu.getId_menu());
         //NOMBRE_MENU
         ps.setString(2,menu.getNombre());
         //DESCRIPCION
         ps.setString(3,menu.getDescripcion());
         //PRECIO
         ps.setDouble(4,menu.getPrecio());
         //System.out.println(ps);
         int result = ps.executeUpdate();
         if (result == 0) {
             System.out.println("ERROR: no hay nada que actualizar");
         }
     }
   
    //PLATO
    private void insertPlato(abp.project.mesapp.model.Plato plato) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(Constantes.INSERT_PLATO);
        //ID_PLATO
        ps.setInt(1,plato.getId_plato());
        //NOMBRE_PLATO
        ps.setString(2,plato.getNombre_plato());
        //DESCRIPCION
        ps.setString(3,plato.getDescripcion());
        //ID_CHEF
        ps.setInt(4,plato.getId_chef());
        //System.out.println(ps);
        int result = ps.executeUpdate();
        if (result == 0) {
            System.out.println("ERROR: no hay nada que actualizar");
        }
    }
    //MENU_PLATO
    private void insertMenu_Plato(MenuPlato menuPlato) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(Constantes.INSERT_MENU_PLATO);
        //ID_MENU
        ps.setInt(1,menuPlato.getId_menu());
        //ID_PLATO
        ps.setInt(2,menuPlato.getId_plato());
        //System.out.println(ps);
        int result = ps.executeUpdate();
        if (result == 0) {
            System.out.println("ERROR: no hay nada que actualizar");
        }
    }

    //PRODUCTO
    private void insertProducto(Producto producto) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(Constantes.INSERT_PRODUCTO);
        //ID_PRODUCTO
        ps.setInt(1,producto.getIdproducto());
        //NOMBRE
        ps.setString(2,producto.getNombre());
        //STOCK
        ps.setInt(3,producto.getStock());
        //PROVEEDOR
        ps.setString(4,producto.getProveedor());
        //System.out.println(ps);
        int result = ps.executeUpdate();
        if (result == 0) {
            System.out.println("ERROR: no hay nada que actualizar");
        }
    }
    //PLATO PRODUCTO
    private void insertPlato_Producto(PlatoProducto platoProducto) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(Constantes.INSERT_PLATOS_PRODUCTOS);
        //ID_PLATO
        ps.setInt(1,platoProducto.getId_plato());
        //ID_PRODUCTO
        ps.setInt(2,platoProducto.getId_producto());
        //System.out.println(ps);
        int result = ps.executeUpdate();
        if (result == 0) {
            System.out.println("ERROR: no hay nada que actualizar");
        }
    }

    //METODOS
    public static void conectar() throws SQLException {
        //Nos conectamos
        conn = DriverManager.getConnection(Constantes.BBDD + Constantes.SCHEMA, Constantes.USER, Constantes.PASS);
    }
    public void desconectar() throws SQLException {
        conn.close();
    }
}

