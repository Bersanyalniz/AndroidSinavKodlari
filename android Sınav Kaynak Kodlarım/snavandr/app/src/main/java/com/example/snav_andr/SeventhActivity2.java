package com.example.snav_andr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SeventhActivity2 extends AppCompatActivity {

    private LinearLayout layoutKatilimcilar;
    private Button btnHesapla;
    private TextView textViewSonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventh2);

        layoutKatilimcilar = findViewById(R.id.layoutKatilimcilar);
        btnHesapla = findViewById(R.id.btnHesapla);
        textViewSonuc = findViewById(R.id.textViewSonuc);

        Intent intent = getIntent();
        String etkinlikAdi = intent.getStringExtra("etkinlik_adi");
        String katilimciSayisiStr = intent.getStringExtra("katilimci_sayisi");
        String etkinlikTuru = intent.getStringExtra("etkinlik_turu");

        TextView textViewEtkinlikBilgileri = findViewById(R.id.textViewEtkinlikBilgileri);
        String etkinlikBilgileri = "Etkinlik Adı: " + etkinlikAdi +
                "\nKatılımcı Sayısı: " + katilimciSayisiStr +
                "\nEtkinlik Türü: " + etkinlikTuru;
        textViewEtkinlikBilgileri.setText(etkinlikBilgileri);

        int katilimciSayisi = Integer.parseInt(katilimciSayisiStr);

        for (int i = 1; i <= katilimciSayisi; i++) {
            EditText etKatilimciAdi = new EditText(this);
            etKatilimciAdi.setId(View.generateViewId());
            etKatilimciAdi.setHint("Katılımcı " + i + " Adı");
            layoutKatilimcilar.addView(etKatilimciAdi);

            EditText etKatilimciYasi = new EditText(this);
            etKatilimciYasi.setId(View.generateViewId());
            etKatilimciYasi.setHint("Katılımcı " + i + " Yaşı");
            layoutKatilimcilar.addView(etKatilimciYasi);

            EditText etKatilimciCinsiyet = new EditText(this);
            etKatilimciCinsiyet.setId(View.generateViewId());
            etKatilimciCinsiyet.setHint("Katılımcı " + i + " Cinsiyeti");
            layoutKatilimcilar.addView(etKatilimciCinsiyet);
        }

        btnHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hesaplaKatilimciBilgileri();
            }
        });
    }

    private void hesaplaKatilimciBilgileri() {
        StringBuilder sonuc = new StringBuilder("Katılımcı Bilgileri:\n");

        for (int i = 0; i < layoutKatilimcilar.getChildCount(); i += 3) {
            EditText etKatilimciAdi = (EditText) layoutKatilimcilar.getChildAt(i);
            EditText etKatilimciYasi = (EditText) layoutKatilimcilar.getChildAt(i + 1);
            EditText etKatilimciCinsiyet = (EditText) layoutKatilimcilar.getChildAt(i + 2);

            String katilimciAdi = etKatilimciAdi.getText().toString();
            String katilimciYasiStr = etKatilimciYasi.getText().toString();
            String katilimciCinsiyet = etKatilimciCinsiyet.getText().toString();

            if (!katilimciAdi.isEmpty() && !katilimciYasiStr.isEmpty() && !katilimciCinsiyet.isEmpty()) {
                sonuc.append("Ad: ").append(katilimciAdi)
                        .append(", Yaş: ").append(katilimciYasiStr)
                        .append(", Cinsiyet: ").append(katilimciCinsiyet)
                        .append("\n");
            }
        }

        int toplamKatilimciSayisi = layoutKatilimcilar.getChildCount() / 3;
        int toplamYas = 0;

        for (int i = 1; i <= toplamKatilimciSayisi; i++) {
            EditText etKatilimciYasi = (EditText) layoutKatilimcilar.findViewById(i * 3 - 1);
            String katilimciYasiStr = etKatilimciYasi.getText().toString();

            if (!katilimciYasiStr.isEmpty()) {
                toplamYas += Integer.parseInt(katilimciYasiStr);
            }
        }

        double ortalamaYas = toplamYas / (double) toplamKatilimciSayisi;

        sonuc.append("\nToplam Katılımcı Sayısı: ").append(toplamKatilimciSayisi)
                .append("\nOrtalama Yaş: ").append(ortalamaYas);

        textViewSonuc.setText(sonuc.toString());
    }
}