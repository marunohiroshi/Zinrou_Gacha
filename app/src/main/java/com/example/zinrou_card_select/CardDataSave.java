package com.example.zinrou_card_select;

import java.util.ArrayList;
import java.util.List;

public class CardDataSave {
    private static List<CardData> mSelectedCardDataList = new ArrayList<>();

    private CardDataSave() {
    }

    public static void addSelectedCardData(CardData cardData) {
        mSelectedCardDataList.add(cardData);
    }

    public static CardData[] getmSelectedCardDataList() {
        CardData[] cardData = mSelectedCardDataList.toArray(new CardData[mSelectedCardDataList.size()]);
        return cardData;
    }

    public static void clearSelectedCardData() {
        mSelectedCardDataList.clear();
    }
}
