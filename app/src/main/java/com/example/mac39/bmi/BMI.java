package com.example.mac39.bmi;

import android.graphics.Color;

import java.math.BigDecimal;

public class BMI {
    private Double value;
    private String diagnosisResult;
    private Integer diagnosisColor;

    public BMI(Double height, Double weight) {
        this.value = calc(height, weight);
        setDiagnosis(this.value);
    }

    public Double getValue(){
        return this.value;
    }

    public String getDiagnosisResult(){
        return this.diagnosisResult;
    }

    public Integer getDiagnosisColor(){
        return this.diagnosisColor;
    }

    private double calc(Double height, Double weight) {
        // 体重(kg) ÷ 身長(m) × 身長(m)
        Double bmi = weight / (height * 0.01 * height * 0.01);
        BigDecimal bi = new BigDecimal(String.valueOf(bmi));

        // 小数点2桁で切り捨て
        return bi.setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
    }

    private void setDiagnosis(Double v) {
        if (v >= 25) {
            this.diagnosisResult = "太りぎみ";
            this.diagnosisColor = Color.parseColor("#ff0000");

        } else if(v < 25 && v >= 18.5) {
            this.diagnosisResult = "普通";
            this.diagnosisColor = Color.parseColor("#00ff00");

        } else {
            this.diagnosisResult = "痩せぎみ";
            this.diagnosisColor = Color.parseColor("#0000ff");

        }
    }
}
