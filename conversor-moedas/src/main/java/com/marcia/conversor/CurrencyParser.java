package com.marcia.conversor;

import org.json.JSONObject;

public class CurrencyParser {

    public static double getRate(String json, String targetCurrency) {
        if (json == null || targetCurrency == null) {
            throw new IllegalArgumentException("JSON ou moeda de destino inválido");
        }

        JSONObject jsonObj = new JSONObject(json);
        JSONObject conversionRates = jsonObj.getJSONObject("conversion_rates");

        return conversionRates.getDouble(targetCurrency);
    }
}
