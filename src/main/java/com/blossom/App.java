package com.blossom;

import io.javalin.Javalin;
import io.javalin.http.Context;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.Instant;
import java.util.Map;
import java.util.HashMap;

public class App {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) {
        int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "3000"));

        Javalin app = Javalin.create(config -> {
            config.staticFiles.add("/public");
        });

        // API Routes
        app.get("/api/hello", ctx -> {
            String name = ctx.queryParam("name", "World");
            Map<String, Object> response = new HashMap<>();
            response.put("message", String.format("Hello, %s!", name));
            response.put("timestamp", Instant.now().toString());
            ctx.json(response);
        });

        app.post("/api/echo", ctx -> {
            Map<String, Object> request = objectMapper.readValue(ctx.body(), Map.class);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Echo response");
            response.put("received", request);
            response.put("timestamp", Instant.now().toString());
            ctx.json(response);
        });

        // Start server
        System.out.println("Starting server...");
        System.out.println("- Environment: production");
        System.out.println("- Port: " + port);
        System.out.println("- URL: http://localhost:" + port);
        System.out.println("\nReady! Visit http://localhost:" + port + " to see the demo");

        app.start(port);
    }
}