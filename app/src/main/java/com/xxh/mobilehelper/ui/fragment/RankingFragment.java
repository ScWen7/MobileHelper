package com.xxh.mobilehelper.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xxh.mobilehelper.R;
import com.xxh.mobilehelper.base.BaseMvpFragment;
import com.xxh.mobilehelper.bean.RankBean;
import com.xxh.mobilehelper.presenter.BasePresenter;
import com.xxh.mobilehelper.presenter.RankingPresenter;
import com.xxh.mobilehelper.ui.adapter.RankRecyclerAdapter;
import com.xxh.mobilehelper.ui.view.RankingView;

import java.util.List;

import butterknife.BindView;

/**
 */
public class RankingFragment extends BaseMvpFragment implements RankingView {


    @BindView(R.id.recycler_rank)
    RecyclerView mRecyclerRank;


    public static RankingFragment newInstance() {
        RankingFragment fragment = new RankingFragment();
        return fragment;
    }


    @Override
    protected void initView() {
        mRecyclerRank.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_ranking;
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
    public void showResult(RankBean rankBean) {
        List<RankBean.DatasBean> datas = rankBean.getDatas();
        RankRecyclerAdapter recyclerAdapter = new RankRecyclerAdapter(R.layout.item_reco_recy, datas);
        mRecyclerRank.setAdapter(recyclerAdapter);
    }
}
