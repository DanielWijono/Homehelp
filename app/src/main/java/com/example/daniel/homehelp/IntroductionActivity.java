package com.example.daniel.homehelp;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;

public class IntroductionActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    @BindView(R.id.introduction_view_pager)
    ViewPager introductionViewPager;
    @BindView(R.id.introduction_indicator)
    CircleIndicator introductionIndicator;
    @BindView(R.id.activity_introduction2)
    RelativeLayout activityIntroduction2;

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
            introductionIndicator.setVisibility(View.INVISIBLE);
        } else {
            introductionIndicator.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onBackPressed() {

    }
}
