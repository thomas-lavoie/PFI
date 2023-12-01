package com.example.pfi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

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

        binding = DataBindingUtil.setContentView(ProductsActivity.this, R.layout.activity_products);

        products = Inventory.getInventory();
        client = new Client(getIntent().getStringExtra("username"), getIntent().getStringExtra("password"));

        binding.setClient(client);

        // Affichage des produits
        ProductAdapter adapter = new ProductAdapter(getApplicationContext(), products);
        binding.recyclerProducts.setAdapter(adapter);
        binding.recyclerProducts.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerProducts.setItemAnimator(new DefaultItemAnimator());
        binding.recyclerProducts.setHasFixedSize(true);


    }
}