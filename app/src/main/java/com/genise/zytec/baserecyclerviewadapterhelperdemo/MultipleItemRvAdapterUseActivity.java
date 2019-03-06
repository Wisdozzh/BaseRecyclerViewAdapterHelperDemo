package com.genise.zytec.baserecyclerviewadapterhelperdemo;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.adapter.DemoMultipleItemRvAdapter;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.base.BaseActivity;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.data.DataServer;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.entity.MultipleItem;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.entity.NormalMultipleEntity;

import java.util.List;

public class MultipleItemRvAdapterUseActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    private List<NormalMultipleEntity> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_item_rv_adapter_use);

        setTitle("MultipleItemRvAdapter");
        setBackBtn();

        initView();
        initAdapter();
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.rv_list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
    }

    private void initAdapter() {
        mData = DataServer.getNormalMultipleEntities();

        DemoMultipleItemRvAdapter demoMultipleItemRvAdapter = new DemoMultipleItemRvAdapter(mData);
        demoMultipleItemRvAdapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                int type = mData.get(position).type;
                if (type == NormalMultipleEntity.SINGLE_TEXT) {
                    return MultipleItem.TEXT_SPAN_SIZE;
                } else if (type == NormalMultipleEntity.SINGLE_IMG) {
                    return MultipleItem.IMG_SPAN_SIZE;
                } else {
                    return MultipleItem.IMG_TEXT_SPAN_SIZE;
                }
            }
        });

        mRecyclerView.setAdapter(demoMultipleItemRvAdapter);
    }
}
