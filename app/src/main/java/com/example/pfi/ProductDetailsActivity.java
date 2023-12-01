package com.example.pfi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductDetailsActivity.this, ProductsActivity.class);
                startActivity(intent);
            }
        });

        binding.btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (product.getStock() > 0) {
                    Intent intent = new Intent(ProductDetailsActivity.this, ProductsActivity.class);
                } else {
                    Toast.makeText(ProductDetailsActivity.this, R.string.outOfStock, Toast.LENGTH_SHORT);
                }
            }
        });
    }
}