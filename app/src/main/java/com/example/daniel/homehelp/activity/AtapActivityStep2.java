package com.example.daniel.homehelp.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.daniel.homehelp.DateTimeUtils;
import com.example.daniel.homehelp.R;
import com.example.daniel.homehelp.Utils;
import com.shuhart.stepview.StepView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.autocomplete_address)
    AutoCompleteTextView autocompleteAddress;

    private DatePickerDialog dateBeginDialog;
    private Calendar dateCalendar;
    private String workType, notes, location, time;
    @SuppressLint("RestrictedApi")
    Context context = new ContextThemeWrapper(this, R.style.MyDatePickerDialogTheme);
    private int mYear, mMonth, mDay;
    private List<String> addressList = new ArrayList<>();
    private int hour, minute;
    Calendar mcurrentTime;

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
            location = autocompleteAddress.getText().toString();
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
        mcurrentTime = Calendar.getInstance();
        hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        minute = mcurrentTime.get(Calendar.MINUTE);
        tvTime.setText(String.format("%02d", hour) + ":" + String.format("%02d", minute));
        time = String.format("%02d", hour) + ":" + String.format("%02d", minute);
        getBundle();
        etNotes.addTextChangedListener(textWatcher);
        autocompleteAddress.addTextChangedListener(textWatcher);
        imgToolbar.setImageResource(R.drawable.ic_step_two);
        setupAutoCompleteTextView();
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

    private void setupAutoCompleteTextView() {
        addressList.add("Jalan Kh Syahdan Barat no.5");
        addressList.add("Jalan Kh Syahdan Timur no.6");
        addressList.add("Jalan Kh Syahdan Pusat no.7");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, addressList);
        autocompleteAddress.setAdapter(adapter);
    }

    @OnClick({R.id.ll_date_picker, R.id.next_button, R.id.ll_time_picker})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_date_picker:
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(this, R.style.MyDatePickerDialogThemes,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                String month = DateTimeUtils.setMonthNumberToWords(monthOfYear + 1);
                                tvDateBegin.setText(dayOfMonth + " " + month + " " + year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                datePickerDialog.show();
                break;
            case R.id.next_button:
                Intent intent = new Intent(this, AtapActivityStep3.class);
                intent.putExtra("WORK_TYPE", workType);
                intent.putExtra("NOTES", notes);
                intent.putExtra("LOCATION", location);
                intent.putExtra("DATE", tvDateBegin.getText().toString());
                intent.putExtra("TIME", time);
                startActivity(intent);
                break;
            case R.id.ll_time_picker:
                mcurrentTime = Calendar.getInstance();
                hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;

                mTimePicker = new TimePickerDialog(AtapActivityStep2.this, R.style.TimePickerTheme, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        tvTime.setText(String.format("%02d", selectedHour) + ":" + String.format("%02d", selectedMinute));
                        time = String.format("%02d", selectedHour) + ":" + String.format("%02d", selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
                break;
        }
    }
}
