package com.mycompany.news.utils;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mycompany.news.data.model.Article;
import com.mycompany.news.data.model.News;
import com.mycompany.news.ui.NewsAdapter;

public class CustomBindingAdapter {
    @BindingAdapter("bind:ImageUrl")
    public static void loadImage(ImageView imageView, String urlImage){
        Glide.with(imageView.getContext())
                .load(urlImage)
                .apply(RequestOptions.circleCropTransform())
                .into(imageView);
    }

    @BindingAdapter("bind:WebView")
    public static void setWebView(WebView webView, String url){
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().getLoadsImagesAutomatically();
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }

    @BindingAdapter({"bind:data", "bind:clickHandler"})
    public static void configureRecyclerView(RecyclerView recyclerView,
                                             PagedList<Article> articles,
                                             NewsAdapter.OnItemClickListener listener){
        NewsAdapter adapter = new NewsAdapter(listener);
        adapter.submitList(articles);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter({"bind:refreshState", "bind:onRefresh"})
    public static void configureSwipeRefreshLayout(SwipeRefreshLayout refreshLayout,
                                                   boolean isLoading,
                                                   SwipeRefreshLayout.OnRefreshListener listener){
        refreshLayout.setOnRefreshListener(listener);
        refreshLayout.post(()-> refreshLayout.setRefreshing(isLoading));
    }
}
