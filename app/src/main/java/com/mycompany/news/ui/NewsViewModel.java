package com.mycompany.news.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.mycompany.news.BuildConfig;
import com.mycompany.news.data.Storage;
import com.mycompany.news.data.model.Article;
import com.mycompany.news.data.model.News;
import com.mycompany.news.utils.ApiUtils;

import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class NewsViewModel extends ViewModel {
    private Disposable disposable;
    private Storage storage;
    private NewsAdapter.OnItemClickListener onItemClickListener;
    private MutableLiveData<Boolean> isErrorVisible = new MutableLiveData<>();
    private MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private LiveData<PagedList<Article>> articles;
    private SwipeRefreshLayout.OnRefreshListener onRefreshListener = () -> updateArticles();

    public NewsViewModel(Storage storage, NewsAdapter.OnItemClickListener onItemClickListener) {
        this.storage = storage;
        this.onItemClickListener = onItemClickListener;
        updateArticles();
        articles = storage.getNewsPaged();
    }

    private void updateArticles(){
        String country = "us";
        disposable = ApiUtils.getApiService()
                .getTopHeadlinesNews(country, BuildConfig.API_KEY)
                .map(News::getArticles)
                .doOnSuccess(response -> isErrorVisible.postValue(false))
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(disposable -> isLoading.postValue(true))
                .doFinally(() -> isLoading.postValue(false))
                .subscribe(
                        response -> storage.insertArticles(response),
                        throwable -> {
                            boolean value = articles.getValue()==null || articles.getValue().size()==0;
                            isErrorVisible.postValue(value);
                        });
    }

    @Override
    public void onCleared(){
        storage = null;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public NewsAdapter.OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public MutableLiveData<Boolean> getIsErrorVisible() {
        return isErrorVisible;
    }

    public MutableLiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    public LiveData<PagedList<Article>> getArticles() {
        return articles;
    }

    public SwipeRefreshLayout.OnRefreshListener getOnRefreshListener() {
        return onRefreshListener;
    }
}
