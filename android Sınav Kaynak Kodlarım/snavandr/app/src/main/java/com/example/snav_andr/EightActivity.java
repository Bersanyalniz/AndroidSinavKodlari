package com.example.snav_andr;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class EightActivity extends AppCompatActivity {

    private EditText etProductName, etProductPrice;
    private Spinner spinnerCategory;
    private Button btnAddProduct;
    private ListView listViewProducts;
    private List<String> productList;
    private ArrayAdapter<String> adapter;
    private String[] categories = {"Elektronik", "Giyim", "Gıda", "Spor"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight);

        etProductName = findViewById(R.id.etProductName);
        etProductPrice = findViewById(R.id.etProductPrice);
        spinnerCategory = findViewById(R.id.spinnerCategory);
        btnAddProduct = findViewById(R.id.btnAddProduct);
        listViewProducts = findViewById(R.id.listViewProducts);

        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(categoryAdapter);

        productList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, productList);
        listViewProducts.setAdapter(adapter);

        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProduct();
            }
        });
    }

    private void addProduct() {
        String productName = etProductName.getText().toString();
        String productPriceStr = etProductPrice.getText().toString();
        String category = spinnerCategory.getSelectedItem().toString();

        if (!productName.isEmpty() && !productPriceStr.isEmpty()) {
            double productPrice = Double.parseDouble(productPriceStr);
            String productInfo = productName + " - $" + productPrice + " - " + category;
            productList.add(productInfo);
            adapter.notifyDataSetChanged();

            etProductName.setText("");
            etProductPrice.setText("");
            spinnerCategory.setSelection(0);
        }
    }
}
