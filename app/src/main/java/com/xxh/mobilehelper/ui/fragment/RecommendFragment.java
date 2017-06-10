package com.xxh.mobilehelper.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.xxh.mobilehelper.R;
import com.xxh.mobilehelper.bean.AppInfo;
import com.xxh.mobilehelper.bean.PageRequest;
import com.xxh.mobilehelper.common.Constant;
import com.xxh.mobilehelper.data.api.ApiService;
import com.xxh.mobilehelper.data.http.HttpUtil;
import com.xxh.mobilehelper.data.model.RecommendModel;
import com.xxh.mobilehelper.presenter.RecommendPresenter;
import com.xxh.mobilehelper.ui.adapter.RecommendRecyAdapter;
import com.xxh.mobilehelper.ui.view.RecommendView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 */
public class RecommendFragment extends Fragment implements RecommendView {


    @BindView(R.id.recycler_reco)
    RecyclerView mRecyclerReco;
    @BindView(R.id.refresh)
    SwipeRefreshLayout mRefresh;



    RecommendPresenter mRecommendPresenter;
    private final HttpUtil mHttpUtil;

    public RecommendFragment() {
        mHttpUtil = HttpUtil.create();
        ApiService apiService = mHttpUtil.provideRetrofit(Constant.BASE_URL).create(ApiService.class);
        mRecommendPresenter = new RecommendPresenter(this,new RecommendModel(apiService));
    }

    public static RecommendFragment newInstance() {
        RecommendFragment fragment = new RecommendFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommend, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initDatas();
    }

    private void initDatas() {
        mRecyclerReco.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecommendPresenter.getApps(new Gson().toJson(new PageRequest(0)));
    }

    @Override
    public void onDetach() {
        super.onDetach();
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
    public void showResult(List<AppInfo> appInfos) {
        RecommendRecyAdapter recyAdapter = new RecommendRecyAdapter(R.layout.item_reco_recy,appInfos);
        mRecyclerReco.setAdapter(recyAdapter);
    }

    @Override
    public void showNoData() {

    }

    @Override
    public void showError() {

    }


}
