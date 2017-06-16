package com.xxh.mobilehelper.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.xxh.mobilehelper.ui.fragment.CategoryAppFragment;

/**
 * Created by 解晓辉 on 2017/6/16.
 * 作用：
 */

public class CategoryPageAdapter extends FragmentStatePagerAdapter {

    private String[] titltes = new String[]{"精品", "排行", "新品"};


    private int categoryid;

    public CategoryPageAdapter(FragmentManager fm, int categoryid) {
        super(fm);
        this.categoryid = categoryid;
    }

    @Override
    public Fragment getItem(int position) {
        return CategoryAppFragment.newInstance(categoryid, position);
    }

    @Override
    public int getCount() {
        return titltes.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titltes[position];
    }
}
