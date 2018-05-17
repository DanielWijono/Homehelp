package com.example.daniel.homehelp;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shuhart.stepview.StepView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AtapActivity extends AppCompatActivity {

    @BindView(R.id.tv_title_toolbar)
    TextView tvTitleToolbar;
    @BindView(R.id.step_view)
    StepView stepView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    AtapJobAdapter atapJobAdapter;
    @BindView(R.id.ll_toolbar_atap)
    LinearLayout llToolbarAtap;
    @BindView(R.id.app_bar_layout_atap)
    AppBarLayout appBarLayoutAtap;
    @BindView(R.id.img_atap)
    ImageView imgAtap;
    @BindView(R.id.ll_job_type)
    LinearLayout llJobType;
    @BindView(R.id.atap_recycler_view)
    RecyclerView atapRecyclerView;
    @BindView(R.id.ll_footer)
    LinearLayout llFooter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atap);
        ButterKnife.bind(this);

        Utils.setupAppToolbarForActivity(this, toolbar, "Pemesanan");
        initStepView();
        initRecyclerView();
        atapRecyclerView.setNestedScrollingEnabled(false);
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

    private void initRecyclerView() {
        atapRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        atapJobAdapter = new AtapJobAdapter(this);
        atapRecyclerView.setAdapter(atapJobAdapter);
    }
}
