package com.mycompany.news.data;

import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import com.mycompany.news.data.database.NewsDao;
import com.mycompany.news.data.model.Article;
import com.mycompany.news.data.model.News;
import java.util.List;

import io.reactivex.Single;

public class Storage {
    private NewsDao newsDao;
    private static final int PAGE_SIZE = 10;

    public Storage(NewsDao newsDao) {
        this.newsDao = newsDao;
    }

    public void insertArticles(News response) {
        insertArticles(response.getArticles());
    }

    public void insertArticles(List<Article> articles){
        newsDao.insertArticles(articles);
    }

    public LiveData<List<Article>> getArticleLive(){
        return newsDao.getLiveArticle();
    }

    public LiveData<PagedList<Article>> getNewsPaged(){
        return new LivePagedListBuilder<>(newsDao.getArticlePaged(), PAGE_SIZE).build();
    }

    public interface StorageOwner {
        Storage obtainStorage();
    }

    public Single<Article> getArticleById(String key) {
        Single<Article> article = newsDao.getArticleById(key);
        return article;
    }
}
