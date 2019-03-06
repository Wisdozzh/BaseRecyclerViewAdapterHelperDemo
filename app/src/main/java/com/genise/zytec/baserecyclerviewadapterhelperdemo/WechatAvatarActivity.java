package com.genise.zytec.baserecyclerviewadapterhelperdemo;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.genise.zytec.baserecyclerviewadapterhelperdemo.adapter.WeChatAvatarAdapter;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class WechatAvatarActivity extends BaseActivity {

    RecyclerView mRecyclerView;
    WeChatAvatarAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wechat_avatar);
        setBackBtn();
        setTitle("WeChat Avatar");

        mRecyclerView = findViewById(R.id.rv_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new WeChatAvatarAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.addData(genData());
    }

    private List<String> genData() {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            strings.add("我是数据" + i);
        }
        return strings;
     }
}
