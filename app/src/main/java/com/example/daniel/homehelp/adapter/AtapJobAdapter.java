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

import com.example.daniel.homehelp.MyApplication;
import com.example.daniel.homehelp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Daniel on 5/18/2018.
 */

public class AtapJobAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;

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

        String[] serviceName = {"ATAP\nBOCOR", "PERBAIKAN\nGENTENG", "PERBAIKAN\nRANGKA", "PERBAIKAN\nTALANG"
                , "WATER\nPROOFING", "BONGKAR\nATAP", "PASANG\nATAP", "PEMBUATAN\nPENUTUP"};

        int[] serviceImage = {R.drawable.ic_pekerjaan_one, R.drawable.ic_pekerjaan_two,
                R.drawable.ic_pekerjaan_tiga, R.drawable.ic_pekerjaan_empat,
                R.drawable.ic_pekerjaan_lima, R.drawable.ic_pekerjaan_enam,
                R.drawable.ic_pekerjaan_tujuh, R.drawable.ic_pekerja_delapan};

        public AtapJobListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void isHarianTrue() {
            if (MyApplication.getInstance().isHarian()) {
                llItemRoof.setAlpha(1);
            } else {
                llItemRoof.setAlpha(0.1f);
            }
        }

        private void isBoronganTrue() {
            if (MyApplication.getInstance().isBorongan()) {
                llItemRoof.setAlpha(1);
            } else {
                llItemRoof.setAlpha(0.1f);
            }
        }

        public void setView(int position) {
            imgRoofJob.setBackgroundResource(serviceImage[position]);
            tvRoofJob.setText(serviceName[position]);

            switch (position) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    isHarianTrue();
                    break;
                case 3:
                    isHarianTrue();
                    break;
                case 4:
                    isHarianTrue();
                    break;
                case 5:
                    isBoronganTrue();
                    break;
                case 6:
                    isBoronganTrue();
                    break;
                case 7:
                    isBoronganTrue();
                    break;
            }
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
