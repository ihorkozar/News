package com.mycompany.news.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mycompany.news.data.model.Article;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CustomTypeConverter {

    Gson gson = new Gson();

    @androidx.room.TypeConverter
    public List<Article> stringToArticleList(String data){
        if (data == null){
            return Collections.emptyList();
        }
        Type listArticle = new TypeToken<List<Article>>(){}.getType();
        return gson.fromJson(data, listArticle);
    }

    @androidx.room.TypeConverter
    public String articleListToString(List<Article> articles) {
        return gson.toJson(articles);
    }
}
