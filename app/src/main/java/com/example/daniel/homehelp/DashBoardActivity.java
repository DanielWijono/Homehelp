package com.example.daniel.homehelp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
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
    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        ButterKnife.bind(this);
        initFragment();

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        FragmentTransaction fx = getSupportFragmentManager().beginTransaction();
                        fx.replace(R.id.frame_layout, homeFragment);
                        fx.addToBackStack(null);
                        fx.commit();
                        break;
                    case R.id.action_agenda:
                        FragmentTransaction fxAgenda = getSupportFragmentManager().beginTransaction();
                        fxAgenda.replace(R.id.frame_layout, agendaFragment);
                        fxAgenda.addToBackStack(null);
                        fxAgenda.commit();
                        break;
                    case R.id.action_inbox:
                        FragmentTransaction fxInbox = getSupportFragmentManager().beginTransaction();
                        fxInbox.replace(R.id.frame_layout, inboxFragment);
                        fxInbox.addToBackStack(null);
                        fxInbox.commit();
                        break;
                    case R.id.action_favorite:
                        FragmentTransaction fxFavorite = getSupportFragmentManager().beginTransaction();
                        fxFavorite.replace(R.id.frame_layout, favoriteFragment);
                        fxFavorite.addToBackStack(null);
                        fxFavorite.commit();
                        break;
                }

                return true;
            }
        });
    }

    private void initFragment() {
        homeFragment = new HomeFragment();
        FragmentTransaction fx = getSupportFragmentManager().beginTransaction();
        fx.replace(R.id.frame_layout, homeFragment);
        fx.addToBackStack(null);
        fx.commit();

        agendaFragment = new AgendaFragment();
        inboxFragment = new InboxFragment();
        favoriteFragment = new FavoriteFragment();
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
