package com.example.daniel.homehelp.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.daniel.homehelp.R;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class SplashActivity extends AppCompatActivity {

    GifDrawable gifFromResource;
    @BindView(R.id.img_splash)
    ImageView imgSplash;
    @BindView(R.id.gif_image_view)
    GifImageView gifImageView;
    @BindView(R.id.activity_splash)
    RelativeLayout activitySplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        setupSplash();
    }

    private void setupSplash() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, IntroductionActivity.class));
                finish();
            }
        }, 5000);

        try {
            gifFromResource = new GifDrawable(getResources(), R.raw.ic_splash_screen_animation);
            gifFromResource.setSpeed(1f);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            gifImageView.setBackground(gifFromResource);
        }
    }
}
