package com.example.daniel.homehelp.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daniel.homehelp.activity.DashBoardActivity;
import com.example.daniel.homehelp.adapter.HomeAdapter;
import com.example.daniel.homehelp.adapter.HomeServiceAdapter;
import com.example.daniel.homehelp.adapter.HomeTipsAdapter;
import com.example.daniel.homehelp.R;
import com.example.daniel.homehelp.RecyclerViewOnClick;
import com.example.daniel.homehelp.activity.BangunanActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;

/**
 * Created by Daniel on 5/13/2018.
 */

public class HomeFragment extends Fragment implements RecyclerViewOnClick {

//    @BindView(R.id.search_view)
//    SearchView searchView;
    @BindView(R.id.home_view_pager)
    ViewPager homeViewPager;
    @BindView(R.id.home_indicator)
    CircleIndicator homeIndicator;
    @BindView(R.id.service_home_recycler_view)
    RecyclerView serviceHomeRecyclerView;
    @BindView(R.id.scrollView)
    ScrollView scrollView;
    @BindView(R.id.tips_home_recycler_view)
    RecyclerView tipsHomeRecyclerView;
    @BindView(R.id.tv_first_title)
    TextView tvFirstTitle;

    private View rootView;
    private DashBoardActivity mActivity;
    private RecyclerViewOnClick recyclerViewOnClick = this;
    HomeServiceAdapter homeServiceAdapter;
    HomeTipsAdapter homeTipsAdapter;

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

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.home_fragment, container, false);
        ButterKnife.bind(this, rootView);

        setupViewPager();
        initServiceRecyclerView();
        initTipsRecyclerView();

        scrollView.setFocusableInTouchMode(true);
        scrollView.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
        serviceHomeRecyclerView.setNestedScrollingEnabled(false);
        tipsHomeRecyclerView.setNestedScrollingEnabled(false);
        tvFirstTitle.setText("Menu Layanan");

        return rootView;
    }

    private void setupViewPager() {
        homeViewPager.setAdapter(new HomeAdapter(mActivity, mActivity));
        homeIndicator.setViewPager(homeViewPager);
        homeViewPager.addOnPageChangeListener(mActivity);
    }

    private void initServiceRecyclerView() {
        //LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity);
        serviceHomeRecyclerView.setLayoutManager(new GridLayoutManager(mActivity,2));

        homeServiceAdapter = new HomeServiceAdapter(mActivity, recyclerViewOnClick);
        serviceHomeRecyclerView.setAdapter(homeServiceAdapter);
    }

    private void initTipsRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity, LinearLayoutManager.HORIZONTAL, false);
        tipsHomeRecyclerView.setLayoutManager(layoutManager);

        homeTipsAdapter = new HomeTipsAdapter(mActivity);
        tipsHomeRecyclerView.setAdapter(homeTipsAdapter);
    }

    @Override
    public void itemOnClick(View view, int position) {
        if (position == 0) {
            startActivity(new Intent(mActivity, BangunanActivity.class));
        } else if (position == 1) {
            Toast.makeText(mActivity, "position 1", Toast.LENGTH_SHORT).show();
        } else if (position == 2) {
            Toast.makeText(mActivity, "position 2", Toast.LENGTH_SHORT).show();
        }
    }
}
