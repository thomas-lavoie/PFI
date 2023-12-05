package com.example.pfi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.pfi.databinding.ActivityConfirmPurchaseBinding;

public class ConfirmPurchaseActivity extends AppCompatActivity {
    ActivityConfirmPurchaseBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_purchase);

        binding = DataBindingUtil.setContentView(ConfirmPurchaseActivity.this, R.layout.activity_confirm_purchase);

        Uri uri2 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.gradient2);
        binding.videoView2.setVideoURI(uri2);
        binding.videoView2.start();

        binding.totalAmount.setText(String.format(getString(R.string.totalAmount), String.valueOf(Cart.getTotalAmount())));

        binding.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfirmPurchaseActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });

        binding.btnPurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfirmPurchaseActivity.this, ProductsActivity.class);
                Inventory.purchase(Cart.getCart(), true);
                intent.putExtra("purchased", true);
                startActivity(intent);
            }
        });
    }
}