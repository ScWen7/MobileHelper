package com.xxh.mobilehelper.ui.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.text.format.Formatter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ms.square.android.expandabletextview.ExpandableTextView;
import com.xxh.mobilehelper.R;
import com.xxh.mobilehelper.base.BaseMvpActivity;
import com.xxh.mobilehelper.base.viewgroup.BaseAdapter;
import com.xxh.mobilehelper.base.viewgroup.VGUtil;
import com.xxh.mobilehelper.base.viewgroup.ViewHolder;
import com.xxh.mobilehelper.bean.AppInfo;
import com.xxh.mobilehelper.common.Constant;
import com.xxh.mobilehelper.common.util.DateUtils;
import com.xxh.mobilehelper.common.util.DensityUtil;
import com.xxh.mobilehelper.presenter.AppDetailPresenter;
import com.xxh.mobilehelper.ui.view.AppDetailView;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

public class AppDetailActivity extends BaseMvpActivity<AppDetailPresenter> implements AppDetailView {


    @BindView(R.id.view_temp)
    View mViewCache;
    @BindView(R.id.activity_app_detail)
    FrameLayout mActivityAppDetail;
    @BindView(R.id.ll_content)
    LinearLayout mLlContent;
    @BindView(R.id.ll_screen_shot)
    LinearLayout mLlScreenShot;
    @BindView(R.id.expandable_text)
    TextView mExpandableText;
    @BindView(R.id.expand_collapse)
    ImageButton mExpandCollapse;
    @BindView(R.id.view_introduction)
    ExpandableTextView mViewIntroduction;
    @BindView(R.id.txt_update_time)
    TextView mTxtUpdateTime;
    @BindView(R.id.txt_version)
    TextView mTxtVersion;
    @BindView(R.id.txt_apk_size)
    TextView mTxtApkSize;
    @BindView(R.id.txt_publisher)
    TextView mTxtPublisher;
    @BindView(R.id.txt_publisher2)
    TextView mTxtPublisher2;
    @BindView(R.id.ll_apps_samedev)
    LinearLayout mLlAppsSamedev;
    @BindView(R.id.ll_apps_rel)
    LinearLayout mLlAppsRel;
    private int mAppId;

    private ObjectAnimator mAnimator;

    @Override
    protected void initData() {
        mPresenter.getAppDetail(mAppId);
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
        mAnimator = ObjectAnimator.ofFloat(mViewCache, "scaleY", 1, 100);
        mAnimator.setStartDelay(500);
        mAnimator.setDuration(300);

        mAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mViewCache.setVisibility(View.GONE);
                mLlContent.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                mViewCache.setBackgroundColor(Color.WHITE);
            }
        });
        mAnimator.start();
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
        showScreenShot(appInfo);

        showAppDesc(appInfo);

        showRelApps(appInfo);

    }

    private void showRelApps(AppInfo appInfo) {
        List<AppInfo> sameDevAppInfoList = appInfo.getSameDevAppInfoList();
        List<AppInfo> relateAppInfoList = appInfo.getRelateAppInfoList();
        BaseAdapter<AppInfo> adapter = new BaseAdapter<AppInfo>(this, sameDevAppInfoList, R.layout.item_app_detail) {
            @Override
            protected void onBindViewHolder(ViewGroup parent, ViewHolder holder, AppInfo item, int pos) {
                ImageView img_app_icon = holder.getView(R.id.img_app_icon);
                Glide.with(this.mContext).load(Constant.BASEIMGURL + item.getIcon()).into(img_app_icon);
                holder.setText(R.id.txt_app_name, item.getDisplayName())
                        .setText(R.id.txt_apk_size, Formatter.formatFileSize(this.mContext, item.getApkSize()));

            }
        };
        new VGUtil(mLlAppsSamedev, adapter).bind();

        BaseAdapter<AppInfo> appInfoBaseAdapter = new BaseAdapter<AppInfo>(this, relateAppInfoList, R.layout.item_app_detail) {
            @Override
            protected void onBindViewHolder(ViewGroup parent, ViewHolder holder, AppInfo item, int pos) {
                ImageView img_app_icon = holder.getView(R.id.img_app_icon);
                Glide.with(this.mContext).load(Constant.BASEIMGURL + item.getIcon()).into(img_app_icon);
                holder.setText(R.id.txt_app_name, item.getDisplayName())
                        .setText(R.id.txt_apk_size, Formatter.formatFileSize(this.mContext, item.getApkSize()));

            }
        };
        new VGUtil(mLlAppsRel, appInfoBaseAdapter).bind();

    }

    private void showAppDesc(AppInfo appInfo) {
        mViewIntroduction.setText(appInfo.getIntroduction());
        mTxtUpdateTime.setText(DateUtils.formatDate(appInfo.getUpdateTime()));
        mTxtApkSize.setText((appInfo.getApkSize() / 1014 / 1024) + " Mb");
        mTxtVersion.setText(appInfo.getVersionName());
        mTxtPublisher.setText(appInfo.getPublisherName());
        mTxtPublisher2.setText(appInfo.getPublisherName());

    }

    private void showScreenShot(AppInfo appInfo) {
        String screenshot = appInfo.getScreenshot();
        List<String> screenShots = Arrays.asList(screenshot.split(","));
        VGUtil vgUtil = new VGUtil(mLlScreenShot, new BaseAdapter<String>(this, screenShots, R.layout.screen_shot) {
            @Override
            protected void onBindViewHolder(ViewGroup parent, ViewHolder holder, String item, int pos) {
                ImageView screen = holder.getView(R.id.iv_screen_shot);
                Glide.with(this.mContext).load(Constant.BASEIMGURL + item).into(screen);
            }
        });
        vgUtil.bind();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mAnimator != null) {
            mAnimator.removeAllListeners();
            mAnimator = null;
        }
    }


}
