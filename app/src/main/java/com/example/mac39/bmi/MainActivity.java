package com.example.mac39.bmi;

import java.math.BigDecimal;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editHeight;
    EditText editWeight;
    TextView textViewResultBMI;
    TextView textViewResultBMIClassification;
    Button buttonResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResultBMI = (TextView) findViewById(R.id.textViewResultBMI);
        textViewResultBMIClassification = (TextView) findViewById(R.id.textViewResultBMIClassification);
        editHeight = (EditText) findViewById(R.id.editHeight);
        editWeight = (EditText) findViewById(R.id.editWeight);
        buttonResult = (Button) findViewById(R.id.button);
        buttonResult.setOnClickListener(buttonListener);
    }

    View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onClickButtonResult();
        }
    };

    protected void onClickButtonResult() {
        Double height = Double.parseDouble(editHeight.getText().toString());
        Double weight = Double.parseDouble(editWeight.getText().toString());
        Double bmi = calcBMI(height, weight, 2);
        String bmiClassification = Classification(bmi);
        textViewResultBMI.setText("BMIは『" +  bmi + "』です");
        textViewResultBMIClassification.setText(bmiClassification + "です");
    }

    final private double calcBMI(Double height, Double weight, Integer n) {
        // 体重(kg) ÷ 身長(m) × 身長(m)
        Double bmi = weight / Math.pow(height / 100, 2);

        // 小数点n桁で切り捨て
        BigDecimal bi = new BigDecimal(String.valueOf(bmi));
        return bi.setScale(n, BigDecimal.ROUND_DOWN).doubleValue();
    }

    final private String Classification(Double bmi) {
        if (bmi < 16) {
            return "痩せすぎ";
        } else if(bmi >= 16 && bmi < 17) {
            return "痩せ";
        } else if(bmi >= 17 && bmi < 18) {
            return "痩せぎみ";
        } else if(bmi >= 18.5 && bmi < 25) {
            return "正常";
        } else if(bmi >= 25 && bmi < 30) {
            return "太り気味";
        } else if(bmi >= 30 && bmi < 35) {
            return "肥満1度";
        } else if(bmi >= 35 && bmi < 40) {
            return "肥満2度";
        } else {
            return "肥満3度";
        }
    }

}
