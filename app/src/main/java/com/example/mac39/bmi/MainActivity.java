package com.example.mac39.bmi;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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

        editWeight.setOnFocusChangeListener(editTextFocusChangeListener);
        editHeight.setOnFocusChangeListener(editTextFocusChangeListener);
        buttonResult.setOnClickListener(buttonListener);
    }

    View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onClickButtonResult();
            hideSoftInputFormWindow(v);
        }
    };

    View.OnFocusChangeListener editTextFocusChangeListener = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus){
            if(!hasFocus) hideSoftInputFormWindow(v);
        }
    };

    protected void onClickButtonResult() {
        Double height = Double.parseDouble(editHeight.getText().toString());
        Double weight = Double.parseDouble(editWeight.getText().toString());

        BMI bmi = new BMI(height, weight);
        Double bmiValue = bmi.getValue();
        String bmiDiagnosis = bmi.getDiagnosisResult();
        Integer bmiDiagnosisColor = bmi.getDiagnosisColor();

        textViewResultBMI.setText("BMIは『" + bmiValue + "』です");
        textViewResultBMIClassification.setText(bmiDiagnosis + "です");
        textViewResultBMIClassification.setTextColor(bmiDiagnosisColor);

        bmi = null;
    }

    protected void hideSoftInputFormWindow(View v) {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }
}
