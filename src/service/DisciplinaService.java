package service;

import infra.HTTP.HttpRequestService;
import infra.JSONService;
import model.Disciplina;

import java.util.ArrayList;

public class DisciplinaService {

    private static final String endpoint = "https://sswfuybfs8.execute-api.us-east-2.amazonaws.com/disciplinaServico/msDisciplina";

    public static ArrayList<Disciplina> get() {

        String response = HttpRequestService.get(endpoint);

        JSONService<Disciplina> JSON = new JSONService<>(Disciplina.class);
        return JSON.deseralization(response);

    }

}
