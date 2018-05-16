package com.example.daniel.homehelp;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Daniel on 5/15/2018.
 */

public class Utils {

    public static void setupAppToolbarForActivity(final AppCompatActivity mActivity, Toolbar toolbar, String title) {
        TextView tvTitle = mActivity.findViewById(R.id.tv_title_toolbar);
        tvTitle.setText(title);
        mActivity.setSupportActionBar(toolbar);
        mActivity.getSupportActionBar().setTitle("");
        mActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mActivity.onBackPressed();
            }
        });
    }
}
