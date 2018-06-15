package com.example.daniel.homehelp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.daniel.homehelp.R;
import com.example.daniel.homehelp.RecyclerViewOnClick;
import com.example.daniel.homehelp.Utils;
import com.example.daniel.homehelp.adapter.NotificationAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotificationActivity extends AppCompatActivity implements RecyclerViewOnClick {

    @BindView(R.id.notification_recycler_view)
    RecyclerView notificationRecyclerView;
    @BindView(R.id.tv_title_toolbar)
    TextView tvTitleToolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    RecyclerViewOnClick recyclerViewOnClick = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);
        Utils.setupAppToolbarForActivity(this, toolbar, "Notifikasi");
        initRecyclerView();
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        notificationRecyclerView.setLayoutManager(layoutManager);
        NotificationAdapter notificationAdapter = new NotificationAdapter(this, this);
        notificationRecyclerView.setAdapter(notificationAdapter);
    }

    @Override
    public void itemOnClick(View view, int position) {
        startActivity(new Intent(this, NotificationDetailActivity.class));
    }
}
