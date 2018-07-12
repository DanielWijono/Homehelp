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
import de.hdodenhof.circleimageview.CircleImageView;

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
    @BindView(R.id.image_worker)
    CircleImageView imageWorker;
    @BindView(R.id.tv_worker_name)
    TextView tvWorkerName;

    String workType, notes, date, listKerusakan, totalWorker, problemDesc, location, time, workerClicked, workerName;
    List<String> listKerusakanFromStep3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking_worker_expanded);
        ButterKnife.bind(this);
        Utils.setupAppToolbarForActivity(this, toolbar, "Tracking Pekerja");
        getBundle();
        setView();
    }

    private void setView() {
        if (workerClicked.equalsIgnoreCase("one")) {
            imageWorker.setImageResource(R.drawable.ic_worker_face_one);
            tvWorkerName.setText(workerName);
        } else if (workerClicked.equalsIgnoreCase("two")) {
            imageWorker.setImageResource(R.drawable.ic_worker_face_two);
            tvWorkerName.setText(workerName);
        }
        tvLocation.setText(location);
        tvNotes.setText(notes);
        tvTipe.setText("Tipe : " + workType);
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
            System.out.println("list kerusakan tracking worker : " + listKerusakanFromStep3);
        }
    }
}
