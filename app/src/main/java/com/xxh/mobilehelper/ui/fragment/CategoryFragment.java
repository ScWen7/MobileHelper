package com.xxh.mobilehelper.ui.fragment;

import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.xxh.mobilehelper.R;
import com.xxh.mobilehelper.base.BaseMvpFragment;
import com.xxh.mobilehelper.bean.CategoryBean;
import com.xxh.mobilehelper.common.Constant;
import com.xxh.mobilehelper.presenter.CategoryPresenter;
import com.xxh.mobilehelper.ui.activity.CategoryAppActivity;
import com.xxh.mobilehelper.ui.adapter.CategoryRecyAdapter;
import com.xxh.mobilehelper.ui.view.CategoryView;

import java.util.List;

import butterknife.BindView;

/**

 */
public class CategoryFragment extends BaseMvpFragment<CategoryPresenter> implements CategoryView {


    @BindView(R.id.recycler_category)
    RecyclerView mRecyclerCategory;

    private CategoryRecyAdapter mRecyAdapter;

    public static CategoryFragment newInstance() {
        CategoryFragment fragment = new CategoryFragment();
        return fragment;
    }


    @Override
    protected void initData() {
        mPresenter.requestDatas();
    }

    @Override
    public CategoryPresenter createPresenter() {
        return new CategoryPresenter(this);
    }

    @Override
    protected void initView() {
        mRecyclerCategory.addItemDecoration(new DividerItemDecoration(mActivity, DividerItemDecoration.VERTICAL));
        mRecyclerCategory.setLayoutManager(new LinearLayoutManager(mActivity));
        mRecyAdapter = new CategoryRecyAdapter();
        mRecyclerCategory.setAdapter(mRecyAdapter);
        mRecyclerCategory.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {

                Intent intent = new Intent(getActivity(), CategoryAppActivity.class);

                intent.putExtra(Constant.CATEGORY, mRecyAdapter.getData().get(position).getId());

                startActivity(intent);

            }
        });

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_category;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void showCategoryData(List<CategoryBean> categoryBeans) {
        mRecyAdapter.addData(categoryBeans);
    }


}
