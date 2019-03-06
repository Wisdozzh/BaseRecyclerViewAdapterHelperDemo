package com.genise.zytec.baserecyclerviewadapterhelperdemo;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.adapter.SectionAdapter;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.base.BaseActivity;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.data.DataServer;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.decoration.GridSectionAverageGapItemDecoration;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.entity.MySection;

import java.util.List;

public class SectionUseActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    private List<MySection> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_use);

        setBackBtn();
        setTitle("Section Use");

        initView();
        initAdapter();
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.rv_list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mRecyclerView.addItemDecoration(new GridSectionAverageGapItemDecoration(50, 20, 20, 20));
    }

    private void initAdapter() {
        mData = DataServer.getSampleData();
        SectionAdapter sectionAdapter = new SectionAdapter(R.layout.item_section_content, R.layout.def_section_head, mData);

        sectionAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                MySection mySection = mData.get(position);
                if (mySection.isHeader)
                    Toast.makeText(SectionUseActivity.this, mySection.header, Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(SectionUseActivity.this, mySection.t.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        sectionAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(SectionUseActivity.this, "onItemChildClick" + position, Toast.LENGTH_SHORT).show();
            }
        });

        mRecyclerView.setAdapter(sectionAdapter);
    }
}
