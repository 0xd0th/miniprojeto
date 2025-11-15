package service;

import infra.HttpService;
import infra.JSONService;
import model.Disciplina;

import java.util.ArrayList;

public class DisciplinaService {

    private static final String endpoint = "https://sswfuybfs8.execute-api.us-east-2.amazonaws.com/disciplinaServico/msDisciplina";

    public static ArrayList<Disciplina> get() {

        String response = HttpService.get(endpoint);

        JSONService<Disciplina> JSON = new JSONService<>(Disciplina.class);
        return JSON.desseralization(response);

    }

}
