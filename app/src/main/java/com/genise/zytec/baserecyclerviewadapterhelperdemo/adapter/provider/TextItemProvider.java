package com.genise.zytec.baserecyclerviewadapterhelperdemo.adapter.provider;

import android.widget.Toast;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.R;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.adapter.DemoMultipleItemRvAdapter;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.entity.NormalMultipleEntity;

public class TextItemProvider extends BaseItemProvider<NormalMultipleEntity, BaseViewHolder> {
    @Override
    public int viewType() {
        return DemoMultipleItemRvAdapter.TYPE_TEXT;
    }

    @Override
    public int layout() {
        return R.layout.item_text_view;
    }

    @Override
    public void convert(BaseViewHolder helper, NormalMultipleEntity data, int position) {
        helper.setText(R.id.tv, data.content);
    }

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
