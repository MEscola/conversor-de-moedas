package com.marcia.conversor;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashSet;
import java.util.Set;

public class FilterCurrencies {

    public static void main(String[] args) {
        String jsonResponse = "{ \"supported_codes\": ["
                + "[\"ARS\", \"Peso argentino\"],"
                + "[\"BOB\", \"Boliviano boliviano\"],"
                + "[\"BRL\", \"Real brasileiro\"],"
                + "[\"CLP\", \"Peso chileno\"],"
                + "[\"COP\", \"Peso colombiano\"],"
                + "[\"USD\", \"Dólar americano\"],"
                + "[\"EUR\", \"Euro\"],"
                + "[\"JPY\", \"Iene japonês\"]"
                + "]}";

        // Moedas que queremos filtrar
        Set<String> moedasSelecionadas = new HashSet<>();
        moedasSelecionadas.add("ARS");
        moedasSelecionadas.add("BOB");
        moedasSelecionadas.add("BRL");
        moedasSelecionadas.add("CLP");
        moedasSelecionadas.add("COP");
        moedasSelecionadas.add("USD");

        // Parse do JSON
        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
        JsonArray supportedCodes = jsonObject.getAsJsonArray("supported_codes");

        System.out.println("Moedas filtradas:");
        for (int i = 0; i < supportedCodes.size(); i++) {
            JsonArray currencyPair = supportedCodes.get(i).getAsJsonArray();
            String code = currencyPair.get(0).getAsString();
            String name = currencyPair.get(1).getAsString();

            if (moedasSelecionadas.contains(code)) {
                System.out.println(code + " - " + name);
            }
        }
    }
}
