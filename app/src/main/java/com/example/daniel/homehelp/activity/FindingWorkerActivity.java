package com.example.daniel.homehelp.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.daniel.homehelp.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class FindingWorkerActivity extends AppCompatActivity {

    String workType, notes, date, listKerusakan, totalWorker, problemDesc, location, time;
    List<String> listKerusakanFromStep3;
    @BindView(R.id.gif_image_view)
    GifImageView gifImageView;
    @BindView(R.id.tv_sign_up)
    TextView tvSignUp;
    @BindView(R.id.tv_sign_in)
    TextView tvSignIn;
    @BindView(R.id.ll_intro_register_login)
    LinearLayout llIntroRegisterLogin;

    GifDrawable gifFromResource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finding_worker);
        ButterKnife.bind(this);
        getBundle();
        gifAnimation();
        delayHandler();
    }

    private void gifAnimation() {
        try {
            gifFromResource = new GifDrawable(getResources(), R.raw.ic_find_worker_animation);
            gifFromResource.setSpeed(0.8f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            gifImageView.setBackground(gifFromResource);
        }
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
        }, 6000);
    }
}
