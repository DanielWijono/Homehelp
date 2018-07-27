package com.example.daniel.homehelp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.daniel.homehelp.R;
import com.example.daniel.homehelp.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
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
    @BindView(R.id.order_confirmation_damage)
    LinearLayout orderConfirmationDamage;
    @BindView(R.id.order_payment_method)
    LinearLayout orderPaymentMethod;
    @BindView(R.id.tv_scroll_to_top)
    TextView tvScrollToTop;
    @BindView(R.id.tv_see_worker)
    TextView tvSeeWorker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_order_agenda_detail);
        ButterKnife.bind(this);
        Utils.setupAppToolbarForActivity(this, toolbar, "Rincian");
    }

    @OnClick({R.id.tv_see_worker, R.id.tv_scroll_to_top})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_see_worker:
                Intent intent = new Intent(this, TrackingWorkerActivity.class);
                intent.putExtra("DATE", tvDateBegin.getText().toString());
                intent.putExtra("TIME",tvTimeBegin.getText().toString());
                startActivity(intent);
                break;
            case R.id.tv_scroll_to_top:
                scrollView.smoothScrollTo(0, 0);
                break;
        }
    }
}
