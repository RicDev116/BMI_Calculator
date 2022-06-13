package com.makeeasy.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;
    private Button calculateButton;
    private RadioButton radioButtonMale;
    private RadioButton radioButtonFemale;
    private EditText editTextAge;
    private EditText editTextFeet;
    private EditText editTextInches;
    private EditText editTextWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setButtonOnClickListener();

    }

    private void findViews(){
        textViewResult = findViewById(R.id.text_view_result);
        calculateButton = findViewById(R.id.button_calculate);
        radioButtonMale = findViewById(R.id.radio_button_male);
        radioButtonFemale = findViewById(R.id.radio_button_female);
        editTextAge = findViewById(R.id.edit_text_age);
        editTextFeet = findViewById(R.id.edit_text_feet);
        editTextInches = findViewById(R.id.edit_text_inches);
        editTextWeight = findViewById(R.id.edit_text_weight);
    }

    private void setButtonOnClickListener() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double bmiResult = calculateBMI();

                String ageText = editTextAge.getText().toString();

                int age = Integer.parseInt(ageText);

                if(age>=18){
                    diaplayResult(bmiResult);
                }else{
                    displayGuidence(bmiResult);
                }
            }
        });
    }

    private void displayGuidence(double bmi) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String bmiTextViewResult = decimalFormat.format(bmi);

        String message;
        if(radioButtonMale.isChecked()){
            message = "As you are nder 18, please contult with your doctor for the healthy range for boys";
        }else if(radioButtonFemale.isChecked()){
            message = "As you are nder 18, please contult with your doctor for the healthy range for girls";
        }else{
            message = "As you are nder 18, please contult with your doctor for the healthy range";
        }

        textViewResult.setText(bmiTextViewResult + " " + message);
    }

    private double calculateBMI() {
        String feetText = editTextFeet.getText().toString();
        String inchesText= editTextInches.getText().toString();
        String weightText = editTextWeight.getText().toString();

        int feet = Integer.parseInt(feetText);
        int inches = Integer.parseInt(inchesText);
        int weight = Integer.parseInt(weightText);

        int totalInches = (feet*12) + inches;

        double heightInMeters = totalInches * 0.0254;

        return weight / (heightInMeters * heightInMeters);
    }

    private void diaplayResult(double bmi){
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String bmiTextViewResult = decimalFormat.format(bmi);

        String message;

        if(bmi<18.5){
            message = "You are a underweight";
        }else if(bmi > 25){
            message = "You are a overweight";
        }else{
            message = "You are a healthy weight";
        }

        textViewResult.setText(bmiTextViewResult + " " + message);
    }

}