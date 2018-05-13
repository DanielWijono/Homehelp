package com.example.daniel.homehelp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DashBoardActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    HomeFragment homeFragment;
    AgendaFragment agendaFragment;
    InboxFragment inboxFragment;
    FavoriteFragment favoriteFragment;

    @BindView(R.id.drawer_layout_view)
    ImageView drawerLayoutView;
    @BindView(R.id.logo_header)
    ImageView logoHeader;
    @BindView(R.id.btn_bell)
    ImageView btnBell;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.viewpager)
    ViewPager dashBoardViewPager;
    @BindView(R.id.dashboard_tab_layout)
    TabLayout dashboardTabLayout;

    private int[] tabIcons = {
            R.drawable.baseline_dehaze_black_18dp,
            R.drawable.baseline_dehaze_black_18dp,
            R.drawable.baseline_dehaze_black_18dp,
            R.drawable.baseline_dehaze_black_18dp
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        ButterKnife.bind(this);
        initFragment();
        setupViewPager(0);
        setupTabIcons();
    }

    private void initFragment() {
        homeFragment = new HomeFragment();
        agendaFragment = new AgendaFragment();
        inboxFragment = new InboxFragment();
        favoriteFragment = new FavoriteFragment();
    }

    private void setupTabIcons() {
        dashboardTabLayout.getTabAt(0).setIcon(tabIcons[0]);
        dashboardTabLayout.getTabAt(1).setIcon(tabIcons[1]);
        dashboardTabLayout.getTabAt(2).setIcon(tabIcons[2]);
        dashboardTabLayout.getTabAt(3).setIcon(tabIcons[3]);
    }

    private void setupViewPager(int position) {
        TabLayoutViewPagerAdapter adapter = new TabLayoutViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(homeFragment, "home");
        adapter.addFragment(agendaFragment, "agenda");
        adapter.addFragment(inboxFragment, "inbox");
        adapter.addFragment(favoriteFragment, "favorite");

        dashBoardViewPager.setAdapter(adapter);
        dashBoardViewPager.setCurrentItem(position);
        dashboardTabLayout.setupWithViewPager(dashBoardViewPager);
    }

    @OnClick({R.id.drawer_layout_view, R.id.btn_bell})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.drawer_layout_view:
                Toast.makeText(this, "DRAWER CLICKED", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_bell:
                Toast.makeText(this, "BELL CLICKED", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
