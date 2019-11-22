package com.mycompany.news.ui.detail;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.mycompany.news.data.Storage;
import com.mycompany.news.data.model.News;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DetailNewsViewModel extends ViewModel {
    private Disposable disposable;
    private Storage storage;
    private int id;
    private MutableLiveData<Boolean> isErrorVisible = new MutableLiveData<>();
    private MutableLiveData<News> detailNews = new MutableLiveData<>();

    public DetailNewsViewModel(Storage storage) {
        this.storage = storage;
        loadDetailNews();
    }

    private void loadDetailNews(){
                /*.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> detailNews.setValue(result));*/
    }

    public void dispatchDetach(){
        storage = null;
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
