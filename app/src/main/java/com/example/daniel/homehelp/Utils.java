package com.example.daniel.homehelp;

import android.content.Intent;
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

    public static void intentWithClearTask(AppCompatActivity mActivity, Class<?> classDestination){
        Intent intent = new Intent(mActivity, classDestination);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        overridePendingTransition(mActivity);
        mActivity.startActivity(intent);
    }

    private static void overridePendingTransition(AppCompatActivity mActivity) {
        mActivity.overridePendingTransition(0,0);
    }
}
