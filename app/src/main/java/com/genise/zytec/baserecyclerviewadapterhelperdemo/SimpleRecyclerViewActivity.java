package com.genise.zytec.baserecyclerviewadapterhelperdemo;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.genise.zytec.baserecyclerviewadapterhelperdemo.adapter.SimpleRecyclerViewAdapter;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.base.BaseActivity;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.entity.SimpleEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimpleRecyclerViewActivity extends BaseActivity {

    RecyclerView mRecyclerView;
    SimpleRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_recyclerview);
        setBackBtn();
        setTitle("SimpleRecyclerViewActivity");

        mRecyclerView = findViewById(R.id.rv_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new SimpleRecyclerViewAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.addData(genData());

        Collections.sort(mAdapter.getData());
    }

    private List<SimpleEntity> genData() {
        ArrayList<SimpleEntity> list = new ArrayList<>();

        list.add(new SimpleEntity(3, "Genise"));
        list.add(new SimpleEntity(2, "Genise"));
        list.add(new SimpleEntity(9, "Genise"));
        list.add(new SimpleEntity(7, "Genise"));
        list.add(new SimpleEntity(5, "Genise"));
        list.add(new SimpleEntity(10, "Genise"));
        list.add(new SimpleEntity(1, "Genise"));
        list.add(new SimpleEntity(6, "Genise"));
        list.add(new SimpleEntity(8, "Genise"));
        list.add(new SimpleEntity(4, "Genise"));
        return list;
    }
}
