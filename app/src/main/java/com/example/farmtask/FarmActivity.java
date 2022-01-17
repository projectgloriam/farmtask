package com.example.farmtask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.transition.Scene;
import androidx.transition.Slide;
import androidx.transition.Transition;
import androidx.transition.TransitionInflater;
import androidx.transition.TransitionManager;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class FarmActivity extends AppCompatActivity {
    private Scene manageScene;
    private Scene storeScene;
    private Scene revenueScene;
    private ViewGroup farmScene;
    ImageView image, manageButton, storeButton, revenueButton, priceMyProduce, sendToMarket, myAccountInfo, topUpAccount, animalStore, plantStore;
    private Button chickenButton, cocoaButton, cowButton, cornButton;
    private Transition transition;
    private AnimatorSet set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm);
        farmScene = findViewById(R.id.farmScenes);
        manageScene = Scene.getSceneForLayout(farmScene, R.layout.manage_scene, this);
        storeScene = Scene.getSceneForLayout(farmScene, R.layout.store_scene, this);
        revenueScene = Scene.getSceneForLayout(farmScene, R.layout.revenue_scene, this);

        manageScene.enter();

        transition = new Slide(Gravity.LEFT);

        manageButton = findViewById(R.id.manageButton);
        storeButton = findViewById(R.id.storeButton);
        revenueButton = findViewById(R.id.revenueButton);

        //changing the img srcCompat
        image = findViewById(R.id.img);

        //Starting Manage FrameLayout Tasks
        manageSceneTasks();

        //Setting onClickListeners
        manageButton.setOnClickListener(view -> {
            TransitionManager.go(manageScene, transition);
            manageSceneTasks();
        });

        storeButton.setOnClickListener(view -> {
            TransitionManager.go(storeScene, transition);
            storeSceneTasks();
        });

        revenueButton.setOnClickListener(view -> {
            TransitionManager.go(revenueScene, transition);
            revenueSceneTasks();
        });

        /*    */

    }

    private void flipView(View view){
        set = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.flip);
        set.setTarget(view);
        set.start();
    }

    private void manageSceneTasks(){
        image.setImageResource(R.drawable.img_plant);
        manageButton.setImageResource(R.drawable.manage_nav_btn);

        storeButton.setImageResource(android.R.color.transparent);
        revenueButton.setImageResource(android.R.color.transparent);

        chickenButton = findViewById(R.id.chicken_button);
        cocoaButton = findViewById(R.id.cocoa_button);
        cowButton = findViewById(R.id.cow_button);
        cornButton = findViewById(R.id.corn_button);

        chickenButton.setOnClickListener(v -> image.setImageResource(R.drawable.img_chick));
        cocoaButton.setOnClickListener(v -> image.setImageResource(R.drawable.img_cocoa));
        cowButton.setOnClickListener(v -> image.setImageResource(R.drawable.img_cow));
        cornButton.setOnClickListener(v -> image.setImageResource(R.drawable.img_plant));
    }

    private void storeSceneTasks(){
        image.setImageResource(R.drawable.img_plant);
        storeButton.setImageResource(R.drawable.store_nav_btn);

        manageButton.setImageResource(android.R.color.transparent);
        revenueButton.setImageResource(android.R.color.transparent);

        plantStore = findViewById(R.id.plant_store);
        animalStore = findViewById(R.id.animal_store);
        //setupCarousel();
    }

    private void revenueSceneTasks(){
        image.setImageResource(R.drawable.img_farm_stats);
        revenueButton.setImageResource(R.drawable.revenue_nav_btn);

        storeButton.setImageResource(android.R.color.transparent);
        manageButton.setImageResource(android.R.color.transparent);

        //revenue framelayout
        priceMyProduce = findViewById(R.id.price_my_produce);
        sendToMarket = findViewById(R.id.send_to_market);
        myAccountInfo = findViewById(R.id.my_account_info);
        topUpAccount = findViewById(R.id.top_up_account);

        priceMyProduce.setOnClickListener(v -> flipView(v));

        sendToMarket.setOnClickListener(v -> flipView(v));

        myAccountInfo.setOnClickListener(v -> flipView(v));

        topUpAccount.setOnClickListener(v -> flipView(v));
    }



}