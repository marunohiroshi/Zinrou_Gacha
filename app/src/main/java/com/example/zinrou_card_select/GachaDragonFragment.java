package com.example.zinrou_card_select;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.Random;

public class GachaDragonFragment extends BaseFragment {
    private static final int GACHA_QUANTITY = 60;
    public static final String TAG = "GachaDragonFragment";

    static GachaDragonFragment newInstance() {
        return new GachaDragonFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.gacha_dragon_fragment, container, false);
        Button gachaStartButton = view.findViewById(R.id.gacha_button);
        Random random = new Random();
        final String randomGacha = "gacha" + random.nextInt(GACHA_QUANTITY - 1);
        final ImageView gachaDragon = view.findViewById(R.id.gacha_dragon);
        gachaDragon.setImageResource(R.drawable.gacha57);

        Log.d(TAG, randomGacha + " selected ");
        gachaStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("onClick", "onClick:gacha start!");
                Glide.with((getActivity().getApplicationContext())).asGif().listener(getRequest()).load(R.raw.gacha_animation).into(gachaDragon);
            }
        });
        return view;
    }

    public RequestListener<GifDrawable> getRequest() {
        return new RequestListener<GifDrawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<GifDrawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(GifDrawable resource, Object model, Target<GifDrawable> target, DataSource dataSource, boolean isFirstResource) {
                resource.setLoopCount(1);
                resource.registerAnimationCallback(new Animatable2Compat.AnimationCallback() {
                    @Override
                    public void onAnimationEnd(Drawable drawable) {
                        super.onAnimationEnd(drawable);
                        transitionTo(FrontBackSwitchAnimation.newInstance());
                    }
                });
                return false;
            }
        };
    }
}
