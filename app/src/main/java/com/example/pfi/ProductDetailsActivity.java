package com.example.pfi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pfi.databinding.ActivityProductDetailsBinding;

public class ProductDetailsActivity extends AppCompatActivity {
    ActivityProductDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        binding = DataBindingUtil.setContentView(ProductDetailsActivity.this, R.layout.activity_product_details);
        String name = getIntent().getStringExtra("name");
        String seller = getIntent().getStringExtra("seller");
        String description = getIntent().getStringExtra("description");
        int imageId = getIntent().getIntExtra("imageId", R.drawable.books);
        double price = getIntent().getDoubleExtra("price", 24.99);
        int stock = getIntent().getIntExtra("stock", 0);

        Product product = new Product(name, seller, description, imageId, price, stock);
        binding.setProduct(product);
        binding.imageDetailed.setImageResource(imageId);

        binding.btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductDetailsActivity.this, CartActivity.class);

            }
        });
    }
}