package com.example.daniel.homehelp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daniel.homehelp.MyApplication;
import com.example.daniel.homehelp.R;
import com.example.daniel.homehelp.Utils;
import com.example.daniel.homehelp.adapter.AtapJobAdapter;
import com.shuhart.stepview.StepView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AtapActivity extends AppCompatActivity {

    @BindView(R.id.tv_title_toolbar)
    TextView tvTitleToolbar;
    @BindView(R.id.step_view)
    StepView stepView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
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
    @BindView(R.id.scroll_view)
    ScrollView scrollView;
    @BindView(R.id.tv_harian)
    TextView tvHarian;
    @BindView(R.id.tv_borongan)
    TextView tvBorongan;
    @BindView(R.id.next_button)
    TextView nextButton;
    @BindView(R.id.img_toolbar)
    ImageView imgToolbar;
    @BindView(R.id.tv_terms_condition_one)
    TextView tvTermsConditionOne;
    @BindView(R.id.tv_terms_condition_two)
    TextView tvTermsConditionTwo;
    @BindView(R.id.tv_terms_condition_three)
    TextView tvTermsConditionThree;
    @BindView(R.id.tv_terms_condition_four)
    TextView tvTermsConditionFour;
    @BindView(R.id.tv_terms_condition_five)
    TextView tvTermsConditionFive;

    AtapJobAdapter atapJobAdapter;
    String workType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atap);
        ButterKnife.bind(this);

        Utils.setupAppToolbarForActivity(this, toolbar, "Pemesanan");
        initRecyclerView();
        scrollView.setFocusableInTouchMode(true);
        scrollView.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
        atapRecyclerView.setNestedScrollingEnabled(false);
        MyApplication.getInstance().setIsHarian(true);
        MyApplication.getInstance().setIsBorongan(false);
        workType = "Harian";
        setTermConditionHarian();
    }

    private void initRecyclerView() {
        atapRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        atapJobAdapter = new AtapJobAdapter(this);
        atapRecyclerView.setAdapter(atapJobAdapter);
    }

    @OnClick({R.id.tv_harian, R.id.tv_borongan, R.id.next_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_harian:
                tvHarian.setBackgroundResource(R.drawable.signup_button);
                tvHarian.setTextColor(getResources().getColor(R.color.color_white));

                tvBorongan.setBackgroundResource(R.drawable.signup_border_background_white);
                tvBorongan.setTextColor(getResources().getColor(R.color.color_black_65));
                MyApplication.getInstance().setIsHarian(true);
                MyApplication.getInstance().setIsBorongan(false);
                workType = "Harian";
                atapRecyclerView.setAdapter(atapJobAdapter);
                setTermConditionHarian();
                break;
            case R.id.tv_borongan:
                tvBorongan.setBackgroundResource(R.drawable.signup_button);
                tvBorongan.setTextColor(getResources().getColor(R.color.color_white));

                tvHarian.setBackgroundResource(R.drawable.signup_border_background_white);
                tvHarian.setTextColor(getResources().getColor(R.color.color_black_65));
                MyApplication.getInstance().setIsHarian(false);
                MyApplication.getInstance().setIsBorongan(true);
                workType = "Borongan";
                atapRecyclerView.setAdapter(atapJobAdapter);
                setTermsConditionBorongan();
                break;
            case R.id.next_button:
                Intent intent = new Intent(this, AtapActivityStep2.class);
                intent.putExtra("WORK_TYPE", workType);
                startActivity(intent);
                break;
        }
    }

    private void setTermConditionHarian() {
        tvTermsConditionOne.setText(getResources().getString(R.string.terms_conditon_harian_one));
        tvTermsConditionTwo.setText(getResources().getString(R.string.terms_conditon_harian_two));
        tvTermsConditionThree.setText(getResources().getString(R.string.terms_conditon_harian_three));
        tvTermsConditionFour.setText(getResources().getString(R.string.terms_conditon_harian_four));
        tvTermsConditionFive.setText(getResources().getString(R.string.terms_conditon_harian_five));
    }

    private void setTermsConditionBorongan() {
        tvTermsConditionOne.setText(getResources().getString(R.string.terms_condition_borongan_one));
        tvTermsConditionTwo.setText(getResources().getString(R.string.terms_condition_borongan_two));
        tvTermsConditionThree.setText(getResources().getString(R.string.terms_condition_borongan_three));
        tvTermsConditionFour.setText(getResources().getString(R.string.terms_condition_borongan_four));
        tvTermsConditionFive.setText(getResources().getString(R.string.terms_condition_borongan_five));
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
