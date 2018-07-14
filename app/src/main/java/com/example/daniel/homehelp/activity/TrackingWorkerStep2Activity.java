package com.example.daniel.homehelp.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.daniel.homehelp.R;
import com.example.daniel.homehelp.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class TrackingWorkerStep2Activity extends AppCompatActivity {

    @BindView(R.id.tv_title_toolbar)
    TextView tvTitleToolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_date_time)
    TextView tvDateTime;
    @BindView(R.id.ll_info)
    LinearLayout llInfo;
    //    @BindView(R.id.img_track_map)
//    ImageView imgTrackMap;
    @BindView(R.id.gif_image_view)
    GifImageView gifImageView;
    @BindView(R.id.tv_done_button)
    TextView tvDoneButton;
    @BindView(R.id.img_expand_layout)
    ImageView imgExpandLayout;
    @BindView(R.id.image_worker)
    CircleImageView imageWorker;
    @BindView(R.id.worker_name)
    TextView tvWorkerName;

    GifDrawable gifFromResource;
    List<String> listKerusakanFromStep3;
    String workType, notes, date, listKerusakan, totalWorker, problemDesc, location, time, workerClicked, workerName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking_worker_step2);
        ButterKnife.bind(this);
        Utils.setupAppToolbarForActivity(this, toolbar, "Tracking Pekerja");
        try {
            gifFromResource = new GifDrawable(getResources(), R.raw.tracking_pekerja_animated);
            gifFromResource.setSpeed(0.8f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            gifImageView.setBackground(gifFromResource);
        }
        getBundle();
        validateUIWorker();
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

    private void validateUIWorker() {
        if (workerClicked.equalsIgnoreCase("one")) {
            imageWorker.setImageResource(R.drawable.ic_worker_face_one);
            tvWorkerName.setText(workerName);
        } else if (workerClicked.equalsIgnoreCase("two")) {
            imageWorker.setImageResource(R.drawable.ic_worker_face_two);
            tvWorkerName.setText(workerName);
        }
    }

    private void showDialogBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        View dialoglayout = getLayoutInflater().inflate(R.layout.cancel_order_dialog, null, false);
        builder.setView(dialoglayout);
        final AlertDialog ad = builder.show();

        TextView tvCancel = dialoglayout.findViewById(R.id.tv_cancel_order);
        TextView tvKembali = dialoglayout.findViewById(R.id.tv_cancel_order_back);
        TextView tvCancelTitle = dialoglayout.findViewById(R.id.tv_title_agenda_dialog);
        TextView tvCancelDesc = dialoglayout.findViewById(R.id.tv_cancel_desc);
        ImageView imageView = dialoglayout.findViewById(R.id.img_agenda_dialog);

        tvCancelTitle.setVisibility(View.GONE);
        tvCancelDesc.setText("Apakah anda yakin ingin \nmeninggalkan halaman ini ?");
        imageView.setImageResource(R.drawable.ic_cancel_agenda);

        tvKembali.setText("Batalkan");
        tvKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad.dismiss();
            }
        });

        tvCancel.setText("Ya");
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad.dismiss();
                finish();
            }
        });
    }

    private void confirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        View dialoglayout = getLayoutInflater().inflate(R.layout.confirmation_dialog, null, false);
        builder.setView(dialoglayout);
        final AlertDialog ad = builder.show();

        TextView tvBack = dialoglayout.findViewById(R.id.back_dialog);
        TextView tvNext = dialoglayout.findViewById(R.id.next_button_dialog);
        TextView tvTitle = dialoglayout.findViewById(R.id.dialog_title);
        TextView tvDesc = dialoglayout.findViewById(R.id.dialog_desc);

        tvTitle.setText("Pekerjaan Sudah Selesai?");
        tvDesc.setText("Tekan Selesai untuk mengakhir,\natau Pesan Lagi jika belum selesai");
        tvBack.setText("Selesai");
        tvNext.setText("Pesan Lagi");

        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad.dismiss();
                Intent intent = new Intent(TrackingWorkerStep2Activity.this, RatingActivity.class);
                intent.putStringArrayListExtra("LIST_KERUSAKAN", (ArrayList<String>) listKerusakanFromStep3);
                startActivity(intent);
            }
        });

        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad.dismiss();
                Intent intents = new Intent(TrackingWorkerStep2Activity.this, BangunanActivity.class);
                startActivity(intents);
//                Intent intent = new Intent(TrackingWorkerStep2Activity.this, RatingActivity.class);
//                intent.putExtra("WORK_TYPE", workType);
//                intent.putExtra("NOTES", notes);
//                intent.putExtra("DATE", date);
//                intent.putExtra("LOCATION", location);
//                intent.putExtra("TOTAL_WORKER", totalWorker);
//                intent.putExtra("PROBLEM_DESC", problemDesc);
//                intent.putExtra("TIME", time);
//                intent.putStringArrayListExtra("LIST_KERUSAKAN", (ArrayList<String>) listKerusakanFromStep3);
//                startActivity(intent);

            }
        });
    }

    @Override
    public void onBackPressed() {
        showDialogBackPressed();
    }

    @OnClick({R.id.img_expand_layout, R.id.tv_done_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
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
                intents.putExtra("BOTTOM_BUTTON","selesai");
                intents.putStringArrayListExtra("LIST_KERUSAKAN", (ArrayList<String>) listKerusakanFromStep3);
                startActivity(intents);
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
                break;
            case R.id.tv_done_button:
                confirmationDialog();
                break;
        }
    }
}
