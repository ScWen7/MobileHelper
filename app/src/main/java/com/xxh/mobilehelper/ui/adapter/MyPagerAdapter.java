package com.xxh.mobilehelper.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by 解晓辉  on 2017/5/20 12:00 *
 * QQ  ：811733738
 * 作用:
 */

public class MyPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Fragment> fragments;
    private String [] titles;
    private ArrayList<String > titleList;

    public MyPagerAdapter(FragmentManager fm , ArrayList<Fragment> fragments, String [] titles) {
        super(fm);
        this.fragments = fragments;
        this.titles = titles;
    }
    public MyPagerAdapter(FragmentManager fm ,ArrayList<Fragment> fragments,ArrayList<String > titleList) {
        super(fm);
        this.fragments = fragments;
        this.titleList = titleList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        try {
            if(titleList==null||titleList.size()==0) {
                return titles[position];
            }
            return titleList.get(position);
        } catch (IndexOutOfBoundsException e){
            throw new IllegalStateException("have not instile titles");
        }
    }

}
