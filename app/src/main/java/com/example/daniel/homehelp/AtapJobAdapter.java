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
 * Created by Daniel on 5/18/2018.
 */

public class AtapJobAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;

    public AtapJobAdapter(Context context) {
        this.context = context;
    }

    public class AtapJobListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_roof_job)
        ImageView imgRoofJob;
        @BindView(R.id.tv_roof_job)
        TextView tvRoofJob;
        @BindView(R.id.ll_item_roof)
        LinearLayout llItemRoof;

        String[] serviceName = {"Atap\nBocor", "Perbaikan\nGenteng", "Pintu\nJendela", "Saluran\nAir", "Atap\nBocor", "Perbaikan\nGenteng", "Pintu\nJendela", "Saluran\nAir"};

        int[] serviceImage = {R.drawable.bottom_navigation_home, R.drawable.bottom_navigation_home,
                R.drawable.bottom_navigation_home, R.drawable.bottom_navigation_home,
                R.drawable.bottom_navigation_home, R.drawable.bottom_navigation_home,
                R.drawable.bottom_navigation_home, R.drawable.bottom_navigation_home};

        public AtapJobListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setView(int position) {
            imgRoofJob.setBackgroundResource(serviceImage[position]);
            tvRoofJob.setText(serviceName[position]);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.item_roof_job, null);
        return new AtapJobListViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        AtapJobListViewHolder atapJobListViewHolder = (AtapJobListViewHolder) holder;
        atapJobListViewHolder.setView(position);
    }

    @Override
    public int getItemCount() {
        return 8;
    }
}
