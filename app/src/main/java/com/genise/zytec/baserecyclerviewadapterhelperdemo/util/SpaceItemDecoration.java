package com.genise.zytec.baserecyclerviewadapterhelperdemo.util;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

/**
 * @author Wisdozzh
 * @desc 给recyclerview的item添加左边距
 * 
 */
public class SpaceItemDecoration extends ItemDecoration{
	private int mSpace;

	public SpaceItemDecoration(int mSpace) {
		super();
		this.mSpace = mSpace;
	}
	
	@Override
	public void getItemOffsets(Rect outRect, View view, RecyclerView parent, State state) {
		super.getItemOffsets(outRect, view, parent, state);
		outRect.left = mSpace;
	}
}
