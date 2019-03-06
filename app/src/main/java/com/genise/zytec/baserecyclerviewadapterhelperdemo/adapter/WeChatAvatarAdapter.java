package com.genise.zytec.baserecyclerviewadapterhelperdemo.adapter;

import android.graphics.Color;
import android.util.Log;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.R;
import com.genise.zytec.combinebitmap.combinebitmap.CombineBitmap;
import com.genise.zytec.combinebitmap.combinebitmap.layout.WechatLayoutManager;
import com.genise.zytec.combinebitmap.combinebitmap.listener.OnSubItemClickListener;

public class WeChatAvatarAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    private String[] IMG_URL_ARR = {
            "http://img.hb.aicdn.com/eca438704a81dd1fa83347cb8ec1a49ec16d2802c846-laesx2_fw658",
            "http://img.hb.aicdn.com/729970b85e6f56b0d029dcc30be04b484e6cf82d18df2-XwtPUZ_fw658",
            "http://img.hb.aicdn.com/85579fa12b182a3abee62bd3fceae0047767857fe6d4-99Wtzp_fw658",
            "http://img.hb.aicdn.com/2814e43d98ed41e8b3393b0ff8f08f98398d1f6e28a9b-xfGDIC_fw658",
            "http://img.hb.aicdn.com/a1f189d4a420ef1927317ebfacc2ae055ff9f212148fb-iEyFWS_fw658",
            "http://img.hb.aicdn.com/69b52afdca0ae780ee44c6f14a371eee68ece4ec8a8ce-4vaO0k_fw658",
            "http://img.hb.aicdn.com/9925b5f679964d769c91ad407e46a4ae9d47be8155e9a-seH7yY_fw658",
            "http://img.hb.aicdn.com/e22ee5730f152c236c69e2242b9d9114852be2bd8629-EKEnFD_fw658",
            "http://img.hb.aicdn.com/73f2fbeb01cd3fcb2b4dccbbb7973aa1a82c420b21079-5yj6fx_fw658",
    };

    public WeChatAvatarAdapter() {
        super(R.layout.item_wechat_avatar, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv, item);

        ImageView imageView = helper.getView(R.id.iv);
        int random = (int) (Math.random() * 9 + 1);
        Log.e("Genise", "random = " + random);
//        loadWechatBitmap(imageView, 9);
        loadWechatBitmap(imageView, random);
    }

    private void loadWechatBitmap(ImageView imageView, int count) {
        CombineBitmap.init(mContext)
                .setLayoutManager(new WechatLayoutManager())
                .setSize(80)
                .setGap(3)
                .setGapColor(Color.parseColor("#E8E8E8"))
                .setUrls(getUrls(count))
                .setImageView(imageView)
                .setOnSubItemClickListener(new OnSubItemClickListener() {
                    @Override
                    public void onSubItemClick(int index) {
                        Log.e("SubItemIndex", "--->" + index);
                    }
                })
                .build();
    }

    private String[] getUrls(int count) {
        String[] urls = new String[count];
        System.arraycopy(IMG_URL_ARR, 0, urls, 0, count);
        return urls;
    }
}
