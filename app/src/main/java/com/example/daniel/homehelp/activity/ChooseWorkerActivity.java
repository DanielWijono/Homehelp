package com.example.daniel.homehelp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daniel.homehelp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChooseWorkerActivity extends AppCompatActivity {

    @BindView(R.id.tv_order_button)
    TextView tvOrderButton;
    @BindView(R.id.img_check_worker_one)
    ImageView imgCheckWorkerOne;
    @BindView(R.id.ll_worker_one)
    LinearLayout llWorkerOne;
    @BindView(R.id.img_check_worker_two)
    ImageView imgCheckWorkerTwo;
    @BindView(R.id.ll_worker_two)
    LinearLayout llWorkerTwo;
    @BindView(R.id.tv_worker_one)
    TextView tvWorkerOne;
    @BindView(R.id.tv_worker_two)
    TextView tvWorkerTwo;

    boolean isOneClicked, isTwoClicked;
    String workType, notes, date, listKerusakan, totalWorker, problemDesc, location, time, workerClicked, workerName;
    List<String> listKerusakanFromStep3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_worker);
        ButterKnife.bind(this);
        getBundle();
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
            listKerusakanFromStep3 = bundle.getStringArrayList("LIST_KERUSAKAN");
            System.out.println("list kerusakan finding worker : " + listKerusakanFromStep3);
        }
    }

    @OnClick({R.id.ll_worker_one, R.id.ll_worker_two, R.id.tv_order_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_worker_one:
                isOneClicked = true;
                isTwoClicked = false;
                imgCheckWorkerOne.setImageResource(R.drawable.ic_already_choose);
                imgCheckWorkerTwo.setImageResource(R.drawable.ic_not_choose);
                workerClicked = "one";
                workerName = tvWorkerOne.getText().toString();
                break;
            case R.id.ll_worker_two:
                isOneClicked = false;
                isTwoClicked = true;
                imgCheckWorkerOne.setImageResource(R.drawable.ic_not_choose);
                imgCheckWorkerTwo.setImageResource(R.drawable.ic_already_choose);
                workerClicked = "two";
                workerName = tvWorkerTwo.getText().toString();
                break;
            case R.id.tv_order_button:
                if (isOneClicked || isTwoClicked) {
                    Intent intent = new Intent(ChooseWorkerActivity.this, TrackingWorkerActivity.class);
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
                } else {
                    Toast.makeText(this, "Mohon pilih salah satu pekerja", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
