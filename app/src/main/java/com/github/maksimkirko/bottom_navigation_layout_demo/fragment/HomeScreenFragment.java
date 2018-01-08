package com.github.maksimkirko.bottom_navigation_layout_demo.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.maksimkirko.bottom_navigation_layout_demo.R;
import com.github.maksimkirko.bottom_navigation_layout_demo.util.HomePagerAdapter;

public class HomeScreenFragment extends ScreenFragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    private static int currentTab = 0;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        initTabLayout();
        initViewPager();

        getActivity().setTitle("Home");

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        viewPager.setCurrentItem(currentTab);
    }

    private void initTabLayout() {
        tabLayout = getActivity().findViewById(R.id.tab_layout_main);
    }

    private void initViewPager() {
        viewPager = view.findViewById(R.id.view_pager_fragment_home);
        pagerAdapter = new HomePagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                currentTab = tab.getPosition();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
