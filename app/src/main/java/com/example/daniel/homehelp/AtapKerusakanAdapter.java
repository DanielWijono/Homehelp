package com.example.daniel.homehelp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Daniel on 5/19/2018.
 */

public class AtapKerusakanAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;

    public AtapKerusakanAdapter(Context context) {
        this.context = context;
    }

    public class AtapKerusakanListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_checkbox)
        ImageView imgCheckbox;
        @BindView(R.id.tv_title_kerusakan)
        TextView tvTitleKerusakan;
        @BindView(R.id.img_drop_down_up)
        ImageView imgDropDownUp;
        @BindView(R.id.rl_title)
        RelativeLayout rlTitle;
        @BindView(R.id.tv_desc_kerusakan)
        TextView tvDescKerusakan;

        String[] kerusakanTitle = {"Rangka Atap", "Kuda-kuda", "Struktur baja konvensional"};
        String[] kerusakanDescription = {"Mencakup atap, lantai, pintu jendela dan saluran air", "Mencakup AC dan instalasi listrik",
                "Untuk perawatan rumah bebas hama"};

        public AtapKerusakanListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setView(int position) {
            tvTitleKerusakan.setText(kerusakanTitle[position]);
            tvDescKerusakan.setText(kerusakanDescription[position]);

            imgDropDownUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (tvDescKerusakan.getVisibility() == View.GONE) {
                        tvDescKerusakan.setVisibility(View.VISIBLE);
                    } else {
                        tvDescKerusakan.setVisibility(View.GONE);
                    }
                }
            });
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.item_kerusakan_atap, null);
        return new AtapKerusakanListViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        AtapKerusakanListViewHolder atapKerusakanListViewHolder = (AtapKerusakanListViewHolder) holder;
        atapKerusakanListViewHolder.setView(position);
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
