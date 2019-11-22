package com.mycompany.news.ui;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import com.mycompany.news.data.model.Article;
import com.mycompany.news.data.model.News;
import com.mycompany.news.databinding.NewsListBinding;

public class NewsAdapter extends PagedListAdapter<Article, NewsHolder> {

    private final OnItemClickListener onItemClickListener;

    public NewsAdapter(OnItemClickListener onItemClickListener) {
        super(CALLBACK);
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        NewsListBinding newsListBinding = NewsListBinding.inflate(inflater,parent,false);
        return new NewsHolder(newsListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int position) {
        Article article = getItem(position);
        if (article != null){
            holder.bind(article, onItemClickListener);
        }
    }

    private static final DiffUtil.ItemCallback<Article> CALLBACK = new DiffUtil.ItemCallback<Article>() {
        @Override
        public boolean areItemsTheSame(Article oldItem, Article newItem) {
            return oldItem.getArticle_id() == newItem.getArticle_id();
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(Article oldItem, Article newItem) {
            return oldItem.equals(newItem);
        }
    };

    public interface OnItemClickListener {
        void onItemClick();
    }
}
