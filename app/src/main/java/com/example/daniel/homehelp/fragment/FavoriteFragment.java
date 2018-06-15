package com.example.daniel.homehelp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.daniel.homehelp.R;
import com.example.daniel.homehelp.activity.DashBoardActivity;
import com.example.daniel.homehelp.adapter.FavoriteAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Daniel on 5/13/2018.
 */

public class FavoriteFragment extends Fragment {

    @BindView(R.id.favorite_recycler_view)
    RecyclerView favoriteRecyclerView;
    private View rootView;
    private DashBoardActivity mActivity;
    private FavoriteAdapter favoriteAdapter;

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

    public static FavoriteFragment newInstance() {
        Bundle args = new Bundle();

        FavoriteFragment fragment = new FavoriteFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.favorite_fragment, container, false);
        ButterKnife.bind(this, rootView);
        initRecyclerView();

        return rootView;
    }

    private void initRecyclerView() {
        favoriteRecyclerView.setLayoutManager(new GridLayoutManager(mActivity, 2));
        favoriteAdapter = new FavoriteAdapter(mActivity);
        favoriteRecyclerView.setAdapter(favoriteAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
