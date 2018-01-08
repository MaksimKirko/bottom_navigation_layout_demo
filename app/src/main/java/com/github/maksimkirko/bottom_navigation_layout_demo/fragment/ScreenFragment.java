package com.github.maksimkirko.bottom_navigation_layout_demo.fragment;

import android.app.Fragment;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.github.maksimkirko.bottom_navigation_layout_demo.R;

public abstract class ScreenFragment extends Fragment {

    protected View view;
    protected TextView titleTextView;

    protected void initTitleView(@NonNull String text) {
        titleTextView = view.findViewById(R.id.text_view_fragment_bottom_tab_title);
        titleTextView.setText(text);

        getActivity().setTitle(text);
    }
}
