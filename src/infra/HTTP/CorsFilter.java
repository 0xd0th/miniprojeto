package infra.HTTP;

import com.sun.net.httpserver.Filter;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;

public class CorsFilter extends Filter {

    @Override
    public void doFilter(HttpExchange exchange, Chain chain) throws IOException {
        Headers reqHeaders = exchange.getRequestHeaders();
        Headers resHeaders = exchange.getResponseHeaders();

        // Origin do navegador (ex.: http://localhost:4200)
        String origin = reqHeaders.getFirst("Origin");

        // Se quiser liberar geral (dev):
        // resHeaders.set("Access-Control-Allow-Origin", "*");
        // Se quiser liberar só o Angular:
        if (origin != null && origin.equals("http://localhost:4200")) {
            resHeaders.set("Access-Control-Allow-Origin", origin);
        }

        resHeaders.set("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        resHeaders.set("Access-Control-Allow-Headers", "Content-Type, Authorization");
        // Se for usar cookies / Authorization bearer com credenciais:
        // resHeaders.set("Access-Control-Allow-Credentials", "true");
        resHeaders.set("Vary", "Origin");

        // Preflight
        if ("OPTIONS".equalsIgnoreCase(exchange.getRequestMethod())) {
            // 204: No Content, sem body
            exchange.sendResponseHeaders(204, -1);
            return;
        }

        chain.doFilter(exchange);
    }

    @Override
    public String description() {
        return "CORS filter";
    }
}
