package com.genise.zytec.baserecyclerviewadapterhelperdemo.adapter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.R;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.entity.HorizontalModel;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.entity.VerticalModel;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.util.DensityUtil;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.util.SpaceItemDecoration;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.util.ToastUtils;

import java.util.ArrayList;

public class VerticalRecyclerViewAdapter extends BaseQuickAdapter<VerticalModel, BaseViewHolder> {

    public VerticalRecyclerViewAdapter() {
        super(R.layout.item_vertical, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, VerticalModel item) {
        helper.setText(R.id.txtTitle, item.getTitle());

        ArrayList<HorizontalModel> singleItem = item.getArrayList();
        RecyclerView recyclerView = helper.getView(R.id.recyclerview);
        HorizontalRecyclerViewAdapter horizontalRecyclerViewAdapter = new HorizontalRecyclerViewAdapter(singleItem);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.addItemDecoration(new SpaceItemDecoration(DensityUtil.dip2px(mContext, 10)));
        recyclerView.setAdapter(horizontalRecyclerViewAdapter);

        Button btnMore = helper.getView(R.id.btnMore);
        btnMore.setTag(item);
        btnMore.setOnClickListener(moreClick);
    }

    private View.OnClickListener moreClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            VerticalModel item = (VerticalModel) v.getTag();
            ToastUtils.showShortToast(item.getTitle());
        }
    };

}
