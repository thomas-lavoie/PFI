package com.example.pfi;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pfi.databinding.ActivityProductsBinding;

import java.util.List;

public class ProductInCartAdapter extends RecyclerView.Adapter<ProductInCartAdapter.MyViewHolder> {
    Context Context;
    List<Product> Products;

    public ProductInCartAdapter(Context context, List<Product> products) {
        this.Context = context;
        Products = products;
    }

    @NonNull
    @Override
    public ProductInCartAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(this.Context);
        View itemView = inflater.inflate(R.layout.product_cart_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductInCartAdapter.MyViewHolder holder, int position) {
        int imageId = Products.get(position).getImageId();
        String name = Products.get(position).getName();
        String price = "$" + String.valueOf(Products.get(position).getPrice());
        holder.imageView.setImageResource(imageId);
        holder.nameText.setText(name);
        holder.priceText.setText(String.valueOf(price));

        holder.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cart.removeFromCart(Products.get(holder.getAdapterPosition()));
                Products.remove(holder.getAdapterPosition() - 1);
                notifyItemRemoved(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return Products.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameText;
        TextView priceText;
        ImageButton btnRemove;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageCart);
            nameText = (TextView) itemView.findViewById(R.id.nameCart);
            priceText = (TextView) itemView.findViewById(R.id.priceCart);
            btnRemove = (ImageButton) itemView.findViewById(R.id.btnRemove);
        }
    }
}
