package com.xxh.mobilehelper.ui.weight;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

import com.xxh.mobilehelper.R;
import com.xxh.mobilehelper.common.util.AnimHelper;

/**
 * Created by 解晓辉 on 2017/6/27.
 * 作用：
 */

public class AppDetailBehavior extends CoordinatorLayout.Behavior<TextView> {


    private Context mContext;

    private int totalScrollRange; //可滑动的范围

    private int appBarHeight; //AppBar 的高度

    private int appBarWidth;//appBar的宽度


    private float originX;

    private float originY;

    private float finalX;

    private float finalY;


    // ToolBar高度
    private int mToolBarHeight;
    // AppBar的起始Y坐标
    private float mAppBarStartY;
    // 滚动执行百分比[0~1]
    private float mPercent;
    // Y轴移动插值器
    private DecelerateInterpolator mMoveYInterpolator;
    // X轴移动插值器
    private AccelerateInterpolator mMoveXInterpolator;
    private int finalSize;


    public AppDetailBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        mMoveYInterpolator = new DecelerateInterpolator();
        mMoveXInterpolator = new AccelerateInterpolator();
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, TextView child, View dependency) {
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, TextView child, View dependency) {
        if (dependency instanceof AppBarLayout) {
            //初始化变量
            initVariable(child, dependency);


            mPercent = (mAppBarStartY - dependency.getY()) * 1.0f / totalScrollRange;

            float percentY = mMoveYInterpolator.getInterpolation(mPercent);
            AnimHelper.setViewY(child, originY, finalY, percentY);

            float percentX = mMoveXInterpolator.getInterpolation(mPercent);

            AnimHelper.setViewX(child, originX, finalX, percentX);


        }


        return true;
    }

    private void initVariable(TextView child, View dependency) {
        AppBarLayout appBarLayout = (AppBarLayout) dependency;

        if (totalScrollRange == 0) {
            totalScrollRange = appBarLayout.getTotalScrollRange();
        }

        if (finalSize == 0) {
            finalSize = child.getHeight();
        }
        if (mAppBarStartY == 0) {
            mAppBarStartY = appBarLayout.getY();
        }
        if (appBarHeight == 0) {
            appBarHeight = appBarLayout.getHeight();
        }
        if (appBarWidth == 0) {
            appBarWidth = appBarLayout.getWidth();
        }

        if (mToolBarHeight == 0) {
            mToolBarHeight = mContext.getResources().getDimensionPixelSize(R.dimen.toolbar_height);
        }


        if (originX == 0) {
            originX = child.getX();
        }
        if (originY == 0) {
            originY = child.getY();
        }
        if (finalX == 0) {
            finalX = mContext.getResources().getDimensionPixelSize(R.dimen.toolbar_height);
        }
        if (finalY == 0) {
            finalY = (mToolBarHeight - finalSize) / 2 + mAppBarStartY;
        }


    }
}
