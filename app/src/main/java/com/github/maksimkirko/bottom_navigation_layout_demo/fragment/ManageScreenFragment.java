package com.github.maksimkirko.bottom_navigation_layout_demo.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.maksimkirko.bottom_navigation_layout_demo.R;

public class ManageScreenFragment extends ScreenFragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_default_screen, container, false);

        initTitleView("Manage");
        return view;
    }
}