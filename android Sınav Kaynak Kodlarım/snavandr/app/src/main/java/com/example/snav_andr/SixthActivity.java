package com.example.snav_andr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SixthActivity extends AppCompatActivity {

    private EditText etAd, etSoyad, etYas;
    private Button btnDevam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);

        etAd = findViewById(R.id.etAd);
        etSoyad = findViewById(R.id.etSoyad);
        etYas = findViewById(R.id.etYas);
        btnDevam = findViewById(R.id.btnDevam);

        btnDevam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SixthActivity.this, SixthActivity2.class);

                intent.putExtra("ad", etAd.getText().toString());
                intent.putExtra("soyad", etSoyad.getText().toString());
                intent.putExtra("yas", etYas.getText().toString());

                startActivity(intent);
            }
        });
    }
}
