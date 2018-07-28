package com.example.daniel.homehelp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daniel.homehelp.R;
import com.example.daniel.homehelp.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotificationDetailActivity extends AppCompatActivity {

    @BindView(R.id.tv_title_toolbar)
    TextView tvTitleToolbar;
    @BindView(R.id.btn_delete)
    ImageView btnDelete;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_notification_title)
    TextView tvNotificationTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_detail);
        ButterKnife.bind(this);
        Utils.setupAppToolbarForActivity(this, toolbar, "Hot Day Promo");
        tvNotificationTitle.setText("Yuk, cobain perbaikan\nAC GRATIS!");
    }
}
