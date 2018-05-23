package com.example.daniel.homehelp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.daniel.homehelp.adapter.BangunanAdapter;
import com.example.daniel.homehelp.R;
import com.example.daniel.homehelp.RecyclerViewOnClick;
import com.example.daniel.homehelp.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BangunanActivity extends AppCompatActivity implements RecyclerViewOnClick {

    @BindView(R.id.tv_title_toolbar)
    TextView tvTitleToolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.bangunan_recycler_view)
    RecyclerView bangunanRecyclerView;

    BangunanAdapter bangunanAdapter;
    RecyclerViewOnClick recyclerViewOnClick = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangunan);
        ButterKnife.bind(this);

        Utils.setupAppToolbarForActivity(this, toolbar, "Bangunan");

        initRecyclerView();
    }

    private void initRecyclerView() {
        bangunanRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        bangunanAdapter = new BangunanAdapter(this, recyclerViewOnClick);
        bangunanRecyclerView.setAdapter(bangunanAdapter);
    }

    @Override
    public void itemOnClick(View view, int position) {
        switch (position) {
            case 0:
                startActivity(new Intent(this, AtapActivity.class));
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }
}
