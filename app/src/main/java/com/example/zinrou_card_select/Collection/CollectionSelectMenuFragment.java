package com.example.zinrou_card_select.Collection;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.zinrou_card_select.BaseFragment;
import com.example.zinrou_card_select.R;

public class CollectionSelectMenuFragment extends BaseFragment {
    private ImageView gachaCollection;
    private ImageView zinrouCardCollection;
    private ImageView cardDesignCollection;
    private ImageView gachadoraCollection;

    public static CollectionSelectMenuFragment newInstance() {
        return new CollectionSelectMenuFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.collection_select_menu, container, false);
        gachaCollection = view.findViewById(R.id.gacha_collection);
        zinrouCardCollection = view.findViewById(R.id.zinnrou_card_collection);
        cardDesignCollection = view.findViewById(R.id.card_design_collection);
        gachadoraCollection = view.findViewById(R.id.gachadora_collection);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        gachaCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transitionTo(SelectedCardPositionFragment.newInstance());
            }
        });

        zinrouCardCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transitionTo(CardAllPositionFragment.newInstance());
            }
        });

        cardDesignCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transitionTo(CardAllBackDesignFragment.newInstance());
            }
        });

        gachadoraCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
