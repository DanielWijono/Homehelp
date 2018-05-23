package com.example.daniel.homehelp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.daniel.homehelp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Daniel on 5/13/2018.
 */

public class HomeTipsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;

    public HomeTipsAdapter(Context context) {
        this.context = context;
    }

    public class HomeTipsListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tips_image)
        ImageView tipsImage;
        @BindView(R.id.tips_title)
        TextView tipsTitle;
        @BindView(R.id.tips_desc)
        TextView tipsDesc;

        String[] introTitle = {"Bangunan", "Kelistrikan", "Hama"};
        String[] introDescription = {"Mencakup atap, lantai, pintu jendela dan saluran air", "Mencakup AC dan instalasi listrik",
                "Untuk perawatan rumah bebas hama"};
        int[] introBgImage = {R.drawable.introduction_one, R.drawable.introduction_two,
                R.drawable.introduction_three, R.drawable.introduction_four};

        public HomeTipsListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setView(int position) {
            tipsTitle.setText(introTitle[position]);
            tipsDesc.setText(introDescription[position]);
            tipsImage.setBackgroundResource(introBgImage[position]);
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
        return 3;
    }
}
