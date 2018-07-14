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

public class NotificationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private RecyclerViewOnClick recyclerViewOnClick;

    public NotificationAdapter(Context context, RecyclerViewOnClick recyclerViewOnClick) {
        this.context = context;
        this.recyclerViewOnClick = recyclerViewOnClick;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.item_notification, null);
        return new NotificationListViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NotificationListViewHolder notificationListViewHolder = (NotificationListViewHolder) holder;
        notificationListViewHolder.setView(position);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class NotificationListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_notification)
        ImageView imgNotification;
        @BindView(R.id.notif_title)
        TextView notifTitle;
        @BindView(R.id.notif_desc)
        TextView notifDesc;
        @BindView(R.id.ll_notif_list)
        LinearLayout llNotifList;
        @BindView(R.id.line_separator_view)
        View lineSeparatorView;

        String[] notificationTitle = {"Hot Day Promo", "Lantai", "Menunggu konfirmasi survey", "Pekerja ditemukan untuk anda"};
        String[] notificationDesc = {"Promo layanan musim hujan", "Silahkan pilih tanggal anda survey", "Silahkan menunggu pekerja anda datang"};

        int[] imageNotification = {R.drawable.ic_notif_not_read, R.drawable.ic_notif_not_read,
                R.drawable.ic_notif_not_read, R.drawable.ic_notif_not_read};

        int[] imageNotificationRead = {R.drawable.ic_notif_read, R.drawable.ic_notif_read,
                R.drawable.ic_notif_read, R.drawable.ic_notif_read};

        public NotificationListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setView(final int position) {
            imgNotification.setImageResource(imageNotification[position]);
            notifTitle.setText(notificationTitle[position]);
            notifDesc.setText(notificationDesc[position]);

            llNotifList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (position == 0) {
                        imgNotification.setImageResource(imageNotificationRead[position]);
                        recyclerViewOnClick.itemOnClick(view, position);
                    }
                }
            });

            if (position == 2) {
                lineSeparatorView.setVisibility(View.GONE);
            } else {
                lineSeparatorView.setVisibility(View.VISIBLE);
            }
        }
    }
}
