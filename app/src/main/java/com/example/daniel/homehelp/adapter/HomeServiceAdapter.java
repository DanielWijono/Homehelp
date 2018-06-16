package com.example.daniel.homehelp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.daniel.homehelp.R;
import com.example.daniel.homehelp.RecyclerViewOnClick;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Daniel on 5/13/2018.
 */

public class HomeServiceAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;

    private RecyclerViewOnClick mRecyclerViewOnClick;

    public HomeServiceAdapter(Context context, RecyclerViewOnClick mRecyclerViewOnClick) {
        this.context = context;
        this.mRecyclerViewOnClick = mRecyclerViewOnClick;
    }

    public class HomeServiceListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.service_title)
        TextView serviceTitle;
        @BindView(R.id.service_description)
        TextView serviceDescription;
        @BindView(R.id.ll_home_title_desc_service)
        LinearLayout llHomeTitleDescService;
        @BindView(R.id.image_service)
        ImageView imageService;
        @BindView(R.id.img_parent_right_top)
        ImageView imgParentRightTop;
        @BindView(R.id.img_parent_right_bottom)
        ImageView imgParentRightBottom;
        @BindView(R.id.img_parent_left_bottom)
        ImageView imgParentLeftBottom;
        @BindView(R.id.img_parent_left_top)
        ImageView imgParentLeftTop;
        @BindView(R.id.ll_home_service)
        RelativeLayout llHomeService;
        @BindView(R.id.cardview_home_service)
        CardView cardviewHomeService;

        String[] introTitle = {"Bangunan", "Kelistrikan", "Hama"};
        String[] introDescription = {"Mencakup atap, lantai, pintu jendela dan saluran air", "Mencakup AC dan instalasi listrik",
                "Untuk perawatan rumah bebas hama"};
        int[] introBgImage = {R.drawable.baseline_dehaze_black_18dp, R.drawable.baseline_dehaze_black_18dp,
                R.drawable.baseline_dehaze_black_18dp, R.drawable.baseline_dehaze_black_18dp};

        public HomeServiceListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setView(final int position) {
            serviceTitle.setText(introTitle[position]);
            serviceDescription.setText(introDescription[position]);
            imageService.setBackgroundResource(introBgImage[position]);

            llHomeService.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mRecyclerViewOnClick.itemOnClick(view, position);
                }
            });

            cardviewHomeService.setCardBackgroundColor(Color.TRANSPARENT);

            if (position == 0) {
                imgParentLeftBottom.setVisibility(View.VISIBLE);
                imgParentRightBottom.setVisibility(View.VISIBLE);
                imgParentLeftTop.setVisibility(View.GONE);
                imgParentRightTop.setVisibility(View.GONE);

                imgParentLeftBottom.setBackgroundResource(R.drawable.ic_rope_bottom);
                imgParentRightBottom.setBackgroundResource(R.drawable.ic_rope_bottom);
                imageService.setBackgroundResource(R.drawable.ic_bangunan);
            }
            if (position == 1) {
                imgParentLeftBottom.setVisibility(View.VISIBLE);
                imgParentRightBottom.setVisibility(View.VISIBLE);
                imgParentLeftTop.setVisibility(View.VISIBLE);
                imgParentRightTop.setVisibility(View.VISIBLE);

                imgParentLeftBottom.setBackgroundResource(R.drawable.ic_rope_bottom);
                imgParentRightBottom.setBackgroundResource(R.drawable.ic_rope_bottom);
                imgParentLeftTop.setBackgroundResource(R.drawable.ic_rope_top);
                imgParentRightTop.setBackgroundResource(R.drawable.ic_rope_top);
                imageService.setBackgroundResource(R.drawable.ic_kelistrikan);
            }
            if (position == 2) {
                imgParentLeftBottom.setVisibility(View.GONE);
                imgParentRightBottom.setVisibility(View.GONE);
                imgParentLeftTop.setVisibility(View.VISIBLE);
                imgParentRightTop.setVisibility(View.VISIBLE);

                imgParentLeftTop.setBackgroundResource(R.drawable.ic_rope_top);
                imgParentRightTop.setBackgroundResource(R.drawable.ic_rope_top);
                imageService.setBackgroundResource(R.drawable.ic_hama);
            }
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.item_home_service, null);
        return new HomeServiceListViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeServiceListViewHolder homeServiceListViewHolder = (HomeServiceListViewHolder) holder;
        homeServiceListViewHolder.setView(position);
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
