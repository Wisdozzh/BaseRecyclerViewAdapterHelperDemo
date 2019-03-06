package com.genise.zytec.baserecyclerviewadapterhelperdemo.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.R;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.entity.HomeItem;

import java.util.List;

public class HomeAdapter extends BaseQuickAdapter<HomeItem, BaseViewHolder> {
    public HomeAdapter(int layoutResId, @Nullable List<HomeItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeItem item) {
        helper.setText(R.id.text, item.getTitle());
        helper.setImageResource(R.id.icon, item.getImageResource());
    }
}
