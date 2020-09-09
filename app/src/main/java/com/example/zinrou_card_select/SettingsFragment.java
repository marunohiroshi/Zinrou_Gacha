package com.example.zinrou_card_select;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SettingsFragment extends BaseFragment {
    private Button cardDataResetButton;
    private PopupWindow mPopupWindow;

    static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.setting, container, false);
        cardDataResetButton = view.findViewById(R.id.reset_button);
        cardDataResetButton.setOnClickListener(null);
        final View popupView = getLayoutInflater().inflate(R.layout.card_data_reset_popup, null);
        Button cardDataResetYesButton = popupView.findViewById(R.id.reset_yes_button);
        Button cardDataResetNoButton = popupView.findViewById(R.id.reset_no_button);
        cardDataResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow = new PopupWindow();
                mPopupWindow.setContentView(popupView);

                //タップ時に他のViewでキャッチされないための設定
                mPopupWindow.setOutsideTouchable(true);
                mPopupWindow.setFocusable(true);

                //表示サイズの設定、今回は幅300dp
                float width = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300, getResources().getDisplayMetrics());
                mPopupWindow.setWindowLayoutMode((int) width, WindowManager.LayoutParams.WRAP_CONTENT);
                mPopupWindow.setWidth((int) width);
                mPopupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);

                //画面中央に表示
                mPopupWindow.showAtLocation(cardDataResetButton, Gravity.CENTER, 0, 0);
            }
        });

        cardDataResetYesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CardDataSave.clearSelectedCardData();
                Toast toast = Toast.makeText(getActivity(), "カードデータを初期化しました。", Toast.LENGTH_LONG);
                toast.show();
                mPopupWindow.dismiss();
            }
        });

        cardDataResetNoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.dismiss();
            }
        });

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPopupWindow != null && mPopupWindow.isShowing()) {
            mPopupWindow.dismiss();
        }
    }

}
