package com.xxh.mobilehelper.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.xxh.mobilehelper.ui.adapter.RecommendRecyAdapter;

import java.util.List;

/**
 * Created by 解晓辉 on 2017/6/13.
 * 作用：
 */

public class IndexBean {


    private List<BannersBean> banners;
    private List<RecommendAppsBean> recommendApps;
    private List<RecommendGamesBean> recommendGames;

    public List<BannersBean> getBanners() {
        return banners;
    }

    public void setBanners(List<BannersBean> banners) {
        this.banners = banners;
    }

    public List<RecommendAppsBean> getRecommendApps() {
        return recommendApps;
    }

    public void setRecommendApps(List<RecommendAppsBean> recommendApps) {
        this.recommendApps = recommendApps;
    }

    public List<RecommendGamesBean> getRecommendGames() {
        return recommendGames;
    }

    public void setRecommendGames(List<RecommendGamesBean> recommendGames) {
        this.recommendGames = recommendGames;
    }

    public static class BannersBean {
        /**
         * thumbnail : http://t4.market.mi-img.com/thumbnail/jpeg/l750/AppStore/0ff69546de24355c8a484aafc27222e230f41f76f
         * action : subject
         * id : 169136
         */

        private String thumbnail;
        private String action;
        private String id;

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }


    }

    public static class RecommendAppsBean implements MultiItemEntity{
        /**
         * addTime : 0
         * hasSameDevApp : false
         * videoId : 0
         * source :
         * versionName : 6.1.9
         * hdIcon : {"main":"AppStore/0761b5acee61b219cb84f32ec2631a465df43e360"}
         * ratingScore : 3.5
         * briefShow : 超过7亿用户选择，你关心的才是头条
         * developerId : 0
         * fitness : 0
         * id : 2841
         * level1CategoryId : 11
         * releaseKeyHash : 0aa08095564a155b455ede748688ee5c
         * relateAppHasMore : false
         * rId : 0
         * suitableType : 0
         * briefUseIntro : false
         * ads : 0
         * publisherName : 北京字节跳动网络技术有限公司
         * level2CategoryId : 193
         * position : 0
         * favorite : false
         * isFavorite : false
         * appendSize : 0
         * level1CategoryName : 新闻资讯
         * samDevAppHasMore : false
         * displayName : 今日头条
         * icon : AppStore/00cdc3478626742c808c3ef2d4fb68dea2b846d89
         * screenshot : AppStore/0dd635261725503b751cad3738582097fbe40d160,AppStore/07249c4545585410c3e06226ac53d61c92418f477,AppStore/0531c59256093d7889ef40244e77237e1d040e9b4,AppStore/0531c59256093e788cef492444772d7e14040e9b4,AppStore/0dd635261125583b741ca8373e582497f7e40d160
         * ratingTotalCount : 0
         * adType : 0
         * apkSize : 13683265
         * packageName : com.ss.android.article.news
         * updateTime : 1497252495830
         * grantCode : 0
         * versionCode : 619
         * diffFileSize : 0
         */

        private int addTime;
        private boolean hasSameDevApp;
        private int videoId;
        private String source;
        private String versionName;
        private HdIconBean hdIcon;
        private double ratingScore;
        private String briefShow;
        private int developerId;
        private int fitness;
        private int id;
        private int level1CategoryId;
        private String releaseKeyHash;
        private boolean relateAppHasMore;
        private int rId;
        private int suitableType;
        private boolean briefUseIntro;
        private int ads;
        private String publisherName;
        private int level2CategoryId;
        private int position;
        private boolean favorite;
        private boolean isFavorite;
        private int appendSize;
        private String level1CategoryName;
        private boolean samDevAppHasMore;
        private String displayName;
        private String icon;
        private String screenshot;
        private int ratingTotalCount;
        private int adType;
        private int apkSize;
        private String packageName;
        private long updateTime;
        private int grantCode;
        private int versionCode;
        private int diffFileSize;

        public int getAddTime() {
            return addTime;
        }

        public void setAddTime(int addTime) {
            this.addTime = addTime;
        }

        public boolean isHasSameDevApp() {
            return hasSameDevApp;
        }

        public void setHasSameDevApp(boolean hasSameDevApp) {
            this.hasSameDevApp = hasSameDevApp;
        }

        public int getVideoId() {
            return videoId;
        }

        public void setVideoId(int videoId) {
            this.videoId = videoId;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getVersionName() {
            return versionName;
        }

        public void setVersionName(String versionName) {
            this.versionName = versionName;
        }

        public HdIconBean getHdIcon() {
            return hdIcon;
        }

        public void setHdIcon(HdIconBean hdIcon) {
            this.hdIcon = hdIcon;
        }

        public double getRatingScore() {
            return ratingScore;
        }

        public void setRatingScore(double ratingScore) {
            this.ratingScore = ratingScore;
        }

        public String getBriefShow() {
            return briefShow;
        }

        public void setBriefShow(String briefShow) {
            this.briefShow = briefShow;
        }

        public int getDeveloperId() {
            return developerId;
        }

        public void setDeveloperId(int developerId) {
            this.developerId = developerId;
        }

        public int getFitness() {
            return fitness;
        }

        public void setFitness(int fitness) {
            this.fitness = fitness;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getLevel1CategoryId() {
            return level1CategoryId;
        }

        public void setLevel1CategoryId(int level1CategoryId) {
            this.level1CategoryId = level1CategoryId;
        }

        public String getReleaseKeyHash() {
            return releaseKeyHash;
        }

        public void setReleaseKeyHash(String releaseKeyHash) {
            this.releaseKeyHash = releaseKeyHash;
        }

        public boolean isRelateAppHasMore() {
            return relateAppHasMore;
        }

        public void setRelateAppHasMore(boolean relateAppHasMore) {
            this.relateAppHasMore = relateAppHasMore;
        }

        public int getRId() {
            return rId;
        }

        public void setRId(int rId) {
            this.rId = rId;
        }

        public int getSuitableType() {
            return suitableType;
        }

        public void setSuitableType(int suitableType) {
            this.suitableType = suitableType;
        }

        public boolean isBriefUseIntro() {
            return briefUseIntro;
        }

        public void setBriefUseIntro(boolean briefUseIntro) {
            this.briefUseIntro = briefUseIntro;
        }

        public int getAds() {
            return ads;
        }

        public void setAds(int ads) {
            this.ads = ads;
        }

        public String getPublisherName() {
            return publisherName;
        }

        public void setPublisherName(String publisherName) {
            this.publisherName = publisherName;
        }

        public int getLevel2CategoryId() {
            return level2CategoryId;
        }

        public void setLevel2CategoryId(int level2CategoryId) {
            this.level2CategoryId = level2CategoryId;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public boolean isFavorite() {
            return favorite;
        }

        public void setFavorite(boolean favorite) {
            this.favorite = favorite;
        }

        public boolean isIsFavorite() {
            return isFavorite;
        }

        public void setIsFavorite(boolean isFavorite) {
            this.isFavorite = isFavorite;
        }

        public int getAppendSize() {
            return appendSize;
        }

        public void setAppendSize(int appendSize) {
            this.appendSize = appendSize;
        }

        public String getLevel1CategoryName() {
            return level1CategoryName;
        }

        public void setLevel1CategoryName(String level1CategoryName) {
            this.level1CategoryName = level1CategoryName;
        }

        public boolean isSamDevAppHasMore() {
            return samDevAppHasMore;
        }

        public void setSamDevAppHasMore(boolean samDevAppHasMore) {
            this.samDevAppHasMore = samDevAppHasMore;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getScreenshot() {
            return screenshot;
        }

        public void setScreenshot(String screenshot) {
            this.screenshot = screenshot;
        }

        public int getRatingTotalCount() {
            return ratingTotalCount;
        }

        public void setRatingTotalCount(int ratingTotalCount) {
            this.ratingTotalCount = ratingTotalCount;
        }

        public int getAdType() {
            return adType;
        }

        public void setAdType(int adType) {
            this.adType = adType;
        }

        public int getApkSize() {
            return apkSize;
        }

        public void setApkSize(int apkSize) {
            this.apkSize = apkSize;
        }

        public String getPackageName() {
            return packageName;
        }

        public void setPackageName(String packageName) {
            this.packageName = packageName;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }

        public int getGrantCode() {
            return grantCode;
        }

        public void setGrantCode(int grantCode) {
            this.grantCode = grantCode;
        }

        public int getVersionCode() {
            return versionCode;
        }

        public void setVersionCode(int versionCode) {
            this.versionCode = versionCode;
        }

        public int getDiffFileSize() {
            return diffFileSize;
        }

        public void setDiffFileSize(int diffFileSize) {
            this.diffFileSize = diffFileSize;
        }

        @Override
        public int getItemType() {
            return RecommendRecyAdapter.RECOMMEND_APP;
        }

        public static class HdIconBean {
            /**
             * main : AppStore/0761b5acee61b219cb84f32ec2631a465df43e360
             */

            private String main;

            public String getMain() {
                return main;
            }

            public void setMain(String main) {
                this.main = main;
            }
        }
    }

    public static class RecommendGamesBean implements MultiItemEntity{
        /**
         * addTime : 0
         * hasSameDevApp : false
         * videoId : 0
         * source :
         * versionName : 1.1.0
         * hdIcon : {"main":"AppStore/0934b3435f03e4e2125939487401eb077ee12b1aa"}
         * ratingScore : 2.5
         * briefShow : 好玩又刺激的四川麻将
         * developerId : 0
         * fitness : 0
         * id : 110688
         * level1CategoryId : 15
         * releaseKeyHash : 449a2c94ebfbe841e2d376319808c7e0
         * relateAppHasMore : false
         * rId : 0
         * suitableType : 0
         * briefUseIntro : false
         * ads : 0
         * publisherName : 深圳市棋游网络科技有限公司
         * level2CategoryId : 20
         * position : 0
         * favorite : false
         * isFavorite : false
         * appendSize : 0
         * level1CategoryName : 游戏
         * samDevAppHasMore : false
         * displayName : 血战四川麻将
         * icon : AppStore/0c6ee4383750fa4e4586474f5ee61c38850429e76
         * screenshot : AppStore/0b0664bd14694dae0331102d043429982b8437553,AppStore/0b0664bd14694eae0e311c2d0a3420982a8437553,AppStore/0b6134ff29c3d8d2996a8c96961d8ac0bb8430cc4,AppStore/027b154955c9442ff0bccc1eb09d77f6be20eeae0
         * ratingTotalCount : 0
         * adType : 0
         * apkSize : 20435830
         * packageName : com.szqy.xuezhansichuanmajiang.mi
         * updateTime : 1460637340997
         * grantCode : 0
         * versionCode : 110
         * diffFileSize : 0
         */

        private int addTime;
        private boolean hasSameDevApp;
        private int videoId;
        private String source;
        private String versionName;
        private HdIconBeanX hdIcon;
        private double ratingScore;
        private String briefShow;
        private int developerId;
        private int fitness;
        private int id;
        private int level1CategoryId;
        private String releaseKeyHash;
        private boolean relateAppHasMore;
        private int rId;
        private int suitableType;
        private boolean briefUseIntro;
        private int ads;
        private String publisherName;
        private int level2CategoryId;
        private int position;
        private boolean favorite;
        private boolean isFavorite;
        private int appendSize;
        private String level1CategoryName;
        private boolean samDevAppHasMore;
        private String displayName;
        private String icon;
        private String screenshot;
        private int ratingTotalCount;
        private int adType;
        private int apkSize;
        private String packageName;
        private long updateTime;
        private int grantCode;
        private int versionCode;
        private int diffFileSize;

        public int getAddTime() {
            return addTime;
        }

        public void setAddTime(int addTime) {
            this.addTime = addTime;
        }

        public boolean isHasSameDevApp() {
            return hasSameDevApp;
        }

        public void setHasSameDevApp(boolean hasSameDevApp) {
            this.hasSameDevApp = hasSameDevApp;
        }

        public int getVideoId() {
            return videoId;
        }

        public void setVideoId(int videoId) {
            this.videoId = videoId;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getVersionName() {
            return versionName;
        }

        public void setVersionName(String versionName) {
            this.versionName = versionName;
        }

        public HdIconBeanX getHdIcon() {
            return hdIcon;
        }

        public void setHdIcon(HdIconBeanX hdIcon) {
            this.hdIcon = hdIcon;
        }

        public double getRatingScore() {
            return ratingScore;
        }

        public void setRatingScore(double ratingScore) {
            this.ratingScore = ratingScore;
        }

        public String getBriefShow() {
            return briefShow;
        }

        public void setBriefShow(String briefShow) {
            this.briefShow = briefShow;
        }

        public int getDeveloperId() {
            return developerId;
        }

        public void setDeveloperId(int developerId) {
            this.developerId = developerId;
        }

        public int getFitness() {
            return fitness;
        }

        public void setFitness(int fitness) {
            this.fitness = fitness;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getLevel1CategoryId() {
            return level1CategoryId;
        }

        public void setLevel1CategoryId(int level1CategoryId) {
            this.level1CategoryId = level1CategoryId;
        }

        public String getReleaseKeyHash() {
            return releaseKeyHash;
        }

        public void setReleaseKeyHash(String releaseKeyHash) {
            this.releaseKeyHash = releaseKeyHash;
        }

        public boolean isRelateAppHasMore() {
            return relateAppHasMore;
        }

        public void setRelateAppHasMore(boolean relateAppHasMore) {
            this.relateAppHasMore = relateAppHasMore;
        }

        public int getRId() {
            return rId;
        }

        public void setRId(int rId) {
            this.rId = rId;
        }

        public int getSuitableType() {
            return suitableType;
        }

        public void setSuitableType(int suitableType) {
            this.suitableType = suitableType;
        }

        public boolean isBriefUseIntro() {
            return briefUseIntro;
        }

        public void setBriefUseIntro(boolean briefUseIntro) {
            this.briefUseIntro = briefUseIntro;
        }

        public int getAds() {
            return ads;
        }

        public void setAds(int ads) {
            this.ads = ads;
        }

        public String getPublisherName() {
            return publisherName;
        }

        public void setPublisherName(String publisherName) {
            this.publisherName = publisherName;
        }

        public int getLevel2CategoryId() {
            return level2CategoryId;
        }

        public void setLevel2CategoryId(int level2CategoryId) {
            this.level2CategoryId = level2CategoryId;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public boolean isFavorite() {
            return favorite;
        }

        public void setFavorite(boolean favorite) {
            this.favorite = favorite;
        }

        public boolean isIsFavorite() {
            return isFavorite;
        }

        public void setIsFavorite(boolean isFavorite) {
            this.isFavorite = isFavorite;
        }

        public int getAppendSize() {
            return appendSize;
        }

        public void setAppendSize(int appendSize) {
            this.appendSize = appendSize;
        }

        public String getLevel1CategoryName() {
            return level1CategoryName;
        }

        public void setLevel1CategoryName(String level1CategoryName) {
            this.level1CategoryName = level1CategoryName;
        }

        public boolean isSamDevAppHasMore() {
            return samDevAppHasMore;
        }

        public void setSamDevAppHasMore(boolean samDevAppHasMore) {
            this.samDevAppHasMore = samDevAppHasMore;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getScreenshot() {
            return screenshot;
        }

        public void setScreenshot(String screenshot) {
            this.screenshot = screenshot;
        }

        public int getRatingTotalCount() {
            return ratingTotalCount;
        }

        public void setRatingTotalCount(int ratingTotalCount) {
            this.ratingTotalCount = ratingTotalCount;
        }

        public int getAdType() {
            return adType;
        }

        public void setAdType(int adType) {
            this.adType = adType;
        }

        public int getApkSize() {
            return apkSize;
        }

        public void setApkSize(int apkSize) {
            this.apkSize = apkSize;
        }

        public String getPackageName() {
            return packageName;
        }

        public void setPackageName(String packageName) {
            this.packageName = packageName;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }

        public int getGrantCode() {
            return grantCode;
        }

        public void setGrantCode(int grantCode) {
            this.grantCode = grantCode;
        }

        public int getVersionCode() {
            return versionCode;
        }

        public void setVersionCode(int versionCode) {
            this.versionCode = versionCode;
        }

        public int getDiffFileSize() {
            return diffFileSize;
        }

        public void setDiffFileSize(int diffFileSize) {
            this.diffFileSize = diffFileSize;
        }

        @Override
        public int getItemType() {
            return RecommendRecyAdapter.RECOMMEND_GAME;
        }

        public static class HdIconBeanX {
            /**
             * main : AppStore/0934b3435f03e4e2125939487401eb077ee12b1aa
             */

            private String main;

            public String getMain() {
                return main;
            }

            public void setMain(String main) {
                this.main = main;
            }
        }
    }

}
