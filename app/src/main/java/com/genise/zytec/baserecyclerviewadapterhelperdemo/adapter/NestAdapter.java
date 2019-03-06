package com.genise.zytec.baserecyclerviewadapterhelperdemo.adapter;

import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.R;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.data.DataServer;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.entity.Status;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.util.SpannableStringUtils;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.util.ToastUtils;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.util.Utils;

public class NestAdapter extends BaseQuickAdapter<Status, BaseViewHolder> {
    public NestAdapter() {
        super(R.layout.layout_nest_item, DataServer.getSimpleData(20));
    }

    @Override
    protected void convert(BaseViewHolder helper, Status item) {
        helper.addOnClickListener(R.id.tweetText);
        switch (helper.getLayoutPosition()%
                3){
            case 0:
                helper.setImageResource(R.id.img,R.mipmap.animation_img1);
                break;
            case 1:
                helper.setImageResource(R.id.img,R.mipmap.animation_img2);
                break;
            case 2:
                helper.setImageResource(R.id.img,R.mipmap.animation_img3);
                break;
        }
        helper.setText(R.id.tweetName,"Hoteis in Rio de Janeiro");
        String msg="\"He was one of Australia's most of distinguished artistes, renowned for his portraits\"";
        ( (TextView)helper.getView(R.id.tweetText)).setText(SpannableStringUtils.getBuilder(msg).append("landscapes and nedes").setClickSpan(clickableSpan).create());
        ( (TextView)helper.getView(R.id.tweetText)).setMovementMethod(LinkMovementMethod.getInstance());
    }

    ClickableSpan clickableSpan = new ClickableSpan() {
        @Override
        public void onClick(View widget) {
            ToastUtils.showShortToast("事件触发了 landscapes and nedes");
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setColor(Utils.getContext().getResources().getColor(R.color.clickspan_color));
            ds.setUnderlineText(true);
        }
    };
}
