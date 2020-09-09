package com.example.zinrou_card_select;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.zinrou_card_select.Collection.CardAllBackDesignFragment;
import com.example.zinrou_card_select.Collection.CollectionSelectMenuFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import static android.content.ContentValues.TAG;

//import io.realm.Realm;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    private BaseFragment mCurrentFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Realm.init(this);
//        Realm realm = Realm.getDefaultInstance();
        bottomNavigationView = findViewById(R.id.buttom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottom_navigation_title:
                        Log.d(TAG,"タイトルボタンが押されました");
                        transitionTo(CardAllBackDesignFragment.newInstance());
                        return true;
                    case R.id.bottom_navigation_gacha:
                        Log.d(TAG,"ガチャボタンが押されました");
                        transitionTo(GachaStartFragment.newInstance());
                        return true;
                    case R.id.bottom_navigation_collection:
                        Log.d(TAG,"コレクションボタンが押されました");
                        transitionTo(CollectionSelectMenuFragment.newInstance());
                        return true;
                    case R.id.bottom_navigation_reset:
                        Log.d(TAG,"設定画面が押されました");
                        transitionTo(SettingsFragment.newInstance());
                        return true;
                }
                return false;
            }
        });

        if (savedInstanceState == null) {
            BaseFragment newFragment = GachaStartFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, newFragment, GachaStartFragment.TAG)
                    .commitNow();
            mCurrentFragment = newFragment;
        }
    }

    public int transitionTo(BaseFragment newFragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, newFragment, newFragment.getClass().getSimpleName());
        fragmentTransaction.addToBackStack(newFragment.getClass().getSimpleName());

        int id = fragmentTransaction.commit();
        mCurrentFragment = newFragment;
        return id;
    }

    @Override
    public void onBackPressed() {
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.popBackStack();
        super.onBackPressed();
    }
}
