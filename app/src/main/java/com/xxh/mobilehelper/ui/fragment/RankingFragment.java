package com.xxh.mobilehelper.ui.fragment;

import com.xxh.mobilehelper.R;
import com.xxh.mobilehelper.base.BaseMvpFragment;
import com.xxh.mobilehelper.presenter.BasePresenter;
import com.xxh.mobilehelper.ui.view.RankingView;

/**
 */
public class RankingFragment extends BaseMvpFragment implements RankingView {


    public static RankingFragment newInstance() {
        RankingFragment fragment = new RankingFragment();
        return fragment;
    }


    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_ranking;
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }
}
