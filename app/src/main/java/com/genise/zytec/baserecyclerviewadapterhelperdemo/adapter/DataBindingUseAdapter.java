package com.genise.zytec.baserecyclerviewadapterhelperdemo.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.BR;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.R;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.entity.Movie;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.entity.MoviePresenter;

import java.util.List;

public class DataBindingUseAdapter extends BaseQuickAdapter<Movie, DataBindingUseAdapter.MovieViewHolder> {

    private MoviePresenter mPresenter;


    public DataBindingUseAdapter(int layoutResId, List<Movie> data) {
        super(layoutResId, data);

        mPresenter = new MoviePresenter();
    }

    @Override
    protected void convert(MovieViewHolder helper, Movie item) {
        ViewDataBinding binding = helper.getBinding();
        /**
         * 在onBindViewHolder方法中，调用Binding的setVariable方法设置UI显示的数据，其中item是RecyclerView内置的变量，如果RecyclerView只使用了一种布局，
         * 还可以使用holder.getBinding().setItem(list.get(position));来设置数据。由于数据改变后，DataBinding会在下一帧刷新UI，这样会导致屏幕闪一下，
         * 所以还需要调用Binding的executePendingBindings方法立即刷新UI
         */
        binding.setVariable(BR.movie, item);
        binding.setVariable(BR.presenter, mPresenter);
        binding.executePendingBindings();
        switch (helper.getLayoutPosition() % 2) {
            case 0:
                helper.setBackgroundRes(R.id.iv, R.mipmap.m_img1);
                break;
            case 1:
                helper.setBackgroundRes(R.id.iv, R.mipmap.m_img2);
                break;
        }
    }

    @Override
    protected View getItemView(int layoutResId, ViewGroup parent) {
        /**
         * Utility class to create {@link ViewDataBinding} from layouts.
         */
        ViewDataBinding binding = DataBindingUtil.inflate(mLayoutInflater, layoutResId, parent, false);
        if (binding == null) {
            return super.getItemView(layoutResId, parent);
        }
        /**
         * Returns the outermost View in the layout file associated with the Binding. If this
         * binding is for a merge layout file, this will return the first root in the merge tag.
         */
        View view = binding.getRoot();
        view.setTag(R.id.BaseQuickAdapter_databinding_support, binding);
        return view;
    }

    public static class MovieViewHolder extends BaseViewHolder {

        public MovieViewHolder(View view) {
            super(view);
        }

        public ViewDataBinding getBinding() {
            return (ViewDataBinding) itemView.getTag(R.id.BaseQuickAdapter_databinding_support);
        }
    }
}

