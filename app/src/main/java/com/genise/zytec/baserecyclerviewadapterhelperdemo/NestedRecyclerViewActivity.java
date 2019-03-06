package com.genise.zytec.baserecyclerviewadapterhelperdemo;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.genise.zytec.baserecyclerviewadapterhelperdemo.adapter.VerticalRecyclerViewAdapter;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.base.BaseActivity;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.entity.HorizontalModel;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.entity.VerticalModel;

import java.util.ArrayList;
import java.util.List;

public class NestedRecyclerViewActivity extends BaseActivity {

    RecyclerView verticalRecyclerView;
    VerticalRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nested_recycler_view);
        setBackBtn();
        setTitle("Nested RecyclerView");

        verticalRecyclerView = findViewById(R.id.recyclerview);
        verticalRecyclerView.setHasFixedSize(true);

        verticalRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        adapter = new VerticalRecyclerViewAdapter();
        verticalRecyclerView.setAdapter(adapter);
        adapter.addData(setData());

    }

    private List<VerticalModel> setData() {
        List<VerticalModel> verticalModels = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            VerticalModel verticalModel = new VerticalModel();
            verticalModel.setTitle("Title: " + i);

            ArrayList<HorizontalModel> arrayListHorizontal = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                HorizontalModel horizontalModel = new HorizontalModel();
                horizontalModel.setDescription("Description: " + j);
                horizontalModel.setName("Name: " + j);
                arrayListHorizontal.add(horizontalModel);
            }
            verticalModel.setArrayList(arrayListHorizontal);
            verticalModels.add(verticalModel);
        }
        return verticalModels;
    }


}
