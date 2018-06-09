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
import com.example.daniel.homehelp.RecyclerViewOnClick;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Daniel on 5/15/2018.
 */

public class BangunanAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private RecyclerViewOnClick recyclerViewOnClick;
    private boolean isFavorite = false;

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
        @BindView(R.id.ll_item_bangunan)
        LinearLayout llItemBangunan;

        String[] serviceName = {"Atap", "Lantai", "Pintu", "Saluran Air"};

        int[] introBgImageFavorite = {R.drawable.ic_unfavorite, R.drawable.ic_unfavorite,
                R.drawable.ic_unfavorite, R.drawable.ic_unfavorite};
        int[] bgImageService = {R.drawable.ic_bangunan_atap, R.drawable.ic_bangunan_lantai,
                R.drawable.ic_bangunan_pintu, R.drawable.ic_bangunan_saluran_air};

        public BangunanListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setView(final int position) {
            imgFavorite.setBackgroundResource(introBgImageFavorite[position]);
            imgService.setBackgroundResource(bgImageService[position]);
            tvServiceName.setText(serviceName[position]);

            llItemBangunan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    recyclerViewOnClick.itemOnClick(view, position);
                }
            });

            imgFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!isFavorite) {
                        imgFavorite.setImageResource(R.drawable.ic_favorite);
                        isFavorite = true;
                    } else {
                        imgFavorite.setImageResource(R.drawable.ic_unfavorite);
                        isFavorite = false;
                    }
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
