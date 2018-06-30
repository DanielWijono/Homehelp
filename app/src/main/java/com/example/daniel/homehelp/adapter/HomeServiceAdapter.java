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

        @BindView(R.id.ll_home)
        LinearLayout llHome;
        @BindView(R.id.tv_service_name)
        TextView tvServiceName;
        @BindView(R.id.img_service)
        ImageView imgService;

        String[] introTitle = {"Bangunan", "Kelistrikan", "Hama", "Kebun"};
        String[] introDescription = {"Mencakup atap, lantai, pintu jendela dan saluran air", "Mencakup AC dan instalasi listrik",
                "Untuk perawatan rumah bebas hama"};
        int[] introBgImage = {R.drawable.ic_bangunan, R.drawable.ic_kelistrikan,
                R.drawable.ic_hama, R.drawable.ic_kebun};

        public HomeServiceListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setView(final int position) {
            tvServiceName.setText(introTitle[position]);
            imgService.setImageResource(introBgImage[position]);

            llHome.setOnClickListener(new View.OnClickListener() {
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
        return 4;
    }
}
