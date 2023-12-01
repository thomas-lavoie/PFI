package com.example.pfi;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pfi.databinding.ActivityProductsBinding;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {
    Context Context;
    Product[] Products;

    public ProductAdapter(Context context, Product[] products) {
        this.Context = context;
        Products = products;
    }

    @NonNull
    @Override
    public ProductAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(this.Context);
        View itemView = inflater.inflate(R.layout.product_listing_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.MyViewHolder holder, int position) {
        int imageId = Products[position].getImageId();
        String name = Products[position].getName();
        String price = "$" + String.valueOf(Products[position].getPrice());
        holder.imageView.setImageResource(imageId);
        holder.nameText.setText(name);
        holder.priceText.setText(String.valueOf(price));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Context, ProductDetailsActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("name", Products[holder.getAdapterPosition()].getName());
                intent.putExtra("seller", Products[holder.getAdapterPosition()].getSeller());
                intent.putExtra("description", Products[holder.getAdapterPosition()].getDescription());
                intent.putExtra("imageId", Products[holder.getAdapterPosition()].getImageId());
                intent.putExtra("price", Products[holder.getAdapterPosition()].getPrice());
                intent.putExtra("stock", Products[holder.getAdapterPosition()].getStock());
                Context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Products.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameText;
        TextView priceText;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image);
            nameText = (TextView) itemView.findViewById(R.id.name);
            priceText = (TextView) itemView.findViewById(R.id.price);
        }
    }
}
