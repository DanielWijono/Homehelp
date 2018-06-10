package com.example.daniel.homehelp.activity;

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
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.daniel.homehelp.DateTimeUtils;
import com.example.daniel.homehelp.R;
import com.example.daniel.homehelp.Utils;
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
    @BindView(R.id.et_notes)
    EditText etNotes;
    @BindView(R.id.img_toolbar)
    ImageView imgToolbar;
    @BindView(R.id.et_location)
    EditText etLocation;

    private DatePickerDialog dateBeginDialog;
    private Calendar dateCalendar;
    private String workType, notes, location;
    @SuppressLint("RestrictedApi")
    Context context = new ContextThemeWrapper(this, R.style.MyDatePickerDialogTheme);

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            notes = etNotes.getText().toString();
            location = etLocation.getText().toString();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atap_step2);
        ButterKnife.bind(this);
        Utils.setupAppToolbarForActivity(this, toolbar, "Pemesanan");
        scrollView.setFocusableInTouchMode(true);
        scrollView.setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);
        dateCalendar = Calendar.getInstance();
        initCalendar();
        dateBeginDialog.getDatePicker().setTag(tvDateBegin.getId());
        DateTimeUtils.setInDateFormalFormat(dateCalendar, tvDateBegin);
        getBundle();
        etNotes.addTextChangedListener(textWatcher);
        etLocation.addTextChangedListener(textWatcher);
        imgToolbar.setImageResource(R.drawable.ic_step_two);
    }

    private void getBundle() {
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            workType = bundle.getString("WORK_TYPE");
        }
    }

    @SuppressWarnings("ResourceType")
    private void initCalendar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            dateBeginDialog = new DatePickerDialog(context, myDateListener, dateCalendar.get(Calendar.YEAR), dateCalendar.get(Calendar.MONTH), dateCalendar.get(Calendar.DAY_OF_MONTH));
        } else {
            dateBeginDialog = new DatePickerDialog(this, AlertDialog.THEME_HOLO_LIGHT, myDateListener, dateCalendar.get(Calendar.YEAR), dateCalendar.get(Calendar.MONTH), dateCalendar.get(Calendar.DAY_OF_MONTH));
        }
        dateBeginDialog.getDatePicker().setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
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
                Intent intent = new Intent(this, AtapActivityStep3.class);
                intent.putExtra("WORK_TYPE", workType);
                intent.putExtra("NOTES", notes);
                intent.putExtra("DATE", tvDateBegin.getText().toString());
                startActivity(intent);
                break;
        }
    }
}
