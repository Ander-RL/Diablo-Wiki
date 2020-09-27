package com.example.diablowiki;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapterThird extends FragmentStatePagerAdapter {

    private int mNumOfTabs;

    public PagerAdapterThird(@NonNull FragmentManager fm, int NumOfTabs) { //mNumOfTabs = behavior
        super(fm, NumOfTabs);
        this.mNumOfTabs = NumOfTabs;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new ThirdTabFragment1();
            case 1: return new ThirdTabFragment2();
        }
        return null;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
