package com.xxh.mobilehelper.presenter;

import com.xxh.mobilehelper.bean.CategoryBean;
import com.xxh.mobilehelper.data.model.CategoryModel;
import com.xxh.mobilehelper.data.rxhelper.RxExceptionHandler;
import com.xxh.mobilehelper.ui.view.CategoryView;

import java.util.List;

import io.reactivex.functions.Consumer;

/**
 * Created by 解晓辉 on 2017/6/13.
 * 作用：
 */

public class CategoryPresenter extends BasePresenter<CategoryModel, CategoryView> {


    public CategoryPresenter(CategoryView view) {
        super(view);
    }

    public void requestDatas() {
        addRx(mModel.getCategory().subscribe(new Consumer<List<CategoryBean>>() {
            @Override
            public void accept(List<CategoryBean> categoryBeans) throws Exception {
                mView.showCategoryData(categoryBeans);
            }
        }, new RxExceptionHandler<Throwable>(mContext, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        })));
    }


    @Override
    protected CategoryModel createModel() {
        return new CategoryModel();
    }

    @Override
    public void detachView() {

    }
}
