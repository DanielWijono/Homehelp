package com.example.daniel.homehelp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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
        @BindView(R.id.image_service)
        ImageView imageService;
        @BindView(R.id.ll_home_service)
        LinearLayout llHomeService;

        String[] introTitle = {"Bangunan", "Kelistrikan", "Hama"};
        String[] introDescription = {"Mencakup atap, lantai, pintu jendela dan saluran air", "Mencakup AC dan instalasi listrik",
                "Untuk perawatan rumah bebas hama"};
        int[] introBgImage = {R.drawable.baseline_dehaze_black_18dp, R.drawable.introduction_one,
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
