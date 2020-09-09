package com.example.zinrou_card_select.Collection;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.zinrou_card_select.R;



public class CardAllBackDesignFragmentRecyclerViewAdapter extends RecyclerView.Adapter<CardAllBackDesignFragmentRecyclerViewAdapter.ViewHolder> {
    private int[] cardDesignSet;

    CardAllBackDesignFragmentRecyclerViewAdapter(int[] MyDataSet) {
        cardDesignSet = MyDataSet;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView cardBackDesign;

        ViewHolder(View view) {
            super(view);
            cardBackDesign = (ImageView) view.findViewById(R.id.card_back_design);
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_card_back_design_recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.cardBackDesign.setImageResource(cardDesignSet[position]);
    }

    @Override
    public int getItemCount() {
        return cardDesignSet.length;
    }
}
