package com.xxh.mobilehelper.ui.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xxh.mobilehelper.R;
import com.xxh.mobilehelper.bean.AppInfo;

import java.util.List;

/**
 * Created by 解晓辉  on 2017/6/4 07:39 *
 * QQ  ：811733738
 * 作用:
 */

public class RecommendRecyAdapter extends BaseQuickAdapter<AppInfo, BaseViewHolder> {
    String baseImgUrl = "http://file.market.xiaomi.com/mfc/thumbnail/png/w150q80/";

    public RecommendRecyAdapter(@LayoutRes int layoutResId, @Nullable List<AppInfo> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AppInfo item) {
        ImageView iv_icon = helper.getView(R.id.iv_icon);
        String url = baseImgUrl+item.getIcon();
        Glide.with(mContext).load(url).centerCrop().into(iv_icon);
        helper.setText(R.id.tv_name, item.getDisplayName()).setText(R.id.tv_desc, item.getBriefShow());

    }
}
