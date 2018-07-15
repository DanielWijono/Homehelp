package com.example.daniel.homehelp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.daniel.homehelp.R;
import com.example.daniel.homehelp.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StatusOrderAgendaActivity extends AppCompatActivity {

    @BindView(R.id.tv_title_toolbar)
    TextView tvTitleToolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.img_status_order_agenda)
    ImageView imgStatusOrderAgenda;
    @BindView(R.id.tv_chat)
    TextView tvChat;
    @BindView(R.id.tv_order_detail)
    TextView tvOrderDetail;
    @BindView(R.id.ll_order_agenda)
    LinearLayout llOrderAgenda;
    @BindView(R.id.scroll_view)
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_order_agenda);
        ButterKnife.bind(this);
        Utils.setupAppToolbarForActivity(this, toolbar, "Status");
    }

    @OnClick({R.id.tv_chat, R.id.tv_order_detail})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_chat:
                break;
            case R.id.tv_order_detail:
                Intent intent = new Intent(StatusOrderAgendaActivity.this, StatusOrderAgendaDetailActivity.class);
                startActivity(intent);
                break;
        }
    }
}
