package com.xxh.mobilehelper.ui.fragment;

import com.xxh.mobilehelper.R;
import com.xxh.mobilehelper.base.BaseMvpFragment;
import com.xxh.mobilehelper.presenter.CategoryPresenter;

/**

 */
public class CategoryFragment extends BaseMvpFragment<CategoryPresenter> {



    public static CategoryFragment newInstance() {
        CategoryFragment fragment = new CategoryFragment();
        return fragment;
    }


    @Override
    protected void initData() {

    }

    @Override
    public CategoryPresenter createPresenter() {
        return new CategoryPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_category;
    }
}
