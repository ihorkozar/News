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
    void insertArticles(List<Article> articles);

    @Query("select * from article")
    List<Article> getNews();

    @Query("select * from article order by publishedAt desc")
    LiveData<List<Article>> getLiveArticle();

    @Query("select * from article")
    DataSource.Factory<Integer, Article> getArticlePaged();


}
