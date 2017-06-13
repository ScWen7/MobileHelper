package com.xxh.mobilehelper.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.xxh.mobilehelper.ui.adapter.RecommendRecyAdapter;

import java.util.List;

/**
 * Created by 解晓辉 on 2017/6/13.
 * 作用：
 */

public class BannerBean implements MultiItemEntity {

    private List<IndexBean.BannersBean> banners;

    public BannerBean(List<IndexBean.BannersBean> banners) {
        this.banners = banners;
    }

    public List<IndexBean.BannersBean> getBanners() {
        return banners;
    }

    public void setBanners(List<IndexBean.BannersBean> banners) {
        this.banners = banners;
    }

    @Override
    public int getItemType() {
        return RecommendRecyAdapter.BANNER;
    }
}
