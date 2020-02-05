package com.miguel.mynews.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.miguel.mynews.Businessfragment;
import com.miguel.mynews.MostPopularfragment;
import com.miguel.mynews.R;
import com.miguel.mynews.TopStoriesfragment;

public class FragmentAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public FragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
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
                return mContext.getResources().getString(R.string.tab_label1);
            case 1: //Page number 2
                return mContext.getResources().getString(R.string.tab_label2);
            case 2: //Page number 3
                return mContext.getResources().getString(R.string.tab_label3);
            default:
                return null;
        }
    }
}
