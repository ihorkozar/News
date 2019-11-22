package com.mycompany.news.ui.detail;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.mycompany.news.data.Storage;
import com.mycompany.news.data.model.Article;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DetailNewsViewModel extends ViewModel {
    private Disposable disposable;
    private Storage storage;
    private String key;
    private MutableLiveData<Boolean> isErrorVisible = new MutableLiveData<>();
    private MutableLiveData<Article> detailArticle = new MutableLiveData<>();

    public DetailNewsViewModel(Storage storage, String key) {
        this.storage = storage;
        this.key = key;
        loadDetailNews();
    }

    private void loadDetailNews(){
        disposable = storage.getArticleById(key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(article -> detailArticle.setValue(article));
    }

    public void dispatchDetach(){
        storage = null;
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
