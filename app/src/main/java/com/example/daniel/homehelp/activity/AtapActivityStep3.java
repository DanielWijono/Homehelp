package com.example.daniel.homehelp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.daniel.homehelp.R;
import com.example.daniel.homehelp.Utils;
import com.example.daniel.homehelp.adapter.AtapKerusakanAdapter;
import com.shuhart.stepview.StepView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AtapActivityStep3 extends AppCompatActivity {

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
    @BindView(R.id.service_atap_recycler_view)
    RecyclerView serviceAtapRecyclerView;
    @BindView(R.id.scroll_view)
    ScrollView scrollView;

    AtapKerusakanAdapter atapKerusakanAdapter;
    @BindView(R.id.tv_substract)
    TextView tvSubstract;
    @BindView(R.id.tv_tukang_sum)
    TextView tvTukangSum;
    @BindView(R.id.tv_plus)
    TextView tvPlus;
    @BindView(R.id.next_button)
    TextView nextButton;
    @BindView(R.id.ll_footer)
    LinearLayout llFooter;
    @BindView(R.id.et_problem_desc)
    EditText etProblemDesc;

    String workType, notes, date, problemDesc;

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            problemDesc = etProblemDesc.getText().toString();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atap_step3);
        ButterKnife.bind(this);
        initRecyclerView();
        initStepView();
        Utils.setupAppToolbarForActivity(this, toolbar, "Pemesanan");
        getBundle();
        etProblemDesc.addTextChangedListener(textWatcher);
    }
    
    private void getBundle() {
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            workType = bundle.getString("WORK_TYPE");
            notes = bundle.getString("NOTES");
            date = bundle.getString("DATE");
        }
    }

    private void initRecyclerView() {
        serviceAtapRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        atapKerusakanAdapter = new AtapKerusakanAdapter(this);
        serviceAtapRecyclerView.setAdapter(atapKerusakanAdapter);
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

    @OnClick({R.id.tv_substract, R.id.tv_plus, R.id.next_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_substract:
                if (tvTukangSum.getText().toString().equals("2")) {
                    tvTukangSum.setText("1");
                }
                break;
            case R.id.tv_plus:
                if (tvTukangSum.getText().toString().equals("1")) {
                    tvTukangSum.setText("2");
                }
                break;
            case R.id.next_button:
                String replaceOpenBracket = String.valueOf(AtapKerusakanAdapter.listKerusakan).replace("[", "");
                String finalReplace = replaceOpenBracket.replace("]", "");
                Intent intent = new Intent(this, AtapActivityStep4.class);
                intent.putExtra("WORK_TYPE", workType);
                intent.putExtra("NOTES", notes);
                intent.putExtra("DATE", date);
                intent.putExtra("TOTAL_WORKER", tvTukangSum.getText().toString());
                intent.putExtra("PROBLEM_DESC",problemDesc);
                intent.putExtra("LIST_KERUSAKAN", finalReplace);
                startActivity(intent);
                break;
        }
    }
}
