package com.example.daniel.homehelp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;

/**
 * Created by Daniel on 5/13/2018.
 */

public class HomeFragment extends Fragment {

    @BindView(R.id.search_view)
    SearchView searchView;
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

    private View rootView;
    private DashBoardActivity mActivity;
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

        return rootView;
    }

    private void setupViewPager() {
        homeViewPager.setAdapter(new HomeAdapter(mActivity, mActivity));
        homeIndicator.setViewPager(homeViewPager);
        homeViewPager.addOnPageChangeListener(mActivity);
    }

    private void initServiceRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity);
        serviceHomeRecyclerView.setLayoutManager(layoutManager);

        homeServiceAdapter = new HomeServiceAdapter(mActivity);
        serviceHomeRecyclerView.setAdapter(homeServiceAdapter);
    }

    private void initTipsRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity, LinearLayoutManager.HORIZONTAL, false);
        tipsHomeRecyclerView.setLayoutManager(layoutManager);

        homeTipsAdapter = new HomeTipsAdapter(mActivity);
        tipsHomeRecyclerView.setAdapter(homeTipsAdapter);
    }

}
