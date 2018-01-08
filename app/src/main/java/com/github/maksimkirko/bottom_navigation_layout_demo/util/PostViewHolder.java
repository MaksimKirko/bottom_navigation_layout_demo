package com.github.maksimkirko.bottom_navigation_layout_demo.util;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.github.maksimkirko.bottom_navigation_layout_demo.R;

public class PostViewHolder extends RecyclerView.ViewHolder {

    private TextView textView;

    public PostViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.text_view_view_holder_post);
    }

    public void onBind(@NonNull String text) {
        textView.setText(text);
    }
}
