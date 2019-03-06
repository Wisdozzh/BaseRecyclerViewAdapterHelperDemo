package com.genise.zytec.baserecyclerviewadapterhelperdemo;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.adapter.MultipleItemQuickAdapter;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.base.BaseActivity;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.data.DataServer;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.entity.MultipleItem;

import java.util.List;

public class MultipleItemUseActivity extends BaseActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_item_use);
        setTitle("MultipleItem Use");
        setBackBtn();

        initView();
        initAdapter();
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.rv_list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
    }

    private void initAdapter() {
        final List<MultipleItem> data = DataServer.getMultipleItemData();
        final MultipleItemQuickAdapter multipleItemQuickAdapter = new MultipleItemQuickAdapter(this, data);
        multipleItemQuickAdapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                Log.e("Genise", "data.get(position).getSpanSize() = " + data.get(position).getSpanSize());
                return data.get(position).getSpanSize();
            }
        });

        mRecyclerView.setAdapter(multipleItemQuickAdapter);
    }
}
