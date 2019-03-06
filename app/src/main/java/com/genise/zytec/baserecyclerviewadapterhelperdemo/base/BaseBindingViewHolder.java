package com.genise.zytec.baserecyclerviewadapterhelperdemo.base;

import android.databinding.ViewDataBinding;
import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;

public class BaseBindingViewHolder<Binding extends ViewDataBinding> extends BaseViewHolder {
    private Binding mBinding;

    public BaseBindingViewHolder(View view) {
        super(view);
    }

    public Binding getBinding() {
        return mBinding;
    }

    public void setBinding(Binding mBinding) {
        this.mBinding = mBinding;
    }
}
