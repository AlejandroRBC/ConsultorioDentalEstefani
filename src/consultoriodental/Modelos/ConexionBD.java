
package consultoriodental.Modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/consultoriodental";
    private static final String USER = "abernasc";
    private static final String PASSWORD = "123456";
    
    
    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    
    // Método para probar la conexión
    public static boolean probarConexion() {
        try (Connection conn = getConexion()) {
            return true;
        } catch (SQLException e) {
            System.err.println("Error al conectar: " + e.getMessage());
            return false;
        }
    }
}
