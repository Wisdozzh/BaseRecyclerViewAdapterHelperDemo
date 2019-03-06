package com.genise.zytec.baserecyclerviewadapterhelperdemo.adapter;

import com.genise.zytec.baserecyclerviewadapterhelperdemo.R;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.base.BaseDataBindingAdapter;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.databinding.ItemMovieBinding;
import com.genise.zytec.baserecyclerviewadapterhelperdemo.entity.Movie;

public class UpFetchAdapter extends BaseDataBindingAdapter<Movie, ItemMovieBinding> {
    public UpFetchAdapter() {
        super(R.layout.item_movie, null);
    }

    @Override
    protected void convert(ItemMovieBinding binding, Movie item) {
        binding.setMovie(item);
    }
}
