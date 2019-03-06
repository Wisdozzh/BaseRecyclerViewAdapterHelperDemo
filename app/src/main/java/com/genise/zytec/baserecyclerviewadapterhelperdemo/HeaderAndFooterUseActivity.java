package com.genise.zytec.baserecyclerviewadapterhelperdemo;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.adapter.HeaderAndFooterAdapter;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.base.BaseActivity;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.data.DataServer;

public class HeaderAndFooterUseActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    private HeaderAndFooterAdapter headerAndFooterAdapter;
    private static final int PAGE_SIZE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackBtn();
        setTitle("HeaderAndFooter Use");
        setContentView(R.layout.activity_header_and_footer_use);

        initView();
        initAdapter();
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.rv_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initAdapter() {
        headerAndFooterAdapter = new HeaderAndFooterAdapter(PAGE_SIZE);
        headerAndFooterAdapter.openLoadAnimation();
        headerAndFooterAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                adapter.setNewData(DataServer.getSimpleData(PAGE_SIZE));
                Toast.makeText(HeaderAndFooterUseActivity.this, "" + Integer.toString(position), Toast.LENGTH_LONG).show();
            }
        });

        View headerView = getHeaderView(0, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                headerAndFooterAdapter.addHeaderView(getHeaderView(1, getRemoveHeaderListener()), 0);
            }
        });
        headerAndFooterAdapter.addHeaderView(headerView);

        View footerView = getFooterView(0, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                headerAndFooterAdapter.addFooterView(getFooterView(1, getRemoveFooterListener()), 0);
            }
        });
        headerAndFooterAdapter.addFooterView(footerView, 0);

        mRecyclerView.setAdapter(headerAndFooterAdapter);
    }

    private View getHeaderView(int type, View.OnClickListener listener) {
        View view = getLayoutInflater().inflate(R.layout.head_view, (ViewGroup) mRecyclerView.getParent(), false);
        if (type == 1) {
            ImageView imageView = view.findViewById(R.id.iv);
            imageView.setImageResource(R.mipmap.rm_icon);
        }
        view.setOnClickListener(listener);
        return view;
    }

    private View getFooterView(int type, View.OnClickListener listener) {
        View view = getLayoutInflater().inflate(R.layout.footer_view, (ViewGroup) mRecyclerView.getParent(), false);
        if (type == 1) {
            ImageView imageView = view.findViewById(R.id.iv);
            imageView.setImageResource(R.mipmap.rm_icon);
        }
        view.setOnClickListener(listener);
        return view;
    }

    private View.OnClickListener getRemoveHeaderListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                headerAndFooterAdapter.removeHeaderView(v);
            }
        };
    }

    private View.OnClickListener getRemoveFooterListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                headerAndFooterAdapter.removeFooterView(v);
            }
        };
    }
}
