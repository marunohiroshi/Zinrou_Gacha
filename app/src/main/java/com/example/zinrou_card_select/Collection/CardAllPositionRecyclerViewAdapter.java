package com.example.zinrou_card_select.Collection;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zinrou_card_select.CardData;
import com.example.zinrou_card_select.R;

public class CardAllPositionRecyclerViewAdapter extends RecyclerView.Adapter<CardAllPositionRecyclerViewAdapter.ViewHolder> {
    private CardData[] cardDates;

    CardAllPositionRecyclerViewAdapter(CardData[] cardData) {
        cardDates = cardData;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {
        TextView cardName;
        ImageView cardImage;
        CardView cardView;

        ViewHolder(View view) {
            super(view);
            cardName = view.findViewById(R.id.card_name);
            cardImage = view.findViewById(R.id.card_design);
            cardView = view.findViewById(R.id.all_position_view);
        }

        @Override
        public boolean onLongClick(View v) {
            return false;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_position_card_recyclerview_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.cardName.setText(cardDates[position].getName());
        holder.cardImage.setImageResource(cardDates[position].getDrawable());
        if (cardDates[position].getCamp().contains("市民")) {
            holder.cardView.setBackgroundColor(Color.BLUE);
            holder.cardName.setBackgroundColor(Color.BLUE);
        } else if (cardDates[position].getCamp().contains("人狼")) {
            holder.cardView.setBackgroundColor(Color.RED);
            holder.cardName.setBackgroundColor(Color.RED);
        } else {
            holder.cardView.setBackgroundColor(Color.GRAY);
            holder.cardName.setBackgroundColor(Color.GRAY);
        }
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                onItemClick(v, position, cardDates);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cardDates.length;
    }

    void onItemClick(View view, int position, CardData[] cardDatas) {

    }
}
