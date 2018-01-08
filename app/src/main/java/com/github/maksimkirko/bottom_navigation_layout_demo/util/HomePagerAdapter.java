package com.github.maksimkirko.bottom_navigation_layout_demo.util;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentStatePagerAdapter;

import com.github.maksimkirko.bottom_navigation_layout_demo.fragment.home.FirstTabFragment;
import com.github.maksimkirko.bottom_navigation_layout_demo.fragment.home.SecondTabFragment;
import com.github.maksimkirko.bottom_navigation_layout_demo.fragment.home.TabFragment;
import com.github.maksimkirko.bottom_navigation_layout_demo.fragment.home.ThirdTabFragment;

public class HomePagerAdapter extends FragmentStatePagerAdapter {

    private final static int TABS_COUNT = 3;

    public HomePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        TabFragment tabFragment = null;
        switch (position) {
            case 0:
                tabFragment = new FirstTabFragment();
                break;
            case 1:
                tabFragment = new SecondTabFragment();
                break;
            case 2:
                tabFragment = new ThirdTabFragment();
                break;
        }
        return tabFragment;
    }

    @Override
    public int getCount() {
        return TABS_COUNT;
    }
}