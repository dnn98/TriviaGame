package com.example.triviagame;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class QuizSplashActivity extends QuizActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        startAnimation();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void startAnimation() {
        ImageView logo1= findViewById(R.id.logo_id);
        Animation ani= AnimationUtils.loadAnimation(this, R.anim.my_animation);
        ani.setAnimationListener(new Animation.AnimationListener() {
                                       public void onAnimationStart(Animation animation) {
                                       }

                                       public void onAnimationRepeat(Animation animation) {
                                       }

                                       public void onAnimationEnd(Animation animation) {
                                           changeActivity();
                                       }
                                   });
        logo1.startAnimation(ani);
    }
    public void changeActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
