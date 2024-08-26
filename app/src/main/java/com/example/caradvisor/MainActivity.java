package com.example.caradvisor;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner carBrandSpinner;
    private Button getAdviceButton;
    private TextView adviceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carBrandSpinner = findViewById(R.id.carBrandSpinner);
        getAdviceButton = findViewById(R.id.getAdviceButton);
        adviceTextView = findViewById(R.id.adviceTextView);

        // Populate Spinner with car brands
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.car_brands_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        carBrandSpinner.setAdapter(adapter);

        // Set up button click listener
        getAdviceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedBrand = carBrandSpinner.getSelectedItem().toString();
                String advice = getAdviceForBrand(selectedBrand);
                adviceTextView.setText(advice);
            }
        });
    }

    private String getAdviceForBrand(String brand) {
        switch (brand) {
            case "Toyota":
                return "Reliable and affordable!" +
                        " \n1st Choice in Bangladesh \n Best resell value";
            case "Honda":
                return "Great for fuel efficiency.";
            case "BMW":
                return "Luxury with performance.";
            case "Ford":
                return "Built tough!";
            case "Tesla":
                return "Innovative and electric.";
            default:
                return "Select a brand to get advice.";
        }
    }
}
