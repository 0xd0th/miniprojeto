package dao;

import infra.DB.DBConnection;
import model.Disciplina;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DisciplinaDAO {

    private static final Connection conexao = DBConnection.getConnection();

    public static void inserirDisciplinas( ArrayList<Disciplina> disciplinas ) {

        String sql = """
                INSERT INTO disciplina (id, curso, nome, vagas) VALUES (?, ?, ?, ?);
                """;

        for ( Disciplina disciplina : disciplinas ) {

            try ( PreparedStatement stmt = conexao.prepareStatement(sql) ) {

                stmt.setInt(1, disciplina.getId());
                stmt.setString(2, disciplina.getCurso());
                stmt.setString(3, disciplina.getNome());
                stmt.setInt(4, disciplina.getVagas());

                stmt.executeUpdate();

            } catch ( SQLException e ) {
                System.out.println("error DisciplinaDAO");
            }

        }

    }

    public static Disciplina acharPorId( int ID ) {

        String sql = """
                SELECT * FROM disciplina WHERE disciplina.id = ?;
                """;

        Disciplina temp = null;

        try ( PreparedStatement stmt = conexao.prepareStatement(sql) ) {

            stmt.setInt(1, ID);

            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                temp = new Disciplina(
                        result.getInt("id"),
                        result.getString("curso"),
                        result.getString("nome"),
                        result.getInt("vagas"));
            }

        } catch ( SQLException e ) {
            System.out.println("error DisciplinaDAO");
        }

        return temp;

    }



}
