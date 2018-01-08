package com.github.maksimkirko.bottom_navigation_layout_demo.util;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.maksimkirko.bottom_navigation_layout_demo.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<PostViewHolder> {

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_holder_post, parent, false);
        return new PostViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        holder.onBind("Item " + position);
    }

    @Override
    public int getItemCount() {
        return 50;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


}
