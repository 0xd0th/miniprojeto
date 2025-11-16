package service;

import java.util.ArrayList;

import infra.HTTP.HttpRequestService;
import infra.JSONService;
import model.Discente;

public class DiscenteService  {

    private static final String endpoint = "https://rmi6vdpsq8.execute-api.us-east-2.amazonaws.com/msAluno";

    public static ArrayList<Discente> get() {

        String response = HttpRequestService.get(endpoint);

        JSONService<Discente> JSON = new JSONService<>(Discente.class);
        return JSON.deseralization(response);

    }

}
