package com.example.snav_andr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NinthActivity extends AppCompatActivity {

    private EditText etNumber1, etNumber2;
    private Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ninth);

        etNumber1 = findViewById(R.id.etNumber1);
        etNumber2 = findViewById(R.id.etNumber2);
        btnContinue = findViewById(R.id.btnContinue);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                continueToMathActivity();
            }
        });
    }

    private void continueToMathActivity() {
        double number1 = Double.parseDouble(etNumber1.getText().toString());
        double number2 = Double.parseDouble(etNumber2.getText().toString());

        Intent intent = new Intent(NinthActivity.this, NinthActivity2.class);

        intent.putExtra("number1", number1);
        intent.putExtra("number2", number2);

        startActivity(intent);
    }
}