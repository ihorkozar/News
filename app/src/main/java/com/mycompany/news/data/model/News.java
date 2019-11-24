package com.mycompany.news.data.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class News implements Serializable {

    @SerializedName("articles")
    //@TypeConverters({CustomTypeConverter.class})
    private List<Article> articles;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

}
