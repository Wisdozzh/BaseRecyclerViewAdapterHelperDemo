package com.genise.zytec.baserecyclerviewadapterhelperdemo.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.adapter.ExpandableItemAdapter;

public class Person implements MultiItemEntity {

    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int getItemType() {
        return ExpandableItemAdapter.TYPE_PERSON;
    }
}
