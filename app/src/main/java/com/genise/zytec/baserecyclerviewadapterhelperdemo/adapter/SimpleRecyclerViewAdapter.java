package com.genise.zytec.baserecyclerviewadapterhelperdemo.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.R;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.entity.SimpleEntity;

public class SimpleRecyclerViewAdapter extends BaseQuickAdapter<SimpleEntity, BaseViewHolder> {

    public SimpleRecyclerViewAdapter() {
        super(R.layout.item_simple, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, SimpleEntity item) {
        helper.setText(R.id.tv, item.getName() + "----" +item.getId());
    }
}
