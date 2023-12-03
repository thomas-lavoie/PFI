package com.example.pfi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pfi.databinding.ActivityProductsBinding;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.List;

public class ProductsActivity extends AppCompatActivity {
    ActivityProductsBinding binding;
    private List<Product> products;
    private Client client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        if (getIntent().getBooleanExtra("purchased", false)) {
            Toast.makeText(ProductsActivity.this, getString(R.string.purchased), Toast.LENGTH_LONG).show();
        }

        binding = DataBindingUtil.setContentView(ProductsActivity.this, R.layout.activity_products);

        products = Inventory.getInventory();
        client = Client.getLoggedInClient();

        binding.setClient(client);

        // Affichage des produits
        ProductAdapter adapter = new ProductAdapter(getApplicationContext(), products);
        binding.recyclerProducts.setAdapter(adapter);
        binding.recyclerProducts.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerProducts.setItemAnimator(new DefaultItemAnimator());
        binding.recyclerProducts.setHasFixedSize(true);

        binding.btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ProductsActivity.this, CartActivity.class);
                startActivity(intent);

                /* Mecanique que je ne pense pas me servir. Je suis incertain
                if (Cart.count() > 0) {
                    Intent intent = new Intent(ProductsActivity.this, CartActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(ProductsActivity.this, getResources().getString(R.string.emptyCartError), Toast.LENGTH_SHORT).show();
                }
                */
            }
        });
    }
}