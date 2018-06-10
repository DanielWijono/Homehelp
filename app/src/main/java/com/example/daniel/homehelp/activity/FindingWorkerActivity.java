package com.example.daniel.homehelp.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.daniel.homehelp.R;
import com.example.daniel.homehelp.Utils;

public class FindingWorkerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finding_worker);
        delayHandler();
    }

    private void delayHandler() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(FindingWorkerActivity.this, ChooseWorkerActivity.class));
                finish();
            }
        }, 3000);
    }
}
