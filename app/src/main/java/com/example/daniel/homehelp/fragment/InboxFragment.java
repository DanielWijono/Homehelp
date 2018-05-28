package com.example.daniel.homehelp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.daniel.homehelp.activity.DashBoardActivity;
import com.example.daniel.homehelp.R;

import butterknife.ButterKnife;

/**
 * Created by Daniel on 5/13/2018.
 */

public class InboxFragment extends Fragment {

    private View rootView;
    private DashBoardActivity mActivity;

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

    public static InboxFragment newInstance() {
        Bundle args = new Bundle();

        InboxFragment fragment = new InboxFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.inbox_fragment, container, false);
        ButterKnife.bind(this, rootView);

        return rootView;
    }
}
