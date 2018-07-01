package com.example.daniel.homehelp.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.daniel.homehelp.DateTimeUtils;
import com.example.daniel.homehelp.R;
import com.example.daniel.homehelp.RecyclerViewOnClick;
import com.example.daniel.homehelp.Utils;
import com.example.daniel.homehelp.adapter.HomeServiceAdapter;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ReminderActivity extends AppCompatActivity implements RecyclerViewOnClick {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.bangunan_recycler_view)
    RecyclerView serviceHomeRecyclerView;
    @BindView(R.id.scroll_view)
    ScrollView scrollView;
    @BindView(R.id.ll_date_picker)
    LinearLayout llDatePicker;
    @BindView(R.id.ll_time_picker)
    LinearLayout llTimePicker;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_save_reminder)
    TextView tvSaveReminder;

    HomeServiceAdapter homeServiceAdapter;
    RecyclerViewOnClick recyclerViewOnClick = this;
    @BindView(R.id.tv_title_toolbar)
    TextView tvTitleToolbar;
    @BindView(R.id.img_reminder)
    ImageView imgReminder;
    @BindView(R.id.ll_reminder)
    LinearLayout llReminder;
    @BindView(R.id.ll_service_reminder)
    LinearLayout llServiceReminder;
    @BindView(R.id.ll_reminder_notes)
    LinearLayout llReminderNotes;
    @BindView(R.id.ll_reminder_location)
    LinearLayout llReminderLocation;
    @BindView(R.id.tv_date_begin)
    TextView tvDateBegin;
    @BindView(R.id.ll_date)
    LinearLayout llDate;
    @BindView(R.id.ll_hour)
    LinearLayout llHour;
    @BindView(R.id.ll_reminder_time)
    LinearLayout llReminderTime;
    private DatePickerDialog dateBeginDialog;
    private Calendar dateCalendar;
    private int mYear, mMonth, mDay;
    @SuppressLint("RestrictedApi")
    Context context = new ContextThemeWrapper(this, R.style.MyDatePickerDialogTheme);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);
        ButterKnife.bind(this);
        Utils.setupAppToolbarForActivity(this, toolbar, "Buat Reminder");
        initRecyclerView();
        serviceHomeRecyclerView.setNestedScrollingEnabled(false);
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

    private void initRecyclerView() {
        serviceHomeRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        homeServiceAdapter = new HomeServiceAdapter(this, recyclerViewOnClick);
        serviceHomeRecyclerView.setAdapter(homeServiceAdapter);
    }

    @Override
    public void itemOnClick(View view, int position) {
        Toast.makeText(this, "postion reminder service : " + position, Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.ll_date_picker, R.id.ll_time_picker, R.id.tv_save_reminder})
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
                                String month = DateTimeUtils.setMonthNumberToWords(monthOfYear+1);
                                tvDateBegin.setText(dayOfMonth + " " + month + " " + year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                datePickerDialog.show();
                break;
            case R.id.ll_time_picker:
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;

                mTimePicker = new TimePickerDialog(ReminderActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        tvTime.setText(String.format("%02d", selectedHour) + ":" + String.format("%02d", selectedMinute));
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
                break;
            case R.id.tv_save_reminder:
                popupReminderSuccess();
                break;
        }
    }

    private void popupReminderSuccess() {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(this);
        builder.setCancelable(true);
        View dialoglayout = getLayoutInflater().inflate(R.layout.reminder_success_dialog, null, false);
        builder.setView(dialoglayout);
        final android.support.v7.app.AlertDialog ad = builder.show();

        TextView tvReminder = dialoglayout.findViewById(R.id.tv_reminder_success_dialog);
        TextView tvSeeAgenda = dialoglayout.findViewById(R.id.tv_see_agenda_reminder);
        ImageView imageReminder = dialoglayout.findViewById(R.id.img_reminder_success_dialog);

        imageReminder.setImageResource(R.drawable.ic_bangunan);
        tvReminder.setText("Reminder \nBerhasil Dibuat!");

        tvSeeAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad.dismiss();
                Intent intent = new Intent(ReminderActivity.this, DashBoardActivity.class);
                intent.putExtra("REMINDER", "REMINDER");
                startActivity(intent);
                finish();
            }
        });
    }
}
