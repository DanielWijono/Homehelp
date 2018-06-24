package com.example.daniel.homehelp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.daniel.homehelp.R;
import com.example.daniel.homehelp.RecyclerViewOnClick;
import com.example.daniel.homehelp.Utils;
import com.example.daniel.homehelp.adapter.HomeServiceAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReminderActivity extends AppCompatActivity implements RecyclerViewOnClick {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.bangunan_recycler_view)
    RecyclerView serviceHomeRecyclerView;

    HomeServiceAdapter homeServiceAdapter;
    RecyclerViewOnClick recyclerViewOnClick = this;
    @BindView(R.id.scroll_view)
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);
        ButterKnife.bind(this);
        Utils.setupAppToolbarForActivity(this, toolbar, "Buat Reminder");
        initRecyclerView();
        serviceHomeRecyclerView.setNestedScrollingEnabled(false);
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        serviceHomeRecyclerView.setLayoutManager(layoutManager);

        homeServiceAdapter = new HomeServiceAdapter(this, recyclerViewOnClick);
        serviceHomeRecyclerView.setAdapter(homeServiceAdapter);
    }

    @Override
    public void itemOnClick(View view, int position) {
        Toast.makeText(this, "postion reminder service : " + position, Toast.LENGTH_SHORT).show();
    }
}
