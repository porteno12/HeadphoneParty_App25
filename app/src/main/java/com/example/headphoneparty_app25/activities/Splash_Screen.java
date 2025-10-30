package com.example.headphoneparty_app25.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;

import com.example.headphoneparty_app25.R;
import com.example.headphoneparty_app25.databinding.ActivitySplashScreenBinding;

public class Splash_Screen extends AppCompatActivity {

    private ActivitySplashScreenBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Animation logoAnim = AnimationUtils.loadAnimation(Splash_Screen.this, R.anim.blink);
        binding.logo.startAnimation(logoAnim);

        Intent intent = new Intent(Splash_Screen.this, LogInActivity.class);
        startActivity(intent);






        Thread splashThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000); // 3 שניות
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // חזרה ל-UI Thread כדי לבצע מעבר מסכים
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(Splash_Screen.this, LogInActivity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        finish();
                    }
                });
            }
        });

        splashThread.start();

    }
}