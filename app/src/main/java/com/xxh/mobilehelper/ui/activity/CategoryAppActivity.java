package com.xxh.mobilehelper.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.xxh.mobilehelper.R;
import com.xxh.mobilehelper.base.BaseActivity;
import com.xxh.mobilehelper.common.Constant;
import com.xxh.mobilehelper.ui.adapter.CategoryPageAdapter;

import butterknife.BindView;

public class CategoryAppActivity extends BaseActivity {


    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;
    private int mCategoryid;

    @Override
    protected void initView() {

        mCategoryid = getIntent().getIntExtra(Constant.CATEGORY, 0);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mViewpager.setOffscreenPageLimit(3);
        mViewpager.setAdapter(new CategoryPageAdapter(getSupportFragmentManager(),mCategoryid));
        mTabLayout.setupWithViewPager(mViewpager);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_category_app;
    }


}
