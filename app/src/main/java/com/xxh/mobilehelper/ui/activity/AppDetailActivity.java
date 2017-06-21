package com.xxh.mobilehelper.ui.activity;

import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.xxh.mobilehelper.R;
import com.xxh.mobilehelper.base.BaseMvpActivity;
import com.xxh.mobilehelper.bean.AppInfo;
import com.xxh.mobilehelper.common.Constant;
import com.xxh.mobilehelper.common.util.DensityUtil;
import com.xxh.mobilehelper.presenter.AppDetailPresenter;
import com.xxh.mobilehelper.ui.view.AppDetailView;

import butterknife.BindView;

public class AppDetailActivity extends BaseMvpActivity<AppDetailPresenter> implements AppDetailView {


    @BindView(R.id.view_temp)
    View mViewCache;
    @BindView(R.id.activity_app_detail)
    FrameLayout mActivityAppDetail;
    private int mAppId;

    @Override
    protected void initData() {

    }

    @Override
    public AppDetailPresenter createPresenter() {
        return new AppDetailPresenter(this);
    }

    @Override
    protected void initView() {



        mAppId = getIntent().getIntExtra(Constant.APPID, -1);
        if (mAppId == -1) {
            finish();
        }
        //显示缓存的View
        View cacheView = mApplication.getCacheView();
        Bitmap bitmapCache = getCacheBitMap(cacheView);
        if (bitmapCache == null) {
            return;
        }
        mViewCache.setBackgroundDrawable(new BitmapDrawable(bitmapCache));

        //固定View的显示位置
        int[] location = new int[2];
        cacheView.getLocationOnScreen(location);
        int left = location[0];
        int top = location[1];


        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(mViewCache.getLayoutParams());

        marginLayoutParams.topMargin = top - DensityUtil.getStatusBarH(this);
        marginLayoutParams.leftMargin = left;
        marginLayoutParams.width = cacheView.getWidth();
        marginLayoutParams.height = cacheView.getHeight();

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(marginLayoutParams);

        mViewCache.setLayoutParams(params);
        openAnimator();


    }

    private void openAnimator() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(mViewCache, "scaleY", 1, 100);
    }

    private Bitmap getCacheBitMap(View cacheView) {
        cacheView.setDrawingCacheEnabled(true);
        cacheView.buildDrawingCache();
        Bitmap cache = cacheView.getDrawingCache();
        if (cache != null) {
            cache = Bitmap.createBitmap(cache);
        }
        cacheView.destroyDrawingCache();
        return cache;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_app_detail;
    }

    //显示App详情
    @Override
    public void showAppDetail(AppInfo appInfo) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

}
