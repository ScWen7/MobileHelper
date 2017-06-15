package com.xxh.mobilehelper.presenter;

import com.xxh.mobilehelper.data.model.CategoryModel;
import com.xxh.mobilehelper.ui.view.CategoryView;

/**
 * Created by 解晓辉 on 2017/6/13.
 * 作用：
 */

public class CategoryPresenter extends BasePresenter<CategoryModel,CategoryView> {


    public CategoryPresenter(CategoryView view) {
        super(view);
    }

    @Override
    protected CategoryModel createModel() {
        return new CategoryModel();
    }

    @Override
    public void detachView() {

    }
}
