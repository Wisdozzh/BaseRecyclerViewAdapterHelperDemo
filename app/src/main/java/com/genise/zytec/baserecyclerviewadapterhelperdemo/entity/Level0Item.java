package com.genise.zytec.baserecyclerviewadapterhelperdemo.entity;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.adapter.ExpandableItemAdapter;

public class Level0Item extends AbstractExpandableItem<Level1Item> implements MultiItemEntity {

    public String title;
    public String subTitle;

    public Level0Item(String title, String subTitle) {
        this.subTitle = subTitle;
        this.title = title;
    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public int getItemType() {
        return ExpandableItemAdapter.TYPE_LEVEL_0;
    }
}
