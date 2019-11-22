package com.mycompany.news.data.database;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.mycompany.news.data.model.Article;
import com.mycompany.news.data.model.News;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNews(News news);

    @Query("select * from news")
    News getNews();

    @Query("select * from news")
    LiveData<News> getLiveNews();

    @Query("select * from news")
    DataSource.Factory<Integer, News> getNewsPaged();

    /*@Query("select * from article where id = :articleId")
    Single<Article> getArticleById(int articleId);*/

}
