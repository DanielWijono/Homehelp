package com.example.daniel.homehelp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.daniel.homehelp.R;
import com.example.daniel.homehelp.RecyclerViewOnClickTipsHome;
import com.example.daniel.homehelp.Utils;
import com.example.daniel.homehelp.adapter.HomeTipsAdapter;
import com.example.daniel.homehelp.adapter.HomeTipsAdapterDetail;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeTipsDetailActivity extends AppCompatActivity {

    @BindView(R.id.tv_title_toolbar)
    TextView tvTitleToolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.img_atap)
    ImageView imgAtap;
    @BindView(R.id.tv_tips_one)
    TextView tvTipsOne;
    @BindView(R.id.tv_tips_two)
    TextView tvTipsTwo;
    @BindView(R.id.tv_tips_three)
    TextView tvTipsThree;
    @BindView(R.id.ll_home_tips_detail)
    LinearLayout llHomeTipsDetail;
    @BindView(R.id.scroll_view)
    ScrollView scrollView;
    @BindView(R.id.tv_check_article)
    TextView tvCheckArticle;
    @BindView(R.id.tips_home_recycler_view)
    RecyclerView tipsHomeRecyclerView;

    HomeTipsAdapterDetail homeTipsAdapterDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_tips_detail);
        ButterKnife.bind(this);
        Utils.setupAppToolbarForActivity(this, toolbar, "Tips Rumah");
        setTextArticle();
        initTipsRecyclerView();
    }

    private void setTextArticle() {
        tvTipsOne.setText(getResources().getString(R.string.tips_one));
        tvTipsTwo.setText(getResources().getString(R.string.tips_two));
        tvTipsThree.setText(getResources().getString(R.string.tips_three));
    }

    private void initTipsRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        tipsHomeRecyclerView.setLayoutManager(layoutManager);

        homeTipsAdapterDetail = new HomeTipsAdapterDetail(this);
        tipsHomeRecyclerView.setAdapter(homeTipsAdapterDetail);
    }
}
