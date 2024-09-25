package com.example.caradvisor;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        resultTextView = findViewById(R.id.adviceTextView);

        // Get the Intent that started this activity and extract the string
        String selectedCar = getIntent().getStringExtra("selectedCar");

        // Set specific advice based on the selected car brand
        String advice;
        switch (selectedCar) {
            case "Toyota":
                advice = getString(R.string.advice_toyota);
                break;
            case "Honda":
                advice = getString(R.string.advice_honda);
                break;


            case "BMW":
                advice = getString(R.string.advice_bmw);
                break;
            case "Audi":
                advice = getString(R.string.advice_audi);
                break;
            case "Mercedes-Benz":
                advice = getString(R.string.advice_mercedes_benz);
                break;


            case "Hyundai":
                advice = getString(R.string.advice_hyundai);
                break;
            default:
                advice = getString(R.string.default_advice);
                break;
        }

        // Display the selected car advice
        resultTextView.setText(advice);
    }
}
