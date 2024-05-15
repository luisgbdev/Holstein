package java.functionalities;
import java.sql.*;
import java.util.*;
public class CamareroFunctionality {
	public void atenderMesa(Connection conn, Mesa mesa) {
        try {
            // Obtener la información de la mesa y sus pedidos
            String sql = "SELECT * FROM Comandas WHERE ID_mesa = ?;";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, mesa.getId());
            ResultSet rs = pstmt.executeQuery();

            List<Pedido> pedidos = new ArrayList<>();
            while (rs.next()) {
                Pedido pedido = new Pedido(rs.getInt("ID_comanda"), rs.getDate("Fecha"), mesa, rs.getString("Detalle"));
                pedidos.add(pedido);
            }

            // Mostrar los pedidos de la mesa
            System.out.println("Pedidos de la Mesa " + mesa.getNumero() + ":");
            for (Pedido pedido : pedidos) {
                System.out.println(pedido);
            }

            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para informar al cocinero sobre los pedidos
    public void informarCocinero(Connection conn, List<Pedido> pedidos) {
        // Implementa lógica para enviar los pedidos al cocinero
    }

    // Método para traer platos a la mesa
    public void traerPlatos(Connection conn, Pedido pedido) {
        // Implementa lógica para llevar los platos a la mesa del cliente
    }

    // Método para retirar platos vacíos de la mesa
    public void retirarPlatos(Connection conn, Pedido pedido) {
        // Implementa lógica para retirar los platos vacíos de la mesa del cliente
    }

    // Otros métodos para las funcionalidades del Camarero, como apuntar platos, etc.
}
}
