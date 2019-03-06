package com.genise.zytec.combinebitmap.combinebitmap.region;

import android.graphics.Region;

public interface IRegionManager {
    Region[] calculateRegion(int size, int subSize, int gap, int count);
}
