package com.mycompany.news.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.mycompany.news.data.Storage;
import com.mycompany.news.databinding.NewsBinding;
import com.mycompany.news.utils.CustomFactory;

public class NewsFragment extends Fragment {
    private NewsViewModel newsViewModel;

    private NewsAdapter.OnItemClickListener onItemClickListener = () -> {
        /*Intent intent = new Intent(getActivity(), DetailNewsActivity.class);
        Bundle args = new Bundle();
        args.putString(DetailNewsFragment.DETAIL_NEWS_KEY, username);
        intent.putExtra(DetailNewsActivity.USERNAME_KEY, args);
        startActivity(intent);*/
    };

    public static NewsFragment newInstance() {
        return new NewsFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Storage.StorageOwner) {
            Storage storage = ((Storage.StorageOwner) context).obtainStorage();
            CustomFactory customFactory = new CustomFactory(storage, onItemClickListener);
            newsViewModel = ViewModelProviders.of(this, customFactory)
                    .get(NewsViewModel.class);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        NewsBinding newsBinding = NewsBinding.inflate(inflater, container, false);
        newsBinding.setViewModel(newsViewModel);
        newsBinding.setLifecycleOwner(this);
        return newsBinding.getRoot();
    }
}
