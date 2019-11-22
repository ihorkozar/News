package com.mycompany.news.utils;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.mycompany.news.data.Storage;
import com.mycompany.news.ui.NewsAdapter;
import com.mycompany.news.ui.NewsViewModel;

public class CustomFactory extends ViewModelProvider.NewInstanceFactory{
    private Storage storage;
    private NewsAdapter.OnItemClickListener onItemClickListener;

    public CustomFactory(Storage storage, NewsAdapter.OnItemClickListener onItemClickListener) {
        this.storage = storage;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new NewsViewModel(storage, onItemClickListener);
    }

}
