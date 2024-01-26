package com.example.snav_andr;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SixthActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth2);

        Intent intent = getIntent();
        String ad = intent.getStringExtra("ad");
        String soyad = intent.getStringExtra("soyad");
        String yas = intent.getStringExtra("yas");

        TextView textViewBilgiler = findViewById(R.id.textViewBilgiler);
        textViewBilgiler.setText("Ad: " + ad + "\nSoyad: " + soyad + "\nYaş: " + yas);

        TextView textViewMesaj = findViewById(R.id.textViewMesaj);
        int yasInt = Integer.parseInt(yas);
        String mesaj;

        if (yasInt < 18) {
            mesaj = "Genç bir arkadaşımıza selam!";
        } else {
            mesaj = "Merhaba, yaşınız size her türlü yetkiyi verir!";
        }

        textViewMesaj.setText(mesaj);
    }
}
