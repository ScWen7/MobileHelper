package com.xxh.mobilehelper.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xxh.mobilehelper.R;
import com.xxh.mobilehelper.base.BaseMvpFragment;
import com.xxh.mobilehelper.bean.AppInfoBean;
import com.xxh.mobilehelper.presenter.BasePresenter;
import com.xxh.mobilehelper.presenter.RankingPresenter;
import com.xxh.mobilehelper.ui.adapter.AppRecyclerAdapter;
import com.xxh.mobilehelper.ui.view.RankingView;

import java.util.List;

import butterknife.BindView;

/**
 */
public class RankingFragment extends BaseMvpFragment implements RankingView {


    @BindView(R.id.recycler_rank)
    RecyclerView mRecyclerRank;
    private AppRecyclerAdapter mRecyclerAdapter;


    public static RankingFragment newInstance() {
        RankingFragment fragment = new RankingFragment();
        return fragment;
    }


    @Override
    protected void initView() {
        mRecyclerRank.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mRecyclerAdapter = new AppRecyclerAdapter.Builder().isShowPosition(true).isShowBrief(true).isShowCategoryName(true).build();
        mRecyclerRank.setAdapter(mRecyclerAdapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_ranking;
    }

    @Override
    protected void initData() {

    }

    @Override
    public BasePresenter createPresenter() {
        return new RankingPresenter(this);
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void showResult(AppInfoBean appInfoBean) {
        List<AppInfoBean.AppBean> datas = appInfoBean.getDatas();
        mRecyclerAdapter.addData(datas);
    }
}
