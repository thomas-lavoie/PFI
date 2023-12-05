package com.example.pfi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pfi.databinding.ActivityProductsBinding;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

public class ProductsActivity extends AppCompatActivity {
    ActivityProductsBinding binding;
    private List<Product> products;
    private Client client;
    private Boolean threadDiscount;
    private int discountBackgroundColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        if (getIntent().getBooleanExtra("purchased", false)) {
            Toast.makeText(ProductsActivity.this, getString(R.string.purchased), Toast.LENGTH_LONG).show();
        }

        threadDiscount = true;
        discountBackgroundColor = ProductsActivity.this.getColor(R.color.green);
        binding = DataBindingUtil.setContentView(ProductsActivity.this, R.layout.activity_products);
        products = Inventory.getInventory();
        client = Client.getLoggedInClient();
        binding.setClient(client);

        // Commencer le thread pour le changement de couleur du solde
        new ExecutorDiscountColor().discountThread();

        // Affichage des produits
        ProductAdapter adapter = new ProductAdapter(getApplicationContext(), products);
        binding.recyclerProducts.setAdapter(adapter);
        binding.recyclerProducts.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerProducts.setItemAnimator(new DefaultItemAnimator());
        binding.recyclerProducts.setHasFixedSize(true);

        binding.btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                threadDiscount = false;
                Intent intent = new Intent(ProductsActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });
    }

    private class ExecutorDiscountColor implements Executor {
        @Override
        public void execute(Runnable command) {
            new Thread(command).start();
        }
        public void discountThread() {
            execute(new Runnable() {
                @Override
                public void run() {
                    while (threadDiscount) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (discountBackgroundColor == ProductsActivity.this.getColor(R.color.red)) {
                                    discountBackgroundColor = ProductsActivity.this.getColor(R.color.green);
                                    binding.discount.setBackgroundColor(discountBackgroundColor);
                                }
                                else{
                                    discountBackgroundColor = ProductsActivity.this.getColor(R.color.red);
                                    binding.discount.setBackgroundColor(discountBackgroundColor);
                                }
                            }
                        });
                    }
                }
            });
        }
    }
}