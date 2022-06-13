package com.makeeasy.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;
    private Button calculateButton;
    private RadioButton radioButtonMale;
    private RadioButton radioButtonMale1;
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
        //String alertText = "This is my variable text";
        //android.widget.Toast.makeText(this,alertText,Toast.LENGTH_SHORT).show();

    }

    private void findViews(){
        textViewResult = findViewById(R.id.text_view_result);
        calculateButton = findViewById(R.id.button_calculate);
        radioButtonMale1 = findViewById(R.id.radio_button_male);
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
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String ageText = editTextAge.getText().toString();
        String feetText = editTextFeet.getText().toString();
        String inchesText= editTextInches.getText().toString();
        String weightText = editTextWeight.getText().toString();

        textViewResult.setText("Age: " + ageText + ",Feet: "+ feetText + ",Inches: " + inchesText + ", Weight: " + weightText);
    }

}