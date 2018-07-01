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
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daniel.homehelp.R;
import com.example.daniel.homehelp.activity.DashBoardActivity;
import com.example.daniel.homehelp.activity.ReminderActivity;
import com.example.daniel.homehelp.adapter.TabLayoutViewPagerAdapter;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.DialogPlusBuilder;
import com.orhanobut.dialogplus.OnClickListener;
import com.orhanobut.dialogplus.OnItemClickListener;
import com.orhanobut.dialogplus.ViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.daniel.homehelp.R.id.tv_agenda_one;

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
    String reminderBundle;
    Fragment onGoingAgendaFragments = OnGoingAgendaFragment.newInstance();

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
        if (getArguments() != null) {
            reminderBundle = getArguments().getString("REMINDER");
            if (reminderBundle != null) {
                Bundle bundle = new Bundle();
                bundle.putString("REMINDER", reminderBundle);
                onGoingAgendaFragments.setArguments(bundle);
            }
        }
        TabLayoutViewPagerAdapter adapter = new TabLayoutViewPagerAdapter(getFragmentManager());
        adapter.addFragment(onGoingAgendaFragments, "Berlangsung");
        adapter.addFragment(finishAgendaFragment, "Selesai");

        agendaViewPager.setAdapter(adapter);
        agendaViewPager.setCurrentItem(position);
        agendaTabLayout.setupWithViewPager(agendaViewPager);
    }

    private void popupDialogOnTop() {
        DialogPlus dialog = DialogPlus.newDialog(mActivity)
                .setContentHolder(new ViewHolder(R.layout.agenda_top_dialog))
                .setGravity(Gravity.BOTTOM)
                .setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(DialogPlus dialog, View view) {
                        switch(view.getId()) {
                            case R.id.tv_agenda_one:
                                dialog.dismiss();
                                startActivity(new Intent(mActivity, ReminderActivity.class));
                                break;
                            case R.id.tv_agenda_two:
                                dialog.dismiss();
                                break;
                        }
                    }
                })
                .setCancelable(true)
                .create();
        dialog.show();
    }

    @OnClick(R.id.logo_header)
    public void onViewClicked() {
        popupDialogOnTop();
    }
}
