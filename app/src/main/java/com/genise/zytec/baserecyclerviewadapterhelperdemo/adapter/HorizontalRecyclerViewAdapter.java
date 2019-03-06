package com.genise.zytec.baserecyclerviewadapterhelperdemo.adapter;

import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.R;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.entity.HorizontalModel;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.util.ToastUtils;

import java.util.List;

public class HorizontalRecyclerViewAdapter extends BaseQuickAdapter<HorizontalModel, BaseViewHolder> {


    public HorizontalRecyclerViewAdapter(List<HorizontalModel> data) {
        super(R.layout.item_horizontal, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HorizontalModel item) {
        helper.setText(R.id.txtTitle, item.getName());

        TextView txtTitle = helper.getView(R.id.txtTitle);
        txtTitle.setTag(item);
        txtTitle.setOnClickListener(click);
    }

    private View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            HorizontalModel horizontalModel = (HorizontalModel) v.getTag();
            ToastUtils.showShortToast(horizontalModel.getName());
        }
    };
}
