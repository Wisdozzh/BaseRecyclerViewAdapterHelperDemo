package com.genise.zytec.baserecyclerviewadapterhelperdemo;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.adapter.DataBindingUseAdapter;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.base.BaseActivity;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.entity.Movie;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.util.ToastUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataBindingUseActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    private DataBindingUseAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_binding_use);

        setBackBtn();
        setTitle("DataBinding Use");

        initView();
        initAdapter();
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initAdapter() {
        mAdapter = new DataBindingUseAdapter(R.layout.item_movie, genData());
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.showShortToast("onItemClick");
            }
        });
        mAdapter.setOnItemChildLongClickListener(new BaseQuickAdapter.OnItemChildLongClickListener() {
            @Override
            public boolean onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.showShortToast("onItemChildLongClick");
                return true;
            }
        });
        mAdapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.showShortToast("onItemLongClick");
                return true;
            }
        });
    }

    private List<Movie> genData() {
        ArrayList<Movie> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            String name = "Chad";
            int price = random.nextInt(10) + 10;
            int len = random.nextInt(80) + 60;
            Movie movie = new Movie(name, len, price, "He was one of Astralia's most distinguished artistes");
            list.add(movie);
        }
        return list;
    }
}
