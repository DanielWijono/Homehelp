package com.example.daniel.homehelp.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.daniel.homehelp.R;
import com.example.daniel.homehelp.activity.DashBoardActivity;
import com.example.daniel.homehelp.activity.StatusOrderAgendaActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OnGoingAgendaFragment extends Fragment {

    @BindView(R.id.img_three_dots_item)
    ImageView imgThreeDotsItem;
    @BindView(R.id.ll_status_item)
    LinearLayout llStatusItem;
    @BindView(R.id.tv_reminder)
    TextView tvReminder;
    @BindView(R.id.ll_on_going_reminder)
    LinearLayout llOnGoingReminder;

    private View rootView;
    private DashBoardActivity mActivity;
    String reminderBundle;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof DashBoardActivity) {
            mActivity = (DashBoardActivity) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mActivity = null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static OnGoingAgendaFragment newInstance() {
        Bundle args = new Bundle();

        OnGoingAgendaFragment fragment = new OnGoingAgendaFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.on_going_agenda, container, false);
        ButterKnife.bind(this, rootView);

        if (getArguments() != null) {
            reminderBundle = getArguments().getString("REMINDER");
            if (reminderBundle != null) {
                llOnGoingReminder.setVisibility(View.VISIBLE);
            }
        }

        return rootView;
    }

    @OnClick({R.id.img_three_dots_item, R.id.ll_status_item})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_three_dots_item:
                //popup dialog
                break;
            case R.id.ll_status_item:
                Intent intent = new Intent(mActivity, StatusOrderAgendaActivity.class);
                startActivity(intent);
                break;
        }
    }
}
