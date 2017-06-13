package com.xxh.mobilehelper.ui.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xxh.mobilehelper.R;
import com.xxh.mobilehelper.bean.RankBean;
import com.xxh.mobilehelper.common.Constant;

import java.util.List;

/**
 * Created by 解晓辉 on 2017/6/13.
 * 作用：
 */

public class RankRecyclerAdapter extends BaseQuickAdapter<RankBean.DatasBean,BaseViewHolder> {


    public RankRecyclerAdapter(@LayoutRes int layoutResId, @Nullable List<RankBean.DatasBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RankBean.DatasBean item) {

        ImageView iv_icon = helper.getView(R.id.iv_icon);
        Glide.with(mContext).load(Constant.BASEIMGURL+item.getIcon()).into(iv_icon);
        helper.setText(R.id.tv_name,item.getDisplayName())
                .setText(R.id.tv_desc,item.getBriefShow());
    }
}
