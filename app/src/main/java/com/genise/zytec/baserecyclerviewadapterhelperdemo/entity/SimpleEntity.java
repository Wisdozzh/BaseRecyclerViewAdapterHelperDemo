package com.genise.zytec.baserecyclerviewadapterhelperdemo.entity;

public class SimpleEntity implements Comparable<SimpleEntity>{
    int id;
    String name;

    public int getId() {
        return id;
    }

    public SimpleEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(SimpleEntity another) {
        return this.id - another.id;
    }


}
