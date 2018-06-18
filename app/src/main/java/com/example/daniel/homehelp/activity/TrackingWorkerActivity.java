package com.example.daniel.homehelp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daniel.homehelp.R;
import com.example.daniel.homehelp.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TrackingWorkerActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.ll_info)
    LinearLayout llInfo;
    @BindView(R.id.tv_title_toolbar)
    TextView tvTitleToolbar;
    @BindView(R.id.ll_chat)
    ImageView llChat;
    @BindView(R.id.ll_call_phone)
    ImageView llCallPhone;
    @BindView(R.id.tv_date_time)
    TextView tvDateTime;
    @BindView(R.id.img_track_map)
    ImageView imgTrackMap;
    @BindView(R.id.img_expand_layout)
    ImageView imgExpandLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking_worker);
        ButterKnife.bind(this);
        Utils.setupAppToolbarForActivity(this, toolbar, "Tracking Pekerja");
    }

    @OnClick({R.id.ll_chat, R.id.ll_call_phone, R.id.img_track_map, R.id.img_expand_layout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_chat:
                Toast.makeText(this, "chat clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_call_phone:
                Toast.makeText(this, "phone clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_track_map:
                startActivity(new Intent(this, TrackingWorkerStep2Activity.class));
                break;
            case R.id.img_expand_layout:
                startActivity(new Intent(this, TrackingWorkerExpandedActivity.class));
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
                break;
        }
    }
}
