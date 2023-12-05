package com.example.pfi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;

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

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.gradient);
        binding.videoView.setVideoURI(uri);
        binding.videoView.start();

        binding.btnBackCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartActivity.this, ProductsActivity.class);
                startActivity(intent);
            }
        });

        MediaPlayer mediaPlayerError = MediaPlayer.create(CartActivity.this, R.raw.error);

        binding.btnPurchaseCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Cart.count() > 0) {
                    Intent intent = new Intent(CartActivity.this, ConfirmPurchaseActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(CartActivity.this, getString(R.string.emptyCartError), Toast.LENGTH_SHORT).show();
                    mediaPlayerError.start();
                }
            }
        });
    }
}