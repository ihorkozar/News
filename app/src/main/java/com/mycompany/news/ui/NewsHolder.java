package com.mycompany.news.ui;

import androidx.recyclerview.widget.RecyclerView;

import com.mycompany.news.data.model.News;
import com.mycompany.news.databinding.NewsListBinding;

public class NewsHolder extends RecyclerView.ViewHolder  {

    private NewsListBinding newsListBinding;

    public NewsHolder(NewsListBinding binding) {
        super(binding.getRoot());
        newsListBinding = binding;
    }

    public void bind(News item, NewsAdapter.OnItemClickListener onItemClickListener) {
        newsListBinding.setNews(new NewsListItemViewModel(item));
        newsListBinding.setOnItemClickListener(onItemClickListener);
        newsListBinding.executePendingBindings();
    }
}
