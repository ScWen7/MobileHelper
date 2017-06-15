package com.xxh.mobilehelper.ui.fragment;

import android.support.v4.app.Fragment;

import com.xxh.mobilehelper.presenter.AppInfoPresenter;
import com.xxh.mobilehelper.ui.adapter.AppRecyclerAdapter;

/**
 */
public class RankingFragment extends BaseAppInfoFragment {


    @Override
    protected AppRecyclerAdapter buildAdapter() {
        return new AppRecyclerAdapter.Builder().isShowBrief(true).isShowCategoryName(false).isShowPosition(true).build();
    }

    @Override
    public int type() {
        return AppInfoPresenter.RANK_TYPE;
    }

    public static Fragment newInstance() {
        return new RankingFragment();
    }
}
