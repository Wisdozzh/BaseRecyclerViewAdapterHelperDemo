package com.genise.zytec.baserecyclerviewadapterhelperdemo.adapter;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.R;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.data.DataServer;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.entity.Status;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.util.ClickableMovementMethod;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.util.SpannableStringUtils;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.util.ToastUtils;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.util.Utils;

public class AnimationAdapter extends BaseQuickAdapter<Status, BaseViewHolder> {
    public AnimationAdapter() {
        super(R.layout.layout_animation, DataServer.getSimpleData(100));
    }

    @Override
    protected void convert(BaseViewHolder helper, Status item) {
        helper.addOnClickListener(R.id.img).addOnClickListener(R.id.tweetName);
        switch (helper.getAdapterPosition() % 3) {
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
        String msg = "\"He was one of Australia's most of distinguished artistes, renowned for his portraits\"";
        ((TextView) helper.getView(R.id.tweetText)).setText(SpannableStringUtils.getBuilder(msg).append("landscapes and nedes").setClickSpan(clickableSpan).create());
        ((TextView) helper.getView(R.id.tweetText)).setMovementMethod(ClickableMovementMethod.getInstance());
        ((TextView) helper.getView(R.id.tweetText)).setFocusable(false);
        ((TextView) helper.getView(R.id.tweetText)).setClickable(false);
        ((TextView) helper.getView(R.id.tweetText)).setLongClickable(false);
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
