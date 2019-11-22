package com.mycompany.news.ui;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import com.mycompany.news.data.model.News;
import com.mycompany.news.databinding.NewsListBinding;

public class NewsAdapter extends PagedListAdapter<News, NewsHolder> {

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
        News news = getItem(position);
        if (news != null){
            holder.bind(news, onItemClickListener);
        }
    }

    private static final DiffUtil.ItemCallback<News> CALLBACK = new DiffUtil.ItemCallback<News>() {
        @Override
        public boolean areItemsTheSame(News oldItem, News newItem) {
            return oldItem.getNewsId() == newItem.getNewsId();
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(News oldItem, News newItem) {
            return oldItem.equals(newItem);
        }
    };

    public interface OnItemClickListener {
        void onItemClick();
    }
}
