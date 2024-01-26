package com.example.snav_andr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etKullaniciAdi, etSifre;
    private Spinner spinnerCinsiyet;
    private Button btnKayit;

    private String[] spinnerItems = {"Erkek", "Kadın"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etKullaniciAdi = findViewById(R.id.etKullaniciAdi);
        etSifre = findViewById(R.id.etSifre);
        spinnerCinsiyet = findViewById(R.id.spinnerCinsiyet);
        btnKayit = findViewById(R.id.btnKayit);

        ArrayAdapter<String> cinsiyetAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                spinnerItems
        );
        cinsiyetAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCinsiyet.setAdapter(cinsiyetAdapter);

        btnKayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kullaniciAdi = etKullaniciAdi.getText().toString();
                String sifre = etSifre.getText().toString();
                String cinsiyet = spinnerCinsiyet.getSelectedItem().toString();

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("kullaniciAdi", kullaniciAdi);
                intent.putExtra("sifre", sifre);
                intent.putExtra("cinsiyet", cinsiyet);
                startActivity(intent);
            }
        });
    }
}

