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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atap_step4);
        ButterKnife.bind(this);
        initStepView();
        Utils.setupAppToolbarForActivity(this, toolbar, "Pemesanan");
    }

    private void initStepView() {
        stepView.getState()
                .selectedTextColor(ContextCompat.getColor(this, R.color.colorAccent))
                .animationType(StepView.ANIMATION_CIRCLE)
                .selectedCircleColor(ContextCompat.getColor(this, R.color.colorAccent))
                .selectedCircleRadius(getResources().getDimensionPixelSize(R.dimen.padding_margin_8dp))
                .selectedStepNumberColor(ContextCompat.getColor(this, R.color.color_white))
                // You should specify only stepsNumber or steps array of strings.
                // In case you specify both steps array is chosen.
                .steps(new ArrayList<String>() {{
                    add("TIPE");
                    add("PLAN");
                    add("MASALAH");
                    add("PESAN");
                }})
                // You should specify only steps number or steps array of strings.
                // In case you specify both steps array is chosen.
                .stepsNumber(4)
                .stepPadding(getResources().getDimensionPixelSize(R.dimen.padding_margin_1dp))
                .animationDuration(getResources().getInteger(android.R.integer.config_shortAnimTime))
                .stepLineWidth(getResources().getDimensionPixelSize(R.dimen.padding_margin_1dp))
                .textSize(getResources().getDimensionPixelSize(R.dimen.normal_font_size))
                .stepNumberTextSize(getResources().getDimensionPixelSize(R.dimen.normal_medium_font_size))
                .typeface(ResourcesCompat.getFont(this, R.font.proxima_nova_medium))
                // other state methods are equal to the corresponding xml attributes
                .commit();
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
