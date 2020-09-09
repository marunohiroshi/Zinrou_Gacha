package com.example.zinrou_card_select;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.Random;

import static android.content.ContentValues.TAG;

//import io.realm.Realm;

public class FrontBackSwitchAnimation extends BaseFragment {
    public static final int CARD_DESIGN_QUANTITY = 143;
    private ImageView cardBackDesign;
    private ImageView gachaImageView;
    private ImageView cardOpenAnimation;
//    private Realm realm;

    static FrontBackSwitchAnimation newInstance() {
        return new FrontBackSwitchAnimation();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.card_front_back_layout, container, false);
        cardBackDesign = view.findViewById(R.id.imageViewBack);
        gachaImageView = view.findViewById(R.id.imageViewFront);
        cardOpenAnimation = view.findViewById(R.id.card_open_animation);
        ImageView cardOpenAnimation2 = view.findViewById(R.id.card_open_animation);
        Glide.with(getContext()).asGif().load(R.raw.card_open_background2).into(cardOpenAnimation2);
//        realm = Realm.getDefaultInstance();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        final int[] cardTapCount = {0};
        Random random = new Random();
        String randomCardDesign = "card_design" + random.nextInt(CARD_DESIGN_QUANTITY - 1);
        cardBackDesign.setImageDrawable(getResources().getDrawable(getResourceID(randomCardDesign, "drawable", getActivity())));
        Log.d(TAG, randomCardDesign + " が選ばれました ");
        final CardData randomCardData = randomEnum(CardData.class);
        Log.d(TAG, randomCardData.getName() + " が選ばれました ");
        GachaCardDetailFragment gachaCardDetailFragment = new GachaCardDetailFragment();
        gachaCardDetailFragment.setSelectedCardData(randomCardData);
        CardDataSave.addSelectedCardData(randomCardData);
//        realm.beginTransaction();
//        RealmCardData realmCardData = realm.createObject(RealmCardData.class);
//        //当たったカードのデータをrealmデータベースに保存
//        realmCardData.setName(randomCardData.getName());
//        realmCardData.setEffect(randomCardData.getEffect());
//        realmCardData.setDrawable(randomCardData.getDrawable());
////        realmCardData.setCamp(randomCardData.getCamp());
////        realmCardData.setCardData(randomCardData);
//        realm.commitTransaction();

        cardBackDesign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "カードがタップされました");
                if (cardTapCount[0] == 0) {
                    Glide.with(getContext()).asGif().listener(getRequest()).load(R.raw.card_open_animation).into(cardOpenAnimation);

                    final ObjectAnimator oa1 = ObjectAnimator.ofFloat(cardBackDesign, "scaleX", 1f, 0f);
                    final ObjectAnimator oa2 = ObjectAnimator.ofFloat(gachaImageView, "scaleX", 0f, 1f);
                    oa1.setDuration(500);
                    oa2.setDuration(500);
                    oa1.setInterpolator(new DecelerateInterpolator());
                    oa2.setInterpolator(new AccelerateDecelerateInterpolator());
                    oa1.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            gachaImageView.setImageResource(randomCardData.getDrawable());
                            oa2.start();
                        }
                    });
                    oa1.start();
                    cardTapCount[0] = cardTapCount[0] + 1;
                } else {
                    transitionTo(GachaCardDetailFragment.newInstance(randomCardData, false));
                }
            }
        });
    }

    protected static int getResourceID(final String resName, final String resType, final Context context) {
        final int ResourceID = context.getResources().getIdentifier(resName, resType, context.getApplicationInfo().packageName);
        if (ResourceID == 0) {
            throw new IllegalArgumentException("No resource string found with name " + resName);
        } else {
            return ResourceID;
        }
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
                return false;
            }
        };
    }

    public static <T extends Enum<?>> T randomEnum(Class<T> clazz) {
        Random random = new Random();
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
}
