package com.example.daniel.homehelp;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    private int space;

    public SpaceItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);

        outRect.left = space;
        outRect.right = space;
        outRect.bottom = space;
        outRect.top = space;

        if(position%2==0){
            outRect.left = 0;
        }
    }
}
