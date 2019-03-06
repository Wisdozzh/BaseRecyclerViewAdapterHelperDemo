package com.genise.zytec.baserecyclerviewadapterhelperdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.adapter.PullToRefreshAdapter;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.base.BaseActivity;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.data.DataServer;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.entity.Status;

import java.util.List;

public class PullToRefreshUseActivity extends BaseActivity {

    private static final int PAGE_SIZE = 6;

    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private PullToRefreshAdapter mAdapter;

    private int mNextRequestPage = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_to_refresh_use);

        setTitle("Pull To Refresh Use");
        setBackBtn();

        initView();
        initAdapter();
        initRefreshLayout();
        mSwipeRefreshLayout.setRefreshing(true);
        refresh();
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.rv_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mSwipeRefreshLayout = findViewById(R.id.swiptLayout);
        mSwipeRefreshLayout.setColorSchemeColors(Color.BLUE);
    }

    private void initAdapter() {
        mAdapter = new PullToRefreshAdapter();
        mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                loadMore();
            }
        }, mRecyclerView);
        mAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(PullToRefreshUseActivity.this, Integer.toString(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initRefreshLayout() {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });
    }

    private void refresh() {
        mNextRequestPage = 1;
        mAdapter.setEnableLoadMore(false);//这里的作用是防止下啦刷新的时候还可以上拉加载
        new Request(mNextRequestPage, new RequestCallBack() {
            @Override
            public void success(List<Status> data) {
                setData(true, data);
                mAdapter.setEnableLoadMore(true);
                mSwipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void fail(Exception e) {
                Toast.makeText(PullToRefreshUseActivity.this, R.string.network_err, Toast.LENGTH_LONG).show();
                mAdapter.setEnableLoadMore(true);
                mSwipeRefreshLayout.setRefreshing(false);
            }
        }).start();
    }

    private void loadMore() {
        new Request(mNextRequestPage, new RequestCallBack() {
            @Override
            public void success(List<Status> data) {
                boolean isFresh = mNextRequestPage == 1;
                setData(isFresh, data);
            }

            @Override
            public void fail(Exception e) {
                mAdapter.loadMoreFail();
                Toast.makeText(PullToRefreshUseActivity.this, R.string.network_err, Toast.LENGTH_LONG).show();
            }
        }).start();
    }

    private void setData(boolean isRefresh, List data) {
        mNextRequestPage++;
        final int size = data == null ? 0 : data.size();
        if (isRefresh) {
            mAdapter.setNewData(data);
        } else {
            if (size > 0) {
                mAdapter.addData(data);
            }
        }
        if (size < PAGE_SIZE) {
            //第一页如果不够一页 就不现实没有更过数据布局
            mAdapter.loadMoreEnd(isRefresh);
            Toast.makeText(this, "no more data", Toast.LENGTH_SHORT).show();
        } else {
            mAdapter.loadMoreComplete();
        }
    }
}

interface RequestCallBack {
    void success(List<Status> data);

    void fail(Exception e);
}

class Request extends Thread {
    private static final int PAGE_SIZE = 6;
    private int mPage;
    private RequestCallBack mCallBack;
    private Handler mHandler;

    private static boolean mFirstPageNoMore;
    private static boolean mFirstError = true;

    public Request(int page, RequestCallBack callBack) {
        mPage = page;
        mCallBack = callBack;
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }

        if (mPage == 2 && mFirstError) {
            mFirstError = false;
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    mCallBack.fail(new RuntimeException("fail"));
                }
            });
        } else {
            int size = PAGE_SIZE;
            if (mPage == 1) {
                if (mFirstPageNoMore) {
                    size = 1;
                }
                mFirstPageNoMore = !mFirstPageNoMore;
                if (!mFirstError) {
                    mFirstError = true;
                }
            } else if (mPage == 4) {
                size = 1;
            }

            final int dataSize = size;
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    mCallBack.success(DataServer.getSimpleData(dataSize));
                }
            });
        }
    }
}