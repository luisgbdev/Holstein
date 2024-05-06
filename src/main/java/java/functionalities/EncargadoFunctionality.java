package functionalities;
import java.sql.*;
import java.util.*;
public class EncargadoFunctionality {
	

	    // Método para recopilar y mostrar mesas disponibles
	    public void mostrarMesasDisponibles(Connection conn) {
	        try {
	            String sql = "SELECT * FROM Mesas WHERE Disponibilidad = 'disponible';";
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);

	            List<Mesa> mesasDisponibles = new ArrayList<>();
	            while (rs.next()) {
	                Mesa mesa = new Mesa(rs.getInt("ID_mesa"), rs.getInt("Numero"), rs.getInt("Capacidad"));
	                mesasDisponibles.add(mesa);
	            }

	            // Mostrar las mesas disponibles
	            System.out.println("Mesas Disponibles:");
	            for (Mesa mesa : mesasDisponibles) {
	                System.out.println(mesa);
	            }

	            stmt.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // Otros métodos para la funcionalidad del Encargado, como asignar mesa, tomar nota de las reservas, etc.
	}

