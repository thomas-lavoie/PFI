package com.example.pfi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
            MediaPlayer mediaPlayerSuccess = MediaPlayer.create(ProductsActivity.this, R.raw.success);
            mediaPlayerSuccess.start();
        }

        threadDiscount = true;
        discountBackgroundColor = ProductsActivity.this.getColor(R.color.green);
        binding = DataBindingUtil.setContentView(ProductsActivity.this, R.layout.activity_products);
        products = Inventory.getInventory();
        client = Client.getLoggedInClient();
        binding.setClient(client);

        Animation animDiscount = AnimationUtils.loadAnimation(this, R.anim.fadein);
        binding.discount.startAnimation(animDiscount);
        binding.imageBooks.startAnimation(animDiscount);

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

    /**
     * Permet de changer la couleur du message de solde de manière asynchrone.
     */
    private class ExecutorDiscountColor implements Executor {
        int compte = 0;
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

                                // Easter egg
                                binding.discount.setText(R.string.discount);
                                if (compte == 9) {
                                    binding.discount.setText(R.string.easterEgg);
                                    compte = 0;
                                }
                                compte++;
                            }
                        });
                    }
                }
            });
        }
    }
}