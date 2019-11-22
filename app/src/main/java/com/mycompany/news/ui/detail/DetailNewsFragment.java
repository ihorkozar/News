package com.mycompany.news.ui.detail;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.mycompany.news.data.Storage;
import com.mycompany.news.databinding.DetailNewsBinding;

public class DetailNewsFragment extends Fragment {

    public static final String DETAIL_NEWS_KEY = "DETAIL_NEWS_KEY";

    private DetailNewsViewModel detailNewsViewModel;
    private Storage storage;
    private String key;

    public static DetailNewsFragment newInstance(Bundle args) {
        DetailNewsFragment fragment = new DetailNewsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        storage = context instanceof Storage.StorageOwner ? ((Storage.StorageOwner) context).obtainStorage() : null;
        if (getArguments() != null) {
            key = getArguments().getString(DETAIL_NEWS_KEY);
        }
        detailNewsViewModel = new DetailNewsViewModel(storage, key);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        DetailNewsBinding detailNewsBinding = DetailNewsBinding.inflate(inflater, container, false);
        detailNewsBinding.setViewModel(detailNewsViewModel);
        detailNewsBinding.setLifecycleOwner(this);

        return detailNewsBinding.getRoot();
    }

    @Override
    public void onDetach() {
        detailNewsViewModel.dispatchDetach();
        super.onDetach();
    }
}
