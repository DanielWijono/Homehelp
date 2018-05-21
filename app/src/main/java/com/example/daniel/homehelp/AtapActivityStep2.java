package com.example.daniel.homehelp;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.shuhart.stepview.StepView;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AtapActivityStep2 extends AppCompatActivity {

    @BindView(R.id.step_view)
    StepView stepView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_title_toolbar)
    TextView tvTitleToolbar;
    @BindView(R.id.ll_toolbar_atap)
    LinearLayout llToolbarAtap;
    @BindView(R.id.app_bar_layout_atap)
    AppBarLayout appBarLayoutAtap;
    @BindView(R.id.img_atap)
    ImageView imgAtap;
    @BindView(R.id.ll_address)
    LinearLayout llAddress;
    @BindView(R.id.ll_notes)
    LinearLayout llNotes;
    @BindView(R.id.ll_location)
    LinearLayout llLocation;
    @BindView(R.id.ll_date_picker)
    LinearLayout llDatePicker;
    @BindView(R.id.ll_date)
    LinearLayout llDate;
    @BindView(R.id.ll_time_picker)
    LinearLayout llTimePicker;
    @BindView(R.id.ll_hour)
    LinearLayout llHour;
    @BindView(R.id.ll_time)
    LinearLayout llTime;
    @BindView(R.id.scroll_view)
    ScrollView scrollView;
    @BindView(R.id.next_button)
    TextView nextButton;
    @BindView(R.id.ll_footer)
    LinearLayout llFooter;
    @BindView(R.id.tv_date_begin)
    TextView tvDateBegin;

    private DatePickerDialog dateBeginDialog;
    private Calendar dateCalendar;
    @SuppressLint("RestrictedApi")
    Context context = new ContextThemeWrapper(this, R.style.MyDatePickerDialogTheme);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atap_step2);
        ButterKnife.bind(this);
        Utils.setupAppToolbarForActivity(this, toolbar, "Pemesanan");
        initStepView();
        dateCalendar = Calendar.getInstance();
        initCalendar();
        dateBeginDialog.getDatePicker().setTag(tvDateBegin.getId());

        DateTimeUtils.setInDateFormalFormat(dateCalendar, tvDateBegin);
    }

    @SuppressWarnings("ResourceType")
    private void initCalendar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            dateBeginDialog = new DatePickerDialog(context, myDateListener, dateCalendar.get(Calendar.YEAR), dateCalendar.get(Calendar.MONTH), dateCalendar.get(Calendar.DAY_OF_MONTH));
        } else {
            dateBeginDialog = new DatePickerDialog(this, AlertDialog.THEME_HOLO_DARK, myDateListener, dateCalendar.get(Calendar.YEAR), dateCalendar.get(Calendar.MONTH), dateCalendar.get(Calendar.DAY_OF_MONTH));
        }
        dateBeginDialog.getDatePicker().setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
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

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker picker, int year, int month, int date) {
            int tag = (int) picker.getTag();

            if (tag == tvDateBegin.getId()) {
                dateCalendar.set(year, month, date);
                DateTimeUtils.setInDateFormalFormat(dateCalendar, tvDateBegin);
            }
        }
    };

    @OnClick({R.id.ll_date_picker, R.id.next_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_date_picker:
                dateBeginDialog.getDatePicker().updateDate(dateCalendar.get(Calendar.YEAR), dateCalendar.get(Calendar.MONTH), dateCalendar.get(Calendar.DAY_OF_MONTH));
                dateBeginDialog.show();
                break;
            case R.id.next_button:
                startActivity(new Intent(this, AtapActivityStep3.class));
                break;
        }
    }
}
