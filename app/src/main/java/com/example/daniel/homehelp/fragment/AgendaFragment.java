package com.example.daniel.homehelp.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.daniel.homehelp.R;
import com.example.daniel.homehelp.activity.DashBoardActivity;
import com.example.daniel.homehelp.activity.ReminderActivity;
import com.example.daniel.homehelp.adapter.TabLayoutViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Daniel on 5/13/2018.
 */

public class AgendaFragment extends Fragment {

    @BindView(R.id.agenda_tab_layout)
    TabLayout agendaTabLayout;
    @BindView(R.id.agenda_view_pager)
    ViewPager agendaViewPager;
    @BindView(R.id.logo_header)
    ImageView logoHeader;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private View rootView;
    private DashBoardActivity mActivity;
    OnGoingAgendaFragment onGoingAgendaFragment = new OnGoingAgendaFragment();
    FinishAgendaFragment finishAgendaFragment = new FinishAgendaFragment();

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

    public static AgendaFragment newInstance() {
        Bundle args = new Bundle();

        AgendaFragment fragment = new AgendaFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.agenda_fragment, container, false);
        ButterKnife.bind(this, rootView);

        int pos = agendaViewPager.getCurrentItem();
        setupViewPager(pos);

        return rootView;
    }

    private void setupViewPager(int position) {
        TabLayoutViewPagerAdapter adapter = new TabLayoutViewPagerAdapter(getFragmentManager());
        adapter.addFragment(onGoingAgendaFragment, "Berlangsung");
        adapter.addFragment(finishAgendaFragment, "Selesai");

        agendaViewPager.setAdapter(adapter);
        agendaViewPager.setCurrentItem(position);
        agendaTabLayout.setupWithViewPager(agendaViewPager);
    }

    private void popUpDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
        builder.setCancelable(true);
        View dialoglayout = getLayoutInflater().inflate(R.layout.agenda_dialog, null, false);
        builder.setView(dialoglayout);
        final AlertDialog ad = builder.show();

        TextView tvKembali = dialoglayout.findViewById(R.id.tv_kembali);
        TextView tvReminder = dialoglayout.findViewById(R.id.tv_reminder);

        tvKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad.dismiss();
            }
        });

        tvReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad.dismiss();
                startActivity(new Intent(mActivity, ReminderActivity.class));
            }
        });

    }

    @OnClick(R.id.logo_header)
    public void onViewClicked() {
        popUpDialog();
    }
}
