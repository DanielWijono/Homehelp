package com.example.daniel.homehelp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel on 5/13/2018.
 */

public class TabLayoutViewPagerAdapter extends FragmentStatePagerAdapter {
    private List<String> tabTitle = new ArrayList<>();
    private List<Fragment> tabFragment = new ArrayList<>();

    public TabLayoutViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        return tabFragment.get(position);
    }

    @Override
    public int getCount() {
        return tabFragment.size();
    }

    public void addFragment(Fragment fragment,String title){
        tabFragment.add(fragment);
        tabTitle.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitle.get(position);
    }
}
