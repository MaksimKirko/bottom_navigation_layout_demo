package com.github.maksimkirko.bottom_navigation_layout_demo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.github.maksimkirko.bottom_navigation_layout_demo.fragment.GalleryScreenFragment;
import com.github.maksimkirko.bottom_navigation_layout_demo.fragment.HomeScreenFragment;
import com.github.maksimkirko.bottom_navigation_layout_demo.fragment.ManageScreenFragment;
import com.github.maksimkirko.bottom_navigation_layout_demo.fragment.SendScreenFragment;
import com.github.maksimkirko.bottom_navigation_layout_demo.fragment.ShareScreenFragment;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarLayout appBarLayout;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private BottomNavigationViewEx bottomNavigationView;
    private Fragment selectedFragment;

    private boolean isAppBarLayoutExpanded = true;
    private boolean isHomeFragment = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initAppBarLayout();
        initToolbar();
        initTabLayout();
        initNavigationDrawer();
        initBottomNavigationView();
    }

    private void initAppBarLayout() {
        appBarLayout = findViewById(R.id.app_bar_main);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (isHomeFragment) {
                    isAppBarLayoutExpanded = verticalOffset == 0;
                }
            }
        });
    }

    private void initToolbar() {
        toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
    }

    private void initTabLayout() {
        tabLayout = findViewById(R.id.tab_layout_main);
    }

    private void initNavigationDrawer() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    private void initBottomNavigationView() {
        bottomNavigationView = findViewById(R.id.bottom_navigation_view_main);
        bottomNavigationView.setTextVisibility(false);
        bottomNavigationView.enableAnimation(false);
        bottomNavigationView.enableShiftingMode(false);
        bottomNavigationView.enableItemShiftingMode(false);

        Menu menu = bottomNavigationView.getMenu();
        selectScreen(menu.getItem(0));

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        selectScreen(item);
                        return false;
                    }
                });

    }

    private void selectScreen(@NonNull MenuItem item) {
        item.setChecked(true);

        switch (item.getItemId()) {
            case R.id.action_home:
                appBarLayout.setExpanded(isAppBarLayoutExpanded, false);
                tabLayout.setVisibility(View.VISIBLE);
                initFragment(new HomeScreenFragment());
                isHomeFragment = true;
                break;
            case R.id.action_gallery:
                showAppBarLayout();
                initFragment(new GalleryScreenFragment());
                break;
            case R.id.action_manage:
                showAppBarLayout();
                initFragment(new ManageScreenFragment());
                break;
            case R.id.action_send:
                showAppBarLayout();
                initFragment(new SendScreenFragment());
                break;
            case R.id.action_share:
                showAppBarLayout();
                initFragment(new ShareScreenFragment());
                break;
        }
    }

    private void showAppBarLayout() {
        tabLayout.setVisibility(View.GONE);
        appBarLayout.setExpanded(true, false);
        isHomeFragment = false;
    }

    private void initFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            if (ft != null) {
                if (selectedFragment != null) {
                    ft.remove(selectedFragment);
                }
                ft.add(R.id.layout_activity_main_fragment_container, fragment);
                ft.commit();
            }
        }
        selectedFragment = fragment;
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {

        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
