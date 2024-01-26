package com.example.snav_andr;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TenthActivity extends AppCompatActivity {

    private String[] spinnerItems;
    private String[][] countryInfo;
    private ImageView flagImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenth);

        Spinner countrySpinner = findViewById(R.id.countrySpinner);
        flagImageView = findViewById(R.id.flagImageView);
        final TextView capitalTextView = findViewById(R.id.capitalTextView);
        final TextView populationTextView = findViewById(R.id.populationTextView);

        spinnerItems = new String[]{"Türkiye", "ABD", "Almanya"};

        countryInfo = new String[][]{
                {"bayrak_turkiye", "Ankara", "84339067"},
                {"bayrak_usa", "Washington, D.C.", "331002651"},
                {"bayrak_germany", "Berlin", "83149300"},
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerItems);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        countrySpinner.setAdapter(adapter);

        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String[] selectedCountryInfo = countryInfo[position];

                int flagResourceId = getResources().getIdentifier(selectedCountryInfo[0], "drawable", getPackageName());
                flagImageView.setImageResource(flagResourceId);

                capitalTextView.setText("Başkent: " + selectedCountryInfo[1]);
                populationTextView.setText("Nüfus: " + selectedCountryInfo[2]);

                Toast.makeText(TenthActivity.this, "Seçilen Ülke: " + spinnerItems[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });
    }
}
