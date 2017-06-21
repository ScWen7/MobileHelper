package com.xxh.mobilehelper.ui.fragment;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.xxh.mobilehelper.R;
import com.xxh.mobilehelper.base.BaseMvpFragment;
import com.xxh.mobilehelper.bean.AppInfoBean;
import com.xxh.mobilehelper.common.Constant;
import com.xxh.mobilehelper.presenter.AppInfoPresenter;
import com.xxh.mobilehelper.ui.activity.AppDetailActivity;
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

    protected int page = 0;


    @Override
    protected void initView() {
        mRecyclerRank.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mRecyclerAdapter = buildAdapter();
        mRecyclerRank.setAdapter(mRecyclerAdapter);
        mRecyclerAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.request(type(), page);
            }
        }, mRecyclerRank);

        mRecyclerRank.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                mApplication.setCacheView(view);
                Intent intent = new Intent(mActivity, AppDetailActivity.class);
                intent.putExtra(Constant.APPID, mRecyclerAdapter.getItem(position).getId());
                startActivity(intent);
                mActivity.overridePendingTransition(R.anim.anim_in,R.anim.anim_in);
            }
        });
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
        mPresenter.request(type(), page);
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
    public void onLoadMoreComplete() {
        mRecyclerAdapter.loadMoreComplete();
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
}
