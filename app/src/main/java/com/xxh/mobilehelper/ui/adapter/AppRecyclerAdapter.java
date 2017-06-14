package com.xxh.mobilehelper.ui.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xxh.mobilehelper.R;
import com.xxh.mobilehelper.bean.AppInfoBean;
import com.xxh.mobilehelper.common.Constant;

/**
 * Created by 解晓辉 on 2017/6/13.
 * 作用：
 */

public class AppRecyclerAdapter extends BaseQuickAdapter<AppInfoBean.AppBean, BaseViewHolder> {

    private Builder mBuilder;

    private AppRecyclerAdapter(Builder builder) {
        super(builder.layoutId);
        mBuilder = builder;
    }

    @Override
    protected void convert(BaseViewHolder helper, AppInfoBean.AppBean item) {

        helper.setVisible(R.id.tv_position, mBuilder.isShowPosition)
                .setVisible(R.id.tv_category, mBuilder.isShowCategoryName)
                .setVisible(R.id.tv_desc, mBuilder.isShowBrief);


        ImageView iv_icon = helper.getView(R.id.iv_icon);
        Glide.with(mContext).load(Constant.BASEIMGURL + item.getIcon()).into(iv_icon);
        helper.setText(R.id.tv_position, item.getPosition() + 1 + ".")
                .setText(R.id.tv_name, item.getDisplayName())
                .setText(R.id.tv_desc, item.getBriefShow()).setText(R.id.tv_category, item.getLevel1CategoryName());
    }


    public static class Builder {

        private int layoutId = R.layout.item_app;
        private boolean isShowPosition;
        private boolean isShowCategoryName;
        private boolean isShowBrief;


        public Builder isShowPosition(boolean isShowPosition) {
            this.isShowPosition = isShowPosition;
            return this;
        }

        public Builder isShowCategoryName(boolean isShowCategoryName) {
            this.isShowCategoryName = isShowCategoryName;
            return this;
        }

        public Builder isShowBrief(boolean isShowBrief) {
            this.isShowBrief = isShowBrief;
            return this;
        }

        public AppRecyclerAdapter build() {
            return new AppRecyclerAdapter(this);
        }
    }


}
