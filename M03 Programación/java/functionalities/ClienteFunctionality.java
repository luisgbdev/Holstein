package functionalities;
import java.sql.*;
import java.util.*;
public class ClienteFunctionality {
	  public void verMenu(Connection conn) {
	        try {
	            String sql = "SELECT * FROM Menu;";
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);

	            List<Menu> menuItems = new ArrayList<>();
	            while (rs.next()) {
	                Menu menuItem = new Menu(rs.getInt("ID_menu"), rs.getString("Nombre"), rs.getDouble("Precio"));
	                menuItems.add(menuItem);
	            }

	            // Mostrar el menú
	            System.out.println("Menú Disponible:");
	            for (Menu menuItem : menuItems) {
	                System.out.println(menuItem);
	            }

	            stmt.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // Método para pedir platos del menú
	    public void pedirPlatos(Connection conn, List<Plato> platosPedidos) {
	        // Implementa lógica para que el cliente seleccione platos y los agregue a la lista de platosPedidos
	    }

	    // Método para ver las bebidas disponibles
	    public void verBebidas(Connection conn) {
	        try {
	            String sql = "SELECT * FROM Bebidas;";
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);

	            List<Bebida> bebidasDisponibles = new ArrayList<>();
	            while (rs.next()) {
	                Bebida bebida = new Bebida(rs.getInt("ID_bebida"), rs.getString("Nombre"), rs.getDouble("Precio"));
	                bebidasDisponibles.add(bebida);
	            }

	            // Mostrar las bebidas disponibles
	            System.out.println("Bebidas Disponibles:");
	            for (Bebida bebida : bebidasDisponibles) {
	                System.out.println(bebida);
	            }

	            stmt.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // Método para pedir bebidas
	    public void pedirBebidas(Connection conn, List<Bebida> bebidasPedidas) {
	        // Implementa lógica para que el cliente seleccione bebidas y las agregue a la lista de bebidasPedidas
	    }

	    // Otros métodos para las funcionalidades del Cliente, como ver carta, pedir menú, etc.
	
}
