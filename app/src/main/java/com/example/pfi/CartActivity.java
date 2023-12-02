package com.example.pfi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pfi.databinding.ActivityCartBinding;

public class CartActivity extends AppCompatActivity {
    ActivityCartBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        binding = DataBindingUtil.setContentView(CartActivity.this, R.layout.activity_cart);

        // Affichage des produits
        ProductInCartAdapter adapter = new ProductInCartAdapter(getApplicationContext(), Cart.getCart());
        binding.recyclerCart.setAdapter(adapter);
        binding.recyclerCart.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerCart.setItemAnimator(new DefaultItemAnimator());
        binding.recyclerCart.setHasFixedSize(true);

        binding.btnBackCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartActivity.this, ProductsActivity.class);
                startActivity(intent);
            }
        });
    }
}