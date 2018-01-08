package com.github.maksimkirko.bottom_navigation_layout_demo.fragment.home;

import android.support.v7.widget.LinearLayoutManager;

public class ThirdTabFragment extends TabFragment {

    private static int currentPosition = 0;

    @Override
    public void onResume() {
        super.onResume();
        recyclerView.scrollToPosition(currentPosition);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        currentPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
    }
}
