package com.genise.zytec.baserecyclerviewadapterhelperdemo.adapter;

import com.chad.library.adapter.base.BaseSectionMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.R;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.entity.MultipleItem;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.entity.SectionMultipleItem;

import java.util.List;

public class SectionMultipleItemAdapter extends BaseSectionMultiItemQuickAdapter<SectionMultipleItem, BaseViewHolder> {
    /**
     * init SectionMultipleItemAdapter
     * 1.add your header resource layout
     * 2.add some kind of items
     *
     * @param sectionHeadResId The section head layout id for each item
     * @param data             A new list is created out of this one to avoid mutable list
     */
    public SectionMultipleItemAdapter(int sectionHeadResId, List data) {
        super(sectionHeadResId, data);
        addItemType(SectionMultipleItem.TEXT, R.layout.item_text_view);
        addItemType(SectionMultipleItem.IMG_TEXT, R.layout.item_img_text_view);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, SectionMultipleItem item) {
        //deal with header viewHolder
        helper.setText(R.id.header, item.header);
        helper.setVisible(R.id.more, item.isMore());
        helper.addOnClickListener(R.id.more);
    }

    @Override
    protected void convert(BaseViewHolder helper, SectionMultipleItem item) {
        //deal with multiple type item viewHolder
        helper.addOnClickListener(R.id.card_view);
        switch (helper.getItemViewType()) {
            case MultipleItem.TEXT:
                helper.setText(R.id.tv, item.getVideo().getName());
                break;
            case MultipleItem.IMG_TEXT:
                switch (helper.getLayoutPosition() % 2) {
                    case 0:
                        helper.setImageResource(R.id.iv, R.mipmap.animation_img1);
                        break;
                    case 1:
                        helper.setImageResource(R.id.iv, R.mipmap.animation_img2);
                        break;
                }
                break;
        }
    }
}
