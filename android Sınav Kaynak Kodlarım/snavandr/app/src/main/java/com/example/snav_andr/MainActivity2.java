package com.example.snav_andr;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String kullaniciAdi = intent.getStringExtra("kullaniciAdi");
        String sifre = intent.getStringExtra("sifre");
        String cinsiyet = intent.getStringExtra("cinsiyet");

        TextView textView = findViewById(R.id.textView);
        String bilgiler = "Kullanıcı Adı: " + kullaniciAdi + "\nŞifre: " + sifre + "\nCinsiyet: " + cinsiyet;
        textView.setText(bilgiler);
    }
}
