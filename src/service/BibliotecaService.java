package service;

import infra.HTTP.HttpRequestService;
import infra.JSONService;
import model.Livro;

import java.util.ArrayList;

public class BibliotecaService {

    private static final String endpoint = "https://qiiw8bgxka.execute-api.us-east-2.amazonaws.com/acervo/biblioteca";

    public static ArrayList<Livro> get() {

        String response = HttpRequestService.get(endpoint);

        JSONService<Livro> JSON = new JSONService<>(Livro.class);
        return JSON.deseralization(response);

    }

}
