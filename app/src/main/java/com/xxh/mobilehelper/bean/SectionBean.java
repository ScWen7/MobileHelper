package com.xxh.mobilehelper.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.xxh.mobilehelper.ui.adapter.RecommendRecyAdapter;

/**
 * Created by 解晓辉 on 2017/6/13.
 * 作用：
 */

public class SectionBean implements MultiItemEntity {

    private String section_text;

    public SectionBean(String section_text) {
        this.section_text = section_text;
    }

    public String getSection_text() {
        return section_text;
    }

    public void setSection_text(String section_text) {
        this.section_text = section_text;
    }

    @Override
    public int getItemType() {
        return RecommendRecyAdapter.SECTION;
    }
}
