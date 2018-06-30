package com.example.daniel.homehelp.adapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.daniel.homehelp.R;
import com.example.daniel.homehelp.RecyclingPagerAdapter;

import butterknife.ButterKnife;

/**
 * Created by Daniel on 5/13/2018.
 */

public class HomeAdapter extends RecyclingPagerAdapter {

    private Context context;
    private AppCompatActivity mActivity;

    public HomeAdapter (AppCompatActivity mActivity, Context context) {
        this.context = context;
        this.mActivity = mActivity;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup container) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.content_home, null);
        }

        int [] introBgImage = {R.drawable.ic_carousel_home_one, R.drawable.introduction_two};

        ImageView homeImageView = ButterKnife.findById(convertView, R.id.image_view);
        homeImageView.setBackgroundResource(introBgImage[position]);

        return convertView;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
