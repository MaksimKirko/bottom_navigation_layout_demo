package com.github.maksimkirko.bottom_navigation_layout_demo.fragment.home;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.maksimkirko.bottom_navigation_layout_demo.R;
import com.github.maksimkirko.bottom_navigation_layout_demo.util.RecyclerViewAdapter;

public abstract class TabFragment extends Fragment {

    protected View view;
    protected RecyclerView recyclerView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tab, container, false);

        initRecyclerView();
        return view;
    }

    protected void initRecyclerView() {
        recyclerView = view.findViewById(R.id.recycler_view_fragment_tab);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new RecyclerViewAdapter());
    }
}
