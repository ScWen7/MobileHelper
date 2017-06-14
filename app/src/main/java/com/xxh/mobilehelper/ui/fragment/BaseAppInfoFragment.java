package com.xxh.mobilehelper.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xxh.mobilehelper.R;
import com.xxh.mobilehelper.base.BaseMvpFragment;
import com.xxh.mobilehelper.bean.AppInfoBean;
import com.xxh.mobilehelper.presenter.AppInfoPresenter;
import com.xxh.mobilehelper.ui.adapter.AppRecyclerAdapter;
import com.xxh.mobilehelper.ui.view.AppInfoView;

import java.util.List;

import butterknife.BindView;

/**
 */
public abstract class BaseAppInfoFragment extends BaseMvpFragment<AppInfoPresenter> implements AppInfoView {


    @BindView(R.id.recycler_rank)
    RecyclerView mRecyclerRank;
    private AppRecyclerAdapter mRecyclerAdapter;


    @Override
    protected void initView() {
        mRecyclerRank.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mRecyclerAdapter = buildAdapter();
        mRecyclerRank.setAdapter(mRecyclerAdapter);
    }

    /**
     * 子类需要重写此方法完成Adapter 的创建
     *
     * @return
     */
    protected abstract AppRecyclerAdapter buildAdapter();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_ranking;
    }

    @Override
    protected void initData() {
        mPresenter.request(type(), 0);
    }

    /**
     * 子类重写此方法来指定type
     *
     * @return
     */
    public abstract int type();


    @Override
    public AppInfoPresenter createPresenter() {
        return new AppInfoPresenter(this);
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
