package com.genise.zytec.combinebitmap.combinebitmap.listener;

import android.graphics.Bitmap;

public interface OnProgressListener {
    void onStart();

    void onComplete(Bitmap bitmap);
}
