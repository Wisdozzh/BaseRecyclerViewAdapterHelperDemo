package com.genise.zytec.baserecyclerviewadapterhelperdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.genise.zytec.baserecyclerviewadapterhelperdemo.base.BaseActivity;

public class ChooseMultipleItemUseTypeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_multiple_item_use_type);
        setTitle("MultipleItem Use");
        setBackBtn();

        findViewById(R.id.card_view1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseMultipleItemUseTypeActivity.this, MultipleItemUseActivity.class));
            }
        });

        findViewById(R.id.card_view2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseMultipleItemUseTypeActivity.this, MultipleItemRvAdapterUseActivity.class));
            }
        });
    }
}
