package controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import dao.DisciplinaDAO;
import infra.JSONService;
import infra.QueryMapper;
import model.Disciplina;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class MatriculaController implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) {

        try {
            String method = exchange.getRequestMethod();
            if (!"GET".equalsIgnoreCase(method)) {
                exchange.sendResponseHeaders(405, -1);
                return;
            }
        } catch (IOException e) {
            System.out.println("erro ao responder a metodo de request invalido"); ;
        }

        URI requestURI = exchange.getRequestURI();
        String query = requestURI.getQuery();

        Map<String, String> params = QueryMapper.get(query);
        String disciplinaID = params.get("id");

        if (disciplinaID == null) {
            String resp = "Parâmetro 'id' é obrigatório";
            byte[] bytes = resp.getBytes(StandardCharsets.UTF_8);

            try {
                exchange.sendResponseHeaders(400, bytes.length);
                OutputStream os = exchange.getResponseBody();
                os.write(bytes);
                os.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return;
        }

        int id;
        try {
            id = Integer.parseInt(disciplinaID);
        } catch (NumberFormatException e) {
            String resp = "Parâmetro 'id' inválido: " + disciplinaID;
            byte[] bytes = resp.getBytes(StandardCharsets.UTF_8);
            try {
                exchange.sendResponseHeaders(400, bytes.length);
                OutputStream os = exchange.getResponseBody();
                os.write(bytes);
                os.close();
            } catch (IOException i) {
                throw new RuntimeException(i);
            }

            return;
        }


        JSONService<Disciplina> json = new JSONService<>(Disciplina.class);
        String response = json.seralization(DisciplinaDAO.acharPorId(id));

        try {
            exchange.getResponseHeaders().add("Content-Type", "text/plain; charset=UTF-8");
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());

            os.close();

        } catch ( IOException e ) {
            System.out.println("error MatriculaHandler");
        }

    }
}
