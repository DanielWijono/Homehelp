package com.example.daniel.homehelp.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.daniel.homehelp.R;
import com.example.daniel.homehelp.Utils;

import java.util.ArrayList;
import java.util.List;

public class FindingWorkerActivity extends AppCompatActivity {

    String workType, notes, date, listKerusakan, totalWorker, problemDesc, location, time;
    List<String> listKerusakanFromStep3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finding_worker);
        getBundle();
        delayHandler();
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

    private void delayHandler() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(FindingWorkerActivity.this, ChooseWorkerActivity.class);
                intent.putExtra("WORK_TYPE", workType);
                intent.putExtra("NOTES", notes);
                intent.putExtra("DATE", date);
                intent.putExtra("LOCATION", location);
                intent.putExtra("TOTAL_WORKER", totalWorker);
                intent.putExtra("PROBLEM_DESC", problemDesc);
                intent.putExtra("TIME", time);
                intent.putStringArrayListExtra("LIST_KERUSAKAN", (ArrayList<String>) listKerusakanFromStep3);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }
}
