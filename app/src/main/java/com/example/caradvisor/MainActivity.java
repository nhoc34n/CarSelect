package com.example.caradvisor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner carSpinner;
    private Button findCarButton;
    private TextView adviceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carSpinner = findViewById(R.id.carBrandSpinner);
        findCarButton = findViewById(R.id.getAdviceButton);
        adviceTextView = findViewById(R.id.adviceTextView);

        // Set initial text in the TextView
        adviceTextView.setText(R.string.initial_advice_text);

        // Populate Spinner with car brands
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.car_brands, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        carSpinner.setAdapter(adapter);

        findCarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedCar = carSpinner.getSelectedItem().toString();

                // Update the TextView in the MainActivity (if needed)
                adviceTextView.setText(getString(R.string.fetching_advice_text, selectedCar));

                // Create an Intent to start MainActivity2
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("selectedCar", selectedCar);
                startActivity(intent);
            }
        });
    }
}
