package com.example.daniel.homehelp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.daniel.homehelp.R;
import com.example.daniel.homehelp.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class StatusOrderAgendaDetailActivity extends AppCompatActivity {

    @BindView(R.id.tv_title_toolbar)
    TextView tvTitleToolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.img_status_order_agenda_detail)
    ImageView imgStatusOrderAgendaDetail;
    @BindView(R.id.image_worker)
    CircleImageView imageWorker;
    @BindView(R.id.worker_name)
    TextView workerName;
    @BindView(R.id.ll_worker)
    LinearLayout llWorker;
    @BindView(R.id.tv_work_type)
    TextView tvWorkType;
    @BindView(R.id.tv_location)
    TextView tvLocation;
    @BindView(R.id.tv_notes)
    TextView tvNotes;
    @BindView(R.id.tv_date_begin)
    TextView tvDateBegin;
    @BindView(R.id.tv_time_begin)
    TextView tvTimeBegin;
    @BindView(R.id.ll_order_confirmation_detail)
    LinearLayout llOrderConfirmationDetail;
    @BindView(R.id.tv_damage_title)
    TextView tvDamageTitle;
    @BindView(R.id.ll_title_kerusakan)
    LinearLayout llTitleKerusakan;
    @BindView(R.id.tv_problem_desc)
    TextView tvProblemDesc;
    @BindView(R.id.tv_worker_sum)
    TextView tvWorkerSum;
    @BindView(R.id.scroll_view)
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_order_agenda_detail);
        ButterKnife.bind(this);
        Utils.setupAppToolbarForActivity(this, toolbar, "Rincian");
    }
}
