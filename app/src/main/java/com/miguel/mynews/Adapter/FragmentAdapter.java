package com.miguel.mynews.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.miguel.mynews.Businessfragment;
import com.miguel.mynews.MostPopularfragment;
import com.miguel.mynews.TopStoriesfragment;

public class FragmentAdapter extends FragmentPagerAdapter {



    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return(3); // 3 - Number of page to show
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: //Page number 1
                return TopStoriesfragment.newInstance();
            case 1: //Page number 2
                return MostPopularfragment.newInstance();
            case 2: //Page number 3
                return Businessfragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: //Page number 1
                return "TopStories";
            case 1: //Page number 2
                return "Most Popular";
            case 2: //Page number 3
                return "Business";
            default:
                return null;
        }
    }
}
