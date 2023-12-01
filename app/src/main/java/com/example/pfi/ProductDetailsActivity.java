package com.example.pfi;

import androidx.appcompat.app.AppCompatActivity;

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

        binding.imageDetailed.setImageResource(getIntent().getIntExtra("imageId", R.drawable.books));
        binding.nameDetailed.setText(getIntent().getStringExtra("name"));
        binding.sellerDetailed.setText(getIntent().getStringExtra("seller"));
        binding.priceDetailed.setText(String.valueOf(getIntent().getDoubleExtra("price", 24.99)));
        binding.descriptionDetailed.setText(getIntent().getStringExtra("description"));

        binding.btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductDetailsActivity.this, CartActivity.class);

            }
        });
    }
}