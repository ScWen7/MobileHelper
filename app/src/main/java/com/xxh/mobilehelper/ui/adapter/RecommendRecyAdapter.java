package com.xxh.mobilehelper.ui.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.xxh.mobilehelper.R;
import com.xxh.mobilehelper.bean.BannerBean;
import com.xxh.mobilehelper.bean.IndexBean;
import com.xxh.mobilehelper.bean.SectionBean;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerClickListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 解晓辉  on 2017/6/4 07:39 *
 * QQ  ：811733738
 * 作用:
 */

public class RecommendRecyAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    public static final int BANNER = 0;
    public static final int TAG = 1;
    public static final int SECTION = 2;
    public static final int RECOMMEND_APP = 3;
    public static final int RECOMMEND_GAME = 4;

    String baseImgUrl = "http://file.market.xiaomi.com/mfc/thumbnail/png/w150q80/";


    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public RecommendRecyAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(BANNER, R.layout.banner_recommend);
        addItemType(TAG, R.layout.tag_recommend);
        addItemType(SECTION, R.layout.section_recommend);
        addItemType(RECOMMEND_APP, R.layout.item_reco_recy);
        addItemType(RECOMMEND_GAME, R.layout.item_reco_recy);

    }

    @Override
    protected void convert(BaseViewHolder helper, MultiItemEntity item) {
        switch (helper.getItemViewType()) {
            case BANNER:
                convertBanner(helper, item);

                break;
            case TAG:
                convertTag(helper, item);
                break;
            case SECTION:
                convertSection(helper, item);
                break;
            case RECOMMEND_APP:
                convertRecommendApp(helper, item);
                break;
            case RECOMMEND_GAME:
                convertRecommendGame(helper, item);
                break;
        }
    }

    private void convertBanner(BaseViewHolder helper, MultiItemEntity item) {

        BannerBean bannerBean = (BannerBean) item;
        Banner mBanner = helper.getView(R.id.banner_recommend);
        List<IndexBean.BannersBean> banners = bannerBean.getBanners();
        int size = banners.size();
        List<String> images = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            IndexBean.BannersBean bannersBean = banners.get(i);
            String image = bannersBean.getThumbnail();
            images.add(image);
        }

        //设置banner样式
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);

        mBanner.setIndicatorGravity(BannerConfig.CENTER);
        //设置图片加载器
        mBanner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        });

        mBanner.setImages(images);
        //设置banner动画效果
        mBanner.setBannerAnimation(Transformer.Default);
        //设置自动轮播，默认为true
        mBanner.isAutoPlay(true);
        //设置轮播时间
        mBanner.setDelayTime(2000);

        //banner设置方法全部调用完毕时最后调用
        mBanner.start();

        mBanner.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void OnBannerClick(int position) {
                Toast.makeText(mContext, "点击事件：" + position, Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void convertTag(BaseViewHolder helper, MultiItemEntity item) {

    }

    private void convertSection(BaseViewHolder helper, MultiItemEntity item) {
        SectionBean  sectionBean = (SectionBean) item;
        helper.setText(R.id.tv_section,sectionBean.getSection_text());
    }

    private void convertRecommendApp(BaseViewHolder helper, MultiItemEntity item) {
        IndexBean.RecommendAppsBean appsBean = (IndexBean.RecommendAppsBean) item;
        ImageView iv_icon = helper.getView(R.id.iv_icon);
        Glide.with(mContext).load(baseImgUrl+appsBean.getIcon()).into(iv_icon);
        helper.setText(R.id.tv_name,appsBean.getDisplayName()).setText(R.id.tv_desc,appsBean.getBriefShow());
    }

    private void convertRecommendGame(BaseViewHolder helper, MultiItemEntity item) {
        IndexBean.RecommendGamesBean appsBean = (IndexBean.RecommendGamesBean) item;
        ImageView iv_icon = helper.getView(R.id.iv_icon);
        Glide.with(mContext).load(baseImgUrl+appsBean.getIcon()).into(iv_icon);
        helper.setText(R.id.tv_name,appsBean.getDisplayName()).setText(R.id.tv_desc,appsBean.getBriefShow());
    }

}



