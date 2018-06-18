package com.example.daniel.homehelp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.daniel.homehelp.R;
import com.example.daniel.homehelp.Utils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TrackingWorkerStep2Activity extends AppCompatActivity {

    @BindView(R.id.tv_title_toolbar)
    TextView tvTitleToolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_date_time)
    TextView tvDateTime;
    @BindView(R.id.ll_info)
    LinearLayout llInfo;
    @BindView(R.id.img_track_map)
    ImageView imgTrackMap;
    @BindView(R.id.tv_done_button)
    TextView tvDoneButton;

    List<String> listKerusakanFromStep3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking_worker_step2);
        ButterKnife.bind(this);
        Utils.setupAppToolbarForActivity(this, toolbar, "Tracking Pekerja");
        getBundle();
    }

    private void getBundle() {
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            listKerusakanFromStep3 = bundle.getStringArrayList("LIST_KERUSAKAN");
            System.out.println("list kerusakan tracking worker step 2 : " + listKerusakanFromStep3);
        }
    }

    @OnClick(R.id.tv_done_button)
    public void onViewClicked() {
        Intent intent = new Intent(this, RatingActivity.class);
        intent.putStringArrayListExtra("LIST_KERUSAKAN", (ArrayList<String>) listKerusakanFromStep3);
        startActivity(intent);
    }
}
