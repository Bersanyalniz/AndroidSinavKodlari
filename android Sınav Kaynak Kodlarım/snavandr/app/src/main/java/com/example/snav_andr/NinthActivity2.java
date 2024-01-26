package com.example.snav_andr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NinthActivity2 extends AppCompatActivity {

    private TextView tvResult;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ninth2);

        tvResult = findViewById(R.id.tvResult);
        btnBack = findViewById(R.id.btnBack);

        Intent intent = getIntent();
        if (intent.hasExtra("number1") && intent.hasExtra("number2")) {
            double number1 = intent.getDoubleExtra("number1", 0);
            double number2 = intent.getDoubleExtra("number2", 0);

            performMathOperations(number1, number2);
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBackToMainActivity();
            }
        });
    }

    private void performMathOperations(double number1, double number2) {
        double sum = number1 + number2;
        double difference = number1 - number2;
        double product = number1 * number2;
        double quotient = 0;

        if (number2 != 0) {
            quotient = number1 / number2;
        } else {
            Toast.makeText(this, "Sıfıra bölme hatası!", Toast.LENGTH_SHORT).show();
        }

        // Sonuçları TextView'e set et
        tvResult.setText("Toplam: " + sum + "\n"
                + "Fark: " + difference + "\n"
                + "Çarpım: " + product + "\n"
                + "Bölüm: " + quotient);
    }

    private void goBackToMainActivity() {
        // Birinci forma geri dön
        finish();
    }
}