package com.example.snav_andr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class SeventhActivity extends AppCompatActivity {

    private EditText etEtkinlikAdi, etKatilimciSayisi;
    private Spinner spinnerEtkinlikTuru;
    private Button btnDevam;

    private String[] spinnerItems = {"Konser", "Konferans", "Spor Etkinliği", "Diğer"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventh);

        etEtkinlikAdi = findViewById(R.id.etEtkinlikAdi);
        etKatilimciSayisi = findViewById(R.id.etKatilimciSayisi);
        spinnerEtkinlikTuru = findViewById(R.id.spinnerEtkinlikTuru);
        btnDevam = findViewById(R.id.btnDevam);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, spinnerItems);
        spinnerEtkinlikTuru.setAdapter(adapter);

        btnDevam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SeventhActivity.this, SeventhActivity2.class);

                intent.putExtra("etkinlik_adi", etEtkinlikAdi.getText().toString());
                intent.putExtra("katilimci_sayisi", etKatilimciSayisi.getText().toString());
                intent.putExtra("etkinlik_turu", spinnerEtkinlikTuru.getSelectedItem().toString());

                startActivity(intent);
            }
        });
    }
}
