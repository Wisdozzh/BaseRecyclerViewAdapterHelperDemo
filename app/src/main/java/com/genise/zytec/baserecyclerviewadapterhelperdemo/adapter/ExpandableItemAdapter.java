package com.genise.zytec.baserecyclerviewadapterhelperdemo.adapter;

import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.IExpandable;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.R;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.entity.Level0Item;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.entity.Level1Item;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.entity.Person;

import java.util.List;

public class ExpandableItemAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    private static final String TAG = ExpandableItemAdapter.class.getSimpleName();

    public static final int TYPE_LEVEL_0 = 0;
    public static final int TYPE_LEVEL_1 = 1;
    public static final int TYPE_PERSON = 2;
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public ExpandableItemAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(TYPE_LEVEL_0, R.layout.item_expandable_lv0);
        addItemType(TYPE_LEVEL_1, R.layout.item_expandable_lv1);
        addItemType(TYPE_PERSON, R.layout.item_expandable_lv2);
    }

    @Override
    protected void convert(final BaseViewHolder helper, MultiItemEntity item) {
        switch (helper.getItemViewType()) {
            case TYPE_LEVEL_0:
                switch (helper.getLayoutPosition() % 3) {
                    case 0:
                        helper.setImageResource(R.id.iv_head, R.mipmap.head_img0);
                        break;
                    case 1:
                        helper.setImageResource(R.id.iv_head, R.mipmap.head_img1);
                        break;
                    case 2:
                        helper.setImageResource(R.id.iv_head, R.mipmap.head_img2);
                        break;
                }
                final Level0Item lv0 = (Level0Item) item;
                helper.setText(R.id.title, lv0.title)
                        .setText(R.id.sub_title, lv0.subTitle)
                        .setImageResource(R.id.iv, lv0.isExpanded() ? R.mipmap.arrow_b : R.mipmap.arrow_r);
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = helper.getAdapterPosition();
                        Log.d(TAG, "Level 0 item pos: " + pos);
                        if (lv0.isExpanded()) {
                            collapse(pos);
                        } else {
                            expand(pos);
                        }
                    }
                });
                break;
            case TYPE_LEVEL_1:
                final Level1Item lv1 = (Level1Item) item;
                helper.setText(R.id.title, lv1.title)
                        .setText(R.id.sub_title, lv1.subTitle)
                        .setImageResource(R.id.iv, lv1.isExpanded() ? R.mipmap.arrow_b : R.mipmap.arrow_r);
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = helper.getAdapterPosition();
                        Log.d(TAG, "Level 1 item pos: " + pos);
                        if (lv1.isExpanded()) {
                            collapse(pos, false);
                        } else {
                            expand(pos, false);
                        }
                    }
                });

                helper.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        int pos = helper.getAdapterPosition();
                        //先获取当前 item父position,再移除自己
                        int positionAtAll = getParentPositionInAll(pos);
                        remove(pos);
                        if (positionAtAll != -1) {
                            IExpandable multiItemEntity = (IExpandable) getData().get(positionAtAll);
                            if (!hasSubItems(multiItemEntity)) {
                                remove(positionAtAll);
                            }
                        }
                        return true;
                    }
                });
                break;
            case TYPE_PERSON:
                final Person person = (Person) item;
                helper.setText(R.id.tv, person.name + " parent pos :" + getParentPosition(person));
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = helper.getAdapterPosition();
                        //先获取是当前，item的父position，再移除自己
                        int positionAll = getParentPositionInAll(pos);
                        remove(pos);
                        if (positionAll != -1) {
                            IExpandable multiItemEntity = (IExpandable) getData().get(positionAll);
                            if (!hasSubItems(multiItemEntity)) {
                                remove(positionAll);
                            }
                        }
                    }
                });
                break;
        }
    }
}
