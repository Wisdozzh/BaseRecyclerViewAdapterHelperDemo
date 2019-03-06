package com.genise.zytec.baserecyclerviewadapterhelperdemo;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.SectionMultiEntity;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.adapter.SectionMultipleItemAdapter;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.base.BaseActivity;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.data.DataServer;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.entity.SectionMultipleItem;

import java.util.List;

/**
 * to get SectionMultipleItem you need follow two thongs
 * 1.create entity which extend SectionMultiEntity
 * 2.create adapter which extend BaseSectionMultiItemQuickAdapter
 */
public class SectionMultipleItemUseActivity extends BaseActivity {

    RecyclerView mRecyclerView;
    private List<SectionMultiEntity> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_multiple_item_use);
        setBackBtn();
        setTitle("SectionMultiple Use");

        mRecyclerView = findViewById(R.id.rv_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //create entityList which item data extend SectionMultiEntity
        mData = DataServer.getSectionMultiData();

        //create adapter which extend BaseSectionMultiItemQuickAdapter provider your headerResId
        SectionMultipleItemAdapter sectionMultipleItemAdapter = new SectionMultipleItemAdapter(R.layout.def_section_head, mData);
        sectionMultipleItemAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                SectionMultipleItem item = (SectionMultipleItem) adapter.getData().get(position);
                switch (view.getId()) {
                    case R.id.card_view:
                        //获取主体item相应数据给后期使用
                        if (item.getVideo() != null) {
                            Toast.makeText(SectionMultipleItemUseActivity.this, item.getVideo().getName(), Toast.LENGTH_LONG).show();
                        }
                        break;
                    default:
                        Toast.makeText(SectionMultipleItemUseActivity.this, "OnItemChildClickListener " + position, Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });
        mRecyclerView.setAdapter(sectionMultipleItemAdapter);
    }
}
