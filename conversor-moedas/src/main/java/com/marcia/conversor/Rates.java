package com.marcia.conversor;

public class Rates {
    private String result;
    private double conversion_rate;
    private double conversion_result;
    private String base_code;
    private String target_code;

    public String getResult() {
        return result;
    }

    public double getConversion_rate() {
        return conversion_rate;
    }

    public double getConversion_result() {
        return conversion_result;
    }

    public String getBase_code() {
        return base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    public void setResult(String resultado) {
        this.result = resultado;
        //throw new UnsupportedOperationException("Unimplemented method 'setResult'");
    }

    public void setConversion_result(double asDouble) {
        this.conversion_result = asDouble;
        //throw new UnsupportedOperationException("Unimplemented method 'setConversion_result'");
    }
}
