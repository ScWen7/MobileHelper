package com.xxh.mobilehelper.ui.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.xxh.mobilehelper.R;
import com.xxh.mobilehelper.base.BaseMvpFragment;
import com.xxh.mobilehelper.data.model.RecommendModel;
import com.xxh.mobilehelper.presenter.RecommendPresenter;
import com.xxh.mobilehelper.ui.adapter.RecommendRecyAdapter;
import com.xxh.mobilehelper.ui.view.RecommendView;

import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 */
public class RecommendFragment extends BaseMvpFragment<RecommendPresenter> implements RecommendView {


    @BindView(R.id.recycler_reco)
    RecyclerView mRecyclerReco;
    @BindView(R.id.refresh)
    SwipeRefreshLayout mRefresh;





    public RecommendFragment() {
    }

    public static RecommendFragment newInstance() {
        RecommendFragment fragment = new RecommendFragment();

        return fragment;
    }



    @Override
    protected void initView() {
        mRefresh.setColorSchemeResources( android.R.color.holo_green_light, android.R.color.holo_red_light, android.R.color.holo_blue_light);
        mRecyclerReco.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recommend;
    }

    @Override
    public RecommendPresenter createPresenter() {
        return new RecommendPresenter(this,new RecommendModel());
    }


    @Override
    public void showLoading() {
        mRefresh.setRefreshing(true);
    }

    @Override
    public void dismissLoading() {
        mRefresh.setRefreshing(false);
    }

    @Override
    public void showResult(List<MultiItemEntity> multiItemEntities) {
        RecommendRecyAdapter recommendRecyAdapter = new RecommendRecyAdapter(multiItemEntities);
        mRecyclerReco.setAdapter(recommendRecyAdapter);
    }

    @Override
    public void showNoData() {

    }

    @Override
    public void showError() {

    }


}
