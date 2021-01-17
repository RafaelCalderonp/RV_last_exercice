package com.crisspian.recyclerviewexamples_01.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.crisspian.recyclerviewexamples_01.databinding.ItemListDataBinding;
import com.crisspian.recyclerviewexamples_01.model.Item;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MiViewHolder> {

    private List<Item> itemList;
    private IPasselement mPass;
    public ItemAdapter(List<Item> itemList, IPasselement mPass) {
        this.itemList = itemList;
        this.mPass= mPass;

    }

    @NonNull
    @Override
    public MiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListDataBinding mBinding = ItemListDataBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent,false);
        return new MiViewHolder(mBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MiViewHolder holder, int position) {
        Item element = itemList.get(position);
        holder.textView.setText(element.getItemDescription());
        Glide.with(holder.imageView)
                .load(element.getUrlImage()).centerCrop().into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    public class MiViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView textView;
        private ImageView imageView;
        public MiViewHolder(@NonNull ItemListDataBinding mBanding) {
            super(mBanding.getRoot());
            textView = mBanding.tvItem;
            imageView = mBanding.ivItem;
            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            Item item = itemList.get(position);
            mPass.passelement(item);
        }
    }
    public interface IPasselement{
        void passelement(Item item);
    }
}
