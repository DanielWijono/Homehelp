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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

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
    @BindView(R.id.image_worker)
    CircleImageView imageWorker;
    @BindView(R.id.worker_name)
    TextView tvWorkerName;

    String workType, notes, date, listKerusakan, totalWorker, problemDesc, location, time, workerClicked, workerName;
    List<String> listKerusakanFromStep3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking_worker);
        ButterKnife.bind(this);
        Utils.setupAppToolbarForActivity(this, toolbar, "Tracking Pekerja");
        getBundle();
        validateUIWorker();
    }

    private void validateUIWorker() {
        if (workerClicked != null) {
            if (workerClicked.equalsIgnoreCase("one")) {
                imageWorker.setImageResource(R.drawable.ic_worker_face_one);
                tvWorkerName.setText(workerName);
            } else if (workerClicked.equalsIgnoreCase("two")) {
                imageWorker.setImageResource(R.drawable.ic_worker_face_two);
                tvWorkerName.setText(workerName);
            }
        } else {
            imgTrackMap.setEnabled(false);
            imgExpandLayout.setEnabled(false);
            llChat.setEnabled(false);
            llCallPhone.setEnabled(false);
        }

        tvDateTime.setText(date + " Jam " + time);
    }

    private void getBundle() {
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            workType = bundle.getString("WORK_TYPE");
            notes = bundle.getString("NOTES");
            date = bundle.getString("DATE");
            listKerusakan = bundle.getString("LIST_KERUSAKAN");
            totalWorker = bundle.getString("TOTAL_WORKER");
            location = bundle.getString("LOCATION");
            problemDesc = bundle.getString("PROBLEM_DESC");
            time = bundle.getString("TIME");
            workerClicked = bundle.getString("WORKER_CLICKED");
            workerName = bundle.getString("WORKER_NAME");
            listKerusakanFromStep3 = bundle.getStringArrayList("LIST_KERUSAKAN");
        }
    }

    @OnClick({R.id.ll_chat, R.id.ll_call_phone, R.id.img_track_map, R.id.img_expand_layout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_chat:
                Intent intentChat = new Intent(this, DashBoardActivity.class);
                intentChat.putExtra("FROM_STATUS_ORDER","INBOX_PAGE");
                startActivity(intentChat);
                break;
            case R.id.ll_call_phone:
                Toast.makeText(this, "phone clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_track_map:
                Intent intent = new Intent(this, TrackingWorkerStep2Activity.class);
                intent.putExtra("WORK_TYPE", workType);
                intent.putExtra("NOTES", notes);
                intent.putExtra("DATE", date);
                intent.putExtra("LOCATION", location);
                intent.putExtra("TOTAL_WORKER", totalWorker);
                intent.putExtra("PROBLEM_DESC", problemDesc);
                intent.putExtra("TIME", time);
                intent.putExtra("WORKER_CLICKED", workerClicked);
                intent.putExtra("WORKER_NAME", workerName);
                intent.putStringArrayListExtra("LIST_KERUSAKAN", (ArrayList<String>) listKerusakanFromStep3);
                startActivity(intent);
                break;
            case R.id.img_expand_layout:
                Intent intents = new Intent(this, TrackingWorkerExpandedActivity.class);
                intents.putExtra("WORK_TYPE", workType);
                intents.putExtra("NOTES", notes);
                intents.putExtra("DATE", date);
                intents.putExtra("LOCATION", location);
                intents.putExtra("TOTAL_WORKER", totalWorker);
                intents.putExtra("PROBLEM_DESC", problemDesc);
                intents.putExtra("TIME", time);
                intents.putExtra("WORKER_CLICKED", workerClicked);
                intents.putExtra("WORKER_NAME", workerName);
                intents.putStringArrayListExtra("LIST_KERUSAKAN", (ArrayList<String>) listKerusakanFromStep3);
                startActivity(intents);
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
                break;
        }
    }
}
