import com.sun.net.httpserver.HttpServer;
import dao.DiscenteDAO;
import dao.DisciplinaDAO;
import dao.LivroDAO;
import infra.DB.DBInitializer;
import infra.HTTP.HttpServerService;
import infra.JSONService;
import model.Discente;
import model.Disciplina;
import model.Livro;
import service.BibliotecaService;
import service.DiscenteService;
import service.DisciplinaService;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        DBInitializer.init();
        HttpServerService.createConnection();

    }
}