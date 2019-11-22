package com.mycompany.news;

import androidx.room.Room;
import android.app.Application;
import com.mycompany.news.data.Storage;
import com.mycompany.news.data.database.NewsDatabase;

public class AppDelegate extends Application {

    private Storage storage;

    @Override
    public void onCreate() {
        super.onCreate();

        final NewsDatabase database = Room.databaseBuilder(this, NewsDatabase.class, "news_database")
                .fallbackToDestructiveMigration()
                .build();

        storage = new Storage(database.getNewsDao());
    }

    public Storage getStorage() {
        return storage;
    }
}
