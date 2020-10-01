package com.example.diablowiki;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
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

    public void scrollTo(View view) {
        String tag = view.getTag().toString();
        final NestedScrollView scrollview;

        if(tag.equals("tab1")) {scrollview =  findViewById(R.id.scrollviewThirdTab1);}
        else {scrollview =  findViewById(R.id.scrollviewThirdTab2);}

        TextView textView = getID(view);
        scrollview.scrollTo((int)textView.getX(),(int)textView.getY());
    }

    public TextView getID(View view){
        TextView textView = null;
        switch(view.getId()){
            case R.id.button_warrior:
                textView = findViewById(R.id.header_warrior_tab1);
                break;
            case R.id.button_rogue:
                textView = findViewById(R.id.header_rogue_tab1);
                break;
            case R.id.button_sorcerer:
                textView = findViewById(R.id.header_sorcerer_tab1);
                break;
            case R.id.button_monk:
                textView = findViewById(R.id.header_monk_tab1);
                break;
            case R.id.button_barbarian:
                textView = findViewById(R.id.header_barbarian_tab1);
                break;
            case R.id.button_bard:
                textView = findViewById(R.id.header_bard_tab1);
                break;
            case R.id.button_amazon_tab2:
                textView = findViewById(R.id.header_amazon_tab2);
                break;
            case R.id.button_barbarian_tab2:
                textView = findViewById(R.id.header_barbarian_tab2);
                break;
            case R.id.button_necromancer_tab2:
                textView = findViewById(R.id.header_necromancer_tab2);
                break;
            case R.id.button_paladin_tab2:
                textView = findViewById(R.id.header_paladin_tab2);
                break;
            case R.id.button_sorceress_tab2:
                textView = findViewById(R.id.header_sorceress_tab2);
                break;
            case R.id.button_assassin_tab2:
                textView = findViewById(R.id.header_assassin_tab2);
                break;
            case R.id.button_druid_tab2:
                textView = findViewById(R.id.druid_tab2);
                break;
        }
        return textView;
    }
}
