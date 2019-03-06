package com.genise.zytec.baserecyclerviewadapterhelperdemo;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.adapter.ExpandableItemAdapter;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.base.BaseActivity;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.entity.Level0Item;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.entity.Level1Item;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.entity.Person;

import java.util.ArrayList;
import java.util.Random;

public class ExpandableUseActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    private ExpandableItemAdapter adapter;
    private ArrayList<MultiItemEntity> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_use);
        setBackBtn();
        setTitle("ExpanableItem Activity");

        initView();
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.rv);

        list = generateData();
        adapter = new ExpandableItemAdapter(list);

        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(){
            @Override
            public int getSpanSize(int position) {
                return adapter.getItemViewType(position) == ExpandableItemAdapter.TYPE_PERSON ? 1 : gridLayoutManager.getSpanCount();
            }
        });
        mRecyclerView.setAdapter(adapter);
        //important! setLayoutManager should be called after setAdapter
        mRecyclerView.setLayoutManager(gridLayoutManager);
        adapter.expandAll();
    }

    private ArrayList<MultiItemEntity> generateData() {
        int lv0Count = 9;
        int lv1Count = 3;
        int personCount = 5;

        String[] nameList = {"Bob", "Andy", "Lily", "Brown", "Bruce"};
        Random random = new Random();

        ArrayList<MultiItemEntity> res = new ArrayList<>();
        for (int i = 0; i < lv0Count; i++) {
            Level0Item lv0 = new Level0Item("This is " + i + "th item in Level 0", "subtitle of " + i);
            for (int j = 0; j < lv1Count; j++) {
                Level1Item lv1 = new Level1Item("Level 1 item: " + j, "(no animation)");
                for (int k = 0; k < personCount; k++) {
                    lv1.addSubItem(new Person(nameList[k], random.nextInt(40)));
                }
                lv0.addSubItem(lv1);
            }
            res.add(lv0);
        }
        res.add(new  Level0Item("This is " + lv0Count + "th item in Level 0", "subtitle of " + lv0Count));
        return res;
    }
}
