package com.xxh.mobilehelper.ui.view;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.xxh.mobilehelper.ui.BaseView;

import java.util.List;

/**
 * Created by 解晓辉  on 2017/6/10 17:26 *
 * QQ  ：811733738
 * 作用:
 */

public interface RecommendView extends BaseView{
    void showResult(List<MultiItemEntity> multiItemEntities);
    void showNoData();
    void showError();
}
