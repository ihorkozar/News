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

    public void insertNews(News news){
        newsDao.insertNews(news);
    }

    public LiveData<PagedList<News>> getNewsPaged(){
        return new LivePagedListBuilder<>(newsDao.getNewsPaged(), PAGE_SIZE).build();
    }

    public LiveData<News> getLiveNews(){
        return newsDao.getLiveNews();
    }

    public interface StorageOwner {
        Storage obtainStorage();
    }

    /*public Single<Article> getArticle(int id) {
        Single<Article> article = newsDao.getArticleById(id);
        return article;
    }*/
}
