package com.example.daniel.homehelp.activity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.daniel.homehelp.R;
import com.example.daniel.homehelp.RecyclerViewOnClick;
import com.example.daniel.homehelp.Utils;
import com.example.daniel.homehelp.adapter.HomeServiceAdapter;
import com.example.daniel.homehelp.fragment.AgendaFragment;

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

    HomeServiceAdapter homeServiceAdapter;
    RecyclerViewOnClick recyclerViewOnClick = this;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_save_reminder)
    TextView tvSaveReminder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);
        ButterKnife.bind(this);
        Utils.setupAppToolbarForActivity(this, toolbar, "Buat Reminder");
        initRecyclerView();
        serviceHomeRecyclerView.setNestedScrollingEnabled(false);
    }

    private void initRecyclerView() {
        serviceHomeRecyclerView.setLayoutManager(new GridLayoutManager(this,2));

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
                Intent intent  = new Intent(this, DashBoardActivity.class);
                intent.putExtra("REMINDER","REMINDER");
                startActivity(intent);
                finish();
                break;
        }
    }
}
