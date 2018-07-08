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
            listKerusakanFromStep3 = bundle.getStringArrayList("LIST_KERUSAKAN");
            System.out.println("list kerusakan finding worker : " + listKerusakanFromStep3);
        }
    }

    private void delayHandler() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(FindingWorkerActivity.this, ChooseWorkerActivity.class);
                intent.putStringArrayListExtra("LIST_KERUSAKAN", (ArrayList<String>) listKerusakanFromStep3);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }
}
