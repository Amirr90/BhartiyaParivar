package com.e.bhartiyaparivar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.e.bhartiyaparivar.databinding.ActivityMainBinding;

public class SplashScreen extends AppCompatActivity {


    ActivityMainBinding mainBinding;
    Animation aniFade;
    CountDownTimer myCountdownTimer;

    boolean isUserLogin = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        aniFade = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);


        myCountdownTimer = new CountDownTimer(3000, 1000) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                updateUI();
            }
        }.start();
        mainBinding.imageView4.startAnimation(aniFade);
        //mainBinding.textView4.startAnimation(aniFade);

    }

    private void updateUI() {

        Intent intent;
        if (!isUserLogin) {
            intent = new Intent(SplashScreen.this, SignUpActivity.class);
            startActivity(intent);
            finish();
        }


    }
}