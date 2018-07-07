package com.example.daniel.homehelp.adapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.daniel.homehelp.R;
import com.example.daniel.homehelp.RecyclingPagerAdapter;

import butterknife.ButterKnife;

/**
 * Created by Daniel on 5/5/2018.
 */

public class IntroductionAdapter extends RecyclingPagerAdapter {
    private Context context;
    private AppCompatActivity mActivity;

    public IntroductionAdapter(AppCompatActivity mActivity, Context context) {
        this.context = context;
        this.mActivity = mActivity;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup container) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.content_introduction, null);
        }

        String[] introTitle = {" Selamat Datang\n" + "di Homehelp!"," Kenyamanan Keluarga\n" + "adalah Prioritas",
                " Mempermudah dan Mempercepat","Layanan Terjamin\n" + "untuk Anda"};
        String[] introDescription = {"Pekerja akan membantu\n" +
                "membuat rumah anda nyaman", "Merawat hunian anda sepenuh hati\n" +
                "demi kenyamanan keluarga","Perencanaan perbaikan dapat\n" +
                "dilakukan dimanapun, kapanpun","Bebas rasa khawatir, pekerja\n" +
                "professional dan jaminan pekerjaan"};
        int [] introBgImage = {R.drawable.introduction_one, R.drawable.introduction_two,
                R.drawable.introduction_three, R.drawable.introduction_four};

        LinearLayout parentLinearLayout = ButterKnife.findById(convertView, R.id.parent_linear_layout);
        TextView tvTitle = ButterKnife.findById(convertView, R.id.tv_title);
        TextView tvDescription = ButterKnife.findById(convertView, R.id.tv_description);

        tvTitle.setText(introTitle[position]);
        tvDescription.setText(introDescription[position]);
        parentLinearLayout.setBackgroundResource(introBgImage[position]);

        return convertView;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
