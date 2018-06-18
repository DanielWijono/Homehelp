package com.example.daniel.homehelp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.daniel.homehelp.R;
import com.example.daniel.homehelp.Utils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TrackingWorkerExpandedActivity extends AppCompatActivity {

    @BindView(R.id.tv_title_toolbar)
    TextView tvTitleToolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.ll_chat)
    ImageView llChat;
    @BindView(R.id.ll_call_phone)
    ImageView llCallPhone;
    @BindView(R.id.tv_location)
    TextView tvLocation;
    @BindView(R.id.tv_notes)
    TextView tvNotes;
    @BindView(R.id.tv_tipe)
    TextView tvTipe;
    @BindView(R.id.tv_price)
    TextView tvPrice;

    List<String> listKerusakanFromStep3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking_worker_expanded);
        ButterKnife.bind(this);
        Utils.setupAppToolbarForActivity(this, toolbar, "Tracking Pekerja");
        getBundle();
    }

    private void getBundle() {
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            listKerusakanFromStep3 = bundle.getStringArrayList("LIST_KERUSAKAN");
            System.out.println("list kerusakan tracking worker : " + listKerusakanFromStep3);
        }
    }
}
