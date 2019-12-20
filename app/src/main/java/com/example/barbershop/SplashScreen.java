package com.example.barbershop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    private TextView tvWelcome;
    private ImageView ivLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        tvWelcome = (TextView) findViewById(R.id.tvWelcome);
        ivLogo = (ImageView) findViewById(R.id.ivLogo);

        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.splash);
        tvWelcome.startAnimation(myanim);
        ivLogo.startAnimation(myanim);
        final Intent i = new Intent(this,MainActivity.class);
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();
    }
}
