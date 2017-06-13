package com.xxh.mobilehelper.ui.fragment;

import com.xxh.mobilehelper.R;
import com.xxh.mobilehelper.base.BaseMvpFragment;
import com.xxh.mobilehelper.presenter.GamePresenter;

/**

 */
public class GamingFragment extends BaseMvpFragment<GamePresenter> {




    public static GamingFragment newInstance() {
        GamingFragment fragment = new GamingFragment();
        return fragment;
    }


    @Override
    public GamePresenter createPresenter() {
        return new GamePresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gaming;
    }
}
