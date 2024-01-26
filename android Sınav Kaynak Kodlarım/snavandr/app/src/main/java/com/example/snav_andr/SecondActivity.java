package com.example.snav_andr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private EditText etKullaniciAdi, etSifre;
    private Button btnGiris;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        etKullaniciAdi = findViewById(R.id.etKullaniciAdi);
        etSifre = findViewById(R.id.etSifre);
        btnGiris = findViewById(R.id.btnGiris);

        btnGiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kullaniciAdi = etKullaniciAdi.getText().toString();
                String sifre = etSifre.getText().toString();

                if (kullaniciAdi.equals("kullanici") && sifre.equals("sifre")) {
                    Intent intent = new Intent(SecondActivity.this, SecondActivity2.class);
                    intent.putExtra("kullaniciAdi", kullaniciAdi);
                    startActivity(intent);
                } else {
                    Toast.makeText(SecondActivity.this, "Giriş başarısız. Lütfen bilgilerinizi kontrol edin.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
