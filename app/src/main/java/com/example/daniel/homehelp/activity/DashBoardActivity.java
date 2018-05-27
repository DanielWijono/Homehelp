package com.example.daniel.homehelp.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daniel.homehelp.BottomNavigationViewHelper;
import com.example.daniel.homehelp.R;
import com.example.daniel.homehelp.adapter.DrawerLayoutAdapter;
import com.example.daniel.homehelp.fragment.AgendaFragment;
import com.example.daniel.homehelp.fragment.FavoriteFragment;
import com.example.daniel.homehelp.fragment.HomeFragment;
import com.example.daniel.homehelp.fragment.InboxFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DashBoardActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

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
    @BindView(R.id.appbar_layout)
    AppBarLayout appbarLayout;
    @BindView(R.id.frame_layout)
    FrameLayout frameLayout;
    @BindView(R.id.recycler_view_drawer)
    RecyclerView recyclerViewDrawer;
    @BindView(R.id.ll_drawer)
    LinearLayout llDrawer;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    HomeFragment homeFragment;
    AgendaFragment agendaFragment;
    InboxFragment inboxFragment;
    FavoriteFragment favoriteFragment;

    DrawerLayoutAdapter drawerLayoutAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        ButterKnife.bind(this);
        initFragment();
        initDrawerLayout();
        buttonNavigationListener();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initDrawerLayout() {
        llDrawer.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                return true;
            }
        });

        drawerLayoutView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(llDrawer);
            }
        });

        drawerLayoutAdapter = new DrawerLayoutAdapter(this);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewDrawer.setLayoutManager(layoutManager);
        recyclerViewDrawer.setAdapter(drawerLayoutAdapter);
    }

    private void initFragment() {
        homeFragment = new HomeFragment();
        FragmentTransaction fx = getSupportFragmentManager().beginTransaction();
        fx.replace(R.id.frame_layout, homeFragment);
        fx.commit();

        agendaFragment = new AgendaFragment();
        inboxFragment = new InboxFragment();
        favoriteFragment = new FavoriteFragment();
    }

    private void buttonNavigationListener() {
        BottomNavigationViewHelper.disableShiftMode(bottomNavigation);

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        FragmentTransaction fx = getSupportFragmentManager().beginTransaction();
                        fx.replace(R.id.frame_layout, homeFragment);
                        fx.commit();
                        break;
                    case R.id.action_agenda:
                        FragmentTransaction fxAgenda = getSupportFragmentManager().beginTransaction();
                        fxAgenda.replace(R.id.frame_layout, agendaFragment);
                        fxAgenda.commit();
                        break;
                    case R.id.action_inbox:
                        FragmentTransaction fxInbox = getSupportFragmentManager().beginTransaction();
                        fxInbox.replace(R.id.frame_layout, inboxFragment);
                        fxInbox.commit();
                        break;
                    case R.id.action_favorite:
                        FragmentTransaction fxFavorite = getSupportFragmentManager().beginTransaction();
                        fxFavorite.replace(R.id.frame_layout, favoriteFragment);
                        fxFavorite.commit();
                        break;
                }

                return true;
            }
        });
    }

    @OnClick({R.id.btn_bell})
    public void onViewClicked(View view) {
        switch (view.getId()) {
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
