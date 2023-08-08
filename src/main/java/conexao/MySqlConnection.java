package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

    private static final String url = "jdbc:mysql://localhost:3306/clientes";
    private static final String user = "root";
    private static final String senha = "Mm521995$$";

    private static Connection connection; // Armazena a conexão

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Found");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver not Found.", e);
        }
    }

    public static Connection createConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, user, senha);
                System.out.println("Connected to the database");
            } catch (SQLException e) {
                throw new RuntimeException("Not Connected.", e);
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed");
            } catch (SQLException e) {
                System.out.println("Error while closing connection: " + e.getMessage());
            }
        }
    }
}
