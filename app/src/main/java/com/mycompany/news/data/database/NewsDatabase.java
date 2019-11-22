package com.mycompany.news.data.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.mycompany.news.data.model.Article;
import com.mycompany.news.data.model.News;
import com.mycompany.news.data.model.Source;

@Database(entities = {Article.class, Source.class}, version = 1)
public abstract class NewsDatabase extends RoomDatabase {
    public abstract NewsDao getNewsDao();
}
