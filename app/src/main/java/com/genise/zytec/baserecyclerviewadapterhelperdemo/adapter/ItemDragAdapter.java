package com.genise.zytec.baserecyclerviewadapterhelperdemo.adapter;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.R;

import java.util.List;

public class ItemDragAdapter extends BaseItemDraggableAdapter<String, BaseViewHolder> {
    public ItemDragAdapter(List<String> data) {
        super(R.layout.item_draggable_view, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        switch (helper.getLayoutPosition() %
                3) {
            case 0:
                helper.setImageResource(R.id.iv_head, R.mipmap.head_img0);
                break;
            case 1:
                helper.setImageResource(R.id.iv_head, R.mipmap.head_img1);
                break;
            case 2:
                helper.setImageResource(R.id.iv_head, R.mipmap.head_img2);
                break;
        }
        helper.setText(R.id.tv, item);
    }
}
