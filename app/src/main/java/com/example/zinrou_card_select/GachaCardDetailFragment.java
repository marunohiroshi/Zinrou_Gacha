package com.example.zinrou_card_select;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.zinrou_card_select.Collection.CardAllPositionFragment;

public class GachaCardDetailFragment extends BaseFragment {
    private TextView cardName;
    private TextView campName;
    private ImageView selectedCard;
    private ImageView backgroundAnimation;
    private TextView cardEffect;
    private ImageView cardTextBackground;
    private ImageView backButton;
    private static CardData selectedCardData;
    private static boolean mHasBackButton;

    public static GachaCardDetailFragment newInstance(CardData cardData, boolean hasBackButton) {
        selectedCardData = cardData;
        mHasBackButton = hasBackButton;
        return new GachaCardDetailFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gacha_card_detail, container, false);
        cardName = view.findViewById(R.id.card_name);
        campName = view.findViewById(R.id.card_camp);
        selectedCard = view.findViewById(R.id.card_design);
        backgroundAnimation = view.findViewById(R.id.card_background_animation);
        cardEffect = view.findViewById(R.id.card_effect);
        cardTextBackground = view.findViewById(R.id.card_text_background);
        backButton = view.findViewById(R.id.back_button);
        Glide.with(getContext()).asGif().load(R.raw.card_detail_background).into(backgroundAnimation);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        cardName.setText(selectedCardData.getName());
        campName.setText("【" + selectedCardData.getCamp() + "】");
        selectedCard.setImageResource(selectedCardData.getDrawable());
        cardEffect.setText(selectedCardData.getEffect());
        cardTextBackground.setImageResource(R.drawable.card_text_frame);
        if (mHasBackButton) {
            backButton.setVisibility(View.VISIBLE);
            backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    transitionTo(CardAllPositionFragment.newInstance());
                }
            });
        }
    }

    public void setSelectedCardData(CardData selectedCardData) {
        this.selectedCardData = selectedCardData;
    }
}
