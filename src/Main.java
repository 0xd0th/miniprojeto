import dao.DiscenteDAO;
import dao.DisciplinaDAO;
import dao.LivroDAO;
import infra.DB.DBInitializer;
import model.Discente;
import model.Disciplina;
import model.Livro;
import service.BibliotecaService;
import service.DiscenteService;
import service.DisciplinaService;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Livro> livros = BibliotecaService.get();

        DBInitializer.init();
        LivroDAO.inserirLivros(livros);

    }
}