package com.genise.zytec.baserecyclerviewadapterhelperdemo.adapter.provider;

import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.R;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.adapter.DemoMultipleItemRvAdapter;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.entity.NormalMultipleEntity;

public class TextImgItemProvider extends BaseItemProvider<NormalMultipleEntity, BaseViewHolder> {

    @Override
    public int viewType() {
        return DemoMultipleItemRvAdapter.TYPE_TEXT_IMAGE;
    }

    @Override
    public int layout() {
        return R.layout.item_img_text_view;
    }

    @Override
    public void convert(BaseViewHolder helper, NormalMultipleEntity data, int position) {
        Log.e("Genise", "convert");
        helper.setText(R.id.tv, data.content);
        helper.addOnClickListener(R.id.tv);
        TextView tv = helper.getView(R.id.tv);
        tv.setTag(data);
        tv.setOnClickListener(click);
        if (position % 2 == 0) {
            helper.setImageResource(R.id.iv, R.mipmap.animation_img1);
        } else {
            helper.setImageResource(R.id.iv, R.mipmap.animation_img2);
        }
    }

    private View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.e("Genise", "content click");
            NormalMultipleEntity data = (NormalMultipleEntity) v.getTag();
            Toast.makeText(mContext, data.content + "click", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onClick(BaseViewHolder helper, NormalMultipleEntity data, int position) {
        Toast.makeText(mContext, "click", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onLongClick(BaseViewHolder helper, NormalMultipleEntity data, int position) {
        Toast.makeText(mContext, "longClick", Toast.LENGTH_SHORT).show();
        return true;
    }
}
