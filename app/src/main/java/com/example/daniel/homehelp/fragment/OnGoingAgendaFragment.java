package com.example.daniel.homehelp.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.daniel.homehelp.R;
import com.example.daniel.homehelp.activity.DashBoardActivity;
import com.example.daniel.homehelp.activity.StatusOrderAgendaActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OnGoingAgendaFragment extends Fragment {

    @BindView(R.id.img_three_dots_item)
    ImageView imgThreeDotsItem;
    @BindView(R.id.ll_status_item)
    LinearLayout llStatusItem;
    @BindView(R.id.tv_reminder)
    TextView tvReminder;
    @BindView(R.id.ll_on_going_reminder)
    LinearLayout llOnGoingReminder;
    @BindView(R.id.ll_pesanan)
    LinearLayout llPesanan;

    private View rootView;
    private DashBoardActivity mActivity;
    String reminderBundle;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof DashBoardActivity) {
            mActivity = (DashBoardActivity) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mActivity = null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static OnGoingAgendaFragment newInstance() {
        Bundle args = new Bundle();

        OnGoingAgendaFragment fragment = new OnGoingAgendaFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.on_going_agenda, container, false);
        ButterKnife.bind(this, rootView);

        if (getArguments() != null) {
            reminderBundle = getArguments().getString("REMINDER");
            if (reminderBundle != null) {
                llOnGoingReminder.setVisibility(View.VISIBLE);
            }
        }

        return rootView;
    }

    private void popupDialogCancelOrder() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
        builder.setCancelable(true);
        View dialoglayout = getLayoutInflater().inflate(R.layout.cancel_order_dialog, null, false);
        builder.setView(dialoglayout);
        final AlertDialog ad = builder.show();

        TextView tvCancel = dialoglayout.findViewById(R.id.tv_cancel_order);
        TextView tvCancelDesc = dialoglayout.findViewById(R.id.tv_cancel_desc);
        ImageView imageView = dialoglayout.findViewById(R.id.img_agenda_dialog);

        tvCancelDesc.setText("Anda yakin untuk \nmembatalkan pesanan ?");
        imageView.setImageResource(R.drawable.ic_bangunan);

        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad.dismiss();
                popupDialogCancelSuccessDialog();
                llPesanan.setVisibility(View.GONE);
            }
        });
    }

    private void popupDialogCancelSuccessDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
        builder.setCancelable(true);
        View dialoglayout = getLayoutInflater().inflate(R.layout.cancel_order_dialog, null, false);
        builder.setView(dialoglayout);
        final AlertDialog ad = builder.show();

        TextView tvCancel = dialoglayout.findViewById(R.id.tv_cancel_order);
        TextView tvCancelTitle = dialoglayout.findViewById(R.id.tv_title_agenda_dialog);
        TextView tvCancelDesc = dialoglayout.findViewById(R.id.tv_cancel_desc);
        ImageView imageView = dialoglayout.findViewById(R.id.img_agenda_dialog);

        tvCancelTitle.setText("Berhasil dibatalkan");
        tvCancel.setText("Ok");
        tvCancelDesc.setVisibility(View.GONE);
        imageView.setImageResource(R.drawable.ic_bangunan);

        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad.dismiss();
            }
        });
    }

    private void popupMenuDialog() {
        PopupMenu popupMenu = new PopupMenu(mActivity, imgThreeDotsItem);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu_cancel_order, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.getTitle().toString().equalsIgnoreCase("batalkan pesanan")) {
                    popupDialogCancelOrder();
                } else {
                    //do nothing
                }
                return true;
            }
        });

        popupMenu.show();
    }

    @OnClick({R.id.img_three_dots_item, R.id.ll_status_item})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_three_dots_item:
                popupMenuDialog();
                break;
            case R.id.ll_status_item:
                Intent intent = new Intent(mActivity, StatusOrderAgendaActivity.class);
                startActivity(intent);
                break;
        }
    }
}
