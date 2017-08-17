package com.example.mac39.bmi;

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

        BMI bmi = new BMI(height, weight);
        textViewResultBMI.setText("BMIは『" +  bmi.getValue() + "』です");
        textViewResultBMIClassification.setText(bmi.getDiagnosisResult() + "です");
    }

}
