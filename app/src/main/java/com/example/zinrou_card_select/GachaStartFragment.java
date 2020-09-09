package com.example.zinrou_card_select;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class GachaStartFragment extends BaseFragment {
    private ImageView gachaStartButton;
    public static final String TAG = "GachaStartFragment";

    static GachaStartFragment newInstance() {
        return new GachaStartFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gacha_start, container, false);
        gachaStartButton = view.findViewById(R.id.gacha_start_button);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        gachaStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transitionTo(GachaDragonFragment.newInstance());
            }
        });
    }
}
