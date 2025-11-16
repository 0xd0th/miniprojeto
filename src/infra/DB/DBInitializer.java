package infra.DB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBInitializer {

    public static void init() {

        try ( Connection conexao = DBConnection.createConnection() ) {

            Statement stmt = conexao.createStatement();

            //stmt.execute("DROP DATABASE miniprojeto;");
            //stmt.execute("CREATE DATABASE miniprojeto;");
            //stmt.execute("USE miniprojeto");

            String createDiscente = """
                    CREATE TABLE IF NOT EXISTS discente (
                        id INT PRIMARY KEY,
                        nome VARCHAR(100) NOT NULL,
                        curso VARCHAR(50) NOT NULL,
                        modalidade VARCHAR(15) NOT NULL,
                        status VARCHAR(20) NOT NULL
                    );
                    """;

            String createDisciplina = """
                    CREATE TABLE IF NOT EXISTS disciplina (
                        id INT PRIMARY KEY,
                        curso VARCHAR(50) NOT NULL,
                        nome VARCHAR(50) NOT NULL,
                        vagas INT NOT NULL
                    );
                    """;

            String createLivro = """
                    CREATE TABLE IF NOT EXISTS livro (
                        id INT PRIMARY KEY,
                        titulo VARCHAR(50) NOT NULL,
                        autor VARCHAR(100) NOT NULL,
                        ano INT NOT NULL,
                        status VARCHAR(20) NOT NULL
                    );
                    """;

            stmt.execute(createDiscente);
            stmt.execute(createDisciplina);
            stmt.execute(createLivro);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


}
