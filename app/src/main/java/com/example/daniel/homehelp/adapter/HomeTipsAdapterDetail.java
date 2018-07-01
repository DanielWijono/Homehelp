package com.example.daniel.homehelp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.daniel.homehelp.R;
import com.example.daniel.homehelp.RecyclerViewOnClickTipsHome;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeTipsAdapterDetail extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;

    public HomeTipsAdapterDetail(Context context) {
        this.context = context;
    }

    public class HomeTipsListDetailViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tips_image)
        ImageView tipsImage;
        @BindView(R.id.tips_title)
        TextView tipsTitle;
        @BindView(R.id.tips_desc)
        TextView tipsDesc;
        @BindView(R.id.ll_home_tips)
        LinearLayout llHomeTips;

        String[] introTitle = {"Inspirasi", "Versus"};
        String[] introDescription = {"Dekorasi Nyaman \n Ruang Keluarga", "Mending Merawat \natau Membeli"};
        int[] introBgImage = {R.drawable.ic_tips_detail_article_one, R.drawable.ic_tips_detail_article_two};

        public HomeTipsListDetailViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setView(final int position) {
            tipsTitle.setText(introTitle[position]);
            tipsDesc.setText(introDescription[position]);
            tipsImage.setBackgroundResource(introBgImage[position]);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.item_home_tips_detail, null);
        return new HomeTipsAdapterDetail.HomeTipsListDetailViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeTipsAdapterDetail.HomeTipsListDetailViewHolder homeTipsListDetailViewHolder = (HomeTipsListDetailViewHolder) holder;
        homeTipsListDetailViewHolder.setView(position);
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
