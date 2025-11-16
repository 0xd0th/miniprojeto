package infra.HTTP;

import com.sun.net.httpserver.HttpServer;
import controller.MatriculaController;

import java.io.IOException;
import java.net.InetSocketAddress;

public class HttpServerService {

    private static final int porta = 8080;

    public static void createConnection() {

        HttpServer server = null;

        try {
            server = HttpServer.create( new InetSocketAddress(porta), 0);
        } catch ( IOException e ) {
            System.out.println("Error ao criar servidor http na porta " + porta );
        }

        server.createContext("/matricula", new MatriculaController())
                .getFilters().add(new CorsFilter());


        server.setExecutor(null);
        server.start();

        System.out.println("Servidor HTTP rodando em http://localhost:8080/");

    }


}
