package com.example.snav_andr;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class FifthActivity extends AppCompatActivity {

    private EditText etAd, etSoyad;
    private Spinner spinnerSinif;
    private List<EditText> etDersAdiList, etNotList;
    private Button btnHesapla;
    private TextView textViewSonuc;

    private String[] siniflar = {"9A", "9B", "9C", "10A", "10B", "10C", "11A", "11B", "11C", "12A", "12B", "12C"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

        etAd = findViewById(R.id.etAd);
        etSoyad = findViewById(R.id.etSoyad);
        spinnerSinif = findViewById(R.id.spinnerSinif);
        etDersAdiList = new ArrayList<>();
        etNotList = new ArrayList<>();
        btnHesapla = findViewById(R.id.btnHesapla);
        textViewSonuc = findViewById(R.id.textViewSonuc);

        ArrayAdapter<String> sinifAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, siniflar);
        sinifAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSinif.setAdapter(sinifAdapter);

        for (int i = 1; i <= 5; i++) {
            EditText etDersAdi = new EditText(this);
            etDersAdi.setHint("Ders " + i + " Adı");
            etDersAdiList.add(etDersAdi);

            EditText etNot = new EditText(this);
            etNot.setHint("Ders " + i + " Notu");
            etNotList.add(etNot);
        }

        for (int i = 0; i < etDersAdiList.size(); i++) {
            etDersAdiList.get(i).setId(View.generateViewId());
            etNotList.get(i).setId(View.generateViewId());
            etDersAdiList.get(i).setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            etNotList.get(i).setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            ((LinearLayout) findViewById(R.id.layoutDersler)).addView(etDersAdiList.get(i));
            ((LinearLayout) findViewById(R.id.layoutDersler)).addView(etNotList.get(i));
        }

        btnHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hesaplaNotOrtalamasi();
            }
        });
    }

    private void hesaplaNotOrtalamasi() {
        String ad = etAd.getText().toString();
        String soyad = etSoyad.getText().toString();
        String sinif = spinnerSinif.getSelectedItem().toString();

        List<String> dersAdlari = new ArrayList<>();
        List<Integer> notlar = new ArrayList<>();

        for (int i = 0; i < etDersAdiList.size(); i++) {
            String dersAdi = etDersAdiList.get(i).getText().toString();
            String notStr = etNotList.get(i).getText().toString();

            if (!dersAdi.isEmpty() && !notStr.isEmpty()) {
                dersAdlari.add(dersAdi);
                notlar.add(Integer.parseInt(notStr));
            }
        }

        if (dersAdlari.size() == 0 || notlar.size() == 0) {
            Toast.makeText(this, "En az bir ders ve notu girilmelidir.", Toast.LENGTH_SHORT).show();
            return;
        }

        int toplamNot = 0;
        for (int not : notlar) {
            toplamNot += not;
        }

        double ortalama = (double) toplamNot / notlar.size();

        // Genel sonucu göster
        String sonuc = "Öğrenci: " + ad + " " + soyad + "\nSınıf: " + sinif + "\n\nDersler ve Notlar:\n";
        for (int i = 0; i < dersAdlari.size(); i++) {
            sonuc += dersAdlari.get(i) + ": " + notlar.get(i) + "\n";
        }
        sonuc += "\nGenel Not Ortalaması: " + ortalama + "\n";

        if (ortalama >= 50) {
            sonuc += "Sınıfı Geçti!";
        } else {
            sonuc += "Sınıfta Kaldı!";
        }

        textViewSonuc.setText(sonuc);
    }
}
