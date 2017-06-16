package com.xxh.mobilehelper.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xxh.mobilehelper.R;
import com.xxh.mobilehelper.base.BaseMvpFragment;
import com.xxh.mobilehelper.bean.AppInfoBean;
import com.xxh.mobilehelper.common.Constant;
import com.xxh.mobilehelper.presenter.AppInfoPresenter;
import com.xxh.mobilehelper.ui.adapter.AppRecyclerAdapter;
import com.xxh.mobilehelper.ui.view.AppInfoView;

import java.util.List;

import butterknife.BindView;

/**
 * Created by 解晓辉 on 2017/6/16.
 * 作用：
 */

public class CategoryAppFragment extends BaseMvpFragment<AppInfoPresenter> implements AppInfoView {


    private int mCategoryid;
    private int flagtype;

    @BindView(R.id.recycler_rank)
    RecyclerView mRecyclerRank;
    private AppRecyclerAdapter mRecyclerAdapter;

    protected int page = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mCategoryid = getArguments().getInt(Constant.CATEGORY);
        flagtype = getArguments().getInt(Constant.FLAGTYPE);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public static CategoryAppFragment newInstance(int categoryid, int flagtype) {
        CategoryAppFragment fragment = new CategoryAppFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constant.CATEGORY, categoryid);
        bundle.putInt(Constant.FLAGTYPE, flagtype);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    protected void initData() {
        mPresenter.request(AppInfoPresenter.CATEGORY_TYPE, page,mCategoryid,flagtype);
    }

    @Override
    public AppInfoPresenter createPresenter() {
        return new AppInfoPresenter(this);
    }

    @Override
    protected void initView() {
        mRecyclerRank.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mRecyclerAdapter = new AppRecyclerAdapter.Builder().isShowCategoryName(false).isShowPosition(false).isShowBrief(true).build();
        mRecyclerRank.setAdapter(mRecyclerAdapter);
        mRecyclerAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.request(AppInfoPresenter.CATEGORY_TYPE, page,mCategoryid,flagtype);
            }
        }, mRecyclerRank);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_ranking;
    }

    @Override
    public void showResult(AppInfoBean appInfoBean) {
        List<AppInfoBean.AppBean> datas = appInfoBean.getDatas();
        if (appInfoBean.isHasMore()) {
            page++;
        }
        mRecyclerAdapter.addData(datas);
        mRecyclerAdapter.setEnableLoadMore(appInfoBean.isHasMore());
    }

    @Override
    public void onLoadMoreComplete() {
        mRecyclerAdapter.loadMoreComplete();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }
}
