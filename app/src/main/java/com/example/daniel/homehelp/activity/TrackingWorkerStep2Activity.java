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

    List<String> listKerusakanFromStep3;
    GifDrawable gifFromResource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking_worker_step2);
        ButterKnife.bind(this);
        Utils.setupAppToolbarForActivity(this, toolbar, "Tracking Pekerja");
        try {
            gifFromResource = new GifDrawable( getResources(), R.raw.tracking_pekerja_animated);
            gifFromResource.setSpeed(0.8f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            gifImageView.setBackground(gifFromResource);
        }
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

    @Override
    public void onBackPressed() {
        showDialogBackPressed();
    }
}
