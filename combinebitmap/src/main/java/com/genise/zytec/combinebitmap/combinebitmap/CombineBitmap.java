package com.genise.zytec.combinebitmap.combinebitmap;

import android.content.Context;

import com.genise.zytec.combinebitmap.combinebitmap.helper.Builder;

public class CombineBitmap {
    public static Builder init(Context context) {
        return new Builder(context);
    }
}
