package com.genise.zytec.baserecyclerviewadapterhelperdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.adapter.AnimationAdapter;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.entity.Status;

public class AnimationUseActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private AnimationAdapter mAnimationAdapter;
    private int mFirstPageItemCount = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_use);

        initView();
        initAdapter();
    }

    private void initView() {
        findViewById(R.id.img_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mRecyclerView = findViewById(R.id.rv_list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initAdapter() {
        mAnimationAdapter = new AnimationAdapter();
        mAnimationAdapter.openLoadAnimation();
        mAnimationAdapter.setNotDoAnimationCount(mFirstPageItemCount);
        mAnimationAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                String content = null;
                Status status = (Status) adapter.getItem(position);
                switch (view.getId()) {
                    case R.id.img:
                        content = "img:" + status.getUserAvatar();
                        Toast.makeText(AnimationUseActivity.this, content, Toast.LENGTH_LONG).show();
                        break;
                    case R.id.tweetName:
                        content = "name:" + status.getUserName();
                        Toast.makeText(AnimationUseActivity.this, content, Toast.LENGTH_LONG).show();
                        break;
                    case R.id.tweetText:
                        content = "tweetText:" + status.getUserName();
                        Toast.makeText(AnimationUseActivity.this, content, Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });
        mRecyclerView.setAdapter(mAnimationAdapter);
        //spinner.setItems("AlphaIn", "ScaleIn", "SlideInBottom", "SlideInLeft", "SlideInRight", "Custom");
        mAnimationAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mAnimationAdapter.isFirstOnly(false);
    }
}
