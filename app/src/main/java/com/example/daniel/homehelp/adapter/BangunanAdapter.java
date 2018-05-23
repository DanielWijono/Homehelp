package com.example.daniel.homehelp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.daniel.homehelp.R;
import com.example.daniel.homehelp.RecyclerViewOnClick;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Daniel on 5/15/2018.
 */

public class BangunanAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    RecyclerViewOnClick recyclerViewOnClick;

    public BangunanAdapter(Context context, RecyclerViewOnClick recyclerViewOnClick) {
        this.context = context;
        this.recyclerViewOnClick = recyclerViewOnClick;
    }

    public class BangunanListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_favorite)
        ImageView imgFavorite;
        @BindView(R.id.img_service)
        ImageView imgService;
        @BindView(R.id.tv_service_name)
        TextView tvServiceName;
        @BindView(R.id.rl_item_bangunan)
        RelativeLayout rlItemBangunan;

        String[] serviceName = {"Atap", "Lantai", "Pintu & Jendela", "Saluran Air"};

        int[] introBgImageFavorite = {R.drawable.bottom_navigation_home, R.drawable.bottom_navigation_home,
                R.drawable.bottom_navigation_home, R.drawable.bottom_navigation_home};
        int[] bgImageService = {R.drawable.bottom_navigation_home, R.drawable.bottom_navigation_home,
                R.drawable.bottom_navigation_home, R.drawable.bottom_navigation_home};

        public BangunanListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setView(final int position) {
            imgFavorite.setBackgroundResource(introBgImageFavorite[position]);
            imgService.setBackgroundResource(bgImageService[position]);
            tvServiceName.setText(serviceName[position]);

            rlItemBangunan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    recyclerViewOnClick.itemOnClick(view, position);
                }
            });
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.item_bangunan_service, null);
        return new BangunanListViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        BangunanListViewHolder bangunanListViewHolder = (BangunanListViewHolder) holder;
        bangunanListViewHolder.setView(position);
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
