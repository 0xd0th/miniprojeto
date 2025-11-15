package dao;

import infra.DB.DBConnection;
import model.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class LivroDAO {

    private static final Connection conexao = DBConnection.getConnection();

    public static void inserirLivros( ArrayList<Livro> livros ) {

        String sql = """
                INSERT INTO livro (id, titulo, autor, ano, status) VALUES (?, ?, ?, ?, ?);
                """;

        for ( Livro livro : livros ) {

            try ( PreparedStatement stmt = conexao.prepareStatement(sql) ) {

                stmt.setInt(1, livro.getId());
                stmt.setString(2, livro.getTitulo());
                stmt.setString(3, livro.getAutor());
                stmt.setInt(4, livro.getAno());
                stmt.setString(5, livro.getStatus());

                stmt.executeUpdate();

            } catch ( SQLException e ) {
                System.out.println("error DisciplinaDAO");
            }

        }

    }

}

