package com.example.mac39.bmi;

import java.math.BigDecimal;

public class BMI {
    private Double height;
    private Double weight;
    private Double value;
    private String diagnosisResult;

    public BMI(Double height, Double weight) {
        this.height = height;
        this.weight = weight;
        this.value = calc();
        this.diagnosisResult = diagnosis();
    }

    public Double getValue(){
        return this.value;
    }

    public String getDiagnosisResult(){
        return this.diagnosisResult;
    }

    private double calc() {
        // 体重(kg) ÷ 身長(m) × 身長(m)
        Double bmi = this.weight / Math.pow(this.height / 100, 2);
        BigDecimal bi = new BigDecimal(String.valueOf(bmi));

        // 小数点2桁で切り捨て
        return bi.setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
    }

    private String diagnosis() {
        Double v = this.value;
        if (v >= 25) {
            return "太り気味";

        } else if(v < 25 && v >= 18.5) {
            return "普通";

        } else {
            return "痩せすぎ";

        }
    }
}
