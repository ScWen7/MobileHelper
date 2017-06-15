package com.xxh.mobilehelper.ui.view;

import com.xxh.mobilehelper.bean.CategoryBean;
import com.xxh.mobilehelper.ui.BaseView;

import java.util.List;

/**
 * Created by 解晓辉 on 2017/6/13.
 * 作用：
 */

public interface CategoryView extends BaseView {
    void showCategoryData(List<CategoryBean> categoryBeans);
}
