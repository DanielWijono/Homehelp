package com.example.daniel.homehelp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daniel.homehelp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class DrawerLayoutAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    private String[] drawerArray;
    private static final int TYPE_ITEM = 0;
    private static final int TYPE_HEADER = 1;

    private int[] drawerImageArray = {R.drawable.ic_account, R.drawable.ic_rewards, R.drawable.ic_settings
    ,R.drawable.ic_become_worker, R.drawable.ic_sign_out};

    public DrawerLayoutAdapter(Context context) {
        this.context = context;
        drawerArray = context.getResources().getStringArray(R.array.drawer_menu);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.nav_header_main_name, parent, false);
            return new ViewHolderHeader(v);
        } else if (viewType == TYPE_ITEM) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_view_drawer_layout, parent, false);
            return new ViewHolderItems(v);
        } else {
            throw new RuntimeException("there is no type that matches the type " + viewType + " + make sure your using types correctly");
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        switch(holder.getItemViewType()) {
            case TYPE_ITEM:
                ViewHolderItems viewHolderItems = (ViewHolderItems) holder;

                viewHolderItems.tvTitle.setText(drawerArray[position - 1]);
                viewHolderItems.imgDrawer.setBackgroundResource(drawerImageArray[position - 1]);
                break;
            case TYPE_HEADER:
                ViewHolderHeader viewHolderHeader = (ViewHolderHeader) holder;

                break;
        }
    }

    @Override
    public int getItemCount() {
        return drawerArray.length + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position)) {
            return TYPE_HEADER;
        } else if (position != 0) {
            return TYPE_ITEM;
        } else {
            return position;
        }
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

    class ViewHolderItems extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_drawer_layout)
        TextView tvTitle;
        @BindView(R.id.img_drawer_layout)
        ImageView imgDrawer;

        public ViewHolderItems(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class ViewHolderHeader extends RecyclerView.ViewHolder {
        @BindView(R.id.circle_image_view)
        CircleImageView cvProfileImg;
        @BindView(R.id.profile_name)
        TextView profileName;
        @BindView(R.id.profile_point)
        TextView profilePoint;
        @BindView(R.id.profile_member)
        TextView profileMember;

        public ViewHolderHeader(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
