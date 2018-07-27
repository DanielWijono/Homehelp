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

public class FavoriteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    RecyclerViewOnClick recyclerViewOnClick;

    public FavoriteAdapter(Context context, RecyclerViewOnClick recyclerViewOnClick) {
        this.context = context;
        this.recyclerViewOnClick = recyclerViewOnClick;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.item_favorite, null);
        return new FavoriteListViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FavoriteListViewHolder favoriteListViewHolder = (FavoriteListViewHolder) holder;
        favoriteListViewHolder.setView(position);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class FavoriteListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_favorite)
        ImageView imgFavorite;
        @BindView(R.id.img_service)
        ImageView imgService;
        @BindView(R.id.tv_service_name)
        TextView tvServiceName;
        @BindView(R.id.ll_item_bangunan)
        LinearLayout llItemBangunan;

        String[] serviceName = {"Atap", "Lantai", "Pintu", "Saluran Air"};

        int[] introBgImageFavorite = {R.drawable.ic_favorite, R.drawable.ic_favorite,
                R.drawable.ic_favorite, R.drawable.ic_favorite};
        int[] bgImageService = {R.drawable.ic_bangunan_atap, R.drawable.ic_bangunan_lantai,
                R.drawable.ic_bangunan_pintu, R.drawable.ic_bangunan_saluran_air};

        public FavoriteListViewHolder(View itemView) {
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
        }
    }
}
