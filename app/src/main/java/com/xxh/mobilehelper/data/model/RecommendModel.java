package com.xxh.mobilehelper.data.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.xxh.mobilehelper.bean.AppInfo;
import com.xxh.mobilehelper.bean.BannerBean;
import com.xxh.mobilehelper.bean.BaseResult;
import com.xxh.mobilehelper.bean.IndexBean;
import com.xxh.mobilehelper.bean.PageBean;
import com.xxh.mobilehelper.bean.SectionBean;
import com.xxh.mobilehelper.common.Constant;
import com.xxh.mobilehelper.data.api.ApiService;
import com.xxh.mobilehelper.data.http.HttpUtil;
import com.xxh.mobilehelper.data.rxhelper.RxResultCompat;
import com.xxh.mobilehelper.data.rxhelper.RxSchedulerHepler;
import com.xxh.mobilehelper.ui.adapter.RecommendRecyAdapter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;


/**
 * Created by 解晓辉  on 2017/5/21 09:39 *
 * QQ  ：811733738
 * 作用:
 */

public class RecommendModel {
    ApiService mApiService;

    public RecommendModel() {
        mApiService = HttpUtil.getInstance().provideRetrofit(Constant.BASE_URL).create(ApiService.class);
    }

    public Observable<PageBean<AppInfo>> getApps(String jsonParams) {
        return mApiService
                .getApps(jsonParams);
    }
    public Observable<PageBean<AppInfo>> getAppList(int  page) {
        return mApiService
                .getAppList(page);
    }
    public Observable<List<MultiItemEntity>> getIndex() {
        return mApiService
                .getIndex()
                .compose(RxSchedulerHepler.<BaseResult<IndexBean>>io_main())
                .compose(RxResultCompat.<IndexBean>handleResult())
                .flatMap(new Function<IndexBean, ObservableSource<List<MultiItemEntity>>>() {
                    @Override
                    public ObservableSource<List<MultiItemEntity>> apply(IndexBean indexBean) throws Exception {
                        List<MultiItemEntity> multiItemEntities = new ArrayList<MultiItemEntity>();
                        //为了方便列表，调整数据结构
                        List<IndexBean.BannersBean> banners = indexBean.getBanners();
                       multiItemEntities.add(new BannerBean(banners));

                        multiItemEntities.add(new MultiItemEntity() {
                            @Override
                            public int getItemType() {
                                return RecommendRecyAdapter.TAG;
                            }
                        });
                        multiItemEntities.add(new SectionBean("热门应用"));

                        List<IndexBean.RecommendAppsBean> recommendApps = indexBean.getRecommendApps();
                        for (IndexBean.RecommendAppsBean recommendApp : recommendApps) {
                            multiItemEntities.add(recommendApp);
                        }

                        multiItemEntities.add(new SectionBean("热门游戏"));
                        List<IndexBean.RecommendGamesBean> recommendGames = indexBean.getRecommendGames();
                        for (IndexBean.RecommendGamesBean recommendGame : recommendGames) {
                            multiItemEntities.add(recommendGame);
                        }
                        return Observable.just(multiItemEntities);
                    }
                });
    }


}
