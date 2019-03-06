package com.genise.zytec.baserecyclerviewadapterhelperdemo.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.R;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.data.DataServer;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.entity.Status;

public class QuickAdapter extends BaseQuickAdapter<Status, BaseViewHolder> {
    public QuickAdapter(int dataSize) {
        super(R.layout.layout_animation, DataServer.getSimpleData(dataSize));
    }

    @Override
    protected void convert(BaseViewHolder helper, Status item) {
        switch (helper.getLayoutPosition() %
                3) {
            case 0:
                helper.setImageResource(R.id.img, R.mipmap.animation_img1);
                break;
            case 1:
                helper.setImageResource(R.id.img, R.mipmap.animation_img2);
                break;
            case 2:
                helper.setImageResource(R.id.img, R.mipmap.animation_img3);
                break;
        }
        helper.setText(R.id.tweetName, "Hoteis in Rio de Janeiro");
        helper.setText(R.id.tweetText, "O ever youthful,O ever weeping");
    }
}
