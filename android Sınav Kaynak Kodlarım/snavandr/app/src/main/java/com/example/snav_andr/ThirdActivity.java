package com.example.snav_andr;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    private Spinner spinnerSehir;
    private TextView textViewBilgiler;

    private String[] isimler = {"Ahmet", "Mehmet", "Ayşe", "Fatma", "Mustafa"};
    private String[] soyisimler = {"Yılmaz", "Kaya", "Şahin", "Çelik", "Demir"};
    private String[] sehirler = {"İstanbul", "Ankara", "İzmir", "Bursa", "Adana"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        spinnerSehir = findViewById(R.id.spinnerSehir);
        textViewBilgiler = findViewById(R.id.textViewBilgiler);

        ArrayAdapter<String> sehirAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sehirler);
        sehirAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSehir.setAdapter(sehirAdapter);

        spinnerSehir.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                String secilenSehir = sehirler[position];

                String bilgiler = getBilgiler(secilenSehir);
                textViewBilgiler.setText(bilgiler);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });
    }

    private String getBilgiler(String sehir) {
        StringBuilder bilgiler = new StringBuilder();

        for (int i = 0; i < isimler.length; i++) {
            String isimSoyisim = isimler[i] + " " + soyisimler[i];
            bilgiler.append(isimSoyisim).append(", ").append(sehir).append("\n");
        }

        return bilgiler.toString();
    }
}
