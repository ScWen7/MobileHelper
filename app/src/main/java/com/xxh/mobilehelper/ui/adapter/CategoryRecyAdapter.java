package com.xxh.mobilehelper.ui.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xxh.mobilehelper.R;
import com.xxh.mobilehelper.bean.CategoryBean;
import com.xxh.mobilehelper.common.Constant;

/**
 * Created by 解晓辉 on 2017/6/15.
 * 作用：
 */

public class CategoryRecyAdapter extends BaseQuickAdapter<CategoryBean, BaseViewHolder> {

    public CategoryRecyAdapter() {
        super(R.layout.item_category);
    }

    @Override
    protected void convert(BaseViewHolder helper, CategoryBean item) {
        ImageView iv_icon = helper.getView(R.id.iv_icon);
        Glide.with(mContext).load(Constant.BASEIMGURL + item.getIcon()).into(iv_icon);
        helper.setText(R.id.tv_name, item.getName());
    }
}
