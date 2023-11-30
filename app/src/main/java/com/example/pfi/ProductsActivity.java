package com.example.pfi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.TextView;

import com.example.pfi.databinding.ActivityProductsBinding;

import org.w3c.dom.Text;

public class ProductsActivity extends AppCompatActivity {
    ActivityProductsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        binding = DataBindingUtil.setContentView(ProductsActivity.this, R.layout.activity_products);
        Client client = new Client(getIntent().getStringExtra("username"), getIntent().getStringExtra("password"));
        binding.setClient(client);
    }
}