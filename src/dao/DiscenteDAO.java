package dao;

import infra.DB.DBConnection;
import model.Discente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class DiscenteDAO {

    private static final Connection conexao = DBConnection.getConnection();

    public static void inserirDiscentes( ArrayList<Discente> discentes ) {

        String sql = """
                INSERT INTO discente (id, nome, curso, modalidade, status) VALUES (?, ?, ?, ?, ?);
                """;

        for ( Discente discente : discentes ) {

            try ( PreparedStatement stmt = conexao.prepareStatement(sql) ) {

                stmt.setInt(1, discente.getId());
                stmt.setString(2, discente.getNome());
                stmt.setString(3, discente.getCurso());
                stmt.setString(4, discente.getModalidade());
                stmt.setString(5, discente.getStatus());

                stmt.executeUpdate();

            } catch ( SQLException e ) {
                System.out.println("error DiscenteDAO");
            }

        }
    }


}
