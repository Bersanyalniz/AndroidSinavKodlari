package com.example.snav_andr;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FourthActivty extends AppCompatActivity {

    private Spinner spinnerArac;
    private TextView textViewOzellikler;

    private String[] aracTurleri = {"Seçiniz", "Otomobil", "Motosiklet", "Kamyonet"};
    private String[] otomobilOzellikleri = {"4 Kapı", "5 Kişi Kapasite", "Sedan"};
    private String[] motosikletOzellikleri = {"2 Tekerlek", "1 Kişi Kapasite", "Çatal"};
    private String[] kamyonetOzellikleri = {"2 Kapı", "3 Kişi Kapasite", "Hafif Ticari"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        spinnerArac = findViewById(R.id.spinnerArac);
        textViewOzellikler = findViewById(R.id.textViewOzellikler);

        ArrayAdapter<String> aracAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, aracTurleri);
        aracAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerArac.setAdapter(aracAdapter);

        spinnerArac.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String secilenArac = aracTurleri[position];
                String ozellikler = getAracOzellikleri(secilenArac);
                textViewOzellikler.setText(ozellikler);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });
    }

    private String getAracOzellikleri(String aracTuru) {
        StringBuilder ozellikler = new StringBuilder();

        switch (aracTuru) {
            case "Otomobil":
                for (String ozellik : otomobilOzellikleri) {
                    ozellikler.append(ozellik).append("\n");
                }
                break;
            case "Motosiklet":
                for (String ozellik : motosikletOzellikleri) {
                    ozellikler.append(ozellik).append("\n");
                }
                break;
            case "Kamyonet":
                for (String ozellik : kamyonetOzellikleri) {
                    ozellikler.append(ozellik).append("\n");
                }
                break;
            default:
                ozellikler.append("Lütfen bir araç türü seçiniz.");
        }

        return ozellikler.toString();
    }
}
