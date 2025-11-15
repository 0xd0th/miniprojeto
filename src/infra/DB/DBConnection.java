package infra.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String url = "jdbc:mysql://localhost:3306/miniprojeto";
    private static final String user = "root";
    private static final String password = "root";

    private static final Connection conexao = createConnection();

    public static Connection createConnection() {

        Connection conexao = null;

        try {
            conexao = DriverManager.getConnection(url, user, password);
        } catch ( SQLException e ) {
            System.out.println("Conexao com o banco de dados falhou");
            return null;
        }

        return conexao;

    }

    public static Connection getConnection() {
        return conexao;
    }

}
