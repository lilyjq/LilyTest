package com.example.lily.lilytest.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ljq
 * on 2018/3/2.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter{
    List<ViewPagerFragment> list=new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    public void adddate(ViewPagerFragment fragment){
        list.add(fragment);
    }




}
