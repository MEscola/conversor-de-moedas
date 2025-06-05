package com.marcia.conversor;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Request {

    public Rates baixaRate(String base_code, String target_code, double amount) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/" + Key.getMyApiKey()
                        + "/pair/" + base_code + "/" + target_code + "/" + amount))
                .build();
           
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();

                String resultado = json.get("result").getAsString();
            if ("success".equalsIgnoreCase(resultado)) {
                // Criar e preencher objeto Rates
                Rates rates = new Rates();
                rates.setResult(resultado);
                rates.setConversion_result(json.get("conversion_result").getAsDouble());
                return rates;
            } else {
                throw new RuntimeException("Erro na conversão. Resultado: " + resultado);
            }
        } else {
            throw new RuntimeException("Erro na requisição. Código: " + response.statusCode());
        }

    } catch (Exception e) {
        System.out.println("Erro detalhado: " + e.getMessage());
    e.printStackTrace();  // Mostra o erro completo
    throw new RuntimeException("Erro na requisição da API: ", e);
    }
}}