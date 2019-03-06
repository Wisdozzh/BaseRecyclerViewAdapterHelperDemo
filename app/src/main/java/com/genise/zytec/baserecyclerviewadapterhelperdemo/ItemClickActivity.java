package com.genise.zytec.baserecyclerviewadapterhelperdemo;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.adapter.ItemClickAdapter;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.base.BaseActivity;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.entity.ClickEntity;

import java.util.ArrayList;
import java.util.List;

public class ItemClickActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    private ItemClickAdapter adapter;
    private static final int PAGE_SIZE = 10;
    private static String TAG = "ItemClickAntivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_click);

        setBackBtn();
        setTitle("ItemClickActivity Activity");

        initView();
        initAdapter();
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initAdapter() {
        List<ClickEntity> data = new ArrayList<>();
        data.add(new ClickEntity(ClickEntity.CLICK_ITEM_VIEW));
        data.add(new ClickEntity(ClickEntity.CLICK_ITEM_CHILD_VIEW));
        data.add(new ClickEntity(ClickEntity.LONG_CLICK_ITEM_VIEW));
        data.add(new ClickEntity(ClickEntity.LONG_CLICK_ITEM_CHILD_VIEW));
        data.add(new ClickEntity(ClickEntity.NEST_CLICK_ITEM_CHILD_VIEW));
        adapter = new ItemClickAdapter(data);
        adapter.openLoadAnimation();
        mRecyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Log.d(TAG, "onItemClick: ");
                Toast.makeText(ItemClickActivity.this, "onItemClick" + position, Toast.LENGTH_SHORT).show();
            }
        });
        adapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                Log.d(TAG, "onItemLongClick: ");
                Toast.makeText(ItemClickActivity.this, "onItemLongClick" + position, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Log.d(TAG, "onItemChildClick: ");
                Toast.makeText(ItemClickActivity.this, "onItemChildClick" + position, Toast.LENGTH_SHORT).show();
            }
        });
        adapter.setOnItemChildLongClickListener(new BaseQuickAdapter.OnItemChildLongClickListener() {
            @Override
            public boolean onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {
                Log.d(TAG, "onItemChildLongClick: ");
                Toast.makeText(ItemClickActivity.this, "onItemChildLongClick" + position, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

}
