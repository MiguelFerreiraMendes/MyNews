package com.miguel.mynews;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.miguel.mynews.Adapter.FragmentAdapter;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        this.configureDrawerLayout();
        this.configureNavigationView();
        this.configureViewPagerandTabs();
    }

    private void configureViewPagerandTabs(){
        // 1 - Get ViewPager from layout
        ViewPager pager = findViewById(R.id.pager);
        // 2 - Set Adapter PageAdapter and glue it together
        pager.setAdapter(new FragmentAdapter(getSupportFragmentManager(), this) {
        });
        mPager = pager;
        // 1 - Get TabLayout from layout
        TabLayout tabs= findViewById(R.id.tab_layout);
        // 2 - Glue TabLayout and ViewPager together
        tabs.setupWithViewPager(pager);
        // 3 - Design purpose. Tabs have the same width
        tabs.setTabMode(TabLayout.MODE_FIXED);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu_main) {
        getMenuInflater().inflate(R.menu.menu_main, menu_main);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.notif_sub) {
            Intent intent = new Intent(MainActivity.this, NotificationActivity.class);
            this.startActivity(intent);
        }

        if (id == R.id.menu_activity_main_search){
            Intent myIntent = new Intent(MainActivity.this, FilterActivity.class);
            this.startActivity(myIntent);
        }
        return super.onOptionsItemSelected(item);
    }

    // Configure NavigationView
    private void configureNavigationView(){
        this.navigationView = findViewById(R.id.activity_main_nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    // Configure Drawer Layout
    private void configureDrawerLayout(){
        this.drawerLayout = findViewById(R.id.activity_main_drawer_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle Navigation Item Click
        int id = item.getItemId();
        switch (id){
            case R.id.activity_main_drawer_search :
                Intent myIntent = new Intent(MainActivity.this, FilterActivity.class);
                this.startActivity(myIntent);
                break;
            case R.id.activity_main_drawer_TopStories:
                mPager.setCurrentItem(0);
                break;
            case R.id.activity_main_drawer_Mostpop:
                mPager.setCurrentItem(1);
                break;
            case R.id.activity_main_drawer_Business:
                mPager.setCurrentItem(2);
                break;
                default:
                break;
        }
        this.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
