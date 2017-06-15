package com.xxh.mobilehelper.ui.fragment;

import android.support.v4.app.Fragment;

import com.xxh.mobilehelper.presenter.AppInfoPresenter;
import com.xxh.mobilehelper.ui.adapter.AppRecyclerAdapter;

/**

 */
public class GamingFragment extends BaseAppInfoFragment {


    @Override
    protected AppRecyclerAdapter buildAdapter() {
        return new AppRecyclerAdapter.Builder().isShowPosition(false).isShowBrief(true).build();
    }

    @Override
    public int type() {
        return AppInfoPresenter.GAME_TYPE;
    }

    public static Fragment newInstance() {
        return new GamingFragment();
    }
}
