package com.example.snav_andr;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.snav_andr.R;

public class SecondActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);

        String kullaniciAdi = getIntent().getStringExtra("kullaniciAdi");

        TextView textView = findViewById(R.id.textView);
        textView.setText("Hoş geldiniz, " + kullaniciAdi + "!");


        String[] spinnerItems = {"Seçenek 1", "Seçenek 2", "Seçenek 3"};
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}
