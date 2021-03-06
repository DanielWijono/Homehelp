package com.example.daniel.homehelp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.daniel.homehelp.R;
import com.example.daniel.homehelp.RecyclerViewOnClick;
import com.example.daniel.homehelp.RecyclerViewOnClickTipsHome;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Daniel on 5/13/2018.
 */

public class HomeTipsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    RecyclerViewOnClickTipsHome recyclerViewOnClickTipsHome;

    public HomeTipsAdapter(Context context, RecyclerViewOnClickTipsHome recyclerViewOnClickTipsHome) {
        this.context = context;
        this.recyclerViewOnClickTipsHome = recyclerViewOnClickTipsHome;
    }

    public class HomeTipsListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tips_image)
        ImageView tipsImage;
        @BindView(R.id.tips_title)
        TextView tipsTitle;
        @BindView(R.id.tips_desc)
        TextView tipsDesc;
        @BindView(R.id.ll_home_tips)
        LinearLayout llHomeTips;

        String[] introTitle = {"Hama", "Versus"};
        String[] introDescription = {"Bagian Rumah yang\n Rentan Rayap", "Mending Merawat \natau Membeli"};
        int[] introBgImage = {R.drawable.ic_tips_hama, R.drawable.ic_tips_versus};

        public HomeTipsListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setView(final int position) {
            tipsTitle.setText(introTitle[position]);
            tipsDesc.setText(introDescription[position]);
            tipsImage.setBackgroundResource(introBgImage[position]);

            llHomeTips.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    recyclerViewOnClickTipsHome.itemOnClickTipsHome(view, position);
                }
            });
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.item_home_tips, null);
        return new HomeTipsListViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeTipsListViewHolder homeTipsListViewHolder = (HomeTipsListViewHolder) holder;
        homeTipsListViewHolder.setView(position);
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
