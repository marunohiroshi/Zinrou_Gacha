package com.example.zinrou_card_select.Collection;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zinrou_card_select.BaseFragment;
import com.example.zinrou_card_select.FrontBackSwitchAnimation;
import com.example.zinrou_card_select.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardAllBackDesignFragment extends BaseFragment {
    private int[] cardDesignSet = new int[FrontBackSwitchAnimation.CARD_DESIGN_QUANTITY];

    public static CardAllBackDesignFragment newInstance() {
        return new CardAllBackDesignFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.all_card_back_design_recyclerview, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.container_recycler_view_card_back_design);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        createDate();
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                new LinearLayoutManager(getActivity()).getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        RecyclerView.Adapter adapter = new CardAllBackDesignFragmentRecyclerViewAdapter(cardDesignSet);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void createDate() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < cardDesignSet.length; i++) {
            cardDesignSet[i] = getResources().getIdentifier("card_design" + i, "drawable", getActivity().getPackageName());
            list.add(cardDesignSet[i]);
        }
        Collections.shuffle(list);
        for (int i = 0; i < cardDesignSet.length; i++) {
            cardDesignSet[i] = list.get(i);
        }
    }
}
