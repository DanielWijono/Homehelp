package com.example.daniel.homehelp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daniel.homehelp.R;
import com.example.daniel.homehelp.adapter.IntroductionAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.relex.circleindicator.CircleIndicator;

public class IntroductionActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    @BindView(R.id.introduction_view_pager)
    ViewPager introductionViewPager;
    @BindView(R.id.introduction_indicator)
    CircleIndicator introductionIndicator;
    @BindView(R.id.activity_introduction2)
    RelativeLayout activityIntroduction2;
    @BindView(R.id.ll_intro_register_login)
    LinearLayout llIntroRegisterLogin;
    @BindView(R.id.tv_sign_up)
    TextView tvSignUp;
    @BindView(R.id.tv_sign_in)
    TextView tvSignIn;

    int pageCount = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);
        ButterKnife.bind(this);

        initialization();
    }

    private void initialization() {
        introductionViewPager.setAdapter(new IntroductionAdapter(IntroductionActivity.this, this));
        introductionIndicator.setViewPager(introductionViewPager);
        introductionViewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position == pageCount) {
            introductionIndicator.setVisibility(View.GONE);
            llIntroRegisterLogin.setVisibility(View.VISIBLE);
        } else {
            introductionIndicator.setVisibility(View.VISIBLE);
            llIntroRegisterLogin.setVisibility(View.GONE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @OnClick({R.id.tv_sign_up, R.id.tv_sign_in})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_sign_up:
                startActivity(new Intent(this, SignUpActivity.class));
                finish();
                break;
            case R.id.tv_sign_in:
                Toast.makeText(this, "SIGN IN", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
