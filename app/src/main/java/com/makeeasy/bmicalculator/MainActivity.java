package com.makeeasy.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String alertText = "This is my variable text";

        android.widget.Toast.makeText(this,alertText,Toast.LENGTH_SHORT).show();


        TextView textViewResult =  findViewById(R.id.text_view_result);
        textViewResult.setText("Updating text");

        RadioButton radioButtonMale = findViewById(R.id.radio_button_male);
        RadioButton radioButtonFemale = findViewById(R.id.radio_button_female);

        EditText editTextAge = findViewById(R.id.edit_text_age);
        EditText editTextFeet = findViewById(R.id.edit_text_feet);
        EditText editTextInches = findViewById(R.id.edit_text_inches);
        EditText editTextWeight = findViewById(R.id.edit_text_weight);

        Button button;
    }
}