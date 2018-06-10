package com.example.daniel.homehelp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.daniel.homehelp.R;
import com.example.daniel.homehelp.Utils;
import com.shuhart.stepview.StepView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AtapActivityStep4 extends AppCompatActivity {

    @BindView(R.id.tv_title_toolbar)
    TextView tvTitleToolbar;
    @BindView(R.id.step_view)
    StepView stepView;
    @BindView(R.id.ll_toolbar_atap)
    LinearLayout llToolbarAtap;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.app_bar_layout_atap)
    AppBarLayout appBarLayoutAtap;
    @BindView(R.id.img_atap)
    ImageView imgAtap;
    @BindView(R.id.scroll_view)
    ScrollView scrollView;
    @BindView(R.id.radioMale)
    RadioButton radioMale;
    @BindView(R.id.radioFemale)
    RadioButton radioFemale;
    @BindView(R.id.radioPayment)
    RadioGroup radioPayment;
    @BindView(R.id.tv_order_button)
    TextView tvOrderButton;
    @BindView(R.id.tv_work_type)
    TextView tvWorkType;
    @BindView(R.id.tv_damage_title)
    TextView tvDamageTitle;
    @BindView(R.id.tv_problem_desc)
    TextView tvProblemDesc;
    @BindView(R.id.tv_date_begin)
    TextView tvDateBegin;
    @BindView(R.id.tv_worker_sum)
    TextView tvWorkerSum;
    @BindView(R.id.img_toolbar)
    ImageView imgToolbar;
    @BindView(R.id.ll_title_kerusakan)
    LinearLayout llTitleKerusakan;

    String workType, notes, date, listKerusakan, totalWorker, problemDesc;
    List<String> listKerusakanFromStep3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atap_step4);
        ButterKnife.bind(this);
        Utils.setupAppToolbarForActivity(this, toolbar, "Pemesanan");
        getBundle();
        setUpView();
        setViewBagianKerusakan();
    }

    private void setViewBagianKerusakan() {
        for (int i = 0; i < listKerusakanFromStep3.size(); i++) {
            View view = getLayoutInflater().inflate(R.layout.item_kerusakan_step4, null);
            TextView tvItemKerusakan = view.findViewById(R.id.tv_item_kerusakan);
            ImageView imgItemKerusakan = view.findViewById(R.id.image_item_kerusakan);

            tvItemKerusakan.setText(listKerusakanFromStep3.get(i));
            imgItemKerusakan.setImageResource(R.drawable.ic_checked);
            llTitleKerusakan.addView(view);
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
            problemDesc = bundle.getString("PROBLEM_DESC");
            listKerusakanFromStep3 = bundle.getStringArrayList("LIST_KERUSAKAN");
            System.out.println("list kerusakan from step 3 : "+listKerusakanFromStep3);
        }
    }

    private void setUpView() {
        tvWorkType.setText(workType);
        tvDamageTitle.setText(listKerusakan);
        tvDateBegin.setText(date);
        tvProblemDesc.setText(problemDesc);
        tvWorkerSum.setText("Jumlah Pekerja : " + totalWorker);
    }

    private void confirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        View dialoglayout = getLayoutInflater().inflate(R.layout.confirmation_dialog, null, false);
        builder.setView(dialoglayout);
        final AlertDialog ad = builder.show();

        TextView tvBack = dialoglayout.findViewById(R.id.back_dialog);
        TextView tvNext = dialoglayout.findViewById(R.id.next_button_dialog);

        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad.dismiss();
            }
        });

        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad.dismiss();
                startActivity(new Intent(AtapActivityStep4.this, FindingWorkerActivity.class));
            }
        });
    }

    @OnClick(R.id.tv_order_button)
    public void onViewClicked() {
        confirmationDialog();
    }
}
