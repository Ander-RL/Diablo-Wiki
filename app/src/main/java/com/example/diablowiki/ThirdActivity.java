package com.example.diablowiki;

import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("");
        toolbar.setSubtitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getIntent();

        // Create an instance of the tab layout from the view.
        TabLayout tabLayout = findViewById(R.id.tab_layout_third);
        // Add the tabs to the layout and a title
        tabLayout.addTab(tabLayout.newTab().setText(R.string.third_tab_title_1));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.third_tab_title_2));
        // Set the tabs to fill the entire layout
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        // Use PagerAdapter to manage page views in fragments.
        // Each page is represented by its own fragment.
        final ViewPager viewPager = findViewById(R.id.pager);
        final PagerAdapterThird adapter = new PagerAdapterThird(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        // Setting a listener for clicks.
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
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
