package com.example.daniel.homehelp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.daniel.homehelp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FinishAgendaFragment extends Fragment {

    @BindView(R.id.img_agenda_finish)
    ImageView imgAgendaFinish;
    @BindView(R.id.tv_agenda_finish_desc)
    TextView tvAgendaFinishDesc;
    @BindView(R.id.tv_desc_empty_data)
    TextView tvDescEmptyData;
    private View rootView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.finish_agenda, container, false);
        ButterKnife.bind(this, rootView);

        tvDescEmptyData.setText("Silahkan lakukan pesanan\nterlebih dahulu ya");

        return rootView;
    }
}
